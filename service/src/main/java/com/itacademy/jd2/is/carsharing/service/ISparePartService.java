package com.itacademy.jd2.is.carsharing.service;

import java.util.List;

import com.itacademy.jd2.is.carsharing.dao.api.entity.ISparePart;

public interface ISparePartService {
	ISparePart get(Integer id);

	List<ISparePart> getAll();

	void save(ISparePart entity);

	void delete(Integer id);

	void deleteAll();

	ISparePart createEntity();
}
