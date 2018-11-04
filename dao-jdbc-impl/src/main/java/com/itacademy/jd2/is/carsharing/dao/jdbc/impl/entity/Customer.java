package com.itacademy.jd2.is.carsharing.dao.jdbc.impl.entity;

import java.util.Date;

import com.itacademy.jd2.is.carsharing.dao.api.entity.ICustomer;
import com.itacademy.jd2.is.carsharing.dao.api.entity.IUserAccount;

public class Customer extends BaseEntity implements ICustomer {

	private String firstName;
	private String lastName;
	private Date birthday;
	private String driverLicense;
	private boolean driverLicenseStatus;
	private String customerPassport;
	private String customerImage;
	private IUserAccount userAccount;

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

	public boolean isDriverLicenseStatus() {
		return driverLicenseStatus;
	}

	public void setDriverLicenseStatus(boolean driverLicenseStatus) {
		this.driverLicenseStatus = driverLicenseStatus;
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
	
	public IUserAccount getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(IUserAccount userAccount) {
		this.userAccount = userAccount;
	}

	@Override
	public String toString() {
		return "Customer [firstName=" + firstName + ", lastName=" + lastName + ", birthday=" + birthday
				+ ", driverLicense=" + driverLicense + ", driverLicenseStatus=" + driverLicenseStatus
				+ ", customerPassport=" + customerPassport + ", customerImage=" + customerImage + "]";
	}

}
