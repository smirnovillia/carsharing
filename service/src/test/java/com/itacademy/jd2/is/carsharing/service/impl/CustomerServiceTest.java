package com.itacademy.jd2.is.carsharing.service.impl;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.itacademy.jd2.is.carsharing.dao.api.entity.ICustomer;

public class CustomerServiceTest extends AbstractTest{
	
	@Test
	public void testCreate() {
		final ICustomer entity = saveNewCustomer();

		final ICustomer entityFromDb = customerService.get(entity.getId());

		assertNotNull(entityFromDb);
		assertEquals(entity.getFirstName(), entityFromDb.getFirstName());
		assertEquals(entity.getLastName(), entityFromDb.getLastName());
		assertNotNull(entityFromDb.getId());
		assertNotNull(entityFromDb.getFirstName());
		assertNotNull(entityFromDb.getLastName());
		assertNotNull(entityFromDb.getBirthday());
		assertNotNull(entityFromDb.getDriverLicense());
		assertNotNull(entityFromDb.isDriverLicenseStatus());
		assertNotNull(entityFromDb.getCustomerPassport());
		assertNotNull(entityFromDb.getCustomerImage());
		assertNotNull(entityFromDb.getCreated());
		assertNotNull(entityFromDb.getUpdated());
		assertTrue(entityFromDb.getCreated().equals(entityFromDb.getUpdated()));
	}

	@Test
	public void testUpdate() throws InterruptedException {
		final ICustomer entity = saveNewCustomer();

		String newFirstName = entity.getFirstName() + "_updated";
		entity.setFirstName(newFirstName);
		String newLastName = entity.getLastName() + "_updated";
		entity.setLastName(newLastName);
		Thread.sleep(2000);
		customerService.save(entity);
		
		final ICustomer entityFromDb = customerService.get(entity.getId());

		assertNotNull(entityFromDb);
		assertEquals(newFirstName, entityFromDb.getFirstName());
		assertEquals(newLastName, entityFromDb.getLastName());
		assertNotNull(entityFromDb.getId());
		assertNotNull(entityFromDb.getBirthday());
		assertNotNull(entityFromDb.getDriverLicense());
		assertNotNull(entityFromDb.isDriverLicenseStatus());
		assertNotNull(entityFromDb.getCustomerPassport());
		assertNotNull(entityFromDb.getCustomerImage());
		assertNotNull(entityFromDb.getCreated());
		assertNotNull(entityFromDb.getUpdated());
		assertEquals(entity.getCreated(), entityFromDb.getCreated());
		assertTrue(entityFromDb.getUpdated().after(entity.getCreated()));
	}

	@Test
	public void testGetAll() {
		final int initialCount = customerService.getAll().size();

		final int randomObjectsCount = getRandomObjectsCount();
		for (int i = 0; i < randomObjectsCount; i++) {
			saveNewCustomer();
		}

		final List<ICustomer> allEntities = customerService.getAll();

		for (final ICustomer entityFromDb : allEntities) {
			assertNotNull(entityFromDb.getId());
			assertNotNull(entityFromDb.getFirstName());
			assertNotNull(entityFromDb.getLastName());
			assertNotNull(entityFromDb.getBirthday());
			assertNotNull(entityFromDb.getDriverLicense());
			assertNotNull(entityFromDb.isDriverLicenseStatus());
			assertNotNull(entityFromDb.getCustomerPassport());
			assertNotNull(entityFromDb.getCustomerImage());
			assertNotNull(entityFromDb.getCreated());
			assertNotNull(entityFromDb.getUpdated());
		}

		assertEquals(randomObjectsCount + initialCount, allEntities.size());
	}

	@Test
	public void testDelete() {
		final ICustomer entity = saveNewCustomer();
		customerService.delete(entity.getId());
		assertNull(customerService.get(entity.getId()));
	}
	
	@Test
	public void testDeleteAll() {
		for (int i = 0; i < getRandomObjectsCount(); i++) {
			saveNewCustomer();
		}
		customerService.deleteAll();
		assertEquals(0, customerService.getAll().size());
	}

}
