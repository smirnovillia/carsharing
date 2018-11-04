package com.itacademy.jd2.is.carsharing.service.impl;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.itacademy.jd2.is.carsharing.dao.api.entity.ICar;
import com.itacademy.jd2.is.carsharing.dao.api.entity.IModification;

public class CarServiceTest extends AbstractTest{
	@Test
	public void testCreate() {
		final ICar entity = saveNewCar();

		final ICar entityFromDb = carService.get(entity.getId());

		assertNotNull(entityFromDb);
		assertNotNull(entityFromDb.getModification());
//		assertEquals(entity.getModification().getId(), entityFromDb.getModification().getId());
		assertNotNull(entityFromDb.getId());
		assertNotNull(entityFromDb.getModel());
//		assertEquals(entity.getModel().getId(), entityFromDb.getModel().getId());
		assertNotNull(entityFromDb.getReleaseDate());
		assertNotNull(entityFromDb.getVin());
		assertEquals(entity.getVin(), entityFromDb.getVin());
		assertNotNull(entityFromDb.getColor());
//		assertEquals(entity.getColor().getId(), entityFromDb.getColor().getId());
		assertNotNull(entityFromDb.getMileage());
		assertNotNull(entityFromDb.getCondition());
		assertNotNull(entityFromDb.getCreated());
		assertNotNull(entityFromDb.getUpdated());
		assertTrue(entityFromDb.getCreated().equals(entityFromDb.getUpdated()));
	}

	@Test
	public void testUpdateCar() throws InterruptedException {
		final ICar entity = saveNewCar();

		final IModification newModification = saveNewModification();
		entity.setModification(newModification);
		Thread.sleep(2000);
		carService.save(entity);
		
		final ICar entityFromDb = carService.get(entity.getId());

		assertNotNull(entityFromDb);
//		assertEquals(newModification.getId(), entityFromDb.getModification().getId());
		assertNotNull(entityFromDb.getId());
		assertNotNull(entityFromDb.getModel());
		assertNotNull(entityFromDb.getReleaseDate());
		assertNotNull(entityFromDb.getVin());
		assertNotNull(entityFromDb.getColor());
		assertNotNull(entityFromDb.getMileage());
		assertNotNull(entityFromDb.getCondition());
		assertNotNull(entityFromDb.getCreated());
		assertNotNull(entityFromDb.getUpdated());
		assertEquals(entity.getCreated(), entityFromDb.getCreated());
		assertTrue(entityFromDb.getUpdated().after(entity.getCreated()));
	}

	@Test
	public void testGetAll() {
		final int initialCount = carService.getAll().size();

		final int randomObjectsCount = getRandomObjectsCount();
		for (int i = 0; i < randomObjectsCount; i++) {
			saveNewCar();
		}

		final List<ICar> allEntities = carService.getAll();

		for (final ICar entityFromDb : allEntities) {
			assertNotNull(entityFromDb.getId());
			assertNotNull(entityFromDb.getModel());
			assertNotNull(entityFromDb.getModification());
			assertNotNull(entityFromDb.getReleaseDate());
			assertNotNull(entityFromDb.getVin());
			assertNotNull(entityFromDb.getColor());
			assertNotNull(entityFromDb.getMileage());
			assertNotNull(entityFromDb.getCondition());
			assertNotNull(entityFromDb.getCreated());
			assertNotNull(entityFromDb.getUpdated());
		}

		assertEquals(randomObjectsCount + initialCount, allEntities.size());
	}

	@Test
	public void testDelete() {
		final ICar entity = saveNewCar();
		carService.delete(entity.getId());
		assertNull(carService.get(entity.getId()));
	}
	
	@Test
	public void testDeleteAll() {
		for (int i = 0; i < getRandomObjectsCount(); i++) {
			saveNewCar();
		}
		carService.deleteAll();
		assertEquals(0, carService.getAll().size());
	}
}
