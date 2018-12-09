package com.itacademy.jd2.is.carsharing.dao.jdbc.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.itacademy.jd2.is.carsharing.dao.api.ICustomerDao;
import com.itacademy.jd2.is.carsharing.dao.api.entity.ICustomer;
import com.itacademy.jd2.is.carsharing.dao.api.filter.CustomerFilter;
import com.itacademy.jd2.is.carsharing.dao.jdbc.impl.entity.Customer;
import com.itacademy.jd2.is.carsharing.dao.jdbc.impl.util.PreparedStatementAction;

@Repository
public class CustomerDaoImpl extends AbstractDaoImpl<ICustomer, Integer> implements ICustomerDao {

	@Override
	public ICustomer createEntity() {
		return new Customer();
	}

	@Override
	public void update(ICustomer entity) {
		executeStatement(new PreparedStatementAction<ICustomer>(String.format(
				"update %s set first_name=?, last_name=?, birthday=?, driver_license=?, driver_license_status=?, updated=? where id=?",
				getTableName())) {

			@Override
			public ICustomer doWithPreparedStatement(PreparedStatement pStmt) throws SQLException {
				pStmt.setString(1, entity.getFirstName());
				pStmt.setString(2, entity.getLastName());
				pStmt.setObject(3, entity.getBirthday(), Types.DATE);
				pStmt.setString(4, entity.getDriverLicense());
				pStmt.setBoolean(5, entity.isDriverLicenseStatus());
				pStmt.setObject(6, entity.getUpdated(), Types.TIMESTAMP);
				pStmt.setInt(7, entity.getId());

				pStmt.executeUpdate();

				return entity;
			}
		});
	}

	@Override
	public void insert(ICustomer entity) {
		executeStatement(new PreparedStatementAction<ICustomer>(String.format(
				"insert into %s (id, first_name, last_name, birthday, driver_license, driver_license_status, created, updated) values (?,?,?,?,?,?,?,?)",
				getTableName()), true) {

			@Override
			public ICustomer doWithPreparedStatement(PreparedStatement pStmt) throws SQLException {
				pStmt.setInt(1, entity.getId());
				pStmt.setString(2, entity.getFirstName());
				pStmt.setString(3, entity.getLastName());
				pStmt.setObject(4, entity.getBirthday(), Types.DATE);
				pStmt.setString(5, entity.getDriverLicense());
				pStmt.setBoolean(6, entity.isDriverLicenseStatus());
				pStmt.setObject(9, entity.getCreated(), Types.TIMESTAMP);
				pStmt.setObject(10, entity.getUpdated(), Types.TIMESTAMP);
				
				pStmt.executeUpdate();

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
		entity.setCreated(resultSet.getTimestamp("created"));
		entity.setUpdated(resultSet.getTimestamp("updated"));
		return entity;
	}

	@Override
	protected String getTableName() {
		return "customer";
	}
	
	@Override
	public List<ICustomer> find(final CustomerFilter filter) {
		final StringBuilder sqlTile = new StringBuilder("");
		appendSort(filter, sqlTile);
		appendPaging(filter, sqlTile);
		return executeFindQuery(sqlTile.toString());
	}

	@Override
	public long getCount(final CustomerFilter filter) {
		return (int) executeCountQuery("");
	}

}
