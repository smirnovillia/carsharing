package com.itacademy.jd2.is.carsharing.service.impl;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.itacademy.jd2.is.carsharing.dao.api.entity.IBrand;
import com.itacademy.jd2.is.carsharing.dao.api.entity.IModel;

public class ModelServiceTest extends AbstractTest {

	@Test
	public void testCreate() {
		final IModel entity = saveNewModel();

		final IModel entityFromDb = modelService.get(entity.getId());

		assertNotNull(entityFromDb);
		assertNotNull(entityFromDb.getId());
		assertEquals(entity.getId(), entityFromDb.getId());
		assertNotNull(entityFromDb.getName());
		assertEquals(entity.getName(), entityFromDb.getName());
//		assertEquals(entity.getBrand().getId(), entityFromDb.getBrand().getId());
		assertNotNull(entityFromDb.getCreated());
		assertNotNull(entityFromDb.getUpdated());
		assertTrue(entityFromDb.getCreated().equals(entityFromDb.getUpdated()));
	}

	@Test
	public void testUpdateBrand() throws InterruptedException {
		final IModel entity = saveNewModel();

		final IBrand newBrand = saveNewBrand();
		entity.setBrand(newBrand);
		Thread.sleep(2000);
		modelService.save(entity);
		
		final IModel entityFromDb = modelService.get(entity.getId());

		assertNotNull(entityFromDb);
//		assertEquals(newBrand.getId(), entityFromDb.getBrand().getId());
		assertNotNull(entityFromDb.getName());
		assertNotNull(entityFromDb.getUpdated());
		assertEquals(entity.getCreated(), entityFromDb.getCreated());
		assertTrue(entityFromDb.getUpdated().after(entity.getCreated()));
	}

	@Test
	public void testGetAll() {
		final int initialCount = modelService.getAll().size();

		final int randomObjectsCount = getRandomObjectsCount();
		for (int i = 0; i < randomObjectsCount; i++) {
			saveNewModel();
		}

		final List<IModel> allEntities = modelService.getAll();

		for (final IModel entityFromDb : allEntities) {
			assertNotNull(entityFromDb.getId());
			assertNotNull(entityFromDb.getName());
			assertNotNull(entityFromDb.getBrand());
			assertNotNull(entityFromDb.getCreated());
			assertNotNull(entityFromDb.getUpdated());
		}

		assertEquals(randomObjectsCount + initialCount, allEntities.size());
	}

	@Test
	public void testDelete() {
		final IModel entity = saveNewModel();
		modelService.delete(entity.getId());
		assertNull(modelService.get(entity.getId()));
	}
	
	@Test
	public void testDeleteAll() {
		for (int i = 0; i < getRandomObjectsCount(); i++) {
			saveNewModel();
		}
		modelService.deleteAll();
		assertEquals(0, modelService.getAll().size());
	}
}
