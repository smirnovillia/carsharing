package com.itacademy.jd2.is.carsharing.web.dto;

import java.util.Date;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class CustomerDTO {

	private Integer id;

	private String firstName;
	private String lastName;
	private Date birthday;
	private String driverLicense;
	private String customerPassport;
	private String customerImage;

	private Date created;
	private Date updated;
	
	@NotNull
	@Valid
	private UserAccountDTO user;
	
	public UserAccountDTO getUser() {
		return user;
	}

	public void setUser(UserAccountDTO user) {
		this.user = user;
	}

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

	public String getCustomerPassport() {
		return customerPassport;
	}

	public void setCustomerPassport(String customerPassport) {
		this.customerPassport = customerPassport;
	}

	public String getCustomerImage() {
		return customerImage;
	}

	public void setCustomerImage(String customerImage) {
		this.customerImage = customerImage;
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
