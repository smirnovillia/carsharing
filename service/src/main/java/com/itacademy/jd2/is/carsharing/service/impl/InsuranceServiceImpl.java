package com.itacademy.jd2.is.carsharing.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itacademy.jd2.is.carsharing.dao.api.IInsuranceDao;
import com.itacademy.jd2.is.carsharing.dao.api.entity.IInsurance;
import com.itacademy.jd2.is.carsharing.service.IInsuranceService;

@Service
public class InsuranceServiceImpl implements IInsuranceService {

	private static final Logger LOGGER = LoggerFactory.getLogger(InsuranceServiceImpl.class);
	private IInsuranceDao dao;

	@Autowired
	public InsuranceServiceImpl(IInsuranceDao dao) {
		super();
		this.dao = dao;
	}

	@Override
	public IInsurance get(Integer id) {
		final IInsurance entity = dao.get(id);
		return entity;
	}

	@Override
	public List<IInsurance> getAll() {
		final List<IInsurance> all = dao.selectAll();
		return all;
	}

	@Override
	public void save(IInsurance entity) {
		final Date modifedOn = new Date();
		entity.setUpdated(modifedOn);
		if (entity.getId() == null) {
			LOGGER.info("new insurance created" + entity);
			entity.setCreated(modifedOn);
			dao.insert(entity);
		} else {
			LOGGER.info("insurance updated" + entity);
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
	public IInsurance createEntity() {
		return dao.createEntity();
	}

}
