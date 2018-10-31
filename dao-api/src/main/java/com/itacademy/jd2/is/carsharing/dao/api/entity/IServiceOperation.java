package com.itacademy.jd2.is.carsharing.dao.api.entity;

import java.util.List;

import com.itacademy.jd2.is.carsharing.dao.api.base.IBaseEntity;

public interface IServiceOperation extends IBaseEntity {
	

	 ICarServiceHistory getCarServiceHistory();

	 void setCarServiceHistory(ICarServiceHistory carServiceHistory);

	 String getName();

	 void setName(String name);

	 double getPrice();

	 void setPrice(double price);

	 List<ISparePart> getSparePart();

	 void setSparePart(List<ISparePart> sparePart);
}
