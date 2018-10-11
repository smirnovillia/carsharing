package com.itacademy.jd2.is.carsharing.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.itacademy.jd2.is.carsharing.dao.api.entity.IBrand;
import com.itacademy.jd2.is.carsharing.service.IBrandService;
import com.itacademy.jd2.is.carsharing.web.converter.BrandToDTOConverter;
import com.itacademy.jd2.is.carsharing.web.dto.BrandDTO;

@Controller
@RequestMapping(value = "/brand")
public class BrandController {

	 @Autowired
	    private IBrandService brandService;

	    @Autowired
	    private BrandToDTOConverter toDtoConverter;

	    @RequestMapping(method = RequestMethod.GET)
	    public ModelAndView index(final HttpServletRequest req) {

	        final List<IBrand> entities = brandService.getAll();
	        List<BrandDTO> dtos = entities.stream().map(toDtoConverter).collect(Collectors.toList());

	        final HashMap<String, Object> models = new HashMap<>();
	        models.put("list", dtos);
	        return new ModelAndView("brand.list", models);
	    }
}