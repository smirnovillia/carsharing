package com.itacademy.jd2.is.carsharing.dao.jdbc.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.List;
import java.util.Set;

import com.itacademy.jd2.is.carsharing.dao.api.IModelDao;
import com.itacademy.jd2.is.carsharing.dao.api.entity.IModel;
import com.itacademy.jd2.is.carsharing.dao.jdbc.impl.entity.Brand;
import com.itacademy.jd2.is.carsharing.dao.jdbc.impl.entity.Model;
import com.itacademy.jd2.is.carsharing.dao.jdbc.impl.util.SQLExecutionException;


public class ModelDaoImpl extends AbstractDaoImpl<IModel, Integer> implements IModelDao {


    @Override
    public IModel createEntity() {
        return new Model();
    }

    @Override
    public void insert(final IModel entity) {
        try (Connection c = getConnection();
                PreparedStatement pStmt = c.prepareStatement(String
                        .format("insert into %s (name, created, updated, brand_id) values(?,?,?,?)", getTableName()),
                        Statement.RETURN_GENERATED_KEYS)) {
            c.setAutoCommit(false);
            try {
                pStmt.setString(1, entity.getName());
                pStmt.setObject(2, entity.getCreated(), Types.TIMESTAMP);
                pStmt.setObject(3, entity.getUpdated(), Types.TIMESTAMP);
                pStmt.setInt(4, entity.getBrand().getId());

                pStmt.executeUpdate();

                final ResultSet rs = pStmt.getGeneratedKeys();
                rs.next();
                final int id = rs.getInt("id");

                rs.close();
                entity.setId(id);

                c.commit();
            } catch (final Exception e) {
                c.rollback();
                throw new RuntimeException(e);
            }

        } catch (final SQLException e) {
            throw new SQLExecutionException(e);
        }
    }

    @Override
    public void update(final IModel entity) {
        try (Connection c = getConnection();
                PreparedStatement pStmt = c.prepareStatement(
                        String.format("update %s set name=?, updated=?, brand_id=? where id=?", getTableName()))) {
            c.setAutoCommit(false);
            try {
                pStmt.setString(1, entity.getName());
                pStmt.setObject(2, entity.getUpdated(), Types.TIMESTAMP);
                pStmt.setInt(3, entity.getBrand().getId());
                pStmt.setInt(4, entity.getId());
                pStmt.executeUpdate();
                c.commit();
            } catch (final Exception e) {
                c.rollback();
                throw new RuntimeException(e);
            }

        } catch (final SQLException e) {
            throw new SQLExecutionException(e);
        }
    }

    @Override
    protected IModel parseRow(final ResultSet resultSet, final Set<String> columns) throws SQLException {
        final IModel entity = createEntity();
        entity.setId((Integer) resultSet.getObject("id"));
        entity.setName(resultSet.getString("name"));
        entity.setCreated(resultSet.getTimestamp("created"));
        entity.setUpdated(resultSet.getTimestamp("updated"));

        final Integer brandId = (Integer) resultSet.getObject("brand_id");
        if (brandId != null) {
            final Brand brand = new Brand();
            brand.setId(brandId);
            if (columns.contains("brand_name")) {
                brand.setName(resultSet.getString("brand_name"));
            }
            entity.setBrand(brand);
        }
        return entity;
    }

    @Override
    public void deleteAll() {
        try (Connection c = getConnection();
                PreparedStatement deleteEngineRefsStmt = c.prepareStatement("delete from model_2_engine");
                PreparedStatement deleteAllStmt = c.prepareStatement("delete from " + getTableName());) {
            c.setAutoCommit(false);
            try {
                deleteEngineRefsStmt.executeUpdate();
                deleteAllStmt.executeUpdate();

                deleteEngineRefsStmt.close();
                deleteAllStmt.close();

                c.commit();
            } catch (final Exception e) {
                c.rollback();
                throw new RuntimeException(e);
            }

        } catch (final SQLException e) {
            throw new SQLExecutionException(e);
        }

    }

    @Override
    protected String getTableName() {
        return "model";
    }



}
