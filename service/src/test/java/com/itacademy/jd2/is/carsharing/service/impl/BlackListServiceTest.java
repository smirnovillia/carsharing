package com.itacademy.jd2.is.carsharing.service.impl;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.itacademy.jd2.is.carsharing.dao.api.entity.IBlackList;
import com.itacademy.jd2.is.carsharing.dao.api.entity.ICustomer;

public class BlackListServiceTest extends AbstractTest{
	
	@Test
	public void testCreate() {
		final IBlackList entity = saveNewBlackList();
		
		final IBlackList entityFromDb = blackListService.get(entity.getId());
		
		assertNotNull(entityFromDb);
		assertEquals(entity.getCustomer().getId(), entityFromDb.getCustomer().getId());
		assertEquals(entity.getReason(), entityFromDb.getReason());
		assertNotNull(entityFromDb.getId());
		assertNotNull(entityFromDb.getCreated());
		assertNotNull(entityFromDb.getUpdated());
		assertEquals(entityFromDb.getCreated(),entityFromDb.getUpdated());
	}
	
	@Test
	public void testUpdateCustomer() throws InterruptedException {
		final IBlackList entity = saveNewBlackList();
		
		final ICustomer newCustomer = saveNewCustomer();
		entity.setCustomer(newCustomer);
		Thread.sleep(2000);
		blackListService.save(entity);
		
		final IBlackList entityFromDb = blackListService.get(entity.getId());
		
		assertNotNull(entityFromDb);
		assertEquals(newCustomer, entity.getCustomer());
		assertNotNull(entityFromDb.getId());
		assertNotNull(entityFromDb.getReason());
		assertNotNull(entityFromDb.getCreated());
		assertNotNull(entityFromDb.getUpdated());
		assertEquals(entity.getCreated(), entityFromDb.getCreated());
		assertTrue(entityFromDb.getUpdated().after(entityFromDb.getCreated()));
	}
	
	@Test
	public void testUpdateReason() throws InterruptedException {
		final IBlackList entity = saveNewBlackList();
		
		String newReason = entity.getReason() + "_updated";
		entity.setReason(newReason);
		Thread.sleep(2000);
		blackListService.save(entity);
		
		final IBlackList entityFromDb = blackListService.get(entity.getId());
		
		assertNotNull(entityFromDb);
		assertEquals(newReason, entity.getReason());
		assertNotNull(entityFromDb.getId());
		assertNotNull(entityFromDb.getCustomer());
		assertNotNull(entityFromDb.getCreated());
		assertNotNull(entityFromDb.getUpdated());
		assertEquals(entity.getCreated(), entityFromDb.getCreated());
		assertTrue(entityFromDb.getUpdated().after(entityFromDb.getCreated()));
	}
	
	@Test
	public void testGetAll() {
		final int initialCount = blackListService.getAll().size();
		
		final int randomObjectCount = getRandomObjectsCount();
		for (int i = 0; i < randomObjectCount; i++) {
			saveNewBlackList();
		}
		
		List<IBlackList> allEntities = blackListService.getAll();
		
		for(IBlackList entityFromDb: allEntities) {
			assertNotNull(entityFromDb.getCustomer());
			assertNotNull(entityFromDb.getReason());
            assertNotNull(entityFromDb.getId());
            assertNotNull(entityFromDb.getCreated());
            assertNotNull(entityFromDb.getUpdated());
		}
		
		assertEquals(randomObjectCount + initialCount, allEntities.size());
	}
	
	@Test
	public void testDelete() {
		final IBlackList entity = saveNewBlackList();
		blackListService.delete(entity.getId());
		assertNull(blackListService.get(entity.getId()));
	}
	
	@Test
	public void testDeleteAll() {
		for (int i = 0; i < getRandomObjectsCount(); i++) {
			saveNewBlackList();
		}
		blackListService.deleteAll();
		assertEquals(0, blackListService.getAll().size());
	}
	
}
