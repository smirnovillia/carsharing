package com.itacademy.jd2.is.carsharing.dao.jdbc.impl.entity;

import java.util.List;

import com.itacademy.jd2.is.carsharing.dao.api.entity.ICarServiceHistory;
import com.itacademy.jd2.is.carsharing.dao.api.entity.IServiceOperation;
import com.itacademy.jd2.is.carsharing.dao.api.entity.ISparePart;

public class ServiceOperation extends BaseEntity implements IServiceOperation {

	private ICarServiceHistory carServiceHistory;
	private String name;
	private double price;
	private List<ISparePart> sparePart;

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

	public List<ISparePart> getSparePart() {
		return sparePart;
	}

	public void setSparePart(List<ISparePart> sparePart) {
		this.sparePart = sparePart;
	}

	@Override
	public String toString() {
		return "ServiceOperation =" + ", name=" + name + ", price=" + price;
	}

}
