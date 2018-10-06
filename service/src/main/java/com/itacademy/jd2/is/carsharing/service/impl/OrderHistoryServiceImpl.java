package com.itacademy.jd2.is.carsharing.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itacademy.jd2.is.carsharing.dao.api.IOrderHistoryDao;
import com.itacademy.jd2.is.carsharing.dao.api.entity.IOrderHistory;
import com.itacademy.jd2.is.carsharing.service.IOrderHistoryService;

@Service
public class OrderHistoryServiceImpl implements IOrderHistoryService {

	private static final Logger LOGGER = LoggerFactory.getLogger(OrderHistoryServiceImpl.class);
	private IOrderHistoryDao dao;

	@Autowired
	public OrderHistoryServiceImpl(IOrderHistoryDao dao) {
		super();
		this.dao = dao;
	}

	@Override
	public IOrderHistory get(Integer id) {
		final IOrderHistory entity = dao.get(id);
		return entity;
	}

	@Override
	public List<IOrderHistory> getAll() {
		final List<IOrderHistory> all = dao.selectAll();
		return all;
	}

	@Override
	public void save(IOrderHistory entity) {
		final Date modifedOn = new Date();
		entity.setUpdated(modifedOn);
		if (entity.getId() == null) {
			LOGGER.info("new order history created" + entity);
			entity.setCreated(modifedOn);
			dao.insert(entity);
		} else {
			LOGGER.info("order history updated" + entity);
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
	public IOrderHistory createEntity() {
		return dao.createEntity();
	}

}
