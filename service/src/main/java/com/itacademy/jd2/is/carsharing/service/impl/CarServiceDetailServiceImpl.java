package com.itacademy.jd2.is.carsharing.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itacademy.jd2.is.carsharing.dao.api.ICarServiceDetailDao;
import com.itacademy.jd2.is.carsharing.dao.api.entity.ICarServiceDetail;
import com.itacademy.jd2.is.carsharing.service.ICarServiceDetailService;

@Service
public class CarServiceDetailServiceImpl implements ICarServiceDetailService{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CarServiceDetailServiceImpl.class);
	private ICarServiceDetailDao dao;
	
	@Autowired
	public CarServiceDetailServiceImpl(ICarServiceDetailDao dao) {
		super();
		this.dao = dao;
	}

	@Override
	public ICarServiceDetail get(Integer id) {
		final ICarServiceDetail entity = dao.get(id);
		return entity;
	}

	@Override
	public List<ICarServiceDetail> getAll() {
		final List<ICarServiceDetail> all = dao.selectAll();
		return all;
	}

	@Override
	public void save(ICarServiceDetail entity) {
		final Date modifedOn = new Date();
		entity.setUpdated(modifedOn);
		if (entity.getId() == null) {
			LOGGER.info("new car service detail created" + entity);
			entity.setCreated(modifedOn);
			dao.insert(entity);
		} else {
			LOGGER.info("car service detail updated" + entity);
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
	public ICarServiceDetail createEntity() {
		return dao.createEntity();
	}

}
