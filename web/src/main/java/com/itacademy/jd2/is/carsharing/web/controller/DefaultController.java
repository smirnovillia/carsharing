package com.itacademy.jd2.is.carsharing.web.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.itacademy.jd2.is.carsharing.dao.api.entity.ITracking;
import com.itacademy.jd2.is.carsharing.dao.api.enums.Condition;
import com.itacademy.jd2.is.carsharing.dao.api.filter.TrackingFilter;
import com.itacademy.jd2.is.carsharing.service.ITrackingService;
import com.itacademy.jd2.is.carsharing.web.converter.TrackingFromDTOConverter;
import com.itacademy.jd2.is.carsharing.web.converter.TrackingToDTOConverter;
import com.itacademy.jd2.is.carsharing.web.dto.CarDTO;
import com.itacademy.jd2.is.carsharing.web.dto.TrackingDTO;
import com.itacademy.jd2.is.carsharing.web.dto.search.CarSearchDTO;

@Controller
@RequestMapping(value = "/")
public class DefaultController extends AbstractController<CarDTO> {

	private final ITrackingService trackingService;
	private final TrackingFromDTOConverter fromDTOConverter;
	private final TrackingToDTOConverter toDTOConverter;

	@Autowired
	public DefaultController(ITrackingService trackingService, TrackingFromDTOConverter fromDTOConverter,
			TrackingToDTOConverter toDTOConverter) {
		super();
		this.trackingService = trackingService;
		this.fromDTOConverter = fromDTOConverter;
		this.toDTOConverter = toDTOConverter;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView showPage() {

		final TrackingFilter filter = new TrackingFilter();
//		filter.setCondition(Condition.AVAILABLE);
		final List<ITracking> entities = trackingService.find(filter);
		List<List<Double>> coordinations = entities.stream()
				.map(tracking -> Arrays.asList(tracking.getLatitude(), tracking.getLongitude()))
				.collect(Collectors.toList());
		final Gson gson = new Gson();
		final String coordinates = gson.toJson(coordinations);
		final Map<String, Object> models = new HashMap<>();
		models.put("coord", coordinates);
		return new ModelAndView("index", models);
	}

}
