package com.itacademy.jd2.is.carsharing.dao.jdbc.impl.entity;

import com.itacademy.jd2.is.carsharing.dao.api.entity.ICar;
import com.itacademy.jd2.is.carsharing.dao.api.entity.ITracking;

public class Tracking extends BaseEntity implements ITracking {

	private ICar car;
	private double latitude;
	private double longitude;

	public ICar getCar() {
		return car;
	}

	public void setCar(ICar car) {
		this.car = car;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	@Override
	public String toString() {
		return "Tracking [car=" + car + ", latitude=" + latitude + ", longitude="
				+ longitude + "]";
	}

}
