package com.itacademy.jd2.is.carsharing.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/data")
public class DataController {

	@RequestMapping(method = RequestMethod.GET)
	public String showPage() {

		return "data";
	}

}
