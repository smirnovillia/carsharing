package com.itacademy.jd2.is.carsharing.web.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.itacademy.jd2.is.carsharing.dao.api.entity.IModel;
import com.itacademy.jd2.is.carsharing.dao.api.entity.IModification;
import com.itacademy.jd2.is.carsharing.dao.api.enums.Body;
import com.itacademy.jd2.is.carsharing.dao.api.enums.Drive;
import com.itacademy.jd2.is.carsharing.dao.api.enums.Fuel;
import com.itacademy.jd2.is.carsharing.dao.api.enums.Gearbox;
import com.itacademy.jd2.is.carsharing.dao.api.filter.ModificationFilter;
import com.itacademy.jd2.is.carsharing.service.IModelService;
import com.itacademy.jd2.is.carsharing.service.IModificationService;
import com.itacademy.jd2.is.carsharing.web.converter.ModificationFromDTOConverter;
import com.itacademy.jd2.is.carsharing.web.converter.ModificationToDTOConverter;
import com.itacademy.jd2.is.carsharing.web.dto.ModelDTO;
import com.itacademy.jd2.is.carsharing.web.dto.ModificationDTO;

@RequestMapping(value = "/data/modification")
@Controller
public class ModificationsController {

	private IModificationService modificationService;

	private ModificationFromDTOConverter fromDTOConverter;
	private ModificationToDTOConverter toDTOConverter;

	private IModelService modelService;

	@Autowired
	public ModificationsController(IModificationService modificationService,
			ModificationFromDTOConverter fromDTOConverter, ModificationToDTOConverter toDTOConverter,
			IModelService modelService) {
		super();
		this.modificationService = modificationService;
		this.fromDTOConverter = fromDTOConverter;
		this.toDTOConverter = toDTOConverter;
		this.modelService = modelService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView viewModifications(@RequestParam(name = "modelId", required = true) final Integer modelId) {

		ModificationFilter filter = new ModificationFilter();
		filter.setModelId(modelId);
		List<IModification> entities = modificationService.find(filter);
		final List<ModificationDTO> dtos = entities.stream().map(toDTOConverter).collect(Collectors.toList());
		final Map<String, Object> hashMap = new HashMap<>();
		hashMap.put("gridItems", dtos);
		hashMap.put("modelId", modelId);
		hashMap.put("modelName", modelService.get(modelId).getName());
		return new ModelAndView("modification.list", hashMap);
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView showForm(@RequestParam(name = "modelId", required = true) final Integer modelId) {
		final Map<String, Object> hashMap = new HashMap<>();
		ModificationDTO dto = new ModificationDTO();
		dto.setModelId(modelId);
		hashMap.put("formModel", dto);
		loadCommonFormModels(hashMap);
		return new ModelAndView("modification.edit", hashMap);
	}

	@RequestMapping(method = RequestMethod.POST)
	public Object save(@Valid @ModelAttribute("formModel") final ModificationDTO formModel,
			final BindingResult result) {
		if (result.hasErrors()) {
			final Map<String, Object> hashMap = new HashMap<>();
			hashMap.put("formModel", formModel);
			loadCommonFormModels(hashMap);
			return new ModelAndView("modification.edit", hashMap);
		} else {
			final IModification entity = fromDTOConverter.apply(formModel);
			modificationService.save(entity);
			return "redirect:/data/modification?modelId="+formModel.getModelId();
		}
	}

	private void loadCommonFormModels(Map<String, Object> hashMap) {
		hashMap.put("bodyChoices",
				Arrays.asList(Body.values()).stream().collect(Collectors.toMap(Body::name, Body::name)));
		hashMap.put("driveChoices",
				Arrays.asList(Drive.values()).stream().collect(Collectors.toMap(Drive::name, Drive::name)));
		hashMap.put("fuelChoices",
				Arrays.asList(Fuel.values()).stream().collect(Collectors.toMap(Fuel::name, Fuel::name)));
		hashMap.put("gearboxChoices",
				Arrays.asList(Gearbox.values()).stream().collect(Collectors.toMap(Gearbox::name, Gearbox::name)));

	}
}
