package com.itacademy.jd2.is.carsharing.service;

import java.util.List;

import javax.transaction.Transactional;

import com.itacademy.jd2.is.carsharing.dao.api.entity.ICarServiceHistory;

public interface ICarServiceHistoryService {
	ICarServiceHistory get(Integer id);

	List<ICarServiceHistory> getAll();

	@Transactional
	void save(ICarServiceHistory entity);

	@Transactional
	void delete(Integer id);

	@Transactional
	void deleteAll();

	@Transactional
	ICarServiceHistory createEntity();
}
