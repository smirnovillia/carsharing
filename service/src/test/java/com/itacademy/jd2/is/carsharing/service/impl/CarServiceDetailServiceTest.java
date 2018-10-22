package com.itacademy.jd2.is.carsharing.service.impl;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.itacademy.jd2.is.carsharing.dao.api.entity.ICarServiceDetail;
import com.itacademy.jd2.is.carsharing.dao.api.entity.ICarServiceHistory;

public class CarServiceDetailServiceTest extends AbstractTest{

	
	@Test
	public void testCreate() {
		final ICarServiceDetail entity = saveNewCarServiceDetail();

		final ICarServiceDetail entityFromDb = carServiceDetailService.get(entity.getId());

		assertNotNull(entityFromDb);
		assertEquals(entity, entityFromDb);
		assertNotNull(entityFromDb.getId());
		assertNotNull(entityFromDb.getCarServiceHistory());
		assertNotNull(entityFromDb.getServiceOperation());
		assertNotNull(entityFromDb.getCreated());
		assertNotNull(entityFromDb.getUpdated());
		assertTrue(entityFromDb.getCreated().equals(entityFromDb.getUpdated()));
	}

	@Test
	public void testUpdateCarHistory() throws InterruptedException {
		final ICarServiceDetail entity = saveNewCarServiceDetail();

		ICarServiceHistory newHistory = saveNewCarServiceHistory();
		entity.setCarServiceHistory(newHistory);
		Thread.sleep(2000);
		carServiceDetailService.save(entity);
		
		final ICarServiceDetail entityFromDb = carServiceDetailService.get(entity.getId());

		assertNotNull(entityFromDb);
		assertEquals(newHistory, entityFromDb.getCarServiceHistory());
		assertNotNull(entityFromDb.getId());
		assertNotNull(entityFromDb.getServiceOperation());
		assertNotNull(entityFromDb.getCreated());
		assertNotNull(entityFromDb.getUpdated());
		assertEquals(entity.getCreated(), entityFromDb.getCreated());
		assertTrue(entityFromDb.getUpdated().after(entity.getCreated()));
	}

	@Test
	public void testGetAll() {
		final int initialCount = carServiceDetailService.getAll().size();

		final int randomObjectsCount = getRandomObjectsCount();
		for (int i = 0; i < randomObjectsCount; i++) {
			saveNewCarServiceDetail();
		}

		final List<ICarServiceDetail> allEntities = carServiceDetailService.getAll();

		for (final ICarServiceDetail entityFromDb : allEntities) {
			assertNotNull(entityFromDb.getId());
			assertNotNull(entityFromDb.getCarServiceHistory());
			assertNotNull(entityFromDb.getServiceOperation());
			assertNotNull(entityFromDb.getCreated());
			assertNotNull(entityFromDb.getUpdated());
		}

		assertEquals(randomObjectsCount + initialCount, allEntities.size());
	}

	@Test
	public void testDelete() {
		final ICarServiceDetail entity = saveNewCarServiceDetail();
		carServiceDetailService.delete(entity.getId());
		assertNull(carServiceDetailService.get(entity.getId()));
	}
	
	@Test
	public void testDeleteAll() {
		for (int i = 0; i < getRandomObjectsCount(); i++) {
			saveNewCarServiceDetail();
		}
		carServiceDetailService.deleteAll();
		assertEquals(0, carServiceDetailService.getAll().size());
	}
}
