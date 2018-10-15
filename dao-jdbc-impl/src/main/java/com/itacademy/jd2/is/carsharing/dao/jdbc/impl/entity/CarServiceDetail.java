package com.itacademy.jd2.is.carsharing.dao.jdbc.impl.entity;

import com.itacademy.jd2.is.carsharing.dao.api.entity.ICarServiceDetail;
import com.itacademy.jd2.is.carsharing.dao.api.entity.ICarServiceHistory;
import com.itacademy.jd2.is.carsharing.dao.api.entity.IServiceOperation;

public class CarServiceDetail extends BaseEntity implements ICarServiceDetail{

	private ICarServiceHistory carServiceHistory;
	private IServiceOperation serviceOperation;

	public ICarServiceHistory getCarServiceHistory() {
		return carServiceHistory;
	}

	public void setCarServiceHistory(ICarServiceHistory service) {
		this.carServiceHistory = service;
	}

	public IServiceOperation getServiceOperation() {
		return serviceOperation;
	}

	public void setServiceOperation(IServiceOperation serviceOperation) {
		this.serviceOperation = serviceOperation;
	}

	@Override
	public String toString() {
		return "CarServiceDetail [carServiceHistory=" + carServiceHistory + ", serviceOperation=" + serviceOperation
				+ "]";
	}

}
