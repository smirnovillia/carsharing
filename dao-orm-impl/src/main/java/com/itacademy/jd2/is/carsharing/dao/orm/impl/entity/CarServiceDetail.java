package com.itacademy.jd2.is.carsharing.dao.orm.impl.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.itacademy.jd2.is.carsharing.dao.api.entity.ICarServiceDetail;
import com.itacademy.jd2.is.carsharing.dao.api.entity.ICarServiceHistory;
import com.itacademy.jd2.is.carsharing.dao.api.entity.IServiceOperation;

@Entity
public class CarServiceDetail extends BaseEntity implements ICarServiceDetail{

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = CarServiceHistory.class)
	private ICarServiceHistory carServiceHistory;
	
	@ManyToOne(fetch = FetchType.LAZY, targetEntity = ServiceOperation.class)
	private IServiceOperation serviceOperation;

	@Override
	public ICarServiceHistory getCarServiceHistory() {
		return carServiceHistory;
	}

	@Override
	public void setCarServiceHistory(ICarServiceHistory service) {
		this.carServiceHistory = service;
	}
	
	@Override
	public IServiceOperation getServiceOperation() {
		return serviceOperation;
	}

	@Override
	public void setServiceOperation(IServiceOperation serviceOperation) {
		this.serviceOperation = serviceOperation;
	}

	@Override
	public String toString() {
		return "CarServiceDetail [carServiceHistory=" + carServiceHistory + ", serviceOperation=" + serviceOperation
				+ "]";
	}

}
