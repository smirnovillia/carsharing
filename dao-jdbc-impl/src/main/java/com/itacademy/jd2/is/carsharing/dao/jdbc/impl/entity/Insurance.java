package com.itacademy.jd2.is.carsharing.dao.jdbc.impl.entity;

import java.util.Date;

import com.itacademy.jd2.is.carsharing.dao.api.entity.ICar;
import com.itacademy.jd2.is.carsharing.dao.api.entity.IInsurance;

public class Insurance extends BaseEntity implements IInsurance{

	private ICar car;
	private String insuranceCompany;
	private String insuranceNumber;
	private Date issued;
	private Date expiried;
	
	public ICar getCar() {
		return car;
	}
	public void setCar(ICar car) {
		this.car = car;
	}
	public String getInsuranceCompany() {
		return insuranceCompany;
	}
	public void setInsuranceCompany(String insuranceCompany) {
		this.insuranceCompany = insuranceCompany;
	}
	public String getInsuranceNumber() {
		return insuranceNumber;
	}
	public void setInsuranceNumber(String insuranceNumber) {
		this.insuranceNumber = insuranceNumber;
	}
	public Date getIssued() {
		return issued;
	}
	public void setIssued(Date issued) {
		this.issued = issued;
	}
	public Date getExpiried() {
		return expiried;
	}
	public void setExpiried(Date expiried) {
		this.expiried = expiried;
	}
	
}
