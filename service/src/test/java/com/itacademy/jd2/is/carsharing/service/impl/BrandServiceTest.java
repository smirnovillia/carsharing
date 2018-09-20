package com.itacademy.jd2.is.carsharing.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.itacademy.jd2.is.carsharing.dao.api.entity.IBrand;

public class BrandServiceTest extends AbstractTest {
	@Test
	public void testCreate() {
		final IBrand entity = saveNewBrand();

		final IBrand entityFromDb = brandService.get(entity.getId());

		assertEquals(entity.getName(), entityFromDb.getName());
		assertNotNull(entityFromDb.getId());
		assertNotNull(entityFromDb.getCreated());
		assertNotNull(entityFromDb.getUpdated());
		assertTrue(entityFromDb.getCreated().equals(entityFromDb.getUpdated()));
	}
}
