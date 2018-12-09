package com.itacademy.jd2.is.carsharing.web.converter;

import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.itacademy.jd2.is.carsharing.dao.api.entity.ICustomer;
import com.itacademy.jd2.is.carsharing.service.ICustomerService;
import com.itacademy.jd2.is.carsharing.web.dto.CustomerDTO;

@Component
public class CustomerFromDTOConverter implements Function<CustomerDTO, ICustomer> {

	@Autowired
	private ICustomerService customerService;

	@Override
	public ICustomer apply(CustomerDTO dto) {
		final ICustomer entity = customerService.createEntity();
		entity.setFirstName(dto.getFirstName());
		entity.setLastName(dto.getLastName());
		entity.setBirthday(dto.getBirthday());
		entity.setDriverLicense(dto.getDriverLicense());

		return entity;
	}

}
