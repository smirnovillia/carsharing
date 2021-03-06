package com.itacademy.jd2.is.carsharing.dao.orm.impl.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import com.itacademy.jd2.is.carsharing.dao.api.entity.ICar;
import com.itacademy.jd2.is.carsharing.dao.api.entity.IColor;
import com.itacademy.jd2.is.carsharing.dao.api.entity.IModel;
import com.itacademy.jd2.is.carsharing.dao.api.entity.IModification;
import com.itacademy.jd2.is.carsharing.dao.api.enums.Condition;

@Entity
public class Car extends BaseEntity implements ICar {


	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Modification.class)
	private IModification modification;
	
	@Column
	private int releaseDate;
	
	@Column
	private String vin;
	
	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Color.class)
	private IColor color;
	
	@Column
	private double mileage;
	
	@Column
	@Enumerated(EnumType.STRING)
	private Condition condition;


	@Override
	public IModification getModification() {
		return modification;
	}

	@Override
	public void setModification(IModification modification) {
		this.modification = modification;
	}

	@Override
	public int getReleaseDate() {
		return releaseDate;
	}

	@Override
	public void setReleaseDate(int releaseDate) {
		this.releaseDate = releaseDate;
	}

	@Override
	public String getVin() {
		return vin;
	}

	@Override
	public void setVin(String vin) {
		this.vin = vin;
	}

	@Override
	public IColor getColor() {
		return color;
	}

	@Override
	public void setColor(IColor color) {
		this.color = color;
	}

	@Override
	public double getMileage() {
		return mileage;
	}

	@Override
	public void setMileage(double mileage) {
		this.mileage = mileage;
	}

	@Override
	public Condition getCondition() {
		return condition;
	}

	@Override
	public void setCondition(Condition condition) {
		this.condition = condition;
	}

	
}
