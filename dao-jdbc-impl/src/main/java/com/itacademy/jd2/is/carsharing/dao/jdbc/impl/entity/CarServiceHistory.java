package com.itacademy.jd2.is.carsharing.dao.jdbc.impl.entity;

import java.util.Date;
import java.util.List;

import com.itacademy.jd2.is.carsharing.dao.api.entity.ICar;
import com.itacademy.jd2.is.carsharing.dao.api.entity.ICarServiceHistory;
import com.itacademy.jd2.is.carsharing.dao.api.entity.IServiceOperation;

public class CarServiceHistory extends BaseEntity implements ICarServiceHistory {

	private ICar car;
	private Date serviceDate;
	private double carMileage;
	private String serviceCompany;
	private List<IServiceOperation> serviceOperationList;
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

	public List<IServiceOperation> getServiceOperationList() {
		return serviceOperationList;
	}

	public void setServiceOperationList(List<IServiceOperation> serviceOperationList) {
		this.serviceOperationList = serviceOperationList;
	}

	public double getServicePrice() {
		return servicePrice;
	}

	public void setServicePrice(double servicePrice) {
		this.servicePrice = servicePrice;
	}

	@Override
	public String toString() {
		return "CarServiceHistory [car=" + car + ", serviceDate=" + serviceDate + ", carMileage=" + carMileage
				+ ", serviceCompany=" + serviceCompany + ", servicePrice=" + servicePrice + "]";
	}

}
