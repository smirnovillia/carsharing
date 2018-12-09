package com.itacademy.jd2.is.carsharing.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itacademy.jd2.is.carsharing.dao.api.ICustomerDao;
import com.itacademy.jd2.is.carsharing.dao.api.entity.ICustomer;
import com.itacademy.jd2.is.carsharing.dao.api.filter.CustomerFilter;
import com.itacademy.jd2.is.carsharing.service.ICustomerService;

@Service
public class CustomerServiceImpl implements ICustomerService {

	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerServiceImpl.class);
	private ICustomerDao dao;

	@Autowired
	public CustomerServiceImpl(ICustomerDao dao) {
		super();
		this.dao = dao;
	}

	@Override
	public ICustomer get(Integer id) {
		final ICustomer entity = dao.get(id);
		return entity;
	}

	@Override
	public List<ICustomer> getAll() {
		final List<ICustomer> all = dao.selectAll();
		return all;
	}

	@Override
	public void save(ICustomer entity) {
		final Date modifedOn = new Date();
		entity.setUpdated(modifedOn);
		if (entity.getCreated() == null) {
			LOGGER.info("new customer created" + entity);
			entity.setCreated(modifedOn);
			dao.insert(entity);
		} else {
			LOGGER.info("customer updated" + entity);
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
	public ICustomer createEntity() {
		return dao.createEntity();
	}

	@Override
	public List<ICustomer> find(CustomerFilter filter) {
		return dao.find(filter);
	}

	@Override
	public long getCount(CustomerFilter filter) {
		return dao.getCount(filter);
	}
	
	

}
