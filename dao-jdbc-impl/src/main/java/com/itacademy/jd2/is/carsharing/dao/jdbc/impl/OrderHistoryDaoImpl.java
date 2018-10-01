package com.itacademy.jd2.is.carsharing.dao.jdbc.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import com.itacademy.jd2.is.carsharing.dao.api.IOrderHistoryDao;
import com.itacademy.jd2.is.carsharing.dao.api.entity.ICar;
import com.itacademy.jd2.is.carsharing.dao.api.entity.ICustomer;
import com.itacademy.jd2.is.carsharing.dao.api.entity.IOrderHistory;
import com.itacademy.jd2.is.carsharing.dao.jdbc.impl.entity.Car;
import com.itacademy.jd2.is.carsharing.dao.jdbc.impl.entity.Customer;
import com.itacademy.jd2.is.carsharing.dao.jdbc.impl.entity.OrderHistory;
import com.itacademy.jd2.is.carsharing.dao.jdbc.impl.util.PreparedStatementAction;

public class OrderHistoryDaoImpl extends AbstractDaoImpl<IOrderHistory, Integer> implements IOrderHistoryDao {

	@Override
	public IOrderHistory createEntity() {
		return new OrderHistory();
	}

	@Override
	public void update(IOrderHistory entity) {
		executeStatement(new PreparedStatementAction<IOrderHistory>(String.format(
				"update %s set customer_id=?, car_id=?, order_date=?, order_mileage=?, rate=?, price=?, updated=? where id=?",
				getTableName())) {

			@Override
			public IOrderHistory doWithPreparedStatement(PreparedStatement pStmt) throws SQLException {
				pStmt.setInt(1, entity.getCustomer().getId());
				pStmt.setInt(2, entity.getCar().getId());
				pStmt.setObject(3, entity.getOrderDate(), Types.DATE);
				pStmt.setDouble(4, entity.getOrderMileage());
				pStmt.setDouble(5, entity.getRate());
				pStmt.setDouble(6, entity.getPrice());
				pStmt.setObject(7, entity.getUpdated(), Types.TIMESTAMP);
				pStmt.setInt(8, entity.getId());

				pStmt.executeUpdate();
				return entity;
			}
		});
	}

	@Override
	public void insert(IOrderHistory entity) {
		executeStatement(new PreparedStatementAction<IOrderHistory>(String.format(
				"insert into %s (customer_id, car_id, order_date, order_mileage, rate, price, created, updated) values (?,?,?,?,?,?,?,?)",
				getTableName()), true) {

			@Override
			public IOrderHistory doWithPreparedStatement(PreparedStatement pStmt) throws SQLException {
				pStmt.setInt(1, entity.getCustomer().getId());
				pStmt.setInt(2, entity.getCar().getId());
				pStmt.setObject(3, entity.getOrderDate(), Types.DATE);
				pStmt.setDouble(4, entity.getOrderMileage());
				pStmt.setDouble(5, entity.getRate());
				pStmt.setDouble(6, entity.getPrice());
				pStmt.setObject(7, entity.getCreated(), Types.TIMESTAMP);
				pStmt.setObject(8, entity.getUpdated(), Types.TIMESTAMP);

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
	protected IOrderHistory parseRow(ResultSet resultSet) throws SQLException {
		final IOrderHistory entity = new OrderHistory();
		entity.setId((Integer) resultSet.getObject("id"));
		entity.setOrderDate(resultSet.getDate("order_date"));
		entity.setOrderMileage(resultSet.getDouble("order_mileage"));
		entity.setRate(resultSet.getDouble("rate"));
		entity.setPrice(resultSet.getDouble("price"));

		final ICustomer customer = new Customer();
		customer.setId((Integer) resultSet.getObject("customer_id"));
		entity.setCustomer(customer);

		final ICar car = new Car();
		car.setId((Integer) resultSet.getObject("car_id"));
		entity.setCar(car);
		
		return entity;
	}

	@Override
	protected String getTableName() {
		return "order_history";
	}

}
