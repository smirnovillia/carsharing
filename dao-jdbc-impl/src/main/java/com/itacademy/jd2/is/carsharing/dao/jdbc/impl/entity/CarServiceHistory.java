package com.itacademy.jd2.is.carsharing.dao.jdbc.impl.entity;

import java.util.Date;

import com.itacademy.jd2.is.carsharing.dao.api.entity.ICar;
import com.itacademy.jd2.is.carsharing.dao.api.entity.ICarServiceHistory;

public class CarServiceHistory extends BaseEntity implements ICarServiceHistory{

	private ICar car;
	private Date serviceDate;
	private double carMileage;
	private String serviceCompany;
	private String operation;
	private double operationPrice;
	private String sparePart;
	private double sparePartPrice;
	private double servicePrice;
	
	public ICar getCar() {
		return car;
	}
	public void setCar(ICar car) {
		this.car = car;
	}
	public Date getServiceDate() {
		return serviceDate;
	}
	public void setServiceDate(Date serviceDate) {
		this.serviceDate = serviceDate;
	}
	public double getCarMileage() {
		return carMileage;
	}
	public void setCarMileage(double carMileage) {
		this.carMileage = carMileage;
	}
	public String getServiceCompany() {
		return serviceCompany;
	}
	public void setServiceCompany(String serviceCompany) {
		this.serviceCompany = serviceCompany;
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public double getOperationPrice() {
		return operationPrice;
	}
	public void setOperationPrice(double operationPrice) {
		this.operationPrice = operationPrice;
	}
	public String getSparePart() {
		return sparePart;
	}
	public void setSparePart(String sparePart) {
		this.sparePart = sparePart;
	}
	public double getSparePartPrice() {
		return sparePartPrice;
	}
	public void setSparePartPrice(double sparePartPrice) {
		this.sparePartPrice = sparePartPrice;
	}
	public double getServicePrice() {
		return servicePrice;
	}
	public void setServicePrice(double servicePrice) {
		this.servicePrice = servicePrice;
	}
	
}
