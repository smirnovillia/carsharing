package com.itacademy.jd2.is.carsharing.dao.api.entity;

import com.itacademy.jd2.is.carsharing.dao.api.base.IBaseEntity;

public interface IModification extends IBaseEntity {

	public IBody getBody();

	public void setBody(IBody body);

	public IFuel getFuel();

	public void setFuel(IFuel fuel);

	public int getEngineCapacity();

	public void setEngineCapacity(int engineCapacity);

	public IDrive getDrive();

	public void setDrive(IDrive drive);

	public IGearbox getGearbox();

	public void setGearbox(IGearbox gearbox);

	public int getTankCapacity();

	public void setTankCapacity(int tankCapacity);
}
