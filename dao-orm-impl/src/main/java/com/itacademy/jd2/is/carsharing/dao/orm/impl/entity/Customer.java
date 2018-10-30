package com.itacademy.jd2.is.carsharing.dao.orm.impl.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.itacademy.jd2.is.carsharing.dao.api.entity.ICustomer;

@Entity
public class Customer extends BaseEntity implements ICustomer {

	@Column
	private String firstName;
	
	@Column
	private String lastName;
	
	@Column
	private Date birthday;
	
	@Column
	private String driverLicense;
	
	@Column
	private boolean driverLicenseStatus;
	
	@Column
	private String customerPassport;
	
	@Column
	private String customerImage;

	@Override
	public String getFirstName() {
		return firstName;
	}

	@Override
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Override
	public String getLastName() {
		return lastName;
	}

	@Override
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public Date getBirthday() {
		return birthday;
	}

	@Override
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Override
	public String getDriverLicense() {
		return driverLicense;
	}

	@Override
	public void setDriverLicense(String driverLicense) {
		this.driverLicense = driverLicense;
	}

	@Override
	public boolean isDriverLicenseStatus() {
		return driverLicenseStatus;
	}

	@Override
	public void setDriverLicenseStatus(boolean driverLicenseStatus) {
		this.driverLicenseStatus = driverLicenseStatus;
	}

	@Override
	public String getCustomerPassport() {
		return customerPassport;
	}

	@Override
	public void setCustomerPassport(String customerPassport) {
		this.customerPassport = customerPassport;
	}

	@Override
	public String getCustomerImage() {
		return customerImage;
	}

	@Override
	public void setCustomerImage(String customerImage) {
		this.customerImage = customerImage;
	}

	@Override
	public String toString() {
		return "Customer [firstName=" + firstName + ", lastName=" + lastName + ", birthday=" + birthday
				+ ", driverLicense=" + driverLicense + ", driverLicenseStatus=" + driverLicenseStatus
				+ ", customerPassport=" + customerPassport + ", customerImage=" + customerImage + "]";
	}

}
