package com.itacademy.jd2.is.carsharing.dao.orm.impl;

import org.springframework.stereotype.Repository;

import com.itacademy.jd2.is.carsharing.dao.api.ICarDao;
import com.itacademy.jd2.is.carsharing.dao.api.entity.ICar;
import com.itacademy.jd2.is.carsharing.dao.orm.impl.entity.Car;

@Repository
public class CarDaoImpl extends AbstractDaoImpl<ICar, Integer> implements ICarDao{
	
	protected  CarDaoImpl() {
		super(Car.class);
	}
	@Override
	public ICar createEntity() {
		return new Car();
	}

}
