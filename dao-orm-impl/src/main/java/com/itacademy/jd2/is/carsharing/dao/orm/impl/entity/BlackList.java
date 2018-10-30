package com.itacademy.jd2.is.carsharing.dao.orm.impl.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import com.itacademy.jd2.is.carsharing.dao.api.entity.IBlackList;
import com.itacademy.jd2.is.carsharing.dao.api.entity.ICustomer;

@Entity
public class BlackList extends BaseEntity implements IBlackList{

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Customer.class)
	private ICustomer customer;
	
	@Column
	private String reason;
	
	@Override
	public ICustomer getCustomer() {
		return customer;
	}
	
	@Override
	public void setCustomer(ICustomer customer) {
		this.customer = customer;
	}
	
	@Override
	public String getReason() {
		return reason;
	}
	
	@Override
	public void setReason(String reason) {
		this.reason = reason;
	}
	
	@Override
	public String toString() {
		return "BlackList [customer=" + customer + ", reason=" + reason + "]";
	}
	
}
