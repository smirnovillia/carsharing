package com.itacademy.jd2.is.carsharing.service;

import java.util.List;

import javax.transaction.Transactional;

import com.itacademy.jd2.is.carsharing.dao.api.entity.IColor;

public interface IColorService {
	IColor get(Integer id);

	List<IColor> getAll();

	@Transactional
	void save(IColor entity);

	@Transactional
	void delete(Integer id);

	@Transactional
	void deleteAll();

	@Transactional
	IColor createEntity();
}
