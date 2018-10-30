package com.itacademy.jd2.is.carsharing.service;

import java.util.List;

import javax.transaction.Transactional;

import com.itacademy.jd2.is.carsharing.dao.api.entity.IBlackList;

public interface IBlackListService {
	IBlackList get(Integer id);

	List<IBlackList> getAll();

	@Transactional
	void save(IBlackList entity);

	@Transactional
	void delete(Integer id);

	@Transactional
	void deleteAll();

	@Transactional
	IBlackList createEntity();
}
