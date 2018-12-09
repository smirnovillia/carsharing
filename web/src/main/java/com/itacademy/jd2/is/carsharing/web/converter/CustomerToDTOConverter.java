package com.itacademy.jd2.is.carsharing.web.converter;

import java.util.function.Function;

import org.springframework.stereotype.Component;

import com.itacademy.jd2.is.carsharing.dao.api.entity.ICustomer;
import com.itacademy.jd2.is.carsharing.web.dto.CustomerDTO;

@Component
public class CustomerToDTOConverter implements Function<ICustomer, CustomerDTO> {

	@Override
	public CustomerDTO apply(ICustomer entity) {
		final CustomerDTO dto = new CustomerDTO();
		dto.setFirstName(entity.getFirstName());
		dto.setLastName(entity.getLastName());
		dto.setBirthday(entity.getBirthday());
		dto.setDriverLicense(entity.getDriverLicense());
		dto.setDriverLicenseStatus(entity.isDriverLicenseStatus());

		return dto;
	}

}
