package com.itacademy.jd2.is.carsharing.dao.jdbc.impl.entity;

public enum Role {
	
	ADMIN("ADMIN"), CUSTOMER("CUSTOMER");

	private String role;
	
	private Role(String role) {
		this.role = role;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
}
