package com.itacademy.jd2.is.carsharing.dao.api.filter;

import com.itacademy.jd2.is.carsharing.dao.api.enums.Condition;

public class TrackingFilter extends AbstractFilter{
	
	private Integer carId;
	
	private Condition condition;

	public Integer getCarId() {
		return carId;
	}

	public void setCarId(Integer carId) {
		this.carId = carId;
	}

	public Condition getCondition() {
		return condition;
	}

	public void setCondition(Condition condition) {
		this.condition = condition;
	}
	
	
}
