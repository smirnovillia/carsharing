package com.itacademy.jd2.is.carsharing.dao.jdbc.impl.entity;

import java.util.Set;

import com.itacademy.jd2.is.carsharing.dao.api.entity.IBrand;
import com.itacademy.jd2.is.carsharing.dao.api.entity.IColor;
import com.itacademy.jd2.is.carsharing.dao.api.entity.IModel;

public class Model extends BaseEntity implements IModel {

	private String name;
	private IBrand brand;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public IBrand getBrand() {
		return brand;
	}

	public void setBrand(IBrand brand) {
		this.brand = brand;
	}

	@Override
	public String toString() {
		return "Model [name=" + name + ", brand=" + brand + "]";
	}

	@Override
	public void setColors(Set<IColor> colors) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Set<IColor> getColors() {
		// TODO Auto-generated method stub
		return null;
	}

}
