package com.itacademy.jd2.is.carsharing.dao.api.entity;

import com.itacademy.jd2.is.carsharing.dao.api.base.IBaseEntity;
import com.itacademy.jd2.is.carsharing.dao.api.modification.Body;
import com.itacademy.jd2.is.carsharing.dao.api.modification.Drive;
import com.itacademy.jd2.is.carsharing.dao.api.modification.Fuel;
import com.itacademy.jd2.is.carsharing.dao.api.modification.Gearbox;

public interface IModification extends IBaseEntity {

	void setBody(Body body);

	Fuel getFuel();

	void setFuel(Fuel fuel);

	int getEngineCapacity();

	void setEngineCapacity(int engineCapacity);

	Drive getDrive();

	void setDrive(Drive drive);

	Gearbox getGearbox();

	void setGearbox(Gearbox gearbox);

	int getTankCapacity();

	void setTankCapacity(int tankCapacity);
}
