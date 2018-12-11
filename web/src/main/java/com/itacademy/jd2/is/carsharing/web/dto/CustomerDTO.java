package com.itacademy.jd2.is.carsharing.web.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class CustomerDTO {

	private Integer id;
	private String firstName;
	private String lastName;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birthday;

	private String driverLicense;
	private Boolean driverLicenseStatus;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date created;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updated;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getDriverLicense() {
		return driverLicense;
	}

	public void setDriverLicense(String driverLicense) {
		this.driverLicense = driverLicense;
	}

	public Boolean getDriverLicenseStatus() {
		return driverLicenseStatus;
	}

	public void setDriverLicenseStatus(Boolean driverLicenseStatus) {
		this.driverLicenseStatus = driverLicenseStatus;
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
