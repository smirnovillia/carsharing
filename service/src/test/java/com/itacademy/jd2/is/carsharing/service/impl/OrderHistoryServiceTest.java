package com.itacademy.jd2.is.carsharing.service.impl;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.itacademy.jd2.is.carsharing.dao.api.entity.ICustomer;
import com.itacademy.jd2.is.carsharing.dao.api.entity.IOrderHistory;

public class OrderHistoryServiceTest extends AbstractTest{

	@Test
	public void testCreate() {
		final IOrderHistory entity = saveNewOrderHistory();

		final IOrderHistory entityFromDb = orderHistoryService.get(entity.getId());

		assertNotNull(entityFromDb);
		assertNotNull(entityFromDb.getId());
		assertNotNull(entityFromDb.getCustomer());
		assertEquals(entity.getCustomer().getId(), entityFromDb.getCustomer().getId());
		assertNotNull(entityFromDb.getCar());
		assertEquals(entity.getCar().getId(), entityFromDb.getCar().getId());
		assertNotNull(entityFromDb.getOrderDate());
		assertNotNull(entityFromDb.getOrderMileage());
		assertNotNull(entityFromDb.getRate());
		assertNotNull(entityFromDb.getPrice());
		assertNotNull(entityFromDb.getCreated());
		assertNotNull(entityFromDb.getUpdated());
		assertTrue(entityFromDb.getCreated().equals(entityFromDb.getUpdated()));
	}

	@Test
	public void testUpdateBrand() throws InterruptedException {
		final IOrderHistory entity = saveNewOrderHistory();

		final ICustomer newCustomer = saveNewCustomer();
		entity.setCustomer(newCustomer);
		Thread.sleep(2000);
		orderHistoryService.save(entity);
		
		final IOrderHistory entityFromDb = orderHistoryService.get(entity.getId());

		assertNotNull(entityFromDb);
		assertEquals(newCustomer.getId(), entityFromDb.getCustomer().getId());
		assertNotNull(entityFromDb.getId());
		assertNotNull(entityFromDb.getCar());
		assertNotNull(entityFromDb.getOrderDate());
		assertNotNull(entityFromDb.getOrderMileage());
		assertNotNull(entityFromDb.getRate());
		assertNotNull(entityFromDb.getPrice());
		assertNotNull(entityFromDb.getCreated());
		assertNotNull(entityFromDb.getUpdated());
		assertEquals(entity.getCreated(), entityFromDb.getCreated());
		assertTrue(entityFromDb.getUpdated().after(entity.getCreated()));
	}

	@Test
	public void testGetAll() {
		final int initialCount = orderHistoryService.getAll().size();

		final int randomObjectsCount = getRandomObjectsCount();
		for (int i = 0; i < randomObjectsCount; i++) {
			saveNewOrderHistory();
		}

		final List<IOrderHistory> allEntities = orderHistoryService.getAll();

		for (final IOrderHistory entityFromDb : allEntities) {
			assertNotNull(entityFromDb.getId());
			assertNotNull(entityFromDb.getCustomer());
			assertNotNull(entityFromDb.getCar());
			assertNotNull(entityFromDb.getOrderDate());
			assertNotNull(entityFromDb.getOrderMileage());
			assertNotNull(entityFromDb.getRate());
			assertNotNull(entityFromDb.getPrice());
			assertNotNull(entityFromDb.getCreated());
			assertNotNull(entityFromDb.getUpdated());
		}

		assertEquals(randomObjectsCount + initialCount, allEntities.size());
	}

	@Test
	public void testDelete() {
		final IOrderHistory entity = saveNewOrderHistory();
		orderHistoryService.delete(entity.getId());
		assertNull(orderHistoryService.get(entity.getId()));
	}
	
	@Test
	public void testDeleteAll() {
		for (int i = 0; i < getRandomObjectsCount(); i++) {
			saveNewOrderHistory();
		}
		orderHistoryService.deleteAll();
		assertEquals(0, orderHistoryService.getAll().size());
	}
}
