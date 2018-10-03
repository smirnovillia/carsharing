package com.itacademy.jd2.is.carsharing.service;

import java.util.List;

import com.itacademy.jd2.is.carsharing.dao.api.entity.ICar;

public interface ICarService {
	ICar get(Integer id);

	List<ICar> getAll();

	void save(ICar entity);

	void delete(Integer id);

	void deleteAll();

	ICar createEntity();
}
