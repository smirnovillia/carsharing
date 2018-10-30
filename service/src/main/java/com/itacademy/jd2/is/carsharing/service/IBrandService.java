package com.itacademy.jd2.is.carsharing.service;

import java.util.List;

import javax.transaction.Transactional;

import com.itacademy.jd2.is.carsharing.dao.api.entity.IBrand;
import com.itacademy.jd2.is.carsharing.dao.api.filter.BrandFilter;

public interface IBrandService {
	IBrand get(Integer id);

	List<IBrand> getAll();

	@Transactional
	void save(IBrand entity);

	@Transactional
	void delete(Integer id);

	@Transactional
	void deleteAll();

	@Transactional
	IBrand createEntity();

	List<IBrand> find(BrandFilter filter);
	
	long getCount(BrandFilter filter);
}
