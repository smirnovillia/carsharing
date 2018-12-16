package com.itacademy.jd2.is.carsharing.dao.jdbc.impl.entity;

import com.itacademy.jd2.is.carsharing.dao.api.entity.IModification;
import com.itacademy.jd2.is.carsharing.dao.api.enums.Body;
import com.itacademy.jd2.is.carsharing.dao.api.enums.Drive;
import com.itacademy.jd2.is.carsharing.dao.api.enums.Fuel;
import com.itacademy.jd2.is.carsharing.dao.api.enums.Gearbox;

public class Modification extends BaseEntity implements IModification {

    private Body body;
    private Fuel fuel;
    private Integer engineCapacity;
    private Drive drive;
    private Gearbox gearbox;
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

}
