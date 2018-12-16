package com.itacademy.jd2.is.carsharing.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itacademy.jd2.is.carsharing.dao.api.ICarDao;
import com.itacademy.jd2.is.carsharing.dao.api.entity.ICar;
import com.itacademy.jd2.is.carsharing.dao.api.enums.Condition;
import com.itacademy.jd2.is.carsharing.dao.api.filter.CarFilter;
import com.itacademy.jd2.is.carsharing.service.ICarService;

@Service
public class CarServiceImpl implements ICarService {
	private static final Logger LOGGER = LoggerFactory.getLogger(CarServiceImpl.class);
	private ICarDao dao;

	@Autowired
	public CarServiceImpl(ICarDao dao) {
		super();
		this.dao = dao;
	}

	@Override
	public ICar createEntity() {

		return dao.createEntity();
	}

	@Override
	public void save(final ICar entity) {
		final Date modifedOn = new Date();
		entity.setUpdated(modifedOn);
		if (entity.getId() == null) {
			LOGGER.info("new car created" + entity);
			entity.setCreated(modifedOn);
			entity.setCondition(Condition.AVAILABLE);
			dao.insert(entity);
		} else {
			LOGGER.info("car" + entity);
			dao.update(entity);
		}
	}

	@Override
	public ICar get(final Integer id) {
		final ICar entity = dao.get(id);
		return entity;
	}

	@Override
	public void delete(final Integer id) {
		dao.delete(id);
	}

	@Override
	public void deleteAll() {
		dao.deleteAll();
	}

	@Override
	public List<ICar> getAll() {
		final List<ICar> all = dao.selectAll();
		return all;
	}

	@Override
	public List<ICar> find(CarFilter filter) {
		return dao.find(filter);
	}

	@Override
	public long getCount(CarFilter filter) {
		return dao.getCount(filter);
	}

	@Override
	public ICar getFullInfo(Integer id) {
		return dao.getFullInfo(id);
	}

}
