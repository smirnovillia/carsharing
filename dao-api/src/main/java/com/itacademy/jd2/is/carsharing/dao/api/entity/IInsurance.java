package com.itacademy.jd2.is.carsharing.dao.api.entity;

import java.util.Date;

import com.itacademy.jd2.is.carsharing.dao.api.base.IBaseEntity;

public interface IInsurance extends IBaseEntity {

	ICar getCar();

	void setCar(ICar car);

	String getInsuranceCompany();

	void setInsuranceCompany(String insuranceCompany);

	String getInsuranceNumber();

	void setInsuranceNumber(String insuranceNumber);

	Date getIssued();

	void setIssued(Date issued);

	Date getExpiried();

	void setExpiried(Date expiried);
}
