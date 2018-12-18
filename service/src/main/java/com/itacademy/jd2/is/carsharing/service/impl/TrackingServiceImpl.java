package com.itacademy.jd2.is.carsharing.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itacademy.jd2.is.carsharing.dao.api.ITrackingDao;
import com.itacademy.jd2.is.carsharing.dao.api.entity.ITracking;
import com.itacademy.jd2.is.carsharing.dao.api.filter.TrackingFilter;
import com.itacademy.jd2.is.carsharing.service.ITrackingService;

@Service
public class TrackingServiceImpl implements ITrackingService {

	private static final Logger LOGGER = LoggerFactory.getLogger(TrackingServiceImpl.class);
	private ITrackingDao dao;

	@Autowired
	public TrackingServiceImpl(ITrackingDao dao) {
		super();
		this.dao = dao;
	}

	@Override
	public ITracking get(Integer id) {
		final ITracking entity = dao.get(id);
		return entity;
	}

	@Override
	public List<ITracking> getAll() {
		final List<ITracking> all = dao.selectAll();
		return all;
	}

	@Override
	public void save(ITracking entity) {
		final Date modifedOn = new Date();
		entity.setUpdated(modifedOn);
		if (entity.getId() == null) {
			LOGGER.info("new tracking created" + entity);
			entity.setCreated(modifedOn);
			dao.insert(entity);
		} else {
			LOGGER.info("tracking updated" + entity);
			dao.update(entity);
		}
	}

	@Override
	public void delete(Integer id) {
		dao.delete(id);
	}

	@Override
	public void deleteAll() {
		dao.deleteAll();
	}

	@Override
	public ITracking createEntity() {
		return dao.createEntity();
	}

	@Override
	public List<ITracking> find(TrackingFilter filter) {
		return dao.find(filter);
	}
	
	

}
