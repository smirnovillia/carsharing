package com.itacademy.jd2.is.carsharing.web.converter;

import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.itacademy.jd2.is.carsharing.dao.api.entity.ICustomer;
import com.itacademy.jd2.is.carsharing.dao.api.entity.IUserAccount;
import com.itacademy.jd2.is.carsharing.dao.api.enums.Role;
import com.itacademy.jd2.is.carsharing.service.IUserAccountService;
import com.itacademy.jd2.is.carsharing.web.dto.UserAccountDTO;

@Component
public class UserAccountFromDTOConverter implements Function<UserAccountDTO, IUserAccount> {

	@Autowired
	private IUserAccountService userAccountService;

	@Override
	public IUserAccount apply(UserAccountDTO dto) {
		final IUserAccount entity = userAccountService.createEntity();
		entity.setId(dto.getId());
		entity.setLogin(dto.getLogin());
		entity.setPassword(dto.getPassword());
		entity.setUserRole(Role.values()[dto.getUserRole()]);

		final ICustomer customer = userAccountService.createCustomerEntity();
		customer.setId(dto.getId());
		customer.setFirstName(dto.getCustomer().getFirstName());
		customer.setLastName(dto.getCustomer().getLastName());
		customer.setBirthday(dto.getCustomer().getBirthday());
		customer.setDriverLicense(dto.getCustomer().getDriverLicense());
		customer.setDriverLicenseStatus(dto.getCustomer().getDriverLicenseStatus());

		entity.setCustomer(customer);

		return entity;
	}

}
