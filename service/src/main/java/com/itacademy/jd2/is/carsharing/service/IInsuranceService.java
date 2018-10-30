package com.itacademy.jd2.is.carsharing.service;

import java.util.List;

import javax.transaction.Transactional;

import com.itacademy.jd2.is.carsharing.dao.api.entity.IInsurance;

public interface IInsuranceService {
	IInsurance get(Integer id);

	List<IInsurance> getAll();

	@Transactional
	void save(IInsurance entity);

	@Transactional
	void delete(Integer id);

	@Transactional
	void deleteAll();

	@Transactional
	IInsurance createEntity();
}
