package com.itacademy.jd2.is.carsharing.dao.jdbc.impl.entity;

import com.itacademy.jd2.is.carsharing.dao.api.entity.IBody;
import com.itacademy.jd2.is.carsharing.dao.api.entity.IDrive;
import com.itacademy.jd2.is.carsharing.dao.api.entity.IFuel;
import com.itacademy.jd2.is.carsharing.dao.api.entity.IGearbox;
import com.itacademy.jd2.is.carsharing.dao.api.entity.IModification;

public class Modification extends BaseEntity implements IModification{
	
	private IBody body;
	private IFuel fuel;
	private int engineCapacity;
	private IDrive drive;
	private IGearbox gearbox;
	private int tankCapacity;
	
	public IBody getBody() {
		return body;
	}
	public void setBody(IBody body) {
		this.body = body;
	}
	public IFuel getFuel() {
		return fuel;
	}
	public void setFuel(IFuel fuel) {
		this.fuel = fuel;
	}
	public int getEngineCapacity() {
		return engineCapacity;
	}
	public void setEngineCapacity(int engineCapacity) {
		this.engineCapacity = engineCapacity;
	}
	public IDrive getDrive() {
		return drive;
	}
	public void setDrive(IDrive drive) {
		this.drive = drive;
	}
	public IGearbox getGearbox() {
		return gearbox;
	}
	public void setGearbox(IGearbox gearbox) {
		this.gearbox = gearbox;
	}
	public int getTankCapacity() {
		return tankCapacity;
	}
	public void setTankCapacity(int tankCapacity) {
		this.tankCapacity = tankCapacity;
	}
	
}
