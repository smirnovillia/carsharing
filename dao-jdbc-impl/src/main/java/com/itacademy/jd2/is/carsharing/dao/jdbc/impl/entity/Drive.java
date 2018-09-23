package com.itacademy.jd2.is.carsharing.dao.jdbc.impl.entity;

import com.itacademy.jd2.is.carsharing.dao.api.entity.IDrive;

public enum Drive implements IDrive{
	
	ALL_WHEEL_DRIVE("All-wheel drive"), REAR_WHEEL_DRIVE("Rear-wheel drive"),
	FRONT_WHEEL_DRIVE("Front-wheel drive");
	
	private String name;
	
	private Drive(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
