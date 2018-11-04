package com.itacademy.jd2.is.carsharing.dao.orm.impl.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.itacademy.jd2.is.carsharing.dao.api.entity.IModification;
import com.itacademy.jd2.is.carsharing.dao.api.enums.Body;
import com.itacademy.jd2.is.carsharing.dao.api.enums.Drive;
import com.itacademy.jd2.is.carsharing.dao.api.enums.Fuel;
import com.itacademy.jd2.is.carsharing.dao.api.enums.Gearbox;

@Entity
public class Modification extends BaseEntity implements IModification {

	@Column
	@Enumerated(EnumType.STRING)
	private Body body;
	
	@Column
	@Enumerated(EnumType.STRING)
	private Fuel fuel;
	
	@Column
	private int engineCapacity;
	
	@Column
	@Enumerated(EnumType.STRING)
	private Drive drive;
	
	@Column
	@Enumerated(EnumType.STRING)
	private Gearbox gearbox;
	
	@Column
	private int tankCapacity;

	@Override
	public Body getBody() {
		return body;
	}

	@Override
	public void setBody(Body body) {
		this.body = body;
	}

	@Override
	public Fuel getFuel() {
		return fuel;
	}

	@Override
	public void setFuel(Fuel fuel) {
		this.fuel = fuel;
	}

	@Override
	public int getEngineCapacity() {
		return engineCapacity;
	}

	@Override
	public void setEngineCapacity(int engineCapacity) {
		this.engineCapacity = engineCapacity;
	}

	@Override
	public Drive getDrive() {
		return drive;
	}

	@Override
	public void setDrive(Drive drive) {
		this.drive = drive;
	}

	@Override
	public Gearbox getGearbox() {
		return gearbox;
	}

	@Override
	public void setGearbox(Gearbox gearbox) {
		this.gearbox = gearbox;
	}

	@Override
	public int getTankCapacity() {
		return tankCapacity;
	}

	@Override
	public void setTankCapacity(int tankCapacity) {
		this.tankCapacity = tankCapacity;
	}

}
