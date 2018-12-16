package com.itacademy.jd2.is.carsharing.dao.api;

import java.util.List;

import com.itacademy.jd2.is.carsharing.dao.api.entity.ICar;
import com.itacademy.jd2.is.carsharing.dao.api.filter.CarFilter;

public interface ICarDao extends IBaseDao<ICar, Integer> {
	
	List<ICar> find(CarFilter filter);

	long getCount(CarFilter filter);

	ICar getFullInfo(Integer id);

}
