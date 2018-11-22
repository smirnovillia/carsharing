package com.itacademy.jd2.is.carsharing.web.converter;

import java.util.function.Function;

import org.springframework.stereotype.Component;

import com.itacademy.jd2.is.carsharing.dao.api.entity.ICustomer;
import com.itacademy.jd2.is.carsharing.dao.api.entity.IUserAccount;
import com.itacademy.jd2.is.carsharing.web.dto.CustomerDTO;

@Component
public class CustomerToDTOConverter implements Function<ICustomer, CustomerDTO> {

	@Override
	public CustomerDTO apply(ICustomer entity) {
		final CustomerDTO dto = new CustomerDTO();
		dto.setId(entity.getId());
		dto.setFirstName(entity.getFirstName());
		dto.setLastName(entity.getLastName());
		dto.setBirthday(entity.getBirthday());
		dto.setDriverLicense(entity.getDriverLicense());
		dto.setCustomerPassport(entity.getCustomerPassport());
		dto.setCustomerImage(entity.getCustomerImage());
		
		final IUserAccount userAccount = entity.getUserAccount();
		return dto;
	}

}
