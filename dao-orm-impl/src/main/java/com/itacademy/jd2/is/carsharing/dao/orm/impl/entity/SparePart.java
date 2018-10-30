package com.itacademy.jd2.is.carsharing.dao.orm.impl.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.itacademy.jd2.is.carsharing.dao.api.entity.ISparePart;

@Entity
public class SparePart extends BaseEntity implements ISparePart {

	@Column
	private String name;
	
	@Column
	private double price;

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
