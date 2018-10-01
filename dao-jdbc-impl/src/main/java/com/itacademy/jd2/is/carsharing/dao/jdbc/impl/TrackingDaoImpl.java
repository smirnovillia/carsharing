package com.itacademy.jd2.is.carsharing.dao.jdbc.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.itacademy.jd2.is.carsharing.dao.api.ITrackingDao;
import com.itacademy.jd2.is.carsharing.dao.api.entity.ITracking;
import com.itacademy.jd2.is.carsharing.dao.jdbc.impl.entity.Tracking;

public class TrackingDaoImpl extends AbstractDaoImpl<ITracking, Integer> implements ITrackingDao{

	@Override
	public ITracking createEntity() {
		return new Tracking();
	}

	@Override
	public void update(ITracking entity) {
	}

	@Override
	public void insert(ITracking entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected ITracking parseRow(ResultSet resultSet) throws SQLException {
		// TODO Auto-generated method stub
		return super.parseRow(resultSet);
	}

	@Override
	protected String getTableName() {
		return "tracking";
	}

}
