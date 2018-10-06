package com.itacademy.jd2.is.carsharing.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itacademy.jd2.is.carsharing.dao.api.ISparePartDao;
import com.itacademy.jd2.is.carsharing.dao.api.entity.ISparePart;
import com.itacademy.jd2.is.carsharing.service.ISparePartService;

@Service
public class SparePartServiceImpl implements ISparePartService {

	private static final Logger LOGGER = LoggerFactory.getLogger(SparePartServiceImpl.class);
	private ISparePartDao dao;

	@Autowired
	public SparePartServiceImpl(ISparePartDao dao) {
		super();
		this.dao = dao;
	}

	@Override
	public ISparePart get(Integer id) {
		final ISparePart entity = dao.get(id);
		return entity;
	}

	@Override
	public List<ISparePart> getAll() {
		final List<ISparePart> all = dao.selectAll();
		return all;
	}

	@Override
	public void save(ISparePart entity) {
		final Date modifedOn = new Date();
		entity.setUpdated(modifedOn);
		if (entity.getId() == null) {
			LOGGER.info("new spare part created" + entity);
			entity.setCreated(modifedOn);
			dao.insert(entity);
		} else {
			LOGGER.info("spare part updated" + entity);
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
	public ISparePart createEntity() {
		return dao.createEntity();
	}

}
