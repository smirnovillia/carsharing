package com.itacademy.jd2.is.carsharing.service;

import java.util.List;

import com.itacademy.jd2.is.carsharing.dao.api.entity.IBrand;

public interface IBrandService {
	IBrand get(Integer id);

	List<IBrand> getAll();

	void save(IBrand entity);

	void delete(Integer id);

	void deleteAll();

	IBrand createEntity();
}
