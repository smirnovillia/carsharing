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

import com.itacademy.jd2.is.carsharing.dao.api.entity.IBrand;
import com.itacademy.jd2.is.carsharing.dao.api.entity.IColor;
import com.itacademy.jd2.is.carsharing.dao.api.entity.IModel;
import com.itacademy.jd2.is.carsharing.dao.api.filter.ModelFilter;
import com.itacademy.jd2.is.carsharing.service.IBrandService;
import com.itacademy.jd2.is.carsharing.service.IColorService;
import com.itacademy.jd2.is.carsharing.service.IModelService;
import com.itacademy.jd2.is.carsharing.web.converter.ModelFromDTOConverter;
import com.itacademy.jd2.is.carsharing.web.converter.ModelToDTOConverter;
import com.itacademy.jd2.is.carsharing.web.dto.ModelDTO;
import com.itacademy.jd2.is.carsharing.web.dto.list.GridStateDTO;

@Controller
@RequestMapping(value = "/data/model")
public class ModelController extends AbstractController<ModelDTO> {

	@Autowired
	private IModelService modelService;
	@Autowired
	private IBrandService brandService;
	@Autowired
	private IColorService colorService;
	@Autowired
	private ModelToDTOConverter toDtoConverter;
	@Autowired
	private ModelFromDTOConverter fromDtoConverter;

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
		hashMap.put("formModel", new ModelDTO());
		loadCommonFormModels(hashMap);
		return new ModelAndView("model.edit", hashMap);
	}

	@RequestMapping(method = RequestMethod.POST)
	public Object save(@Valid @ModelAttribute("formModel") final ModelDTO formModel, final BindingResult result) {
		if (result.hasErrors()) {
			final Map<String, Object> hashMap = new HashMap<>();
			hashMap.put("formModel", formModel);
			loadCommonFormModels(hashMap);
			return new ModelAndView("model.edit", hashMap);
		} else {
			final IModel entity = fromDtoConverter.apply(formModel);
			modelService.save(entity);
			return "redirect:/data/model";
		}
	}

	@RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
	public String delete(@PathVariable(name = "id", required = true) final Integer id) {
		modelService.delete(id);
		return "redirect:/data/model";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ModelAndView viewDetails(@PathVariable(name = "id", required = true) final Integer id) {
		final IModel dbModel = modelService.getFullInfo(id);
		final ModelDTO dto = toDtoConverter.apply(dbModel);
		final Map<String, Object> hashMap = new HashMap<>();
		hashMap.put("formModel", dto);
		hashMap.put("readonly", true);
		loadCommonFormModels(hashMap);
		return new ModelAndView("model.edit", hashMap);
	}

	@RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
	public ModelAndView edit(@PathVariable(name = "id", required = true) final Integer id) {
		final ModelDTO dto = toDtoConverter.apply(modelService.getFullInfo(id));

		final Map<String, Object> hashMap = new HashMap<>();
		hashMap.put("formModel", dto);
		loadCommonFormModels(hashMap);
		return new ModelAndView("model.edit", hashMap);
	}

	private void loadCommonFormModels(final Map<String, Object> hashMap) {
		final List<IBrand> brands = brandService.getAll();

		final Map<Integer, String> brandsMap = brands.stream()
				.collect(Collectors.toMap(IBrand::getId, IBrand::getName));
		hashMap.put("brandsChoices", brandsMap);

		final Map<Integer, String> colorsMap = colorService.getAll().stream()
				.collect(Collectors.toMap(IColor::getId, IColor::getName));
		hashMap.put("colorChoices", colorsMap);

	}

}
