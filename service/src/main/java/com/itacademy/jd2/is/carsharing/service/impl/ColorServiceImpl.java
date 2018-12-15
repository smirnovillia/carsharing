package com.itacademy.jd2.is.carsharing.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itacademy.jd2.is.carsharing.dao.api.IColorDao;
import com.itacademy.jd2.is.carsharing.dao.api.entity.IColor;
import com.itacademy.jd2.is.carsharing.dao.api.filter.ColorFilter;
import com.itacademy.jd2.is.carsharing.service.IColorService;

@Service
public class ColorServiceImpl implements IColorService{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ColorServiceImpl.class);
	private IColorDao dao;
	
	@Autowired
	public ColorServiceImpl(IColorDao dao) {
		super();
		this.dao = dao;
	}

	@Override
	public IColor get(Integer id) {
		final IColor entity = dao.get(id);
		return entity;
	}

	@Override
	public List<IColor> getAll() {
		final List<IColor> all = dao.selectAll();
		return all;
	}

	@Override
	public void save(IColor entity) {
		final Date modifedOn = new Date();
		entity.setUpdated(modifedOn);
		if (entity.getId() == null) {
			LOGGER.info("new color created" + entity);
			entity.setCreated(modifedOn);
			dao.insert(entity);
		} else {
			LOGGER.info("color updated" + entity);
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
	public IColor createEntity() {
		return dao.createEntity();
	}

	@Override
	public List<IColor> find(ColorFilter filter) {
		return dao.find(filter);
	}

	@Override
	public long getCount(ColorFilter filter) {
		return dao.getCount(filter);
	}
	
	

}
