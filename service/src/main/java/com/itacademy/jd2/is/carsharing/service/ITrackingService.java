package com.itacademy.jd2.is.carsharing.service;

import java.util.List;

import com.itacademy.jd2.is.carsharing.dao.api.entity.ITracking;

public interface ITrackingService {
	ITracking get(Integer id);

	List<ITracking> getAll();

	void save(ITracking entity);

	void delete(Integer id);

	void deleteAll();

	ITracking createEntity();
}
