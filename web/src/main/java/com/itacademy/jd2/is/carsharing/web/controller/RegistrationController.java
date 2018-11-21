package com.itacademy.jd2.is.carsharing.web.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.itacademy.jd2.is.carsharing.dao.api.entity.ICustomer;
import com.itacademy.jd2.is.carsharing.dao.api.entity.IUserAccount;
import com.itacademy.jd2.is.carsharing.dao.api.enums.Role;
import com.itacademy.jd2.is.carsharing.service.ICustomerService;
import com.itacademy.jd2.is.carsharing.service.IUserAccountService;
import com.itacademy.jd2.is.carsharing.web.converter.CustomerFromDTOConverter;
import com.itacademy.jd2.is.carsharing.web.converter.CustomerToDTOConverter;
import com.itacademy.jd2.is.carsharing.web.converter.UserAccountFromDTOConverter;
import com.itacademy.jd2.is.carsharing.web.converter.UserAccountToDTOConverter;
import com.itacademy.jd2.is.carsharing.web.dto.CustomerDTO;
import com.itacademy.jd2.is.carsharing.web.dto.UserAccountDTO;

@Controller
@RequestMapping(value = "/registration")
public class RegistrationController {

	private final IUserAccountService userAccountService;
	private final ICustomerService customerService;
	private final UserAccountFromDTOConverter userFromDtoConverter;
	private final UserAccountToDTOConverter userToDtoConverter;
	private final CustomerFromDTOConverter customerFromDtoConverter;
	private final CustomerToDTOConverter customerToDtoConverter;

	@Autowired
	public RegistrationController(IUserAccountService userAccountService, ICustomerService customerService,
			UserAccountFromDTOConverter userFromDtoConverter, UserAccountToDTOConverter userToDtoConverter,
			CustomerFromDTOConverter customerFromDtoConverter, CustomerToDTOConverter customerToDtoConverter) {
		super();
		this.userAccountService = userAccountService;
		this.customerService = customerService;
		this.userFromDtoConverter = userFromDtoConverter;
		this.userToDtoConverter = userToDtoConverter;
		this.customerFromDtoConverter = customerFromDtoConverter;
		this.customerToDtoConverter = customerToDtoConverter;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView showForm() {
		final Map<String, Object> hashMap = new HashMap<>();
		final IUserAccount newUser = userAccountService.createEntity();
		final ICustomer newCustomer = customerService.createEntity();
		hashMap.put("formUser", userToDtoConverter.apply(newUser));
		hashMap.put("formCustomer", customerToDtoConverter.apply(newCustomer));

		return new ModelAndView("registration", hashMap);
	}

	@RequestMapping(method = RequestMethod.POST)
	public String registrate(@RequestParam("f1") final MultipartFile driverLicense,
			@RequestParam("f2") final MultipartFile passport, 
			@Valid @ModelAttribute("formUser") UserAccountDTO formUser,
			@Valid @ModelAttribute("formCustomer") CustomerDTO formCustomer, final BindingResult result)
			throws IOException {

		if (result.hasErrors()) {
			return "registration";
		} else {
			final IUserAccount user = userFromDtoConverter.apply(formUser);
			final ICustomer customer = customerFromDtoConverter.apply(formCustomer);
			final String driverLicenseString = new BufferedReader(new InputStreamReader(driverLicense.getInputStream()))
					.lines().collect(Collectors.joining("\n"));
			final String customerPassportString = new BufferedReader(new InputStreamReader(passport.getInputStream()))
					.lines().collect(Collectors.joining("\n"));
			final String customerImageString = new BufferedReader(new InputStreamReader(image.getInputStream())).lines()
					.collect(Collectors.joining("\n"));
			customer.setDriverLicense(driverLicenseString);
			customer.setCustomerPassport(customerPassportString);
			customer.setCustomerImage(customerImageString);
			user.setUserRole(Role.ROLE_CUSTOMER);
			userAccountService.save(user);
			customerService.save(customer);
			return "redirect:/index";
		}

	}

}
