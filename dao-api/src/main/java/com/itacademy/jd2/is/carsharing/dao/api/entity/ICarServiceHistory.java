package com.itacademy.jd2.is.carsharing.dao.api.entity;

import java.util.Date;

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

	 String getOperation();

	 void setOperation(String operation);

	 double getOperationPrice();

	 void setOperationPrice(double operationPrice);

	 String getSparePart();

	 void setSparePart(String sparePart);

	 double getSparePartPrice();

	 void setSparePartPrice(double sparePartPrice);

	 double getServicePrice();

	 void setServicePrice(double servicePrice);
}
