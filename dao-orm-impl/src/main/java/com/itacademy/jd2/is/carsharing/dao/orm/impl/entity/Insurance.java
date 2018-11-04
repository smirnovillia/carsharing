package com.itacademy.jd2.is.carsharing.dao.orm.impl.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import com.itacademy.jd2.is.carsharing.dao.api.entity.ICar;
import com.itacademy.jd2.is.carsharing.dao.api.entity.IInsurance;

@Entity
public class Insurance extends BaseEntity implements IInsurance {

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Car.class)
	private ICar car;
	
	@Column
	private String insuranceCompany;
	
	@Column
	private String insuranceNumber;
	
	@Column
	private Date issued;
	
	@Column
	private Date expiried;

	
	@Override
	public ICar getCar() {
		return car;
	}

	@Override
	public void setCar(ICar car) {
		this.car = car;
	}

	@Override
	public String getInsuranceCompany() {
		return insuranceCompany;
	}

	@Override
	public void setInsuranceCompany(String insuranceCompany) {
		this.insuranceCompany = insuranceCompany;
	}

	@Override
	public String getInsuranceNumber() {
		return insuranceNumber;
	}

	@Override
	public void setInsuranceNumber(String insuranceNumber) {
		this.insuranceNumber = insuranceNumber;
	}

	@Override
	public Date getIssued() {
		return issued;
	}

	@Override
	public void setIssued(Date issued) {
		this.issued = issued;
	}

	@Override
	public Date getExpiried() {
		return expiried;
	}

	@Override
	public void setExpiried(Date expiried) {
		this.expiried = expiried;
	}

	@Override
	public String toString() {
		return "Insurance [car=" + car + ", insuranceCompany=" + insuranceCompany + ", insuranceNumber="
				+ insuranceNumber + ", issued=" + issued + ", expiried=" + expiried + "]";
	}

}
