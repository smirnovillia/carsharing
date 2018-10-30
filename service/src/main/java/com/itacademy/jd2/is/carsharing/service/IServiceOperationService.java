package com.itacademy.jd2.is.carsharing.service;

import java.util.List;

import javax.transaction.Transactional;

import com.itacademy.jd2.is.carsharing.dao.api.entity.IServiceOperation;

public interface IServiceOperationService {
	IServiceOperation get(Integer id);

	List<IServiceOperation> getAll();

	@Transactional
	void save(IServiceOperation entity);

	@Transactional
	void delete(Integer id);

	@Transactional
	void deleteAll();

	@Transactional
	IServiceOperation createEntity();
}
