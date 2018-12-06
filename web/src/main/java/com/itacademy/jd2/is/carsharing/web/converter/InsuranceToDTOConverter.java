package com.itacademy.jd2.is.carsharing.web.converter;

import java.util.function.Function;

import org.springframework.stereotype.Component;

import com.itacademy.jd2.is.carsharing.dao.api.entity.ICar;
import com.itacademy.jd2.is.carsharing.dao.api.entity.IInsurance;
import com.itacademy.jd2.is.carsharing.web.dto.InsuranceDTO;

@Component
public class InsuranceToDTOConverter implements Function<IInsurance, InsuranceDTO> {

	@Override
	public InsuranceDTO apply(IInsurance entity) {
		final InsuranceDTO dto = new InsuranceDTO();
		dto.setId(entity.getId());

		final ICar car = entity.getCar();
		dto.setCarId(car.getId());

		dto.setInsuranceCompany(entity.getInsuranceCompany());
		dto.setInsuranceNumber(entity.getInsuranceNumber());
		dto.setIssued(entity.getIssued());
		dto.setExpiried(entity.getExpiried());
		dto.setCreated(entity.getCreated());
		dto.setUpdated(entity.getUpdated());

		return dto;
	}

}
