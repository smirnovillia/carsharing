package com.itacademy.jd2.is.carsharing.dao.api.entity;

import com.itacademy.jd2.is.carsharing.dao.api.base.IBaseEntity;
import com.itacademy.jd2.is.carsharing.dao.api.enums.Condition;

public interface ICar extends IBaseEntity {



	IModification getModification();

	void setModification(IModification modification);

	int getReleaseDate();

	void setReleaseDate(int releaseDate);

	String getVin();

	void setVin(String vin);

	IColor getColor();

	void setColor(IColor color);

	double getMileage();

	void setMileage(double mileage);

	Condition getCondition();

	void setCondition(Condition condition);
}
