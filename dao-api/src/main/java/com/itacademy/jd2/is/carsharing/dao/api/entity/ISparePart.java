package com.itacademy.jd2.is.carsharing.dao.api.entity;

import com.itacademy.jd2.is.carsharing.dao.api.base.IBaseEntity;

public interface ISparePart extends IBaseEntity{

	 IServiceOperation getServiceOperation();

	 void setServiceOperation(IServiceOperation serviceOperation);

	 String getName();

	 void setName(String name);

	 double getPrice();

	 void setPrice(double price);
}
