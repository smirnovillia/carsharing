package com.itacademy.jd2.is.carsharing.dao.api.entity;

import java.util.Set;

import com.itacademy.jd2.is.carsharing.dao.api.base.IBaseEntity;

public interface IModel extends IBaseEntity {
	String getName();

	void setName(String name);

	IBrand getBrand();

	void setBrand(IBrand brand);

	void setColors(Set<IColor> colors);

	Set<IColor> getColors();
}
