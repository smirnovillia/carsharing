package com.itacademy.jd2.is.carsharing.service;

import java.util.List;

import com.itacademy.jd2.is.carsharing.dao.api.entity.IServiceOperation;

public interface IServiceOperationService {
	IServiceOperation get(Integer id);

	List<IServiceOperation> getAll();

	void save(IServiceOperation entity);

	void delete(Integer id);

	void deleteAll();

	IServiceOperation createEntity();
}
