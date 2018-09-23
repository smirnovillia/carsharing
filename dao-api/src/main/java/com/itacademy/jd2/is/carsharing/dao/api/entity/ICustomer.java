package com.itacademy.jd2.is.carsharing.dao.api.entity;

import java.util.Date;

import com.itacademy.jd2.is.carsharing.dao.api.base.IBaseEntity;

public interface ICustomer extends IBaseEntity {

	String getFirstName();

	void setFirstName(String firstName);

	String getLastName();

	void setLastName(String lastName);

	Date getBirthday();

	void setBirthday(Date birthday);

	String getDriverLicence();

	void setDriverLicence(String driverLicence);

	boolean isDriverLicenceStatus();

	void setDriverLicenceStatus(boolean driverLicenceStatus);

	String getCustomerPassport();

	void setCustomerPassport(String customerPassport);

	String getCustomerImage();

	void setCustomerImage(String customerImage);
}
