package com.itacademy.jd2.is.carsharing.service;

import java.util.List;

import com.itacademy.jd2.is.carsharing.dao.api.entity.IBlackList;

public interface IBlackListService {
	IBlackList get(Integer id);

	List<IBlackList> getAll();

	void save(IBlackList entity);

	void delete(Integer id);

	void deleteAll();

	IBlackList createEntity();
}
