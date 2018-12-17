package com.itacademy.jd2.is.carsharing.web.controller;

import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.itacademy.jd2.is.carsharing.dao.api.entity.ICar;
import com.itacademy.jd2.is.carsharing.dao.api.entity.IColor;
import com.itacademy.jd2.is.carsharing.dao.api.entity.IModel;
import com.itacademy.jd2.is.carsharing.dao.api.entity.IModification;
import com.itacademy.jd2.is.carsharing.dao.api.enums.Condition;
import com.itacademy.jd2.is.carsharing.dao.api.filter.CarFilter;
import com.itacademy.jd2.is.carsharing.dao.api.filter.ModificationFilter;
import com.itacademy.jd2.is.carsharing.service.ICarService;
import com.itacademy.jd2.is.carsharing.service.IColorService;
import com.itacademy.jd2.is.carsharing.service.IModelService;
import com.itacademy.jd2.is.carsharing.service.IModificationService;
import com.itacademy.jd2.is.carsharing.web.converter.CarToDTOConverter;
import com.itacademy.jd2.is.carsharing.web.dto.CarDTO;
import com.itacademy.jd2.is.carsharing.web.dto.list.GridStateDTO;
import com.itacademy.jd2.is.carsharing.web.dto.search.CarSearchDTO;

@Controller
@RequestMapping(value = "/search")
public class SearchController extends AbstractController<CarDTO> {

	private static final String SEARCH_FORM_MODEL = "searchFormModel";
	private static final String SEARCH_DTO = CarController.class.getSimpleName() + "_SEACH_DTO";

	@Autowired
	private ICarService carService;
	@Autowired
	private IModificationService modificationService;
	@Autowired
	private IModelService modelService;
	@Autowired
	private IColorService colorService;
	@Autowired
	private CarToDTOConverter toDtoConverter;

	@RequestMapping(method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView index(final HttpServletRequest req, @ModelAttribute(SEARCH_FORM_MODEL) CarSearchDTO searchDto,
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
		if (searchDto.getBody() != null) {
			filter.setBody(searchDto.getBody());
		}

		if (searchDto.getFuel() != null) {
			filter.setFuel(searchDto.getFuel());
		}

		if (searchDto.getDrive() != null) {
			filter.setDrive(searchDto.getDrive());
		}

		if (searchDto.getGearbox() != null) {
			filter.setGearbox(searchDto.getGearbox());
		}

		if (searchDto.getEngineCapacity() != null) {
			filter.setEngineCapacity(searchDto.getEngineCapacity());
		}

		prepareFilter(gridState, filter);

		final List<ICar> entities = carService.find(filter);
		final List<CarDTO> dtos = entities.stream().map(toDtoConverter).collect(Collectors.toList());
		gridState.setTotalCount(carService.getCount(filter));

		final Map<String, Object> models = new HashMap<>();
		models.put("gridItems", dtos);
		models.put(SEARCH_FORM_MODEL, searchDto);

//		loadCommonFormModels(models);

		return new ModelAndView("car.list", models);
	}

	private void loadCommonFormModels(final Map<String, Object> hashMap, Integer modelId) {

		if (modelId != null) {
			ModificationFilter filter = new ModificationFilter();
			filter.setModelId(modelId);
			final Map<Integer, String> modificationsMap = modificationService.find(filter).stream()
					.collect(Collectors.toMap(IModification::getId, IModification::toString));
			hashMap.put("modificationsChoices", modificationsMap);

			final Map<Integer, String> colorMap = modelService.getFullInfo(modelId).getColors().stream()
					.collect(Collectors.toMap(IColor::getId, IColor::getName));
			hashMap.put("colorChoices", colorMap);
		}

		Map<Object, Object> yearsMap = new TreeMap<>();
		int currentYear = Calendar.getInstance().get(Calendar.YEAR);
		for (int i = currentYear - 20; i < currentYear; i++) {
			yearsMap.put(i, i);
		}
		hashMap.put("releaseDateChoices", yearsMap);

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
