package com.itacademy.jd2.is.carsharing.service.impl;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.itacademy.jd2.is.carsharing.dao.api.entity.ICar;
import com.itacademy.jd2.is.carsharing.dao.api.entity.ICarServiceHistory;

public class CarServiceHistoryServiceTest extends AbstractTest {

	@Test
	public void testCreate() {
		final ICarServiceHistory entity = saveNewCarServiceHistory();

		final ICarServiceHistory entityFromDb = carServiceHistoryService.get(entity.getId());

		assertNotNull(entityFromDb);
		assertEquals(entity, entityFromDb);
		assertNotNull(entityFromDb.getId());
		assertNotNull(entityFromDb.getCar());
		assertNotNull(entityFromDb.getServiceDate());
		assertNotNull(entityFromDb.getCarMileage());
		assertNotNull(entityFromDb.getServiceCompany());
		assertNotNull(entityFromDb.getServicePrice());
		assertNotNull(entityFromDb.getCreated());
		assertNotNull(entityFromDb.getUpdated());
		assertTrue(entityFromDb.getCreated().equals(entityFromDb.getUpdated()));
	}

	@Test
	public void testUpdateCar() throws InterruptedException {
		final ICarServiceHistory entity = saveNewCarServiceHistory();

		final ICar newCar = saveNewCar();
		entity.setCar(newCar);
		Thread.sleep(2000);
		carServiceHistoryService.save(entity);
		
		final ICarServiceHistory entityFromDb = carServiceHistoryService.get(entity.getId());

		assertNotNull(entityFromDb);
		assertEquals(newCar, entityFromDb.getCar());
		assertNotNull(entityFromDb.getId());
		assertNotNull(entityFromDb.getServiceDate());
		assertNotNull(entityFromDb.getCarMileage());
		assertNotNull(entityFromDb.getServiceCompany());
		assertNotNull(entityFromDb.getServicePrice());
		assertNotNull(entityFromDb.getCreated());
		assertNotNull(entityFromDb.getUpdated());
		assertEquals(entity.getCreated(), entityFromDb.getCreated());
		assertTrue(entityFromDb.getUpdated().after(entity.getCreated()));
	}

	@Test
	public void testGetAll() {
		final int initialCount = carServiceHistoryService.getAll().size();

		final int randomObjectsCount = getRandomObjectsCount();
		for (int i = 0; i < randomObjectsCount; i++) {
			saveNewCarServiceHistory();
		}

		final List<ICarServiceHistory> allEntities = carServiceHistoryService.getAll();

		for (final ICarServiceHistory entityFromDb : allEntities) {
			assertNotNull(entityFromDb.getId());
			assertNotNull(entityFromDb.getCar());
			assertNotNull(entityFromDb.getServiceDate());
			assertNotNull(entityFromDb.getCarMileage());
			assertNotNull(entityFromDb.getServiceCompany());
			assertNotNull(entityFromDb.getServicePrice());
			assertNotNull(entityFromDb.getCreated());
			assertNotNull(entityFromDb.getUpdated());
		}

		assertEquals(randomObjectsCount + initialCount, allEntities.size());
	}

	@Test
	public void testDelete() {
		final ICarServiceHistory entity = saveNewCarServiceHistory();
		carServiceHistoryService.delete(entity.getId());
		assertNull(carServiceHistoryService.get(entity.getId()));
	}
	
	@Test
	public void testDeleteAll() {
		for (int i = 0; i < getRandomObjectsCount(); i++) {
			saveNewCarServiceHistory();
		}
		carServiceHistoryService.deleteAll();
		assertEquals(0, carServiceHistoryService.getAll().size());
	}
}
