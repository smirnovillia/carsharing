package com.itacademy.jd2.is.carsharing.dao.orm.impl.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import com.itacademy.jd2.is.carsharing.dao.api.entity.IServiceOperation;
import com.itacademy.jd2.is.carsharing.dao.api.entity.ISparePart;

@Entity
public class ServiceOperation extends BaseEntity implements IServiceOperation {

	@Column
	private String name;
	
	@Column
	private double price;
	
	@ManyToOne(fetch = FetchType.LAZY, targetEntity = SparePart.class)
	private ISparePart sparePart;

	
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
	public ISparePart getSparePart() {
		return sparePart;
	}

	@Override
	public void setSparePart(ISparePart sparePart) {
		this.sparePart = sparePart;
	}

	@Override
	public String toString() {
		return "ServiceOperation [name=" + name + ", price=" + price + ", sparePart=" + sparePart + "]";
	}

}
