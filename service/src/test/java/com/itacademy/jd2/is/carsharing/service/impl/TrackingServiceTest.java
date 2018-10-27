package com.itacademy.jd2.is.carsharing.service.impl;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.itacademy.jd2.is.carsharing.dao.api.entity.ICar;
import com.itacademy.jd2.is.carsharing.dao.api.entity.ITracking;

public class TrackingServiceTest extends AbstractTest {
	@Test
	public void testCreate() {
		final ITracking entity = saveNewTracking();

		final ITracking entityFromDb = trackingService.get(entity.getId());

		assertNotNull(entityFromDb);
		assertNotNull(entityFromDb.getId());
		assertEquals(entity.getId(), entityFromDb.getId());
		assertNotNull(entityFromDb.getCar());
		assertEquals(entity.getCar().getId(), entityFromDb.getCar().getId());
		assertNotNull(entityFromDb.getLatitude());
		assertNotNull(entityFromDb.getLongitude());
		assertNotNull(entityFromDb.getCreated());
		assertNotNull(entityFromDb.getUpdated());
		assertTrue(entityFromDb.getCreated().equals(entityFromDb.getUpdated()));
	}

	@Test
	public void testUpdateCar() throws InterruptedException {
		final ITracking entity = saveNewTracking();

		final ICar newCar = saveNewCar();
		entity.setCar(newCar);
		Thread.sleep(2000);
		trackingService.save(entity);

		final ITracking entityFromDb = trackingService.get(entity.getId());

		assertNotNull(entityFromDb);
		assertEquals(newCar.getId(), entityFromDb.getCar().getId());
		assertNotNull(entityFromDb.getLatitude());
		assertNotNull(entityFromDb.getLongitude());
		assertNotNull(entityFromDb.getCreated());
		assertNotNull(entityFromDb.getUpdated());
		assertEquals(entity.getCreated(), entityFromDb.getCreated());
		assertTrue(entityFromDb.getUpdated().after(entity.getCreated()));
	}

	@Test
	public void testGetAll() {
		final int initialCount = trackingService.getAll().size();

		final int randomObjectsCount = getRandomObjectsCount();
		for (int i = 0; i < randomObjectsCount; i++) {
			saveNewTracking();
		}

		final List<ITracking> allEntities = trackingService.getAll();

		for (final ITracking entityFromDb : allEntities) {
			assertNotNull(entityFromDb.getId());
			assertNotNull(entityFromDb.getCar());
			assertNotNull(entityFromDb.getLatitude());
			assertNotNull(entityFromDb.getLongitude());
			assertNotNull(entityFromDb.getCreated());
			assertNotNull(entityFromDb.getUpdated());
		}

		assertEquals(randomObjectsCount + initialCount, allEntities.size());
	}

	@Test
	public void testDelete() {
		final ITracking entity = saveNewTracking();
		trackingService.delete(entity.getId());
		assertNull(trackingService.get(entity.getId()));
	}

	@Test
	public void testDeleteAll() {
		for (int i = 0; i < getRandomObjectsCount(); i++) {
			saveNewTracking();
		}
		trackingService.deleteAll();
		assertEquals(0, trackingService.getAll().size());
	}
}
