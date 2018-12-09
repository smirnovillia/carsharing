package com.itacademy.jd2.is.carsharing.web.converter;

import java.util.function.Function;

import org.springframework.stereotype.Component;

import com.itacademy.jd2.is.carsharing.dao.api.entity.ICustomer;
import com.itacademy.jd2.is.carsharing.dao.api.entity.IUserAccount;
import com.itacademy.jd2.is.carsharing.web.dto.UserAccountDTO;

@Component
public class UserAccountToDTOConverter implements Function<IUserAccount, UserAccountDTO> {

	@Override
	public UserAccountDTO apply(IUserAccount entity) {
		final UserAccountDTO userDto = new UserAccountDTO();
		userDto.setId(entity.getId());
		userDto.setLogin(entity.getLogin());
		userDto.setPassword(entity.getPassword());
		userDto.setUserRole(entity.getUserRole().ordinal());
		userDto.setCreated(entity.getCreated());
		userDto.setUpdated(entity.getUpdated());

		final ICustomer customer = entity.getCustomer();
		if (customer != null) {
			userDto.getCustomer().setFirstName(customer.getFirstName());
			userDto.getCustomer().setLastName(customer.getLastName());
			userDto.getCustomer().setBirthday(customer.getBirthday());
			userDto.getCustomer().setDriverLicense(customer.getDriverLicense());
			userDto.getCustomer().setDriverLicenseStatus(customer.isDriverLicenseStatus());
		}
		return userDto;
	}

}
