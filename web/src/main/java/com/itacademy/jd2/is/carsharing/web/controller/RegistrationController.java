package com.itacademy.jd2.is.carsharing.web.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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
import com.itacademy.jd2.is.carsharing.service.ICustomerService;
import com.itacademy.jd2.is.carsharing.web.converter.CustomerFromDTOConverter;
import com.itacademy.jd2.is.carsharing.web.converter.CustomerToDTOConverter;
import com.itacademy.jd2.is.carsharing.web.dto.CustomerDTO;

@Controller
@RequestMapping(value = "/registration")
public class RegistrationController {

	private final ICustomerService customerService;
	private final CustomerFromDTOConverter customerFromDtoConverter;
	private final CustomerToDTOConverter customerToDtoConverter;

	@Autowired
	public RegistrationController(ICustomerService customerService,
			CustomerFromDTOConverter customerFromDtoConverter, CustomerToDTOConverter customerToDtoConverter) {
		super();
		this.customerService = customerService;
		this.customerFromDtoConverter = customerFromDtoConverter;
		this.customerToDtoConverter = customerToDtoConverter;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView showForm() {
		final Map<String, Object> hashMap = new HashMap<>();
		final ICustomer newCustomer = customerService.createEntity();
		hashMap.put("formModel", customerToDtoConverter.apply(newCustomer));

		return new ModelAndView("registration", hashMap);
	}

	@RequestMapping(method = RequestMethod.POST)
	public String registrate(@RequestParam("driverLicense") final MultipartFile driverLicense,
			@RequestParam("passport") final MultipartFile passport, @RequestParam("image") final MultipartFile image, 
			@Valid @ModelAttribute("formModel") CustomerDTO formCustomer, final BindingResult result)
			throws IOException {

		if (result.hasErrors()) {
			return "registration";
		} else {
			final ICustomer customer = customerFromDtoConverter.apply(formCustomer);
			customerService.save(customer);
			return "redirect:/index";
		}

	}

}
