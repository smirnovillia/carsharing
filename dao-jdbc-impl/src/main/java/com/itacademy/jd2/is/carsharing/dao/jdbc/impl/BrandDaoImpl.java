package com.itacademy.jd2.is.carsharing.dao.jdbc.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import com.itacademy.jd2.is.carsharing.dao.api.IBrandDao;
import com.itacademy.jd2.is.carsharing.dao.api.entity.IBrand;
import com.itacademy.jd2.is.carsharing.dao.jdbc.impl.entity.Brand;
import com.itacademy.jd2.is.carsharing.dao.jdbc.impl.util.PreparedStatementAction;

public class BrandDaoImpl extends AbstractDaoImpl<IBrand, Integer> implements IBrandDao {

	public IBrand createEntity() {
		return new Brand();
	}

	public void insert(final IBrand entity) {
		executeStatement(new PreparedStatementAction<IBrand>(
				String.format("insert into %s (name, created, updated) values(?,?,?)", getTableName()), true) {
			public IBrand doWithPreparedStatement(final PreparedStatement pStmt) throws SQLException {
				pStmt.setString(1, entity.getName());
				pStmt.setObject(2, entity.getCreated(), Types.TIMESTAMP);
				pStmt.setObject(3, entity.getUpdated(), Types.TIMESTAMP);

				pStmt.executeUpdate();

				final ResultSet rs = pStmt.getGeneratedKeys();
				rs.next();
				final int id = rs.getInt("id");

				rs.close();

				entity.setId(id);
				return entity;
			}
		});

	}

	public void update(final IBrand entity) {
		executeStatement(new PreparedStatementAction<IBrand>(
				String.format("update %s set name=?, updated=? where id=?", getTableName())) {
			public IBrand doWithPreparedStatement(final PreparedStatement pStmt) throws SQLException {
				pStmt.setString(1, entity.getName());
				pStmt.setObject(2, entity.getUpdated(), Types.TIMESTAMP);
				pStmt.setInt(3, entity.getId());

				pStmt.executeUpdate();
				return entity;
			}
		});
	}

	protected String getTableName() {
		return "brand";
	}

	protected IBrand parseRow(final ResultSet resultSet) throws SQLException {
		final IBrand entity = createEntity();
		entity.setId((Integer) resultSet.getObject("id"));
		entity.setName(resultSet.getString("name"));
		entity.setCreated(resultSet.getTimestamp("created"));
		entity.setUpdated(resultSet.getTimestamp("updated"));
		return entity;
	}

}
