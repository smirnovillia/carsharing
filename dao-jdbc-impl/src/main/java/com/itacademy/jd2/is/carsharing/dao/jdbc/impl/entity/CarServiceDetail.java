package com.itacademy.jd2.is.carsharing.dao.jdbc.impl.entity;

import com.itacademy.jd2.is.carsharing.dao.api.entity.ICarServiceHistory;
import com.itacademy.jd2.is.carsharing.dao.api.entity.IServiceOperation;

public class CarServiceDetail extends BaseEntity {

	private ICarServiceHistory service;
	private IServiceOperation serviceOperation;

	public ICarServiceHistory getService() {
		return service;
	}

	public void setService(ICarServiceHistory service) {
		this.service = service;
	}

	public IServiceOperation getServiceOperation() {
		return serviceOperation;
	}

	public void setServiceOperation(IServiceOperation serviceOperation) {
		this.serviceOperation = serviceOperation;
	}

}
