package com.itacademy.jd2.is.carsharing.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/registration")
public class RegistrationController {

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView showForm() {

		return new ModelAndView("registration");

	}

}
