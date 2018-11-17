package com.itacademy.jd2.is.carsharing.web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.itacademy.jd2.is.carsharing.dao.api.entity.ICustomer;
import com.itacademy.jd2.is.carsharing.dao.api.entity.IUserAccount;
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

		return new ModelAndView("registration.form", hashMap);
	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String registrate(@Valid @ModelAttribute("formUser") UserAccountDTO formUser,
			@Valid @ModelAttribute("formCustomer") CustomerDTO formCustomer, final BindingResult result) {

		if (result.hasErrors()) {
			return "registration";
		} else {
			final IUserAccount user = userFromDtoConverter.apply(formUser);
			final ICustomer customer = customerFromDtoConverter.apply(formCustomer);
			userAccountService.save(user);
			customerService.save(customer);
			return "redirect:/index";
		}

	}

}
