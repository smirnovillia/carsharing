package com.itacademy.jd2.is.carsharing.service;

import java.util.List;

import javax.transaction.Transactional;

import com.itacademy.jd2.is.carsharing.dao.api.entity.ICarServiceDetail;

public interface ICarServiceDetailService {
	ICarServiceDetail get(Integer id);

	List<ICarServiceDetail> getAll();

	@Transactional
	void save(ICarServiceDetail entity);

	@Transactional
	void delete(Integer id);

	@Transactional
	void deleteAll();

	@Transactional
	ICarServiceDetail createEntity();
}
