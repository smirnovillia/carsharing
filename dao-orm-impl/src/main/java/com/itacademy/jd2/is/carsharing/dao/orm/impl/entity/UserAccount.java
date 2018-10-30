package com.itacademy.jd2.is.carsharing.dao.orm.impl.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.itacademy.jd2.is.carsharing.dao.api.entity.IUserAccount;
import com.itacademy.jd2.is.carsharing.dao.api.enums.Role;

@Entity
public class UserAccount extends BaseEntity implements IUserAccount {

	@Column
	private String login;
	
	@Column
	private String password;
	
	@Column
	private Role userRole;

	@Override
	public String getLogin() {
		return login;
	}

	@Override
	public void setLogin(String login) {
		this.login = login;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public Role getUserRole() {
		return userRole;
	}

	@Override
	public void setUserRole(Role userRole) {
		this.userRole = userRole;
	}

	@Override
	public String toString() {
		return "UserAccount [login=" + login + ", password=" + password + ", userRole=" + userRole + "]";
	}

}
