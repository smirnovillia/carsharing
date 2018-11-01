package com.itacademy.jd2.is.carsharing.dao.orm.impl.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.itacademy.jd2.is.carsharing.dao.api.entity.ICar;
import com.itacademy.jd2.is.carsharing.dao.api.entity.ICarServiceHistory;
import com.itacademy.jd2.is.carsharing.dao.api.entity.IServiceOperation;

@Entity
public class CarServiceHistory extends BaseEntity implements ICarServiceHistory {

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Car.class)
	private ICar car;
	
	@Column
	private Date serviceDate;
	
	@Column
	private double carMileage;
	
	@Column
	private String serviceCompany;
	
	@Column
	private List<IServiceOperation> serviceOperationList;
	
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

	@Override
	public void setServiceDate(Date serviceDate) {
		this.serviceDate = serviceDate;
	}

	@Override
	public double getCarMileage() {
		return carMileage;
	}

	@Override
	public void setCarMileage(double carMileage) {
		this.carMileage = carMileage;
	}

	@Override
	public String getServiceCompany() {
		return serviceCompany;
	}

	@Override
	public void setServiceCompany(String serviceCompany) {
		this.serviceCompany = serviceCompany;
	}

	@Override
	public List<IServiceOperation> getServiceOperationList() {
		return serviceOperationList;
	}

	@Override
	public void setServiceOperationList(List<IServiceOperation> serviceOperationList) {
		this.serviceOperationList = serviceOperationList;
	}

	@Override
	public double getServicePrice() {
		return servicePrice;
	}

	@Override
	public void setServicePrice(double servicePrice) {
		this.servicePrice = servicePrice;
	}
	
}
