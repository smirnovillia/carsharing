package com.itacademy.jd2.is.carsharing.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.itacademy.jd2.is.carsharing.dao.api.entity.IBlackList;
import com.itacademy.jd2.is.carsharing.dao.api.entity.IBrand;
import com.itacademy.jd2.is.carsharing.dao.api.entity.ICar;
import com.itacademy.jd2.is.carsharing.dao.api.entity.ICarServiceHistory;
import com.itacademy.jd2.is.carsharing.dao.api.entity.IColor;
import com.itacademy.jd2.is.carsharing.dao.api.entity.ICustomer;
import com.itacademy.jd2.is.carsharing.dao.api.entity.IInsurance;
import com.itacademy.jd2.is.carsharing.dao.api.entity.IModel;
import com.itacademy.jd2.is.carsharing.dao.api.entity.IModification;
import com.itacademy.jd2.is.carsharing.dao.api.entity.IOrderHistory;
import com.itacademy.jd2.is.carsharing.dao.api.entity.IServiceOperation;
import com.itacademy.jd2.is.carsharing.dao.api.entity.ISparePart;
import com.itacademy.jd2.is.carsharing.dao.api.entity.ITracking;
import com.itacademy.jd2.is.carsharing.dao.api.entity.IUserAccount;
import com.itacademy.jd2.is.carsharing.dao.api.enums.Body;
import com.itacademy.jd2.is.carsharing.dao.api.enums.Condition;
import com.itacademy.jd2.is.carsharing.dao.api.enums.Drive;
import com.itacademy.jd2.is.carsharing.dao.api.enums.Fuel;
import com.itacademy.jd2.is.carsharing.dao.api.enums.Gearbox;
import com.itacademy.jd2.is.carsharing.dao.api.enums.Role;
import com.itacademy.jd2.is.carsharing.service.IBlackListService;
import com.itacademy.jd2.is.carsharing.service.IBrandService;
import com.itacademy.jd2.is.carsharing.service.ICarService;
import com.itacademy.jd2.is.carsharing.service.ICarServiceHistoryService;
import com.itacademy.jd2.is.carsharing.service.IColorService;
import com.itacademy.jd2.is.carsharing.service.ICustomerService;
import com.itacademy.jd2.is.carsharing.service.IInsuranceService;
import com.itacademy.jd2.is.carsharing.service.IModelService;
import com.itacademy.jd2.is.carsharing.service.IModificationService;
import com.itacademy.jd2.is.carsharing.service.IOrderHistoryService;
import com.itacademy.jd2.is.carsharing.service.IServiceOperationService;
import com.itacademy.jd2.is.carsharing.service.ISparePartService;
import com.itacademy.jd2.is.carsharing.service.ITrackingService;
import com.itacademy.jd2.is.carsharing.service.IUserAccountService;

@SpringJUnitConfig(locations = "classpath:service-context-test.xml")
public class AbstractTest {
	@Autowired
	protected IBrandService brandService;
	@Autowired
	protected IBlackListService blackListService;
	@Autowired
	protected ICarService carService;
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
	protected IModificationService modificationService;
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
	
	private static final Random RANDOM = new Random();
	
	@BeforeEach
	public void setUpMethod() {
		blackListService.deleteAll();
		orderHistoryService.deleteAll();
		customerService.deleteAll();
		userAccountService.deleteAll();
		sparePartService.deleteAll();
		operationService.deleteAll();
		carServiceHistoryService.deleteAll();
		insuranceService.deleteAll();
		trackingService.deleteAll();
		carService.deleteAll();
		modelService.deleteAll();
		brandService.deleteAll();
		modificationService.deleteAll();
		colorService.deleteAll();
	}

	protected Date getRandomDate() {
		Calendar calendar = Calendar.getInstance();
		int year = RANDOM.nextInt(5) + 2017;
		int month = RANDOM.nextInt(12) + 1;
		int day = RANDOM.nextInt(30) + 1;
		calendar.set(year, month, day);
		Date date = calendar.getTime();
		return date;
	}

	protected boolean getRandomBoolean() {
		return RANDOM.nextBoolean();
	}

	protected Random getRANDOM() {
		return RANDOM;
	}

	protected IBrand saveNewBrand() {
		final IBrand entity = brandService.createEntity();
		entity.setName("brand-" + getRandomPrefix());
		brandService.save(entity);
		return entity;
	}

	protected IModel saveNewModel() {
		final IBrand brand = saveNewBrand();
		final IModel entity = modelService.createEntity();
		entity.setName("model-" + getRandomPrefix());
		entity.setBrand(brand);
		modelService.save(entity);
		return entity;
	}

	protected IModification saveNewModification() {
		final IModification entity = modificationService.createEntity();
		entity.setBody(getRandomBody());
		entity.setFuel(getRandomFuel());
		entity.setEngineCapacity(getRandomInt());
		entity.setDrive(getRandomDrive());
		entity.setGearbox(getRandomGearbox());
		entity.setTankCapacity(getRandomInt());
		modificationService.save(entity);
		return entity;
	}

	protected IColor saveNewColor() {
		final IColor entity = colorService.createEntity();
		entity.setName("color-" + getRandomPrefix());
		colorService.save(entity);
		return entity;
	}

