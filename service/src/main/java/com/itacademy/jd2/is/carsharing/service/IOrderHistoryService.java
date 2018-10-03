package com.itacademy.jd2.is.carsharing.service;

import java.util.List;

import com.itacademy.jd2.is.carsharing.dao.api.entity.IOrderHistory;

public interface IOrderHistoryService {
	IOrderHistory get(Integer id);

	List<IOrderHistory> getAll();

	void save(IOrderHistory entity);

	void delete(Integer id);

	void deleteAll();

	IOrderHistory createEntity();
}
