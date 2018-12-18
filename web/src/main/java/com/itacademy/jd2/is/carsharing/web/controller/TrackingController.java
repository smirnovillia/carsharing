package com.itacademy.jd2.is.carsharing.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.itacademy.jd2.is.carsharing.dao.api.entity.ITracking;
import com.itacademy.jd2.is.carsharing.dao.api.filter.TrackingFilter;
import com.itacademy.jd2.is.carsharing.service.ICarService;
import com.itacademy.jd2.is.carsharing.service.ITrackingService;
import com.itacademy.jd2.is.carsharing.web.converter.TrackingFromDTOConverter;
import com.itacademy.jd2.is.carsharing.web.converter.TrackingToDTOConverter;
import com.itacademy.jd2.is.carsharing.web.dto.TrackingDTO;

@Controller
@RequestMapping(value = "/data/tracking")
public class TrackingController {

	private final ITrackingService trackingService;

	private final TrackingFromDTOConverter fromDTOConverter;
	private final TrackingToDTOConverter toDTOConverter;

	private final ICarService carService;

	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {

		final StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}

	@Autowired
	public TrackingController(ITrackingService trackingService, TrackingFromDTOConverter fromDTOConverter,
			TrackingToDTOConverter toDTOConverter, ICarService carService) {
		super();
		this.trackingService = trackingService;
		this.fromDTOConverter = fromDTOConverter;
		this.toDTOConverter = toDTOConverter;
		this.carService = carService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView viewTracking() {

		final TrackingFilter filter = new TrackingFilter();
		final List<ITracking> entities = trackingService.find(filter);
		final List<TrackingDTO> dtos = entities.stream().map(toDTOConverter).collect(Collectors.toList());
		final Map<String, Object> hashMap = new HashMap<>();
		hashMap.put("gridItems", dtos);
		return new ModelAndView("tracking.list", hashMap);
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView showForm(@RequestParam(name = "carId", required = true) final Integer carId) {
		final Map<String, Object> hashMap = new HashMap<>();
		final TrackingDTO dto = new TrackingDTO();
		dto.setCarId(carId);
		hashMap.put("formModel", dto);
		return new ModelAndView("tracking.add", hashMap);
	}

	@RequestMapping(method = RequestMethod.POST)
	public Object save(@Valid @ModelAttribute("formModel") final TrackingDTO formModel, final BindingResult result) {
		if (result.hasErrors()) {
			final Map<String, Object> hashMap = new HashMap<>();
			hashMap.put("formModel", formModel);
			return new ModelAndView("tracking.add", hashMap);
		} else {
			final ITracking entity = fromDTOConverter.apply(formModel);
			trackingService.save(entity);
			return "redirect:/data/tracking?carId=" + formModel.getCarId();
		}
	}

}