	protected ICar saveNewCar() {
		final IModel model = saveNewModel();
		final IModification modification = saveNewModification();
		final IColor color = saveNewColor();
		final ICar entity = carService.createEntity();
		//entity.setModel(model);
		entity.setModification(modification);
		entity.setReleaseDate(getRandomInt());
		entity.setVin("vin - " + getRandomPrefix());
		entity.setColor(color);
		entity.setMileage(getRandomDouble());
		entity.setCondition(getRandomCondition());
		carService.save(entity);
		return entity;
	}

	protected ITracking saveNewTracking() {
		final ICar car = saveNewCar();
		final ITracking entity = trackingService.createEntity();
		entity.setCar(car);
		entity.setLatitude(getRandomLatitude());
		entity.setLongitude(getRandomLongitude());
		trackingService.save(entity);
		return entity;
	}

	protected IInsurance saveNewInsurance() {
		final ICar car = saveNewCar();
		final IInsurance entity = insuranceService.createEntity();
		entity.setCar(car);
		entity.setInsuranceCompany("insurance company - " + getRandomPrefix());
		entity.setInsuranceNumber("insurance - " + getRandomPrefix());
		entity.setIssued(getRandomDate());
		entity.setExpiried(getRandomDate());
		insuranceService.save(entity);
		return entity;

	}

	protected ICarServiceHistory saveNewCarServiceHistory() {
		final ICar car = saveNewCar();
		final ICarServiceHistory entity = carServiceHistoryService.createEntity();
		entity.setCar(car);
		entity.setServiceDate(getRandomDate());
		entity.setCarMileage(getRandomDouble());
		entity.setServiceCompany("service company - " + getRandomPrefix());
		entity.setServicePrice(getRandomDouble());
		carServiceHistoryService.save(entity);
		return entity;

	}

	protected ISparePart saveNewSparePart() {
		final ISparePart entity = sparePartService.createEntity();
		entity.setServiceOperation(saveNewOperation());
		entity.setName("spare part - " + getRandomPrefix());
		entity.setPrice(getRandomDouble());
		sparePartService.save(entity);
		return entity;
	}

	protected IServiceOperation saveNewOperation() {
		final IServiceOperation entity = operationService.createEntity();
		entity.setCarServiceHistory(saveNewCarServiceHistory());
		entity.setName("service operation - " + getRandomPrefix());
		entity.setPrice(getRandomDouble());
		operationService.save(entity);
		return entity;
	}

	protected IUserAccount saveNewUserAccount() {
		final IUserAccount entity = userAccountService.createEntity();
		entity.setLogin("login - " + getRandomPrefix());
		entity.setPassword("password - " + getRandomPrefix());
		entity.setUserRole(getRandomUserRole());
		userAccountService.save(entity);
		return entity;
	}

	protected ICustomer saveNewCustomer() {
		final ICustomer entity = customerService.createEntity();
		final IUserAccount userAccount = saveNewUserAccount();
		entity.setId(userAccount.getId());
		entity.setFirstName("first name - " + getRandomPrefix());
		entity.setLastName("last name - " + getRandomPrefix());
		entity.setBirthday(getRandomDate());
		entity.setDriverLicense("licence - " + getRandomPrefix());
		entity.setDriverLicenseStatus(getRandomBoolean());
		entity.setUserAccount(userAccount);
		customerService.save(entity);
		return entity;
	}

	protected IBlackList saveNewBlackList() {
		final ICustomer customer = saveNewCustomer();
		final IBlackList entity = blackListService.createEntity();
		entity.setCustomer(customer);
		entity.setReason("reason - " + getRandomPrefix());
		blackListService.save(entity);
		return entity;
	}

	protected IOrderHistory saveNewOrderHistory() {
		final ICustomer customer = saveNewCustomer();
		final ICar car = saveNewCar();
		final IOrderHistory entity = orderHistoryService.createEntity();
		entity.setCustomer(customer);
		entity.setCar(car);
		entity.setOrderDate(getRandomDate());
		entity.setOrderMileage(getRandomDouble());
		entity.setRate(getRandomDouble());
		entity.setPrice(getRandomDouble());
		orderHistoryService.save(entity);
		return entity;
	}

	protected String getRandomPrefix() {
		return RANDOM.nextInt(99999) + "";
	}

	protected int getRandomObjectsCount() {
		return RANDOM.nextInt(9) + 1;
	}

	protected Body getRandomBody() {
		return Body.values()[RANDOM.nextInt(Body.values().length)];
	}

	protected Fuel getRandomFuel() {
		return Fuel.values()[RANDOM.nextInt(Fuel.values().length)];
	}

	protected Drive getRandomDrive() {
		return Drive.values()[RANDOM.nextInt(Drive.values().length)];
	}

	protected Gearbox getRandomGearbox() {
		return Gearbox.values()[RANDOM.nextInt(Gearbox.values().length)];
	}
	
	protected Role getRandomUserRole() {
		return Role.values()[RANDOM.nextInt(Role.values().length)];
	}

	protected int getRandomInt() {
		return RANDOM.nextInt(999) + 1;
	}

	protected double getRandomDouble() {
		return RANDOM.nextDouble() * 1000;
	}

	protected Condition getRandomCondition() {
		return Condition.values()[RANDOM.nextInt(Condition.values().length)];
	}

	protected double getRandomLatitude() {
		return RANDOM.nextDouble() * 90;
	}

	protected double getRandomLongitude() {
		return RANDOM.nextDouble() * 180;
	}

}
