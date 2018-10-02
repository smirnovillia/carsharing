package com.itacademy.jd2.is.carsharing.service.impl;

import java.util.Random;

import com.itacademy.jd2.is.carsharing.dao.api.entity.IBrand;
import com.itacademy.jd2.is.carsharing.service.IBrandService;

public class AbstractTest {
	protected IBrandService brandService;

	public AbstractTest() {
		super();
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
