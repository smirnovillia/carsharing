package com.itacademy.jd2.is.carsharing.service.impl;

import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.itacademy.jd2.is.carsharing.dao.api.entity.IBlackList;
import com.itacademy.jd2.is.carsharing.dao.api.entity.IBrand;
import com.itacademy.jd2.is.carsharing.service.IBlackListService;
import com.itacademy.jd2.is.carsharing.service.IBrandService;
import com.itacademy.jd2.is.carsharing.service.ICarService;
import com.itacademy.jd2.is.carsharing.service.ICarServiceDetailService;
import com.itacademy.jd2.is.carsharing.service.ICarServiceHistoryService;
import com.itacademy.jd2.is.carsharing.service.IColorService;
import com.itacademy.jd2.is.carsharing.service.ICustomerService;
import com.itacademy.jd2.is.carsharing.service.IInsuranceService;
import com.itacademy.jd2.is.carsharing.service.IModelService;
import com.itacademy.jd2.is.carsharing.service.IOrderHistoryService;
import com.itacademy.jd2.is.carsharing.service.IServiceOperationService;
import com.itacademy.jd2.is.carsharing.service.ISparePartService;
import com.itacademy.jd2.is.carsharing.service.ITrackingService;
import com.itacademy.jd2.is.carsharing.service.IUserAccountService;

@SpringJUnitConfig(locations = "classpath:service-context-test.xml")
@Sql
public class AbstractTest {
	@Autowired
	protected IBrandService brandService;
	@Autowired
	protected IBlackListService blackListService;
	@Autowired
	protected ICarService carService;
	@Autowired
	protected ICarServiceDetailService carServiceDetailService;
	@Autowired
	protected ICarServiceHistoryService carServiceHistoryService;
	@Autowired
	protected IColorService colorService;
	@Autowired
	protected ICustomerService customerService;
	@Autowired
	protected IInsuranceService insuranceService;
	@Autowired
	protected IModelService modelService;
	@Autowired
	protected IOrderHistoryService orderHistoryService;
	@Autowired
	protected IServiceOperationService operationService;
	@Autowired
	protected ISparePartService sparePartService;
	@Autowired
	protected ITrackingService trackingService;
	@Autowired
	protected IUserAccountService userAccountService;

	public AbstractTest() {
		super();
	}

	private static final Random RANDOM = new Random();

	protected String getRandomPrefix() {
		return RANDOM.nextInt(99999) + "";
	}

	protected int getRandomObjectsCount() {
		return RANDOM.nextInt(9) + 1;
	}

	public Random getRANDOM() {
		return RANDOM;
	}

	protected IBrand saveNewBrand() {
		final IBrand entity = brandService.createEntity();
		entity.setName("brand-" + getRandomPrefix());
		brandService.save(entity);
		return entity;
	}

	protected IBlackList saveNewBlackList() {
		final IBlackList entity = blackListService.createEntity();
		return entity;
	}

}
