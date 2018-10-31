package com.itacademy.jd2.is.carsharing.dao.jdbc.impl.entity;

import com.itacademy.jd2.is.carsharing.dao.api.entity.IServiceOperation;
import com.itacademy.jd2.is.carsharing.dao.api.entity.ISparePart;

public class SparePart extends BaseEntity implements ISparePart {

	private IServiceOperation serviceOperation;
	private String name;
	private double price;

	public IServiceOperation getServiceOperation() {
		return serviceOperation;
	}

	public void setServiceOperation(IServiceOperation serviceOperation) {
		this.serviceOperation = serviceOperation;
	}

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

	@Override
	public String toString() {
		return "SparePart [serviceOperation=" + serviceOperation + ", name=" + name + ", price=" + price + "]";
	}

}
