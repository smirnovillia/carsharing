package com.itacademy.jd2.is.carsharing.service;

import java.util.List;

import javax.transaction.Transactional;

import com.itacademy.jd2.is.carsharing.dao.api.entity.ICustomer;

public interface ICustomerService {
	ICustomer get(Integer id);

	List<ICustomer> getAll();

	@Transactional
	void save(ICustomer entity);

	@Transactional
	void delete(Integer id);

	@Transactional
	void deleteAll();

	@Transactional
	ICustomer createEntity();
}
