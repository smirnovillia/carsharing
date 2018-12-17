package com.itacademy.jd2.is.carsharing.web.dto;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

public class InsuranceDTO {

	private Integer id;
	@NotNull
	private Integer carId;
	@NotNull
	private String insuranceCompany;
	@NotNull
	private String insuranceNumber;
	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date issued;
	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date expiried;
	
	private Date created;
	private Date updated;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCarId() {
		return carId;
	}

	public void setCarId(Integer carId) {
		this.carId = carId;
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

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

}
