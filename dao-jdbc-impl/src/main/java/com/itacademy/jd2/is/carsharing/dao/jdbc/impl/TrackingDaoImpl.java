package com.itacademy.jd2.is.carsharing.dao.jdbc.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.springframework.stereotype.Repository;

import com.itacademy.jd2.is.carsharing.dao.api.ITrackingDao;
import com.itacademy.jd2.is.carsharing.dao.api.entity.ICar;
import com.itacademy.jd2.is.carsharing.dao.api.entity.ITracking;
import com.itacademy.jd2.is.carsharing.dao.jdbc.impl.entity.Car;
import com.itacademy.jd2.is.carsharing.dao.jdbc.impl.entity.Tracking;
import com.itacademy.jd2.is.carsharing.dao.jdbc.impl.util.PreparedStatementAction;

@Repository
public class TrackingDaoImpl extends AbstractDaoImpl<ITracking, Integer> implements ITrackingDao {

	@Override
	public ITracking createEntity() {
		return new Tracking();
	}

	@Override
	public void update(ITracking entity) {
		executeStatement(new PreparedStatementAction<ITracking>(String
				.format("update %s set car_id=?, latitude=?, longitude=?, updated=? where id=?", getTableName())) {

			@Override
			public ITracking doWithPreparedStatement(PreparedStatement pStmt) throws SQLException {
				pStmt.setInt(1, entity.getCar().getId());
				pStmt.setDouble(2, entity.getLatitude());
				pStmt.setDouble(3, entity.getLongitude());
				pStmt.setObject(4, entity.getUpdated(), Types.TIMESTAMP);
				pStmt.setInt(5, entity.getId());
				pStmt.executeUpdate();
				return entity;
			}
		});
	}

	@Override
	public void insert(ITracking entity) {
		executeStatement(new PreparedStatementAction<ITracking>(
				String.format("insert into %s (car_id, latitude, longitude, created, updated) values (?,?,?,?,?)",
						getTableName()),
				true) {

			@Override
			public ITracking doWithPreparedStatement(PreparedStatement pStmt) throws SQLException {
				pStmt.setInt(1, entity.getCar().getId());
				pStmt.setDouble(2, entity.getLatitude());
				pStmt.setDouble(3, entity.getLongitude());
				pStmt.setObject(4, entity.getCreated(), Types.TIMESTAMP);
				pStmt.setObject(5, entity.getUpdated(), Types.TIMESTAMP);
				pStmt.executeUpdate();

				final ResultSet rs = pStmt.getGeneratedKeys();
				rs.next();
				final int id = rs.getInt("id");
				rs.close();
				entity.setId(id);

				return null;
			}
		});
	}

	@Override
	protected ITracking parseRow(ResultSet resultSet) throws SQLException {
		final ITracking entity = new Tracking();
		entity.setLatitude(resultSet.getDouble("latitude"));
		entity.setLongitude(resultSet.getDouble("longitude"));
		entity.setCreated(resultSet.getTimestamp("created"));
		entity.setUpdated(resultSet.getTimestamp("updated"));

		final ICar car = new Car();
		car.setId((Integer) resultSet.getObject("id"));
		entity.setCar(car);
		return entity;
	}

	@Override
	protected String getTableName() {
		return "tracking";
	}

}
