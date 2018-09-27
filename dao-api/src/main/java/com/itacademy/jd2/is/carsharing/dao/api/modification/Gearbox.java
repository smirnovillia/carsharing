package com.itacademy.jd2.is.carsharing.dao.api.modification;

public enum Gearbox {
	MANUAL("Manual"), AUTOMATIC("Automatic"), CVT("CVT"), 
	EVT("EVT"), SEMI_AUTOMATIC ("Semi-automatic");
	
	private String name;
	
	private Gearbox(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
