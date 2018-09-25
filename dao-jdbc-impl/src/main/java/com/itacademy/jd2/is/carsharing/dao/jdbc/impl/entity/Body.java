package com.itacademy.jd2.is.carsharing.dao.jdbc.impl.entity;

import com.itacademy.jd2.is.carsharing.dao.api.entity.IBody;

public enum Body implements IBody {

	HATCHBACK("Hatchback"), SEDAN("Sedan"), MPV("MPV"), SUV("SUV"), 
	CROSSOVER("Crossover"), COUPE("Coupe"), CONVERTIBLE("Convertible"), 
	ESTATE("Estate");

	private String name;

	private Body(String bodyType) {
		this.name = bodyType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}