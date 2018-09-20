package com.itacademy.jd2.is.carsharing.service.impl;

import java.util.Date;
import java.util.List;

import com.itacademy.jd2.is.carsharing.dao.api.IBrandDao;
import com.itacademy.jd2.is.carsharing.dao.api.entity.IBrand;
import com.itacademy.jd2.is.carsharing.dao.jdbc.impl.BrandDaoImpl;
import com.itacademy.jd2.is.carsharing.service.IBrandService;

public class BrandServiceImpl implements IBrandService {
	private IBrandDao dao = new BrandDaoImpl();

	@Override
	public IBrand createEntity() {
		return dao.createEntity();
	}

	@Override
	public void save(final IBrand entity) {
		final Date modifedOn = new Date();
		entity.setUpdated(modifedOn);
		if (entity.getId() == null) {
			entity.setCreated(modifedOn);
			dao.insert(entity);
		} else {
			dao.update(entity);
		}
	}

	@Override
	public IBrand get(final Integer id) {
		final IBrand entity = dao.get(id);
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
	public List<IBrand> getAll() {
		final List<IBrand> all = dao.selectAll();
		return all;
	}
}
