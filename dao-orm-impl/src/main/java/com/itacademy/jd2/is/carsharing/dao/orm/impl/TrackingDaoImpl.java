package com.itacademy.jd2.is.carsharing.dao.orm.impl;

import org.springframework.stereotype.Repository;

import com.itacademy.jd2.is.carsharing.dao.api.ITrackingDao;
import com.itacademy.jd2.is.carsharing.dao.api.entity.ITracking;
import com.itacademy.jd2.is.carsharing.dao.orm.impl.entity.Tracking;

@Repository
public class TrackingDaoImpl extends AbstractDaoImpl<ITracking, Integer> implements ITrackingDao {

	
	protected TrackingDaoImpl() {
		super(Tracking.class);
	}

	@Override
	public ITracking createEntity() {
		return new Tracking();
	}

}
