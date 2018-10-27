package com.itacademy.jd2.is.carsharing.service.impl;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.itacademy.jd2.is.carsharing.dao.api.entity.IModification;
import com.itacademy.jd2.is.carsharing.dao.api.enums.Fuel;

public class ModificationServiceTest extends AbstractTest {
	@Test
	public void testCreate() {
		final IModification entity = saveNewModification();

		final IModification entityFromDb = modificationService.get(entity.getId());

		assertNotNull(entityFromDb);
		assertNotNull(entityFromDb.getBody());
		assertEquals(entity.getBody(), entityFromDb.getBody());
		assertNotNull(entityFromDb.getFuel());
		assertEquals(entity.getFuel(), entityFromDb.getFuel());
		assertNotNull(entityFromDb.getDrive());
		assertEquals(entity.getDrive(), entityFromDb.getDrive());
		assertNotNull(entityFromDb.getGearbox());
		assertEquals(entity.getGearbox(), entityFromDb.getGearbox());
		assertEquals(entity.getEngineCapacity(), entityFromDb.getEngineCapacity());
		assertEquals(entity.getTankCapacity(), entityFromDb.getTankCapacity());
		assertNotNull(entityFromDb.getCreated());
		assertNotNull(entityFromDb.getUpdated());
		assertTrue(entityFromDb.getCreated().equals(entityFromDb.getUpdated()));
	}

	@Test
	public void testUpdateBrand() throws InterruptedException {
		final IModification entity = saveNewModification();

		final Fuel newFuel = getRandomFuel();
		entity.setFuel(newFuel);
		Thread.sleep(2000);
		modificationService.save(entity);
		
		final IModification entityFromDb = modificationService.get(entity.getId());

		assertNotNull(entityFromDb);
		assertEquals(newFuel, entityFromDb.getFuel());
		assertNotNull(entityFromDb.getId());
		assertNotNull(entityFromDb.getBody());
		assertNotNull(entityFromDb.getEngineCapacity());
		assertNotNull(entityFromDb.getDrive());
		assertNotNull(entityFromDb.getGearbox());
		assertNotNull(entityFromDb.getTankCapacity());
		assertNotNull(entityFromDb.getCreated());
		assertNotNull(entityFromDb.getUpdated());
		assertEquals(entity.getCreated(), entityFromDb.getCreated());
		assertTrue(entityFromDb.getUpdated().after(entity.getCreated()));
	}

	@Test
	public void testGetAll() {
		final int initialCount = modificationService.getAll().size();

		final int randomObjectsCount = getRandomObjectsCount();
		for (int i = 0; i < randomObjectsCount; i++) {
			saveNewModification();
		}

		final List<IModification> allEntities = modificationService.getAll();

		for (final IModification entityFromDb : allEntities) {
			assertNotNull(entityFromDb.getId());
			assertNotNull(entityFromDb.getBody());
			assertNotNull(entityFromDb.getFuel());
			assertNotNull(entityFromDb.getEngineCapacity());
			assertNotNull(entityFromDb.getDrive());
			assertNotNull(entityFromDb.getGearbox());
			assertNotNull(entityFromDb.getTankCapacity());
			assertNotNull(entityFromDb.getCreated());
			assertNotNull(entityFromDb.getUpdated());
		}

		assertEquals(randomObjectsCount + initialCount, allEntities.size());
	}

	@Test
	public void testDelete() {
		final IModification entity = saveNewModification();
		modificationService.delete(entity.getId());
		assertNull(modificationService.get(entity.getId()));
	}
	
	@Test
	public void testDeleteAll() {
		for (int i = 0; i < getRandomObjectsCount(); i++) {
			saveNewModification();
		}
		modificationService.deleteAll();
		assertEquals(0, modificationService.getAll().size());
	}
}
