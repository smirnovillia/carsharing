package com.itacademy.jd2.is.carsharing.web.controller;

import java.util.Arrays;
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
import com.itacademy.jd2.is.carsharing.dao.api.entity.IColor;
import com.itacademy.jd2.is.carsharing.dao.api.entity.IModel;
import com.itacademy.jd2.is.carsharing.dao.api.entity.IModification;
import com.itacademy.jd2.is.carsharing.dao.api.enums.Body;
import com.itacademy.jd2.is.carsharing.dao.api.enums.Condition;
import com.itacademy.jd2.is.carsharing.dao.api.enums.Drive;
import com.itacademy.jd2.is.carsharing.dao.api.enums.Fuel;
import com.itacademy.jd2.is.carsharing.dao.api.enums.Gearbox;
import com.itacademy.jd2.is.carsharing.dao.api.filter.CarFilter;
import com.itacademy.jd2.is.carsharing.service.ICarService;
import com.itacademy.jd2.is.carsharing.service.IColorService;
import com.itacademy.jd2.is.carsharing.service.IModelService;
import com.itacademy.jd2.is.carsharing.service.IModificationService;
import com.itacademy.jd2.is.carsharing.web.converter.CarFromDTOConverter;
import com.itacademy.jd2.is.carsharing.web.converter.CarToDTOConverter;
import com.itacademy.jd2.is.carsharing.web.dto.CarDTO;
import com.itacademy.jd2.is.carsharing.web.dto.list.GridStateDTO;
import com.itacademy.jd2.is.carsharing.web.dto.search.CarSearchDTO;

@Controller
@RequestMapping(value = "/car")
public class CarController extends AbstractController<CarDTO> {
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
    private CarFromDTOConverter fromDtoConverter;
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

        return new ModelAndView("car.list", models);
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView showForm() {
        final Map<String, Object> hashMap = new HashMap<>();
        final CarDTO dto = new CarDTO();
        hashMap.put("formModel", dto);
        loadCommonFormModels(hashMap);
        return new ModelAndView("car.edit", hashMap);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Object save(@Valid @ModelAttribute("formModel") final CarDTO formModel, final BindingResult result) {
        if (result.hasErrors()) {
            final Map<String, Object> hashMap = new HashMap<>();
            hashMap.put("formModel", formModel);
            loadCommonFormModels(hashMap);
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
        loadCommonFormModels(hashMap);
        return new ModelAndView("car.edit", hashMap);
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable(name = "id", required = true) final Integer id) {
        final CarDTO dto = toDtoConverter.apply(carService.get(id));

        final Map<String, Object> hashMap = new HashMap<>();
        hashMap.put("formModel", dto);
        loadCommonFormModels(hashMap);
        return new ModelAndView("car.edit", hashMap);
    }

    private void loadCommonFormModels(final Map<String, Object> hashMap) {

        final Map<Integer, String> modelMap = modelService.getAll().stream()
                .collect(Collectors.toMap(IModel::getId, IModel::getName));
        final Map<Integer, String> colorMap = colorService.getAll().stream()
                .collect(Collectors.toMap(IColor::getId, IColor::getName));

        modificationService.getAll().stream().collect(Collectors.toMap(IModification::getId, IModification::getFuel));
        modificationService.getAll().stream()
                .collect(Collectors.toMap(IModification::getId, IModification::getGearbox));

        hashMap.put("modelChoices", modelMap);
        hashMap.put("colorChoices", colorMap);

        hashMap.put("conditionChoices",
                Arrays.asList(Condition.values()).stream().collect(Collectors.toMap(Condition::name, Condition::name)));
        hashMap.put("bodyChoices",
                Arrays.asList(Body.values()).stream().collect(Collectors.toMap(Body::name, Body::name)));
        hashMap.put("driveChoices",
                Arrays.asList(Drive.values()).stream().collect(Collectors.toMap(Drive::name, Drive::name)));
        hashMap.put("fuelChoices",
                Arrays.asList(Fuel.values()).stream().collect(Collectors.toMap(Fuel::name, Fuel::name)));
        hashMap.put("gearboxChoices",
                Arrays.asList(Gearbox.values()).stream().collect(Collectors.toMap(Gearbox::name, Gearbox::name)));

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
