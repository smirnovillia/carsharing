package com.itacademy.jd2.is.carsharing.dao.orm.impl.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OrderBy;

import com.itacademy.jd2.is.carsharing.dao.api.entity.IBrand;
import com.itacademy.jd2.is.carsharing.dao.api.entity.IColor;
import com.itacademy.jd2.is.carsharing.dao.api.entity.IModel;

@Entity
public class Model extends BaseEntity implements IModel {

	@JoinTable(name = "color_2_model", joinColumns = { @JoinColumn(name = "model_id") }, inverseJoinColumns = {
			@JoinColumn(name = "color_id") })
	@ManyToMany(targetEntity = Color.class, fetch = FetchType.LAZY)
	@OrderBy("name ASC")
	private Set<IColor> colors = new HashSet<>();

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
	public Set<IColor> getColors() {
		return colors;
	}

	@Override
	public void setColors(Set<IColor> colors) {
		this.colors = colors;
	}

	@Override
	public String toString() {
		return "Model [name=" + name + ", brand=" + brand + "]";
	}

}
