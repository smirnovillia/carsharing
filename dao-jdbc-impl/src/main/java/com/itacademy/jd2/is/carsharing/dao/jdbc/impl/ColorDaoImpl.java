package com.itacademy.jd2.is.carsharing.dao.jdbc.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import com.itacademy.jd2.is.carsharing.dao.api.IColorDao;
import com.itacademy.jd2.is.carsharing.dao.api.entity.IColor;
import com.itacademy.jd2.is.carsharing.dao.jdbc.impl.entity.Color;
import com.itacademy.jd2.is.carsharing.dao.jdbc.impl.util.PreparedStatementAction;

public class ColorDaoImpl extends AbstractDaoImpl<IColor, Integer> implements IColorDao{

	@Override
	public IColor createEntity() {
		return new Color();
	}

	@Override
	public void update(IColor entity) {
		executeStatement(new PreparedStatementAction<IColor>(
				String.format("update %s set name=?, updated=? where id=?", getTableName())) {
			
			@Override
			public IColor doWithPreparedStatement(PreparedStatement pStmt) throws SQLException {
				pStmt.setString(1, entity.getName());
				pStmt.setObject(2, entity.getUpdated(), Types.TIMESTAMP);
				pStmt.setInt(3, entity.getId());

				pStmt.executeUpdate();
				return entity;
			}
		});
	}

	@Override
	public void insert(IColor entity) {
		executeStatement(new PreparedStatementAction<IColor>(
				String.format("insert into %s (name, created, updated) values(?,?,?)", getTableName()), true) {
			
			@Override
			public IColor doWithPreparedStatement(PreparedStatement pStmt) throws SQLException {
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

	@Override
	protected IColor parseRow(ResultSet resultSet) throws SQLException {
		final IColor entity = new Color();
		entity.setId((Integer) resultSet.getObject("id"));
		entity.setName(resultSet.getString("name"));
		entity.setCreated(resultSet.getTimestamp("created"));
		entity.setUpdated(resultSet.getTimestamp("updated"));
		return entity;
	}

	@Override
	protected String getTableName() {
		return "color";
	}

}
