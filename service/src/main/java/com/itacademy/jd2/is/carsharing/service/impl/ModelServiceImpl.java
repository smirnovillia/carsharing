package com.itacademy.jd2.is.carsharing.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itacademy.jd2.is.carsharing.dao.api.IBrandDao;
import com.itacademy.jd2.is.carsharing.dao.api.IModelDao;
import com.itacademy.jd2.is.carsharing.dao.api.entity.IModel;
import com.itacademy.jd2.is.carsharing.dao.api.filter.ModelFilter;
import com.itacademy.jd2.is.carsharing.service.IModelService;

@Service
public class ModelServiceImpl implements IModelService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ModelServiceImpl.class);
	private IModelDao dao;

	@Autowired
	public ModelServiceImpl(IModelDao dao) {
		super();
		this.dao = dao;
	}

	@Override
	public IModel get(Integer id) {
		final IModel entity = dao.get(id);
		return entity;
	}

	@Override
	public List<IModel> getAll() {
		final List<IModel> all = dao.selectAll();
		return all;
	}

	@Override
	public void save(IModel entity) {
		final Date modifedOn = new Date();
		entity.setUpdated(modifedOn);
		if (entity.getId() == null) {
			LOGGER.info("new model created" + entity);
			entity.setCreated(modifedOn);
			dao.insert(entity);
		} else {
			LOGGER.info("model updated" + entity);
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
	public IModel createEntity() {
		return dao.createEntity();
	}

	@Override
	public List<IModel> find(ModelFilter filter) {
		return dao.find(filter);
	}

	@Override
	public long getCount(ModelFilter filter) {
		return dao.getCount(filter);
	}

	@Override
	public IModel getFullInfo(Integer id) {
		return dao.getFullInfo(id);
	}
	
	

}
