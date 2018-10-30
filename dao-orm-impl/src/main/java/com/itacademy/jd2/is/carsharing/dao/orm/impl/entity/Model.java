package com.itacademy.jd2.is.carsharing.dao.orm.impl.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import com.itacademy.jd2.is.carsharing.dao.api.entity.IBrand;
import com.itacademy.jd2.is.carsharing.dao.api.entity.IModel;

@Entity
public class Model extends BaseEntity implements IModel {

	@Column
	private String name;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Brand.class)
	private IBrand brand;

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public IBrand getBrand() {
		return brand;
	}

	@Override
	public void setBrand(IBrand brand) {
		this.brand = brand;
	}

	@Override
	public String toString() {
		return "Model [name=" + name + ", brand=" + brand + "]";
	}

}
