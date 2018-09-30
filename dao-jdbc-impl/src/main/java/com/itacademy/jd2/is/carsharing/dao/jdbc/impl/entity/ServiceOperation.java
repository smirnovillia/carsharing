package com.itacademy.jd2.is.carsharing.dao.jdbc.impl.entity;

import com.itacademy.jd2.is.carsharing.dao.api.entity.ISparePart;

public class ServiceOperation extends BaseEntity {

	private String name;
	private double price;
	private ISparePart sparePart;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public ISparePart getSparePart() {
		return sparePart;
	}

	public void setSparePart(ISparePart sparePart) {
		this.sparePart = sparePart;
	}

}
