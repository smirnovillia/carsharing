package com.itacademy.jd2.is.carsharing.dao.orm.impl.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.itacademy.jd2.is.carsharing.dao.api.entity.IBrand;

@Entity
public class Brand extends BaseEntity implements IBrand{
	
	@Column
	private String name;
	
	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Brand [name=" + name + "]";
	}
	
}
