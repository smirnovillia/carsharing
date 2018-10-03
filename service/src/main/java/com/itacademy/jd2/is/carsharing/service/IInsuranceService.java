package com.itacademy.jd2.is.carsharing.service;

import java.util.List;

import com.itacademy.jd2.is.carsharing.dao.api.entity.IInsurance;

public interface IInsuranceService {
	IInsurance get(Integer id);

	List<IInsurance> getAll();

	void save(IInsurance entity);

	void delete(Integer id);

	void deleteAll();

	IInsurance createEntity();
}
