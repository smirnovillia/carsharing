package com.itacademy.jd2.is.carsharing.dao.jdbc.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.springframework.stereotype.Repository;

import com.itacademy.jd2.is.carsharing.dao.api.IServiceOperationDao;
import com.itacademy.jd2.is.carsharing.dao.api.entity.IServiceOperation;
import com.itacademy.jd2.is.carsharing.dao.api.entity.ISparePart;
import com.itacademy.jd2.is.carsharing.dao.jdbc.impl.entity.ServiceOperation;
import com.itacademy.jd2.is.carsharing.dao.jdbc.impl.entity.SparePart;
import com.itacademy.jd2.is.carsharing.dao.jdbc.impl.util.PreparedStatementAction;

@Repository
public class ServiceOperationDaoImpl extends AbstractDaoImpl<IServiceOperation, Integer>
		implements IServiceOperationDao {

	@Override
	public IServiceOperation createEntity() {
		return new ServiceOperation();
	}

	@Override
	public void update(IServiceOperation entity) {
		executeStatement(new PreparedStatementAction<IServiceOperation>(
				String.format("update %s set name=?, price=?, spare_part_id=?, updated=? where id=?", getTableName())) {

			@Override
			public IServiceOperation doWithPreparedStatement(PreparedStatement pStmt) throws SQLException {
				pStmt.setString(1, entity.getName());
				pStmt.setDouble(2, entity.getPrice());
				pStmt.setInt(3, entity.getSparePart().getId());
				pStmt.setObject(4, entity.getUpdated(), Types.TIMESTAMP);
				pStmt.setInt(5, entity.getId());

				pStmt.executeUpdate();

				return entity;
			}
		});
	}

	@Override
	public void insert(IServiceOperation entity) {
		executeStatement(new PreparedStatementAction<IServiceOperation>(
				String.format("insert into %s (name, price, spare_part_id, created, updated) values (?,?,?,?,?)",
						getTableName()),true) {
			
			@Override
			public IServiceOperation doWithPreparedStatement(PreparedStatement pStmt) throws SQLException {
				pStmt.setString(1, entity.getName());
				pStmt.setDouble(2, entity.getPrice());
				pStmt.setInt(3, entity.getSparePart().getId());
				pStmt.setObject(4, entity.getCreated(), Types.TIMESTAMP);
				pStmt.setObject(5, entity.getUpdated(), Types.TIMESTAMP);
				
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
	protected IServiceOperation parseRow(ResultSet resultSet) throws SQLException {
		final IServiceOperation entity = new ServiceOperation();
		entity.setName(resultSet.getString("name"));
		entity.setPrice(resultSet.getDouble("price"));
		
		final ISparePart sparePart = new SparePart();
		sparePart.setId((Integer) resultSet.getObject("spare_part_id"));
		entity.setSparePart(sparePart);
		
		return entity;
	}

	@Override
	protected String getTableName() {
		return "service_operation";
	}

}
