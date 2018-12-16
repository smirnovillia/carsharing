package com.itacademy.jd2.is.carsharing.dao.api.entity;

import com.itacademy.jd2.is.carsharing.dao.api.base.IBaseEntity;
import com.itacademy.jd2.is.carsharing.dao.api.enums.Body;
import com.itacademy.jd2.is.carsharing.dao.api.enums.Drive;
import com.itacademy.jd2.is.carsharing.dao.api.enums.Fuel;
import com.itacademy.jd2.is.carsharing.dao.api.enums.Gearbox;

public interface IModification extends IBaseEntity {

	IModel getModel();

	void setModel(IModel model);

	Body getBody();

	void setBody(Body body);

	Fuel getFuel();

	void setFuel(Fuel fuel);

	Integer getEngineCapacity();

	void setEngineCapacity(Integer engineCapacity);

	Drive getDrive();

	void setDrive(Drive drive);

	Gearbox getGearbox();

	void setGearbox(Gearbox gearbox);

	Integer getTankCapacity();

	void setTankCapacity(Integer tankCapacity);

}
