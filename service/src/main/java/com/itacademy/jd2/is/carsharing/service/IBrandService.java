package com.itacademy.jd2.is.carsharing.service;

import java.util.List;

import com.itacademy.jd2.is.carsharing.dao.api.entity.IBrand;
import com.itacademy.jd2.is.carsharing.dao.api.filter.BrandFilter;

public interface IBrandService {
	IBrand get(Integer id);

	List<IBrand> getAll();

	void save(IBrand entity);

	void delete(Integer id);

	void deleteAll();

	IBrand createEntity();

	List<IBrand> find(BrandFilter filter);
	
	long getCount(BrandFilter filter);
}
