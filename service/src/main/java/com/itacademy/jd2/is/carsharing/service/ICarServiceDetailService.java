package com.itacademy.jd2.is.carsharing.service;

import java.util.List;

import com.itacademy.jd2.is.carsharing.dao.api.entity.ICarServiceDetail;

public interface ICarServiceDetailService {
	ICarServiceDetail get(Integer id);

	List<ICarServiceDetail> getAll();

	void save(ICarServiceDetail entity);

	void delete(Integer id);

	void deleteAll();

	ICarServiceDetail createEntity();
}
