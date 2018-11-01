package com.itacademy.jd2.is.carsharing.dao.orm.impl.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import com.itacademy.jd2.is.carsharing.dao.api.entity.IServiceOperation;
import com.itacademy.jd2.is.carsharing.dao.api.entity.ISparePart;

@Entity
public class SparePart extends BaseEntity implements ISparePart {

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = ServiceOperation.class)
	private IServiceOperation serviceOperation;
	
	@Column
	private String name;
	
	@Column
	private double price;

	@Override
	public IServiceOperation getServiceOperation() {
		return serviceOperation;
	}

	@Override
	public void setServiceOperation(IServiceOperation serviceOperation) {
		this.serviceOperation = serviceOperation;
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
		return "SparePart [name=" + name + ", price=" + price + "]";
	}

}
