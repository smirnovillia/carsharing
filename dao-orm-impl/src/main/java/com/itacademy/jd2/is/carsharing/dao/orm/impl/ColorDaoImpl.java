package com.itacademy.jd2.is.carsharing.dao.orm.impl;

import org.springframework.stereotype.Repository;

import com.itacademy.jd2.is.carsharing.dao.api.IColorDao;
import com.itacademy.jd2.is.carsharing.dao.api.entity.IColor;
import com.itacademy.jd2.is.carsharing.dao.orm.impl.entity.Color;

@Repository
public class ColorDaoImpl extends AbstractDaoImpl<IColor, Integer> implements IColorDao{

	protected ColorDaoImpl() {
		super(Color.class);
	}

	@Override
	public IColor createEntity() {
		return new Color();
	}


}
