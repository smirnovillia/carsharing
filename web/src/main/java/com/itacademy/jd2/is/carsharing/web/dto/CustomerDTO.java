package com.itacademy.jd2.is.carsharing.web.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class CustomerDTO {

	private String firstName;
	private String lastName;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birthday;

	private String driverLicense;
	private Boolean driverLicenseStatus;

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

}
