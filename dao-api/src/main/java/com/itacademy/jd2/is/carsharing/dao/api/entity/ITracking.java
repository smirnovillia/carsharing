package com.itacademy.jd2.is.carsharing.dao.api.entity;

import java.util.Date;

import com.itacademy.jd2.is.carsharing.dao.api.base.IBaseEntity;

public interface ITracking extends IBaseEntity {

	ICar getCar();

	void setCar(ICar car);

	Date getTrackingDate();

	void setTrackingDate(Date trackingDate);

	double getLatitude();

	void setLatitude(double latitude);

	double getLongitude();

	void setLongitude(double longitude);
}
