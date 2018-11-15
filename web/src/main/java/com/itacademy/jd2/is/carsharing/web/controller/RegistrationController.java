package com.itacademy.jd2.is.carsharing.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "filling/")
public class RegistrationController {

	@RequestMapping(value = "registration", method = RequestMethod.GET)
	public ModelAndView showForm() {

		final ModelAndView model = new ModelAndView();
		model.setViewName("registration");

		return model;

	}

	@RequestMapping(value = "registration", method = RequestMethod.POST)
	public ModelAndView registrate() {

		final ModelAndView model = new ModelAndView();
		model.setViewName("registration");

		return model;

	}

}
