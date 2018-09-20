package com.itacademy.jd2.is.carsharing.dao.api.entity;

import com.itacademy.jd2.is.carsharing.dao.api.base.IBaseEntity;

public interface IModel extends IBaseEntity {
	String getName();

	void setName(String name);

	IBrand getBrand();

	void setBrand(IBrand brand);
}
