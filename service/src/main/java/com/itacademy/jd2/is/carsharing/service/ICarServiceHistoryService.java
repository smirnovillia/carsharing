package com.itacademy.jd2.is.carsharing.service;

import java.util.List;

import com.itacademy.jd2.is.carsharing.dao.api.entity.ICarServiceHistory;

public interface ICarServiceHistoryService {
	ICarServiceHistory get(Integer id);

	List<ICarServiceHistory> getAll();

	void save(ICarServiceHistory entity);

	void delete(Integer id);

	void deleteAll();

	ICarServiceHistory createEntity();
}
