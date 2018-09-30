package com.itacademy.jd2.is.carsharing.dao.api.entity;

import com.itacademy.jd2.is.carsharing.dao.api.base.IBaseEntity;

public interface ICarServiceDetail extends IBaseEntity {

	ICarServiceHistory getService();

	void setService(ICarServiceHistory service);

	IServiceOperation getServiceOperation();

	void setServiceOperation(IServiceOperation serviceOperation);
}
