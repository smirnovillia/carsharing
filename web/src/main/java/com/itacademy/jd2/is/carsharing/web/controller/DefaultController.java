package com.itacademy.jd2.is.carsharing.web.controller;

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
import com.itacademy.jd2.is.carsharing.dao.api.entity.ICar;
import com.itacademy.jd2.is.carsharing.dao.api.enums.Condition;
import com.itacademy.jd2.is.carsharing.dao.api.filter.CarFilter;
import com.itacademy.jd2.is.carsharing.service.ICarService;
import com.itacademy.jd2.is.carsharing.web.converter.CarFromDTOConverter;
import com.itacademy.jd2.is.carsharing.web.converter.CarToDTOConverter;
import com.itacademy.jd2.is.carsharing.web.dto.CarDTO;
import com.itacademy.jd2.is.carsharing.web.dto.list.GridStateDTO;
import com.itacademy.jd2.is.carsharing.web.dto.search.CarSearchDTO;

@Controller
@RequestMapping(value = "/")
public class DefaultController extends AbstractController<CarDTO> {
	private static final String SEARCH_FORM_MODEL = "searchFormModel";
	private static final String SEARCH_DTO = DefaultController.class.getSimpleName() + "_SEACH_DTO";

	@Autowired
	private ICarService carService;
	@Autowired
	private CarFromDTOConverter fromDtoConverter;
	@Autowired
	private CarToDTOConverter toDtoConverter;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView showPage(final HttpServletRequest req,
			@ModelAttribute(SEARCH_FORM_MODEL) CarSearchDTO searchDto,
			@RequestParam(name = "page", required = false) final Integer pageNumber,
			@RequestParam(name = "sort", required = false) final String sortColumn) {
		final GridStateDTO gridState = getListDTO(req);
		gridState.setPage(pageNumber);
		gridState.setSort(sortColumn, "id");

		if (req.getMethod().equalsIgnoreCase("get")) {
			searchDto = getSearchDTO(req);
		} else {
			req.getSession().setAttribute(SEARCH_DTO, searchDto);
		}

		final CarFilter filter = new CarFilter();

		if (searchDto.getCondition() != null && searchDto.getCondition().equals(Condition.AVAILABLE)) {
			filter.setCondition(Condition.valueOf(searchDto.getCondition()));
		}

		prepareFilter(gridState, filter);
		final Map<String, Object> models = new HashMap<>();

		final List<ICar> entities = carService.find(filter);
		final List<CarDTO> dtos = entities.stream().map(toDtoConverter).collect(Collectors.toList());
		gridState.setTotalCount(carService.getCount(filter));
//
//		final TrackingFilter filter = new TrackingFilter();
//		final List<ITracking> entities = trackingService.find(filter);
//		final List<TrackingDTO> dtos = entities.stream().map(toDTOConverter).collect(Collectors.toList());
//		hashMap.put("gridItems", dtos);
		models.put(SEARCH_FORM_MODEL, searchDto);
		final double x = 53.21;
		final double y = 27.57;
		final double[] coord = { x, y };
		final Gson gson = new Gson();
		final String coordinates = gson.toJson(coord);
		models.put("coord", coordinates);
		return new ModelAndView("index", models);
	}

	private CarSearchDTO getSearchDTO(final HttpServletRequest req) {
		CarSearchDTO searchDTO = (CarSearchDTO) req.getSession().getAttribute(SEARCH_DTO);
		if (searchDTO == null) {
			searchDTO = new CarSearchDTO();
			req.getSession().setAttribute(SEARCH_DTO, searchDTO);
		}
		return searchDTO;
	}
}
