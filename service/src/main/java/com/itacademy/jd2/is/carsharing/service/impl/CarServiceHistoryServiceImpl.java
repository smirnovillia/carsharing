package com.itacademy.jd2.is.carsharing.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itacademy.jd2.is.carsharing.dao.api.ICarServiceHistoryDao;
import com.itacademy.jd2.is.carsharing.dao.api.entity.ICarServiceHistory;
import com.itacademy.jd2.is.carsharing.service.ICarServiceHistoryService;

@Service
public class CarServiceHistoryServiceImpl implements ICarServiceHistoryService {

	private static final Logger LOGGER = LoggerFactory.getLogger(CarServiceHistoryServiceImpl.class);
	private ICarServiceHistoryDao dao;

	@Autowired
	public CarServiceHistoryServiceImpl(ICarServiceHistoryDao dao) {
		super();
		this.dao = dao;
	}

	@Override
	public ICarServiceHistory get(Integer id) {
		final ICarServiceHistory entity = dao.get(id);
		return entity;
	}

	@Override
	public List<ICarServiceHistory> getAll() {
		final List<ICarServiceHistory> all = dao.selectAll();
		return all;
	}

	@Override
	public void save(ICarServiceHistory entity) {
		final Date modifedOn = new Date();
		entity.setUpdated(modifedOn);
		if (entity.getId() == null) {
			LOGGER.info("new car service history created" + entity);
			entity.setCreated(modifedOn);
			dao.insert(entity);
		} else {
			LOGGER.info("car service history updated" + entity);
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
	public ICarServiceHistory createEntity() {
		return dao.createEntity();
	}

}
