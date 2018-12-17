package com.itacademy.jd2.is.carsharing.web.dto;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

public class CarServiceHistoryDTO {

	private Integer id;
	@NotNull
	private Integer carId;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date serviceDate;
	@NotNull
	private Double carMileage;
	@NotNull
	private String serviceCompany;
	@NotNull
	private Double servicePrice;
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

	public void setCarId(Integer carid) {
		this.carId = carid;
	}

	public Date getServiceDate() {
		return serviceDate;
	}

	public void setServiceDate(Date serviceDate) {
		this.serviceDate = serviceDate;
	}

	public Double getCarMileage() {
		return carMileage;
	}

	public void setCarMileage(Double carMileage) {
		this.carMileage = carMileage;
	}

	public String getServiceCompany() {
		return serviceCompany;
	}

	public void setServiceCompany(String serviceCompany) {
		this.serviceCompany = serviceCompany;
	}

	public Double getServicePrice() {
		return servicePrice;
	}

	public void setServicePrice(Double servicePrice) {
		this.servicePrice = servicePrice;
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
