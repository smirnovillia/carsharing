package com.itacademy.jd2.is.carsharing.dao.orm.impl.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import com.itacademy.jd2.is.carsharing.dao.api.entity.ICar;
import com.itacademy.jd2.is.carsharing.dao.api.entity.ITracking;

@Entity
public class Tracking extends BaseEntity implements ITracking {

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Car.class)
	private ICar car;
	
	@Column
	private double latitude;
	
	@Column
	private double longitude;

	@Override
	public ICar getCar() {
		return car;
	}

	@Override
	public void setCar(ICar car) {
		this.car = car;
	}

	@Override
	public double getLatitude() {
		return latitude;
	}

	@Override
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	@Override
	public double getLongitude() {
		return longitude;
	}

	@Override
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	@Override
	public String toString() {
		return "Tracking [car=" + car + ", latitude=" + latitude + ", longitude="
				+ longitude + "]";
	}

}
