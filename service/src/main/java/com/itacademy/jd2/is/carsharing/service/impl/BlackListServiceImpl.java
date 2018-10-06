package com.itacademy.jd2.is.carsharing.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itacademy.jd2.is.carsharing.dao.api.IBlackListDao;
import com.itacademy.jd2.is.carsharing.dao.api.entity.IBlackList;
import com.itacademy.jd2.is.carsharing.service.IBlackListService;

@Service
public class BlackListServiceImpl implements IBlackListService {
	private static final Logger LOGGER = LoggerFactory.getLogger(BlackListServiceImpl.class);
	private IBlackListDao dao;

	@Autowired
	public BlackListServiceImpl(IBlackListDao dao) {
		super();
		this.dao = dao;
	}

	@Override
	public IBlackList createEntity() {

		return dao.createEntity();
	}

	@Override
	public void save(final IBlackList entity) {
		final Date modifedOn = new Date();
		entity.setUpdated(modifedOn);
		if (entity.getId() == null) {
			LOGGER.info("new black list created" + entity);
			entity.setCreated(modifedOn);
			dao.insert(entity);
		} else {
			LOGGER.info("black list updated" + entity);
			dao.update(entity);
		}
	}

	@Override
	public IBlackList get(final Integer id) {
		final IBlackList entity = dao.get(id);
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
	public List<IBlackList> getAll() {
		final List<IBlackList> all = dao.selectAll();
		return all;
	}
}
