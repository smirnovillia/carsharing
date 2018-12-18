package com.itacademy.jd2.is.carsharing.service;

import java.util.List;

import javax.transaction.Transactional;

import com.itacademy.jd2.is.carsharing.dao.api.entity.ITracking;
import com.itacademy.jd2.is.carsharing.dao.api.filter.TrackingFilter;

public interface ITrackingService {
	ITracking get(Integer id);

	List<ITracking> getAll();

	@Transactional
	void save(ITracking entity);

	@Transactional
	void delete(Integer id);

	@Transactional
	void deleteAll();

	@Transactional
	ITracking createEntity();

	List<ITracking> find(TrackingFilter filter);
}
