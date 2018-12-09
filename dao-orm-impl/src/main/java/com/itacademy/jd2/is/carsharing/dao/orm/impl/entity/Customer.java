package com.itacademy.jd2.is.carsharing.dao.orm.impl.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import com.itacademy.jd2.is.carsharing.dao.api.entity.ICustomer;
import com.itacademy.jd2.is.carsharing.dao.api.entity.IUserAccount;

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
	
	@OneToOne(fetch = FetchType.LAZY, optional = false, targetEntity = UserAccount.class)
	@PrimaryKeyJoinColumn
	private IUserAccount userAccount;

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
	public IUserAccount getUserAccount() {
		return userAccount;
	}

	@Override
	public void setUserAccount(IUserAccount userAccount) {
		this.userAccount = userAccount;
	}

	@Override
	public String toString() {
		return "Customer [firstName=" + firstName + ", lastName=" + lastName + ", birthday=" + birthday
				+ ", driverLicense=" + driverLicense + ", driverLicenseStatus=" + driverLicenseStatus;
	}


}
