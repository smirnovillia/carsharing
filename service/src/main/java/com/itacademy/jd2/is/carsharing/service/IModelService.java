package com.itacademy.jd2.is.carsharing.service;

import java.util.List;

import javax.transaction.Transactional;

import com.itacademy.jd2.is.carsharing.dao.api.entity.IModel;
import com.itacademy.jd2.is.carsharing.dao.api.filter.ModelFilter;

public interface IModelService {
	IModel get(Integer id);

	List<IModel> getAll();

	@Transactional
	void save(IModel entity);

	@Transactional
	void delete(Integer id);

	@Transactional
	void deleteAll();

	@Transactional
	IModel createEntity();

	List<IModel> find(ModelFilter filter);

	long getCount(ModelFilter filter);
}
