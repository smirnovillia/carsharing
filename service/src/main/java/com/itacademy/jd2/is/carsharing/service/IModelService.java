package com.itacademy.jd2.is.carsharing.service;

import java.util.List;

import com.itacademy.jd2.is.carsharing.dao.api.entity.IModel;

public interface IModelService {
	IModel get(Integer id);

	List<IModel> getAll();

	void save(IModel entity);

	void delete(Integer id);

	void deleteAll();

	IModel createEntity();
}
