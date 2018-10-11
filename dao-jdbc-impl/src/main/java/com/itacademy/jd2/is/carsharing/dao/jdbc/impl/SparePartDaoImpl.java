package com.itacademy.jd2.is.carsharing.dao.jdbc.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.springframework.stereotype.Repository;

import com.itacademy.jd2.is.carsharing.dao.api.ISparePartDao;
import com.itacademy.jd2.is.carsharing.dao.api.entity.ISparePart;
import com.itacademy.jd2.is.carsharing.dao.jdbc.impl.entity.SparePart;
import com.itacademy.jd2.is.carsharing.dao.jdbc.impl.util.PreparedStatementAction;

@Repository
public class SparePartDaoImpl extends AbstractDaoImpl<ISparePart, Integer> implements ISparePartDao {

	@Override
	public ISparePart createEntity() {
		return new SparePart();
	}

	@Override
	public void update(ISparePart entity) {
		executeStatement(new PreparedStatementAction<ISparePart>(
				String.format("update %s set name=?, price=?, updated=? where id=?", getTableName())) {

			@Override
			public ISparePart doWithPreparedStatement(PreparedStatement pStmt) throws SQLException {
				pStmt.setString(1, entity.getName());
				pStmt.setDouble(2, entity.getPrice());
				pStmt.setObject(3, entity.getUpdated(), Types.TIMESTAMP);
				pStmt.setInt(4, entity.getId());
				pStmt.executeUpdate();
				return entity;
			}
		});
	}

	@Override
	public void insert(ISparePart entity) {
		executeStatement(new PreparedStatementAction<ISparePart>(
				String.format("insert into %s (name, price, created, updated) values (?,?,?,?)", getTableName()), true) {
				
			@Override
				public ISparePart doWithPreparedStatement(PreparedStatement pStmt) throws SQLException {
				pStmt.setString(1, entity.getName());
				pStmt.setDouble(2, entity.getPrice());
				pStmt.setObject(3, entity.getUpdated(), Types.TIMESTAMP);
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
	
	@Override
	protected ISparePart parseRow(ResultSet resultSet) throws SQLException {
		final ISparePart entity = new SparePart();
		entity.setId((Integer) resultSet.getObject("id"));
		entity.setName(resultSet.getString("name"));
		entity.setPrice(resultSet.getDouble("price"));
		entity.setCreated(resultSet.getTimestamp("created"));
		entity.setUpdated(resultSet.getTimestamp("updated"));
		return entity;
	}

	@Override
	protected String getTableName() {
		return "spare_part";
	}

}
