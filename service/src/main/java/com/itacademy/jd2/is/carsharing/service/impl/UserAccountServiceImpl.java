package com.itacademy.jd2.is.carsharing.service.impl;

import java.security.MessageDigest;
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
import com.itacademy.jd2.is.carsharing.dao.api.filter.UserAccountFilter;
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
	
	public ICustomer createCustomerEntity() {
		return customerDao.createEntity();
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
	public void save(IUserAccount entity, ICustomer customer) {
		final Date modifedDate = new Date();
		entity.setUpdated(modifedDate);
		customer.setUpdated(modifedDate);
		if (entity.getId() == null) {
			LOGGER.info("new user account created" + entity);
			entity.setCreated(modifedDate);
			dao.insert(entity);
			
			customer.setId(entity.getId());
			customer.setCreated(modifedDate);
			customer.setUserAccount(entity);
			customerDao.insert(customer);
			
			entity.setCustomer(customer);
		} else {
			LOGGER.info("user account updated" + entity);
			dao.update(entity);
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
			if (users.getLogin().equals(login)) {
				theUser = users;
			}
		}
		return theUser;
	}

	public void encryptPass(String pass) {
		String algorithm = "SHA";

		byte[] plainText = pass.getBytes();

		try {
			MessageDigest md = MessageDigest.getInstance(algorithm);

			md.reset();
			md.update(plainText);
			byte[] encodedPassword = md.digest();

			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < encodedPassword.length; i++) {
				if ((encodedPassword[i] & 0xff) < 0x10) {
					sb.append("0");
				}

				sb.append(Long.toString(encodedPassword[i] & 0xff, 16));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<IUserAccount> find(UserAccountFilter filter) {
		return dao.find(filter);
	}

	@Override
	public long getCount(UserAccountFilter filter) {
		return dao.getCount(filter);
	}

}
