package com.itacademy.jd2.is.carsharing.dao.api.entity;

import com.itacademy.jd2.is.carsharing.dao.api.base.IBaseEntity;

public interface IServiceOperation extends IBaseEntity {
	
	 String getName();

	 void setName(String name);

	 double getPrice();

	 void setPrice(double price);

	 ISparePart getSparePart();

	 void setSparePart(ISparePart sparePart);
}
