package com.itacademy.jd2.is.carsharing.dao.jdbc.impl.entity;

import com.itacademy.jd2.is.carsharing.dao.api.entity.ICarServiceHistory;
import com.itacademy.jd2.is.carsharing.dao.api.entity.IServiceOperation;

public class ServiceOperation extends BaseEntity implements IServiceOperation {

	private ICarServiceHistory carServiceHistory;
	private String name;
	private double price;

	public ICarServiceHistory getCarServiceHistory() {
		return carServiceHistory;
	}

	public void setCarServiceHistory(ICarServiceHistory carServiceHistory) {
		this.carServiceHistory = carServiceHistory;
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
		return "ServiceOperation =" + ", name=" + name + ", price=" + price;
	}

}
