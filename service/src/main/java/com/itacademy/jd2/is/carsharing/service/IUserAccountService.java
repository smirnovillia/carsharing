package com.itacademy.jd2.is.carsharing.service;

import java.util.List;

import com.itacademy.jd2.is.carsharing.dao.api.entity.IUserAccount;

public interface IUserAccountService {
	IUserAccount get(Integer id);

	List<IUserAccount> getAll();

	void save(IUserAccount entity);

	void delete(Integer id);

	void deleteAll();

	IUserAccount createEntity();
}
