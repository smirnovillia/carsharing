package com.itacademy.jd2.is.carsharing.service.impl;

import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.itacademy.jd2.is.carsharing.dao.api.entity.IBrand;
import com.itacademy.jd2.is.carsharing.service.IBrandService;

@SpringJUnitConfig(locations = "classpath:service-context.xml")
public class AbstractTest {
	@Autowired
	protected IBrandService brandService;

	public AbstractTest() {
		super();
	}

	@BeforeEach
	public void setUpMethod() {
		// clean DB recursive
		brandService.deleteAll();
	}

	private static final Random RANDOM = new Random();

	protected String getRandomPrefix() {
		return RANDOM.nextInt(99999) + "";
	}

	protected int getRandomObjectsCount() {
		return RANDOM.nextInt(9) + 1;
	}

	public Random getRANDOM() {
		return RANDOM;
	}

	protected IBrand saveNewBrand() {
		final IBrand entity = brandService.createEntity();
		entity.setName("brand-" + getRandomPrefix());
		brandService.save(entity);
		return entity;
	}
}
