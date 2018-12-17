package com.itacademy.jd2.is.carsharing.web.dto.search;

import javax.validation.constraints.NotNull;

public class CarSearchDTO {

	@NotNull
	private String body;
	@NotNull
	private String fuel;
	@NotNull
	private String drive;
	@NotNull
	private String gearbox;

	private Integer engineCapacity;

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getFuel() {
		return fuel;
	}

	public void setFuel(String fuel) {
		this.fuel = fuel;
	}

	public String getDrive() {
		return drive;
	}

	public void setDrive(String drive) {
		this.drive = drive;
	}

	public String getGearbox() {
		return gearbox;
	}

	public void setGearbox(String gearbox) {
		this.gearbox = gearbox;
	}

	public Integer getEngineCapacity() {
		return engineCapacity;
	}

	public void setEngineCapacity(Integer engineCapacity) {
		this.engineCapacity = engineCapacity;
	}

}
