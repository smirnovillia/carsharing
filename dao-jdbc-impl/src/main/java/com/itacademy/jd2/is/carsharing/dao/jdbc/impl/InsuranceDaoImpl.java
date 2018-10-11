package com.itacademy.jd2.is.carsharing.dao.jdbc.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.springframework.stereotype.Repository;

import com.itacademy.jd2.is.carsharing.dao.api.IInsuranceDao;
import com.itacademy.jd2.is.carsharing.dao.api.entity.ICar;
import com.itacademy.jd2.is.carsharing.dao.api.entity.IInsurance;
import com.itacademy.jd2.is.carsharing.dao.jdbc.impl.entity.Car;
import com.itacademy.jd2.is.carsharing.dao.jdbc.impl.entity.Insurance;
import com.itacademy.jd2.is.carsharing.dao.jdbc.impl.util.PreparedStatementAction;

@Repository
public class InsuranceDaoImpl extends AbstractDaoImpl<IInsurance, Integer> implements IInsuranceDao {

	@Override
	public IInsurance createEntity() {
		return new Insurance();
	}

	@Override
	public void update(IInsurance entity) {
		executeStatement(new PreparedStatementAction<IInsurance>(String.format(
				"update %s set car_id=?, insurance_company=?, insurance_number=?, issued=?, expiried=?, updated=? where id=?",
				getTableName())) {

			@Override
			public IInsurance doWithPreparedStatement(PreparedStatement pStmt) throws SQLException {
				pStmt.setInt(1, entity.getCar().getId());
				pStmt.setString(2, entity.getInsuranceCompany());
				pStmt.setString(3, entity.getInsuranceNumber());
				pStmt.setObject(4, entity.getIssued(), Types.DATE);
				pStmt.setObject(5, entity.getExpiried(), Types.DATE);
				pStmt.setObject(6, entity.getUpdated(), Types.TIMESTAMP);
				pStmt.setInt(7, entity.getId());

				pStmt.executeUpdate();

				return entity;
			}
		});
	}

	@Override
	public void insert(IInsurance entity) {
		executeStatement(new PreparedStatementAction<IInsurance>(String.format(
				"insert into %s (car_id, insurance_company, insurance_number, issued, expired, created, updated) values (?,?,?,?,?,?,?)",
				getTableName()), true) {

			@Override
			public IInsurance doWithPreparedStatement(PreparedStatement pStmt) throws SQLException {
				pStmt.setInt(1, entity.getCar().getId());
				pStmt.setString(2, entity.getInsuranceCompany());
				pStmt.setString(3, entity.getInsuranceNumber());
				pStmt.setObject(4, entity.getIssued(), Types.DATE);
				pStmt.setObject(5, entity.getExpiried(), Types.DATE);
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
	protected IInsurance parseRow(ResultSet resultSet) throws SQLException {
		final IInsurance entity = new Insurance();
		entity.setId((Integer) resultSet.getObject("id"));
		entity.setInsuranceCompany(resultSet.getString("insurance_company"));
		entity.setInsuranceNumber(resultSet.getString("insurance_number"));
		entity.setIssued(resultSet.getDate("issued"));
		entity.setExpiried(resultSet.getDate("expiried"));
		entity.setCreated(resultSet.getTimestamp("created"));
		entity.setUpdated(resultSet.getTimestamp("updated"));
		
		final ICar car = new Car();
		car.setId((Integer) resultSet.getObject("id"));
		entity.setCar(car);
		return entity;
	}

	@Override
	protected String getTableName() {
		return "insurance";
	}

}
