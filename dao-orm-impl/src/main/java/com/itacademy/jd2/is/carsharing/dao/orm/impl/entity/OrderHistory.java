package com.itacademy.jd2.is.carsharing.dao.orm.impl.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import com.itacademy.jd2.is.carsharing.dao.api.entity.ICar;
import com.itacademy.jd2.is.carsharing.dao.api.entity.ICustomer;
import com.itacademy.jd2.is.carsharing.dao.api.entity.IOrderHistory;

@Entity
public class OrderHistory extends BaseEntity implements IOrderHistory {

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Customer.class)
	private ICustomer customer;
	
	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Car.class)
	private ICar car;
	
	@Column
	private Date orderDate;
	
	@Column
	private double orderMileage;
	
	@Column
	private double rate;
	
	@Column
	private double price;

	@Override
	public ICustomer getCustomer() {
		return customer;
	}

	@Override
	public void setCustomer(ICustomer customer) {
		this.customer = customer;
	}

	@Override
	public ICar getCar() {
		return car;
	}
	
	@Override
	public void setCar(ICar car) {
		this.car = car;
	}

	@Override
	public Date getOrderDate() {
		return orderDate;
	}

	@Override
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	@Override
	public double getOrderMileage() {
		return orderMileage;
	}

	@Override
	public void setOrderMileage(double orderMileage) {
		this.orderMileage = orderMileage;
	}

	@Override
	public double getRate() {
		return rate;
	}

	@Override
	public void setRate(double rate) {
		this.rate = rate;
	}

	@Override
	public double getPrice() {
		return price;
	}

	@Override
	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "OrderHistory [customer=" + customer + ", car=" + car + ", orderDate=" + orderDate + ", orderMileage="
				+ orderMileage + ", rate=" + rate + ", price=" + price + "]";
	}

}
