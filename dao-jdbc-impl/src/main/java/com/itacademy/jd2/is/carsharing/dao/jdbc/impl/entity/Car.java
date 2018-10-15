package com.itacademy.jd2.is.carsharing.dao.jdbc.impl.entity;

import com.itacademy.jd2.is.carsharing.dao.api.entity.ICar;
import com.itacademy.jd2.is.carsharing.dao.api.entity.IColor;
import com.itacademy.jd2.is.carsharing.dao.api.entity.IModel;
import com.itacademy.jd2.is.carsharing.dao.api.entity.IModification;
import com.itacademy.jd2.is.carsharing.dao.api.enums.Status;

public class Car extends BaseEntity implements ICar {

	private IModel model;
	private IModification modification;
	private int releaseDate;
	private String vin;
	private IColor color;
	private double mileage;
	private Status status;

	public IModel getModel() {
		return model;
	}

	public void setModel(IModel model) {
		this.model = model;
	}

	public IModification getModification() {
		return modification;
	}

	public void setModification(IModification modification) {
		this.modification = modification;
	}

	public int getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(int releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	public IColor getColor() {
		return color;
	}

	public void setColor(IColor color) {
		this.color = color;
	}

	public double getMileage() {
		return mileage;
	}

	public void setMileage(double mileage) {
		this.mileage = mileage;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Car [model=" + model + ", modification=" + modification + ", releaseDate=" + releaseDate + ", vin="
				+ vin + ", color=" + color + ", mileage=" + mileage + ", status=" + status + "]";
	}
	
}
