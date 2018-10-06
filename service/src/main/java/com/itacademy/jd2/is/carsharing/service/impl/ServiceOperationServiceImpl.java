package com.itacademy.jd2.is.carsharing.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itacademy.jd2.is.carsharing.dao.api.IServiceOperationDao;
import com.itacademy.jd2.is.carsharing.dao.api.entity.IServiceOperation;
import com.itacademy.jd2.is.carsharing.service.IServiceOperationService;

@Service
public class ServiceOperationServiceImpl implements IServiceOperationService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ServiceOperationServiceImpl.class);
	private IServiceOperationDao dao;

	@Autowired
	public ServiceOperationServiceImpl(IServiceOperationDao dao) {
		super();
		this.dao = dao;
	}

	@Override
	public IServiceOperation get(Integer id) {
		final IServiceOperation entity = dao.get(id);
		return entity;
	}

	@Override
	public List<IServiceOperation> getAll() {
		final List<IServiceOperation> all = dao.selectAll();
		return all;
	}

	@Override
	public void save(IServiceOperation entity) {
		final Date modifedOn = new Date();
		entity.setUpdated(modifedOn);
		if (entity.getId() == null) {
			LOGGER.info("new service operation created" + entity);
			entity.setCreated(modifedOn);
			dao.insert(entity);
		} else {
			LOGGER.info("service operation updated" + entity);
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
	public IServiceOperation createEntity() {
		return dao.createEntity();
	}

}
