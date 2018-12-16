package com.itacademy.jd2.is.carsharing.service;

import java.util.List;

import javax.transaction.Transactional;

import com.itacademy.jd2.is.carsharing.dao.api.entity.IModification;
import com.itacademy.jd2.is.carsharing.dao.api.filter.ModificationFilter;

public interface IModificationService {
	IModification get(Integer id);

	List<IModification> getAll();

	@Transactional
	void save(IModification entity);

	@Transactional
	void delete(Integer id);

	@Transactional
	void deleteAll();

	@Transactional
	IModification createEntity();

	List<IModification> find(ModificationFilter filter);
}
