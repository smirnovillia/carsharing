package com.itacademy.jd2.is.carsharing.web.dto;

import java.util.Date;

public class CarServiceHistoryDTO {

	private Integer id;
	private Integer carId;
	private Date serviceDate;
	private Double carMileage;
	private String serviceCompany;
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
