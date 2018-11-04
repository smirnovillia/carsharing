package com.itacademy.jd2.is.carsharing.dao.api.entity;

import com.itacademy.jd2.is.carsharing.dao.api.base.IBaseEntity;

public interface ITracking extends IBaseEntity {

	ICar getCar();

	void setCar(ICar car);

	double getLatitude();

	void setLatitude(double latitude);

	double getLongitude();

	void setLongitude(double longitude);
}
