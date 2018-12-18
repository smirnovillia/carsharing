package com.itacademy.jd2.is.carsharing.service;

import java.util.List;

import javax.transaction.Transactional;

import com.itacademy.jd2.is.carsharing.dao.api.entity.IOrderHistory;
import com.itacademy.jd2.is.carsharing.dao.api.filter.OrderHistoryFilter;

public interface IOrderHistoryService {
	IOrderHistory get(Integer id);

	List<IOrderHistory> getAll();

	@Transactional
	void save(IOrderHistory entity);

	@Transactional
	void delete(Integer id);

	@Transactional
	void deleteAll();

	@Transactional
	IOrderHistory createEntity();

	long getCount(OrderHistoryFilter filter);

	IOrderHistory getFullInfo(Integer id);

	List<IOrderHistory> find(OrderHistoryFilter filter);
}
