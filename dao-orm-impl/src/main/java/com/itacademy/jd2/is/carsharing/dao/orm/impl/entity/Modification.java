package com.itacademy.jd2.is.carsharing.dao.orm.impl.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import com.itacademy.jd2.is.carsharing.dao.api.entity.IModel;
import com.itacademy.jd2.is.carsharing.dao.api.entity.IModification;
import com.itacademy.jd2.is.carsharing.dao.api.enums.Body;
import com.itacademy.jd2.is.carsharing.dao.api.enums.Drive;
import com.itacademy.jd2.is.carsharing.dao.api.enums.Fuel;
import com.itacademy.jd2.is.carsharing.dao.api.enums.Gearbox;

@Entity
public class Modification extends BaseEntity implements IModification {

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Model.class)
	private IModel model;
	
	
    @Column
    @Enumerated(EnumType.STRING)
    private Body body;

    @Column
    @Enumerated(EnumType.STRING)
    private Fuel fuel;

    @Column
    private Integer engineCapacity;

    @Column
    @Enumerated(EnumType.STRING)
    private Drive drive;

    @Column
    @Enumerated(EnumType.STRING)
    private Gearbox gearbox;

    @Column
    private Integer tankCapacity;

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
    public Integer getEngineCapacity() {
        return engineCapacity;
    }

    @Override
    public void setEngineCapacity(Integer engineCapacity) {
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
    public Integer getTankCapacity() {
        return tankCapacity;
    }

    @Override
    public void setTankCapacity(Integer tankCapacity) {
        this.tankCapacity = tankCapacity;
    }

	public IModel getModel() {
		return model;
	}

	public void setModel(IModel model) {
		this.model = model;
	}

	@Override
	public String toString() {
		return "Modification [fuel=" + fuel + ", engineCapacity=" + engineCapacity + ", drive=" + drive + "]";
	}
    
    

}
