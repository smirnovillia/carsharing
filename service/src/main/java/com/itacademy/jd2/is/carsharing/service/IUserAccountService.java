package com.itacademy.jd2.is.carsharing.service;

import java.util.List;

import javax.transaction.Transactional;

import com.itacademy.jd2.is.carsharing.dao.api.entity.ICustomer;
import com.itacademy.jd2.is.carsharing.dao.api.entity.IUserAccount;
import com.itacademy.jd2.is.carsharing.dao.api.filter.UserAccountFilter;

public interface IUserAccountService {
	IUserAccount get(Integer id);

	List<IUserAccount> getAll();

	@Transactional
	void save(IUserAccount entity);
	
	@Transactional
	void save(IUserAccount entity, ICustomer customer);
	
	@Transactional
	void delete(Integer id);

	@Transactional
	void deleteAll();

	@Transactional
	IUserAccount createEntity();
	
	@Transactional
	ICustomer createCustomerEntity();
	
	IUserAccount getByLogin(String user);
	
	List<IUserAccount> find(UserAccountFilter filter);

	long getCount(UserAccountFilter filter);
	
	
}
