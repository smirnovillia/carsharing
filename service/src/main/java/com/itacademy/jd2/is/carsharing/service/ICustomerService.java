package com.itacademy.jd2.is.carsharing.service;

import java.util.List;

import javax.transaction.Transactional;

import com.itacademy.jd2.is.carsharing.dao.api.entity.IBrand;
import com.itacademy.jd2.is.carsharing.dao.api.entity.ICustomer;
import com.itacademy.jd2.is.carsharing.dao.api.filter.BrandFilter;
import com.itacademy.jd2.is.carsharing.dao.api.filter.CustomerFilter;

public interface ICustomerService {
	ICustomer get(Integer id);

	List<ICustomer> getAll();

	@Transactional
	void save(ICustomer entity);

	@Transactional
	void delete(Integer id);

	@Transactional
	void deleteAll();
	
	List<ICustomer> find(CustomerFilter filter);
	
	long getCount(CustomerFilter filter);

	@Transactional
	ICustomer createEntity();
}
