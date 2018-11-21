package com.itacademy.jd2.is.carsharing.web.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

@Controller
@RequestMapping(value = "/")
public class DefaultController {

	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView showPage() {
		Map<String, Object> models = new HashMap<>();
		double x = 53.21;
		double y = 27.57;
		double[] coord = {x,y};
		Gson gson = new Gson(); 
		String coordinates = gson.toJson(coord);
		models.put("coord", coordinates);
		return new ModelAndView("index", models);
	}
}
