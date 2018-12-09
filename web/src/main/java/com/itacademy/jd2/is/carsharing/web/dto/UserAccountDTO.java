package com.itacademy.jd2.is.carsharing.web.dto;

import java.util.Date;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class UserAccountDTO {

	private Integer id;
	@NotNull
	private String login;
	@NotNull
	private String password;
	@NotNull
	private Integer userRole;

	private Date created;
	private Date updated;

	@NotNull
	@Valid
	private CustomerDTO customer = new CustomerDTO();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getUserRole() {
		return userRole;
	}

	public void setUserRole(Integer userRole) {
		this.userRole = userRole;
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

	public CustomerDTO getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerDTO customer) {
		this.customer = customer;
	}

}
