package com.itacademy.jd2.is.carsharing.service;

import java.util.List;

import javax.transaction.Transactional;

import com.itacademy.jd2.is.carsharing.dao.api.entity.ISparePart;

public interface ISparePartService {
	ISparePart get(Integer id);

	List<ISparePart> getAll();

	@Transactional
	void save(ISparePart entity);

	@Transactional
	void delete(Integer id);

	@Transactional
	void deleteAll();

	@Transactional
	ISparePart createEntity();
}
