package com.itacademy.jd2.is.carsharing.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping(value = "/model")
public class ModelController {
	@RequestMapping(method = RequestMethod.GET)
	public String index(final HttpServletRequest req) {
		return "model.list";
	}
}
