package com.itacademy.jd2.is.carsharing.web.converter;

import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.itacademy.jd2.is.carsharing.dao.api.entity.ICustomer;
import com.itacademy.jd2.is.carsharing.dao.api.entity.IUserAccount;
import com.itacademy.jd2.is.carsharing.dao.api.enums.Role;
import com.itacademy.jd2.is.carsharing.service.ICustomerService;
import com.itacademy.jd2.is.carsharing.service.IUserAccountService;
import com.itacademy.jd2.is.carsharing.web.dto.CustomerDTO;

@Component
public class CustomerFromDTOConverter implements Function<CustomerDTO, ICustomer> {

	@Autowired
	private ICustomerService customerService;
	
	@Autowired
	private IUserAccountService userService;

	@Override
	public ICustomer apply(CustomerDTO dto) {
		final ICustomer entity = customerService.createEntity();
		entity.setId(dto.getId());
		entity.setFirstName(dto.getFirstName());
		entity.setLastName(dto.getLastName());
		entity.setBirthday(dto.getBirthday());
		entity.setDriverLicense(dto.getDriverLicense());
		entity.setCustomerPassport(dto.getCustomerPassport());
		entity.setCustomerImage(dto.getCustomerImage());
		
		final IUserAccount userAccount = userService.createEntity();
		userAccount.setId(dto.getId());
		userAccount.setLogin(dto.getUser().getLogin());
		userAccount.setPassword(dto.getUser().getPassword());
		userAccount.setUserRole(Role.values()[1]);
		entity.setUserAccount(userAccount);
		return entity;
	}

}
