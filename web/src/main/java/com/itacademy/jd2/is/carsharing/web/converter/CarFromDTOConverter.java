package com.itacademy.jd2.is.carsharing.web.converter;

import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.itacademy.jd2.is.carsharing.dao.api.entity.ICar;
import com.itacademy.jd2.is.carsharing.dao.api.entity.IColor;
import com.itacademy.jd2.is.carsharing.dao.api.entity.IModel;
import com.itacademy.jd2.is.carsharing.dao.api.entity.IModification;
import com.itacademy.jd2.is.carsharing.dao.api.enums.Condition;
import com.itacademy.jd2.is.carsharing.service.ICarService;
import com.itacademy.jd2.is.carsharing.service.IColorService;
import com.itacademy.jd2.is.carsharing.service.IModelService;
import com.itacademy.jd2.is.carsharing.service.IModificationService;
import com.itacademy.jd2.is.carsharing.web.dto.CarDTO;

@Component
public class CarFromDTOConverter implements Function<CarDTO, ICar> {

	@Autowired
	private ICarService carService;
	@Autowired
	private IModelService modelService;
	@Autowired
	private IModificationService modificationService;
	@Autowired
	private IColorService colorService;

	@Override
	public ICar apply(final CarDTO dto) {
		final ICar entity = carService.createEntity();
		entity.setId(dto.getId());

		final IModel model = modelService.createEntity();
		model.setId(dto.getModelId());
		entity.setModel(model);

		final IModification modification = modificationService.createEntity();
		modification.setId(dto.getModificationId());
		entity.setModification(modification);

		entity.setReleaseDate(dto.getReleaseDate());
		entity.setVin(dto.getVin());

		final IColor color = colorService.createEntity();
		color.setId(dto.getColorId());
		entity.setColor(color);

		entity.setMileage(dto.getMileage());
		entity.setCondition(Condition.valueOf(dto.getCondition()));

		return entity;
	}
}
