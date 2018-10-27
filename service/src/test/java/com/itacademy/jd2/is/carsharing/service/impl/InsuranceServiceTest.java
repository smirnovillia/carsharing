package com.itacademy.jd2.is.carsharing.service.impl;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.itacademy.jd2.is.carsharing.dao.api.entity.ICar;
import com.itacademy.jd2.is.carsharing.dao.api.entity.IInsurance;

public class InsuranceServiceTest extends AbstractTest {
	@Test
	public void testCreate() {
		final IInsurance entity = saveNewInsurance();

		final IInsurance entityFromDb = insuranceService.get(entity.getId());

		assertNotNull(entityFromDb);
		assertNotNull(entityFromDb.getId());
		assertNotNull(entityFromDb.getCar());
		assertEquals(entity.getCar().getId(), entityFromDb.getCar().getId());
		assertNotNull(entityFromDb.getInsuranceCompany());
		assertEquals(entity.getInsuranceCompany(), entityFromDb.getInsuranceCompany());
		assertNotNull(entityFromDb.getInsuranceNumber());
		assertEquals(entity.getInsuranceNumber(), entityFromDb.getInsuranceNumber());
		assertNotNull(entityFromDb.getIssued());
		assertNotNull(entityFromDb.getExpiried());
		assertNotNull(entityFromDb.getCreated());
		assertNotNull(entityFromDb.getUpdated());
		assertTrue(entityFromDb.getCreated().equals(entityFromDb.getUpdated()));
	}

	@Test
	public void testUpdateCar() throws InterruptedException {
		final IInsurance entity = saveNewInsurance();

		final ICar newCar = saveNewCar();
		entity.setCar(newCar);
		Thread.sleep(2000);
		insuranceService.save(entity);
		
		final IInsurance entityFromDb = insuranceService.get(entity.getId());

		assertNotNull(entityFromDb);
		assertEquals(newCar.getId(), entityFromDb.getCar().getId());
		assertNotNull(entityFromDb.getId());
		assertNotNull(entityFromDb.getInsuranceCompany());
		assertNotNull(entityFromDb.getInsuranceNumber());
		assertNotNull(entityFromDb.getIssued());
		assertNotNull(entityFromDb.getExpiried());
		assertNotNull(entityFromDb.getCreated());
		assertNotNull(entityFromDb.getUpdated());
		assertEquals(entity.getCreated(), entityFromDb.getCreated());
		assertTrue(entityFromDb.getUpdated().after(entity.getCreated()));
	}

	@Test
	public void testGetAll() {
		final int initialCount = insuranceService.getAll().size();

		final int randomObjectsCount = getRandomObjectsCount();
		for (int i = 0; i < randomObjectsCount; i++) {
			saveNewInsurance();
		}

		final List<IInsurance> allEntities = insuranceService.getAll();

		for (final IInsurance entityFromDb : allEntities) {
			assertNotNull(entityFromDb.getId());
			assertNotNull(entityFromDb.getCar());
			assertNotNull(entityFromDb.getInsuranceCompany());
			assertNotNull(entityFromDb.getInsuranceNumber());
			assertNotNull(entityFromDb.getIssued());
			assertNotNull(entityFromDb.getExpiried());
			assertNotNull(entityFromDb.getCreated());
			assertNotNull(entityFromDb.getUpdated());
		}

		assertEquals(randomObjectsCount + initialCount, allEntities.size());
	}

	@Test
	public void testDelete() {
		final IInsurance entity = saveNewInsurance();
		insuranceService.delete(entity.getId());
		assertNull(insuranceService.get(entity.getId()));
	}
	
	@Test
	public void testDeleteAll() {
		for (int i = 0; i < getRandomObjectsCount(); i++) {
			saveNewInsurance();
		}
		insuranceService.deleteAll();
		assertEquals(0, insuranceService.getAll().size());
	}
}
