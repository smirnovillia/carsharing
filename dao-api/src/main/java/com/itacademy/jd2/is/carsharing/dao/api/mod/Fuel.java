package com.itacademy.jd2.is.carsharing.dao.api.mod;

public enum Fuel{
	
	DIESEL("Diesel"), PETROL("Petrol"), HYBRID("Hybrid"), ELECTRIC("Electric");
	
	private String name;
	
	private Fuel( String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
