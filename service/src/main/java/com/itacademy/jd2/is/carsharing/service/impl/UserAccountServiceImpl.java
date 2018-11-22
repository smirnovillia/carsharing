package com.itacademy.jd2.is.carsharing.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itacademy.jd2.is.carsharing.dao.api.ICustomerDao;
import com.itacademy.jd2.is.carsharing.dao.api.IUserAccountDao;
import com.itacademy.jd2.is.carsharing.dao.api.entity.ICustomer;
import com.itacademy.jd2.is.carsharing.dao.api.entity.IUserAccount;
import com.itacademy.jd2.is.carsharing.service.IUserAccountService;

@Service
public class UserAccountServiceImpl implements IUserAccountService {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserAccountServiceImpl.class);
	private IUserAccountDao dao;
	private ICustomerDao customerDao;

	@Autowired
	public UserAccountServiceImpl(IUserAccountDao dao, ICustomerDao customerDao) {
		super();
		this.dao = dao;
		this.customerDao = customerDao;
	}
	
	@Override
	public IUserAccount createEntity() {
		return dao.createEntity();
	}

	@Override
	public IUserAccount get(Integer id) {
		final IUserAccount entity = dao.get(id);
		return entity;
	}

	@Override
	public List<IUserAccount> getAll() {
		final List<IUserAccount> all = dao.selectAll();
		return all;
	}

	@Override
	public void save(IUserAccount entity) {
		final Date modifedOn = new Date();
		entity.setUpdated(modifedOn);
		if (entity.getId() == null) {
			LOGGER.info("new user account created" + entity);
			entity.setCreated(modifedOn);
			dao.insert(entity);
		} else {
			LOGGER.info("user account updated" + entity);
			dao.update(entity);
		}
	}
	
	@Override
	public void save(IUserAccount user, ICustomer customer) {
		final Date modifedOn = new Date();
		user.setUpdated(modifedOn);
		customer.setUpdated(modifedOn);
		if (user.getId() == null) {
			LOGGER.info("new user account, new customer created" + user);
			user.setCreated(modifedOn);
			dao.insert(user);
			
			customer.setId(user.getId());
			customer.setCreated(modifedOn);
			customer.setUserAccount(user);
			customerDao.insert(customer);
			
			user.setCustomer(customer);
		} else {
			LOGGER.info("user account, customer updated" + user);
			dao.update(user);
			customerDao.update(customer);
		}
	}

	@Override
	public void delete(Integer id) {
		dao.delete(id);
	}

	@Override
	public void deleteAll() {
		dao.deleteAll();
	}

	@Override
	public IUserAccount getByLogin(String login) {
		IUserAccount theUser = dao.createEntity();  
		for (IUserAccount users : getAll()) {
			if(users.getLogin().equals(login)) {
				theUser = users;
			}
		}
		return theUser;
	}
	
	

}
