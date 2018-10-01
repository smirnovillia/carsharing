package com.itacademy.jd2.is.carsharing.dao.api.entity;

import java.util.Date;

import com.itacademy.jd2.is.carsharing.dao.api.base.IBaseEntity;

public interface IOrderHistory extends IBaseEntity {

	ICustomer getCustomer();

	void setCustomer(ICustomer customer);

	ICar getCar();

	void setCar(ICar car);

	Date getOrderDate();

	void setOrderDate(Date orderDate);

	double getOrderMileage();

	void setOrderMileage(double orderMileage);

	double getRate();

	void setRate(double rate);

	double getPrice();

	void setPrice(double price);
}
