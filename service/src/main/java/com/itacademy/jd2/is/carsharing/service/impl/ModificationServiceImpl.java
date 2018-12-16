package com.itacademy.jd2.is.carsharing.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itacademy.jd2.is.carsharing.dao.api.IModificationDao;
import com.itacademy.jd2.is.carsharing.dao.api.entity.IModification;
import com.itacademy.jd2.is.carsharing.dao.api.filter.ModificationFilter;
import com.itacademy.jd2.is.carsharing.service.IModificationService;

@Service
public class ModificationServiceImpl implements IModificationService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ModificationServiceImpl.class);
	private IModificationDao dao;

	@Autowired
	public ModificationServiceImpl(IModificationDao dao) {
		super();
		this.dao = dao;
	}

	@Override
	public IModification get(Integer id) {
		final IModification entity = dao.get(id);
		return entity;
	}

	@Override
	public List<IModification> getAll() {
		final List<IModification> all = dao.selectAll();
		return all;
	}

	@Override
	public void save(IModification entity) {
		final Date modifedOn = new Date();
		entity.setUpdated(modifedOn);
		if (entity.getId() == null) {
			LOGGER.info("new modification created" + entity);
			entity.setCreated(modifedOn);
			dao.insert(entity);
		} else {
			LOGGER.info("modification updated" + entity);
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
	public IModification createEntity() {
		return dao.createEntity();
	}

	@Override
	public List<IModification> find(ModificationFilter filter) {
		return dao.find(filter);
	}

}
