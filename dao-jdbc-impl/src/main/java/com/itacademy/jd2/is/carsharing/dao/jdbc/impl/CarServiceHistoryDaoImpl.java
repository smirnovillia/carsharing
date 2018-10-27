package com.itacademy.jd2.is.carsharing.dao.jdbc.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.springframework.stereotype.Repository;

import com.itacademy.jd2.is.carsharing.dao.api.ICarServiceHistoryDao;
import com.itacademy.jd2.is.carsharing.dao.api.entity.ICar;
import com.itacademy.jd2.is.carsharing.dao.api.entity.ICarServiceHistory;
import com.itacademy.jd2.is.carsharing.dao.jdbc.impl.entity.Car;
import com.itacademy.jd2.is.carsharing.dao.jdbc.impl.entity.CarServiceHistory;
import com.itacademy.jd2.is.carsharing.dao.jdbc.impl.util.PreparedStatementAction;

@Repository
public class CarServiceHistoryDaoImpl extends AbstractDaoImpl<ICarServiceHistory, Integer>
		implements ICarServiceHistoryDao {

	@Override
	public ICarServiceHistory createEntity() {
		return new CarServiceHistory();
	}

	@Override
	public void update(ICarServiceHistory entity) {
		executeStatement(new PreparedStatementAction<ICarServiceHistory>(
				String.format("update %s set car_id=?, service_date=?, car_mileage=?, service_company=?, service_price=?, updated=? where id=?",
						getTableName())) {

			@Override
			public ICarServiceHistory doWithPreparedStatement(PreparedStatement pStmt) throws SQLException {
				pStmt.setInt(1, entity.getCar().getId());
				pStmt.setObject(2, entity.getServiceDate(), Types.DATE);
				pStmt.setDouble(3, entity.getCarMileage());
				pStmt.setString(4, entity.getServiceCompany());
				pStmt.setDouble(5, entity.getServicePrice());
				pStmt.setObject(6, entity.getUpdated(), Types.TIMESTAMP);
				pStmt.setInt(7, entity.getId());

				pStmt.executeUpdate();

				return entity;
			}
		});

	}

	@Override
	public void insert(ICarServiceHistory entity) {
		executeStatement(new PreparedStatementAction<ICarServiceHistory>(String.format(
				"insert into %s (car_id, service_date, car_mileage, service_company, service_price, created, updated) values (?,?,?,?,?,?,?)",
				getTableName()), true) {

			@Override
			public ICarServiceHistory doWithPreparedStatement(PreparedStatement pStmt) throws SQLException {
				pStmt.setInt(1, entity.getCar().getId());
				pStmt.setObject(2, entity.getServiceDate(), Types.DATE);
				pStmt.setDouble(3, entity.getCarMileage());
				pStmt.setString(4, entity.getServiceCompany());
				pStmt.setDouble(5, entity.getServicePrice());
				pStmt.setObject(6, entity.getCreated(), Types.TIMESTAMP);
				pStmt.setObject(7, entity.getUpdated(), Types.TIMESTAMP);
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
	protected String getTableName() {
		return "car_service_history";
	}
	
	@Override
	protected ICarServiceHistory parseRow(final ResultSet resultSet) throws SQLException{
		final ICarServiceHistory entity = new CarServiceHistory();
		entity.setId((Integer) resultSet.getObject("id"));
		entity.setServiceDate(resultSet.getDate("service_date"));
		entity.setCarMileage(resultSet.getDouble("car_mileage"));
		entity.setServiceCompany(resultSet.getString("service_company"));
		entity.setServicePrice(resultSet.getDouble("service_price"));
		entity.setCreated(resultSet.getTimestamp("created"));
		entity.setUpdated(resultSet.getTimestamp("updated"));
		
		final ICar car = new Car();
		car.setId((Integer) resultSet.getObject("car_id"));
		entity.setCar(car);
		
		return entity;
	}

}
