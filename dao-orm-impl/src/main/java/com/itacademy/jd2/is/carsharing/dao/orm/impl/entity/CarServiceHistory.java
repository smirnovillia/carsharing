package com.itacademy.jd2.is.carsharing.dao.orm.impl.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;

import com.itacademy.jd2.is.carsharing.dao.api.entity.ICar;
import com.itacademy.jd2.is.carsharing.dao.api.entity.ICarServiceHistory;

@Entity
public class CarServiceHistory extends BaseEntity implements ICarServiceHistory {

	@OneToOne(fetch = FetchType.LAZY, targetEntity = Car.class)
	private ICar car;
	
	@Column
	private Date serviceDate;
	
	@Column
	private double carMileage;
	
	@Column
	private String serviceCompany;
	
	@Column
	private double servicePrice;
	
	@Override
	public ICar getCar() {
		return car;
	}
	
	@Override
	public void setCar(ICar car) {
		this.car = car;
	}

	@Override
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
