package com.itacademy.jd2.is.carsharing.dao.jdbc.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import com.itacademy.jd2.is.carsharing.dao.api.ICustomerDao;
import com.itacademy.jd2.is.carsharing.dao.api.entity.ICustomer;
import com.itacademy.jd2.is.carsharing.dao.jdbc.impl.entity.Customer;
import com.itacademy.jd2.is.carsharing.dao.jdbc.impl.util.PreparedStatementAction;

public class CustomerDaoImpl extends AbstractDaoImpl<ICustomer, Integer> implements ICustomerDao {

	@Override
	public ICustomer createEntity() {
		return new Customer();
	}

	@Override
	public void update(ICustomer entity) {
		executeStatement(new PreparedStatementAction<ICustomer>(String.format(
				"update %s set first_name=?, last_name=?, birthday=?, driver_license=?,"
						+ " driver_license_status=?, customer_passport=?, customer_image=?, updated=? where id=?",
				getTableName())) {

			@Override
			public ICustomer doWithPreparedStatement(PreparedStatement pStmt) throws SQLException {
				pStmt.setString(1, entity.getFirstName());
				pStmt.setString(2, entity.getLastName());
				pStmt.setObject(3, entity.getBirthday(), Types.DATE);
				pStmt.setString(4, entity.getDriverLicense());
				pStmt.setBoolean(5, entity.isDriverLicenseStatus());
				pStmt.setString(6, entity.getCustomerPassport());
				pStmt.setString(7, entity.getCustomerImage());
				pStmt.setObject(8, entity.getUpdated(), Types.TIMESTAMP);
				pStmt.setInt(9, entity.getId());

				pStmt.executeUpdate();

				return entity;
			}
		});
	}

	@Override
	public void insert(ICustomer entity) {
		executeStatement(new PreparedStatementAction<ICustomer>(String.format(
				"insert into %s (first_name, last_name, birthday, driver_license, driver_license_status, "
						+ "customer_passport, customer_image, created, updated) values (?,?,?,?,?,?,?,?,?)",
				getTableName())) {

			@Override
			public ICustomer doWithPreparedStatement(PreparedStatement pStmt) throws SQLException {
				pStmt.setString(1, entity.getFirstName());
				pStmt.setString(2, entity.getLastName());
				pStmt.setObject(3, entity.getBirthday(), Types.DATE);
				pStmt.setString(4, entity.getDriverLicense());
				pStmt.setBoolean(5, entity.isDriverLicenseStatus());
				pStmt.setString(6, entity.getCustomerPassport());
				pStmt.setString(7, entity.getCustomerImage());
				pStmt.setObject(8, entity.getCreated(), Types.TIMESTAMP);
				pStmt.setObject(9, entity.getUpdated(), Types.TIMESTAMP);
				
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
	protected ICustomer parseRow(ResultSet resultSet) throws SQLException {
		final ICustomer entity = new Customer();
		entity.setId((Integer) resultSet.getObject("id"));
		entity.setFirstName(resultSet.getString("first_name"));
		entity.setLastName(resultSet.getString("last_name"));
		entity.setBirthday(resultSet.getDate("birthday"));
		entity.setDriverLicense(resultSet.getString("driver_license"));
		entity.setDriverLicenseStatus(resultSet.getBoolean("driver_license_status"));
		entity.setCustomerPassport(resultSet.getString("customer_passport"));
		entity.setCustomerImage(resultSet.getString("customer_image"));
		return entity;
	}

	@Override
	protected String getTableName() {
		return "customer";
	}

}
