package com.itacademy.jd2.is.carsharing.dao.api.entity;

import com.itacademy.jd2.is.carsharing.dao.api.base.IBaseEntity;

public interface IBlackList extends IBaseEntity {

	ICustomer getCustomer();

	void setCustomer(ICustomer customer);

	String getReason();

	void setReason(String reason);
}
