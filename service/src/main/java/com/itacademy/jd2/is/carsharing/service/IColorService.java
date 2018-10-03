package com.itacademy.jd2.is.carsharing.service;

import java.util.List;

import com.itacademy.jd2.is.carsharing.dao.api.entity.IColor;

public interface IColorService {
	IColor get(Integer id);

	List<IColor> getAll();

	void save(IColor entity);

	void delete(Integer id);

	void deleteAll();

	IColor createEntity();
}
