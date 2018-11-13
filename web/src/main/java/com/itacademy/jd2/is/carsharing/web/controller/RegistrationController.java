package com.itacademy.jd2.is.carsharing.web.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.itacademy.jd2.is.carsharing.web.dto.CustomerDTO;

@Controller
public class RegistrationController {

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public ModelAndView showForm(@RequestParam(value = "registrationForm") String registration) {

		final ModelAndView model = new ModelAndView();
		model.setViewName("registration");

		return model;

	}

	public String save(@Valid @ModelAttribute("formModel") final CustomerDTO formModel, final BindingResult result) {
		if (result.hasErrors()) {
			return "registration";
		} else {
//	            final IUserAccount user = fromDtoConverter.apply(formModel);
//	            final ICustomer customer 
//	            brandService.save(entity);
			return "redirect:/index";
		}
	}

}
