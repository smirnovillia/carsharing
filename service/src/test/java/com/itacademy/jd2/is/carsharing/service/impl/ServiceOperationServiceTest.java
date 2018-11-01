package com.itacademy.jd2.is.carsharing.service.impl;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.itacademy.jd2.is.carsharing.dao.api.entity.IServiceOperation;
import com.itacademy.jd2.is.carsharing.dao.api.entity.ISparePart;

public class ServiceOperationServiceTest extends AbstractTest{

	@Test
	public void testCreate() {
		final IServiceOperation entity = saveNewOperation();
		final IServiceOperation entityFromDb = operationService.get(entity.getId());

		assertNotNull(entityFromDb);
		assertNotNull(entityFromDb.getName());
		assertEquals(entity.getName(), entityFromDb.getName());
		assertNotNull(entityFromDb.getSparePart());
		assertNotNull(entityFromDb.getPrice());
		assertNotNull(entityFromDb.getCreated());
		assertNotNull(entityFromDb.getUpdated());
		assertTrue(entityFromDb.getCreated().equals(entityFromDb.getUpdated()));
	}

	@Test
	public void testUpdateSparePart() throws InterruptedException {
		final IServiceOperation entity = saveNewOperation();
		
		Thread.sleep(2000);
		operationService.save(entity);
		
		final IServiceOperation entityFromDb = operationService.get(entity.getId());
		
		assertNotNull(entityFromDb);
		assertEquals(entity.getId(), entityFromDb.getId());
		assertNotNull(entityFromDb.getName());
		assertNotNull(entityFromDb.getPrice());
		assertNotNull(entityFromDb.getCreated());
		assertNotNull(entityFromDb.getUpdated());
		assertTrue(entityFromDb.getUpdated().after(entity.getCreated()));
	}

	@Test
	public void testGetAll() {
		final int initialCount = operationService.getAll().size();

		final int randomObjectsCount = getRandomObjectsCount();
		for (int i = 0; i < randomObjectsCount; i++) {
			saveNewOperation();
		}

		final List<IServiceOperation> allEntities = operationService.getAll();

		for (final IServiceOperation entityFromDb : allEntities) {
			assertNotNull(entityFromDb.getId());
			assertNotNull(entityFromDb.getName());
			assertNotNull(entityFromDb.getPrice());
			assertNotNull(entityFromDb.getSparePart());
			assertNotNull(entityFromDb.getCreated());
			assertNotNull(entityFromDb.getUpdated());
		}

		assertEquals(randomObjectsCount + initialCount, allEntities.size());
	}

	@Test
	public void testDelete() {
		final IServiceOperation entity = saveNewOperation();
		operationService.delete(entity.getId());
		assertNull(operationService.get(entity.getId()));
	}
	
	@Test
	public void testDeleteAll() {
		for (int i = 0; i < getRandomObjectsCount(); i++) {
			saveNewOperation();
		}
		operationService.deleteAll();
		assertEquals(0, operationService.getAll().size());
	}
}
