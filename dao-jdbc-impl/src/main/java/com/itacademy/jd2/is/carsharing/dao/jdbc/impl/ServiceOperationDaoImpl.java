package com.itacademy.jd2.is.carsharing.dao.jdbc.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.springframework.stereotype.Repository;

import com.itacademy.jd2.is.carsharing.dao.api.IServiceOperationDao;
import com.itacademy.jd2.is.carsharing.dao.api.entity.ICarServiceHistory;
import com.itacademy.jd2.is.carsharing.dao.api.entity.IServiceOperation;
import com.itacademy.jd2.is.carsharing.dao.api.entity.ISparePart;
import com.itacademy.jd2.is.carsharing.dao.jdbc.impl.entity.CarServiceHistory;
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
				String.format("update %s set car_service_history_id=?, name=?, price=?, updated=? where id=?", getTableName())) {

			@Override
			public IServiceOperation doWithPreparedStatement(PreparedStatement pStmt) throws SQLException {
				pStmt.setInt(1, entity.getCarServiceHistory().getId());
				pStmt.setString(2, entity.getName());
				pStmt.setDouble(3, entity.getPrice());
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
				String.format("insert into %s (car_service_history_id, name, price, created, updated) values (?,?,?,?,?)",
						getTableName()),true) {
			
			@Override
			public IServiceOperation doWithPreparedStatement(PreparedStatement pStmt) throws SQLException {
				pStmt.setInt(1, entity.getCarServiceHistory().getId());
				pStmt.setString(2, entity.getName());
				pStmt.setDouble(3, entity.getPrice());
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
		entity.setId((Integer) resultSet.getObject("id"));
		entity.setName(resultSet.getString("name"));
		entity.setPrice(resultSet.getDouble("price"));
		entity.setCreated(resultSet.getTimestamp("created"));
		entity.setUpdated(resultSet.getTimestamp("updated"));
		
		final ICarServiceHistory carServiceHistory = new CarServiceHistory();
		carServiceHistory.setId((Integer) resultSet.getObject("car_service_history_id"));
		entity.setCarServiceHistory(carServiceHistory);
		
		return entity;
	}

	@Override
	protected String getTableName() {
		return "service_operation";
	}

}
