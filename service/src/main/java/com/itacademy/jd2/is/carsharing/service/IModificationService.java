package com.itacademy.jd2.is.carsharing.service;

import java.util.List;

import com.itacademy.jd2.is.carsharing.dao.api.entity.IModification;

public interface IModificationService {
	IModification get(Integer id);

	List<IModification> getAll();

	void save(IModification entity);

	void delete(Integer id);

	void deleteAll();

	IModification createEntity();
}
