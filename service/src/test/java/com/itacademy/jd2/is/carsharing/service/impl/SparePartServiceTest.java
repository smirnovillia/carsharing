package com.itacademy.jd2.is.carsharing.service.impl;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.itacademy.jd2.is.carsharing.dao.api.entity.ISparePart;

public class SparePartServiceTest extends AbstractTest{
	@Test
	public void testCreate() {
		final ISparePart entity = saveNewSparePart();

		final ISparePart entityFromDb = sparePartService.get(entity.getId());

		assertNotNull(entityFromDb);
		assertEquals(entity.getName(), entityFromDb.getName());
		assertNotNull(entityFromDb.getId());
		assertNotNull(entityFromDb.getName());
		assertNotNull(entityFromDb.getPrice());
		assertNotNull(entityFromDb.getCreated());
		assertNotNull(entityFromDb.getUpdated());
		assertTrue(entityFromDb.getCreated().equals(entityFromDb.getUpdated()));
	}

	@Test
	public void testUpdate() throws InterruptedException {
		final ISparePart entity = saveNewSparePart();

		String newName = entity.getName() + "_updated";
		entity.setName(newName);
		Thread.sleep(2000);
		sparePartService.save(entity);
		
		final ISparePart entityFromDb = sparePartService.get(entity.getId());

		assertNotNull(entityFromDb);
		assertEquals(newName, entityFromDb.getName());
		assertNotNull(entityFromDb.getId());
		assertNotNull(entityFromDb.getPrice());
		assertNotNull(entityFromDb.getCreated());
		assertNotNull(entityFromDb.getUpdated());
		assertEquals(entity.getCreated(), entityFromDb.getCreated());
		assertTrue(entityFromDb.getUpdated().after(entity.getCreated()));
	}

	@Test
	public void testGetAll() {
		final int initialCount = sparePartService.getAll().size();

		final int randomObjectsCount = getRandomObjectsCount();
		for (int i = 0; i < randomObjectsCount; i++) {
			saveNewSparePart();
		}

		final List<ISparePart> allEntities = sparePartService.getAll();

		for (final ISparePart entityFromDb : allEntities) {
			assertNotNull(entityFromDb.getId());
			assertNotNull(entityFromDb.getName());
			assertNotNull(entityFromDb.getPrice());
			assertNotNull(entityFromDb.getCreated());
			assertNotNull(entityFromDb.getUpdated());
		}

		assertEquals(randomObjectsCount + initialCount, allEntities.size());
	}

	@Test
	public void testDelete() {
		final ISparePart entity = saveNewSparePart();
		sparePartService.delete(entity.getId());
		assertNull(sparePartService.get(entity.getId()));
	}
	
	@Test
	public void testDeleteAll() {
		for (int i = 0; i < getRandomObjectsCount(); i++) {
			saveNewSparePart();
		}
		sparePartService.deleteAll();
		assertEquals(0, sparePartService.getAll().size());
	}
}
