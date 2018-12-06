package com.itacademy.jd2.is.carsharing.web.converter;

import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.itacademy.jd2.is.carsharing.dao.api.entity.ICar;
import com.itacademy.jd2.is.carsharing.dao.api.entity.IInsurance;
import com.itacademy.jd2.is.carsharing.service.ICarService;
import com.itacademy.jd2.is.carsharing.service.IInsuranceService;
import com.itacademy.jd2.is.carsharing.web.dto.InsuranceDTO;

@Component
public class InsuranceFromDTOConverter implements Function<InsuranceDTO, IInsurance> {

	@Autowired
	private IInsuranceService insuranceService;
	@Autowired
	private ICarService carService;

	@Override
	public IInsurance apply(InsuranceDTO dto) {
		final IInsurance entity = insuranceService.createEntity();

		final ICar car = carService.createEntity();
		car.setId(dto.getCarId());
		entity.setCar(car);

		entity.setInsuranceCompany(dto.getInsuranceCompany());
		entity.setInsuranceNumber(dto.getInsuranceNumber());
		entity.setIssued(dto.getIssued());
		entity.setExpiried(dto.getUpdated());

		return entity;
	}

}
