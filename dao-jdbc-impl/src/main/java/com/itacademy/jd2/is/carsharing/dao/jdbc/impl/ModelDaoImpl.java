package com.itacademy.jd2.is.carsharing.dao.jdbc.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.itacademy.jd2.is.carsharing.dao.api.IModelDao;
import com.itacademy.jd2.is.carsharing.dao.api.entity.IBrand;
import com.itacademy.jd2.is.carsharing.dao.api.entity.IModel;
import com.itacademy.jd2.is.carsharing.dao.api.filter.ModelFilter;
import com.itacademy.jd2.is.carsharing.dao.jdbc.impl.entity.Brand;
import com.itacademy.jd2.is.carsharing.dao.jdbc.impl.entity.Model;
import com.itacademy.jd2.is.carsharing.dao.jdbc.impl.util.PreparedStatementAction;

@Repository
public class ModelDaoImpl extends AbstractDaoImpl<IModel, Integer> implements IModelDao {

	public IModel createEntity() {
		return new Model();
	}

	public void insert(final IModel entity) {
		executeStatement(new PreparedStatementAction<IModel>(
				String.format("insert into %s (name, brand_id, created, updated) values(?,?,?,?)", getTableName()),
				true) {
			public IModel doWithPreparedStatement(final PreparedStatement pStmt) throws SQLException {
				pStmt.setString(1, entity.getName());
				pStmt.setInt(2, entity.getBrand().getId());
				pStmt.setObject(3, entity.getCreated(), Types.TIMESTAMP);
				pStmt.setObject(4, entity.getUpdated(), Types.TIMESTAMP);

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

	public void update(final IModel entity) {
		executeStatement(new PreparedStatementAction<IModel>(
				String.format("update %s set name=?, brand_id=?, updated=? where id=?", getTableName())) {
			
			public IModel doWithPreparedStatement(final PreparedStatement pStmt) throws SQLException {
				pStmt.setString(1, entity.getName());
				pStmt.setInt(2, entity.getBrand().getId());
				pStmt.setObject(3, entity.getUpdated(), Types.TIMESTAMP);
				pStmt.setInt(4, entity.getId());

				pStmt.executeUpdate();
				return entity;
			}
		});
	}

	@Override
	protected String getTableName() {
		return "model";
	}

	@Override
	protected IModel parseRow(final ResultSet resultSet, final Set<String> columns) throws SQLException {
		final IModel entity = createEntity();
		entity.setId((Integer) resultSet.getObject("id"));
		entity.setName(resultSet.getString("name"));
		entity.setCreated(resultSet.getTimestamp("created"));
		entity.setUpdated(resultSet.getTimestamp("updated"));

		final IBrand brand = new Brand();
		brand.setId((Integer) resultSet.getObject("brand_id"));
		entity.setBrand(brand);
		return entity;
	}

	@Override
	public List<IModel> find(ModelFilter filter) {
		final StringBuilder sqlTile = new StringBuilder("");
		appendSort(filter, sqlTile);
		appendPaging(filter, sqlTile);
		return executeFindQuery(sqlTile.toString());
	}

	@Override
	public long getCount(ModelFilter filter) {
		return executeCountQuery("");
	}

	@Override
	public IModel getFullInfo(Integer id) {
		throw new RuntimeException("not implemented");
	}
	

}
