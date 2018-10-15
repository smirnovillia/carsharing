package com.itacademy.jd2.is.carsharing.dao.jdbc.impl.entity;

import java.util.Date;

import com.itacademy.jd2.is.carsharing.dao.api.entity.ICar;
import com.itacademy.jd2.is.carsharing.dao.api.entity.ICustomer;
import com.itacademy.jd2.is.carsharing.dao.api.entity.IOrderHistory;

public class OrderHistory extends BaseEntity implements IOrderHistory {

	private ICustomer customer;
	private ICar car;
	private Date orderDate;
	private double orderMileage;
	private double rate;
	private double price;

	public ICustomer getCustomer() {
		return customer;
	}

	public void setCustomer(ICustomer customer) {
		this.customer = customer;
	}

	public ICar getCar() {
		return car;
	}

	public void setCar(ICar car) {
		this.car = car;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public double getOrderMileage() {
		return orderMileage;
	}

	public void setOrderMileage(double orderMileage) {
		this.orderMileage = orderMileage;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "OrderHistory [customer=" + customer + ", car=" + car + ", orderDate=" + orderDate + ", orderMileage="
				+ orderMileage + ", rate=" + rate + ", price=" + price + "]";
	}

}
