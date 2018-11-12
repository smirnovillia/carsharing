package com.itacademy.jd2.is.carsharing.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.itacademy.jd2.is.carsharing.dao.api.entity.ICar;
import com.itacademy.jd2.is.carsharing.dao.api.filter.CarFilter;
import com.itacademy.jd2.is.carsharing.service.ICarService;
import com.itacademy.jd2.is.carsharing.service.IColorService;
import com.itacademy.jd2.is.carsharing.service.IModelService;
import com.itacademy.jd2.is.carsharing.service.IModificationService;
import com.itacademy.jd2.is.carsharing.web.converter.CarFromDTOConverter;
import com.itacademy.jd2.is.carsharing.web.converter.CarToDTOConverter;
import com.itacademy.jd2.is.carsharing.web.dto.CarDTO;
import com.itacademy.jd2.is.carsharing.web.dto.list.GridStateDTO;

@Controller
@RequestMapping(value = "/car")
public class CarController extends AbstractController<CarDTO> {

	private ICarService carService;
	private CarFromDTOConverter fromDtoConverter;
	private CarToDTOConverter toDtoConverter;
	
	@Autowired
	public CarController(ICarService carService, CarFromDTOConverter fromDtoConverter,
			CarToDTOConverter toDtoConverter) {
		super();
		this.carService = carService;
		this.fromDtoConverter = fromDtoConverter;
		this.toDtoConverter = toDtoConverter;
	}

	@RequestMapping(method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView index(final HttpServletRequest req,
			@RequestParam(name = "page", required = false) final Integer pageNumber,
			@RequestParam(name = "sort", required = false) final String sortColumn) {
		final GridStateDTO gridState = getListDTO(req);
		gridState.setPage(pageNumber);
		gridState.setSort(sortColumn, "id");

		final CarFilter filter = new CarFilter();
        prepareFilter(gridState, filter);

        final List<ICar> entities = carService.find(filter);
        final List<CarDTO> dtos = entities.stream().map(toDtoConverter).collect(Collectors.toList());

		final Map<String, Object> models = new HashMap<>();
		models.put("gridItems", dtos);

		return new ModelAndView("car.list", models);
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView showForm() {
		final Map<String, Object> hashMap = new HashMap<>();
		final CarDTO dto = new CarDTO();
		hashMap.put("formModel", dto);
		return new ModelAndView("car.edit", hashMap);
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Object save(@Valid @ModelAttribute("formModel") final CarDTO formModel, final BindingResult result) {
		if (result.hasErrors()) {
			final Map<String, Object> hashMap = new HashMap<>();
			hashMap.put("formModel", formModel);
			return new ModelAndView("car.edit", hashMap);
		} else {
			final ICar entity = fromDtoConverter.apply(formModel);
			carService.save(entity);
			return "redirect:/car";
		}
	}

	@RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
	public String delete(@PathVariable(name = "id", required = true) final Integer id) {
		carService.delete(id);
		return "redirect:/car";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ModelAndView viewDetails(@PathVariable(name = "id", required = true) final Integer id) {
		final ICar dbModel = carService.get(id);
		final CarDTO dto = toDtoConverter.apply(dbModel);
		final Map<String, Object> hashMap = new HashMap<>();
		hashMap.put("formModel", dto);
		hashMap.put("readonly", true);
		return new ModelAndView("car.edit", hashMap);
	}

	@RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
	public ModelAndView edit(@PathVariable(name = "id", required = true) final Integer id) {
		final CarDTO dto = toDtoConverter.apply(carService.get(id));

		final Map<String, Object> hashMap = new HashMap<>();
		hashMap.put("formModel", dto);
		return new ModelAndView("car.edit", hashMap);
	}

}
