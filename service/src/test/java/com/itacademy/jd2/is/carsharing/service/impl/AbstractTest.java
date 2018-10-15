package com.itacademy.jd2.is.carsharing.service.impl;

import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.itacademy.jd2.is.carsharing.dao.api.entity.IBlackList;
import com.itacademy.jd2.is.carsharing.dao.api.entity.IBrand;
import com.itacademy.jd2.is.carsharing.dao.api.entity.ICar;
import com.itacademy.jd2.is.carsharing.dao.api.entity.IColor;
import com.itacademy.jd2.is.carsharing.dao.api.entity.IModel;
import com.itacademy.jd2.is.carsharing.dao.api.entity.IModification;
import com.itacademy.jd2.is.carsharing.dao.api.enums.Body;
import com.itacademy.jd2.is.carsharing.dao.api.enums.Drive;
import com.itacademy.jd2.is.carsharing.dao.api.enums.Fuel;
import com.itacademy.jd2.is.carsharing.dao.api.enums.Gearbox;
import com.itacademy.jd2.is.carsharing.service.IBlackListService;
import com.itacademy.jd2.is.carsharing.service.IBrandService;
import com.itacademy.jd2.is.carsharing.service.ICarService;
import com.itacademy.jd2.is.carsharing.service.ICarServiceDetailService;
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
@Sql("classpath:sql/clean-db.sql")
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

	protected int getRandomEngineCapacity() {
		return RANDOM.nextInt(5000) + 1;
	}

	protected int getRandomTankCapacity() {
		return RANDOM.nextInt(80) + 1;
	}

	protected int getRandomReleaseDate() {
		return RANDOM.nextInt(2018) + 1;
	}

	protected String getRandomVin() {
		StringBuffer randStr = new StringBuffer();
		for (int i = 0; i < 17; i++) {
			int number = RANDOM.nextInt(charList().length());
			char ch = charList().charAt(number);
			randStr.append(ch);
		}
		return randStr.toString().toUpperCase();
	}

	private String charList() {
		return "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
	}
	
	protected double getRandomMileage() {
		return RANDOM.nextDouble()*300000;
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
		entity.setEngineCapacity(getRandomEngineCapacity());
		entity.setDrive(getRandomDrive());
		entity.setGearbox(getRandomGearbox());
		entity.setTankCapacity(getRandomTankCapacity());
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
		entity.setModel(model);
		entity.setModification(modification);
		entity.setReleaseDate(getRandomReleaseDate());
		entity.setVin(getRandomVin());
		entity.setColor(color);
		entity.setMileage(getRandomMileage());
		return entity;
	}

	protected IBlackList saveNewBlackList() {
		final IBlackList entity = blackListService.createEntity();
		return entity;
	}

}
