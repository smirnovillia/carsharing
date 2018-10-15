package com.itacademy.jd2.is.carsharing.dao.api.entity;

import com.itacademy.jd2.is.carsharing.dao.api.base.IBaseEntity;
import com.itacademy.jd2.is.carsharing.dao.api.enums.Role;

public interface IUserAccount extends IBaseEntity {

	String getLogin();

	void setLogin(String login);

	String getPassword();

	void setPassword(String password);

	Role getUserRole();

	void setUserRole(Role userRole);

}
