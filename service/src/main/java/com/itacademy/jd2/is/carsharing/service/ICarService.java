package com.itacademy.jd2.is.carsharing.service;

import java.util.List;

import javax.transaction.Transactional;

import com.itacademy.jd2.is.carsharing.dao.api.entity.ICar;
import com.itacademy.jd2.is.carsharing.dao.api.filter.CarFilter;

public interface ICarService {
	ICar get(Integer id);

	List<ICar> getAll();

	@Transactional
	void save(ICar entity);

	@Transactional
	void delete(Integer id);

	@Transactional
	void deleteAll();

	@Transactional
	ICar createEntity();
	
	List<ICar> find(CarFilter filter);

	long getCount(CarFilter filter);
	
	
	
}
