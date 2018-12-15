package com.itacademy.jd2.is.carsharing.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.itacademy.jd2.is.carsharing.dao.api.entity.IModel;
import com.itacademy.jd2.is.carsharing.dao.api.filter.ModelFilter;
import com.itacademy.jd2.is.carsharing.service.IModelService;
import com.itacademy.jd2.is.carsharing.web.converter.ModelFromDTOConverter;
import com.itacademy.jd2.is.carsharing.web.converter.ModelToDTOConverter;
import com.itacademy.jd2.is.carsharing.web.dto.ModelDTO;
import com.itacademy.jd2.is.carsharing.web.dto.list.GridStateDTO;

@Controller
@RequestMapping(value = "/data/model")
public class ModelController extends AbstractController<ModelDTO> {

	private final IModelService modelService;

	private final ModelToDTOConverter toDtoConverter;
	private final ModelFromDTOConverter fromDtoConverter;

	@Autowired
	public ModelController(IModelService modelService, ModelToDTOConverter toDtoConverter,
			ModelFromDTOConverter fromDtoConverter) {
		super();
		this.modelService = modelService;
		this.toDtoConverter = toDtoConverter;
		this.fromDtoConverter = fromDtoConverter;
	}

	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {

		final StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView index(final HttpServletRequest req,
			@RequestParam(name = "page", required = false) final Integer pageNumber,
			@RequestParam(name = "sort", required = false) final String sortColumn) {
		final GridStateDTO gridState = getListDTO(req);
		gridState.setPage(pageNumber);
		gridState.setSort(sortColumn, "id");

		final ModelFilter filter = new ModelFilter();
		prepareFilter(gridState, filter);

		final List<IModel> entities = modelService.find(filter);
		final List<ModelDTO> dtos = entities.stream().map(toDtoConverter).collect(Collectors.toList());
		gridState.setTotalCount(modelService.getCount(filter));

		final Map<String, Object> models = new HashMap<>();
		models.put("gridItems", dtos);
		return new ModelAndView("model.list", models);
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView showForm() {
		final Map<String, Object> hashMap = new HashMap<>();
		final IModel newEntity = modelService.createEntity();
		hashMap.put("formModel", toDtoConverter.apply(newEntity));

		return new ModelAndView("model.edit", hashMap);
	}

	@RequestMapping(method = RequestMethod.POST)
	public String save(@Valid @ModelAttribute("formModel") final ModelDTO formModel, final BindingResult result) {
		if (result.hasErrors()) {
			return "model.edit";
		} else {
			final IModel entity = fromDtoConverter.apply(formModel);
			modelService.save(entity);
			return "redirect:/model";
		}
	}

	@RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
	public String delete(@PathVariable(name = "id", required = true) final Integer id) {
		modelService.delete(id);
		return "redirect:/model";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ModelAndView viewDetails(@PathVariable(name = "id", required = true) final Integer id) {
		final IModel dbModel = modelService.get(id);
		final ModelDTO dto = toDtoConverter.apply(dbModel);
		final Map<String, Object> hashMap = new HashMap<>();
		hashMap.put("formModel", dto);
		hashMap.put("readonly", true);

		return new ModelAndView("model.edit", hashMap);
	}

	@RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
	public ModelAndView edit(@PathVariable(name = "id", required = true) final Integer id) {
		final ModelDTO dto = toDtoConverter.apply(modelService.get(id));

		final Map<String, Object> hashMap = new HashMap<>();
		hashMap.put("formModel", dto);

		return new ModelAndView("model.edit", hashMap);
	}

}
