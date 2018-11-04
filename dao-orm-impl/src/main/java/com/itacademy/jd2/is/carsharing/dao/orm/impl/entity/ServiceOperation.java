package com.itacademy.jd2.is.carsharing.dao.orm.impl.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import com.itacademy.jd2.is.carsharing.dao.api.entity.ICarServiceHistory;
import com.itacademy.jd2.is.carsharing.dao.api.entity.IServiceOperation;

@Entity
public class ServiceOperation extends BaseEntity implements IServiceOperation {

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = CarServiceHistory.class)
	private ICarServiceHistory carServiceHistory;
	
	@Column
	private String name;
	
	@Column
	private double price;
	
	@Override
	public ICarServiceHistory getCarServiceHistory() {
		return carServiceHistory;
	}

	@Override
	public void setCarServiceHistory(ICarServiceHistory carServiceHistory) {
		this.carServiceHistory = carServiceHistory;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public double getPrice() {
		return price;
	}

	@Override
	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "ServiceOperation [name=" + name + ", price=" + price;
	}

}
