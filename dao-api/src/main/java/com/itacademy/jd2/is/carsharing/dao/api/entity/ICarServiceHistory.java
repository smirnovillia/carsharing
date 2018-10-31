package com.itacademy.jd2.is.carsharing.dao.api.entity;

import java.util.Date;
import java.util.List;

import com.itacademy.jd2.is.carsharing.dao.api.base.IBaseEntity;

public interface ICarServiceHistory extends IBaseEntity {

	ICar getCar();

	void setCar(ICar car);

	Date getServiceDate();

	void setServiceDate(Date serviceDate);

	double getCarMileage();

	void setCarMileage(double carMileage);

	String getServiceCompany();

	void setServiceCompany(String serviceCompany);

	List<IServiceOperation> getServiceOperationList();

	void setServiceOperationList(List<IServiceOperation> serviceOperationList);

	double getServicePrice();

	void setServicePrice(double servicePrice);
}
