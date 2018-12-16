package com.itacademy.jd2.is.carsharing.web.converter;

import java.util.function.Function;

import org.springframework.stereotype.Component;

import com.itacademy.jd2.is.carsharing.dao.api.entity.ICar;
import com.itacademy.jd2.is.carsharing.dao.api.entity.IColor;
import com.itacademy.jd2.is.carsharing.dao.api.entity.IModel;
import com.itacademy.jd2.is.carsharing.dao.api.entity.IModification;
import com.itacademy.jd2.is.carsharing.web.dto.CarDTO;

@Component
public class CarToDTOConverter implements Function<ICar, CarDTO> {

	@Override
	public CarDTO apply(final ICar entity) {
		final CarDTO dto = new CarDTO();
		dto.setId(entity.getId());

		IModification modification = entity.getModification();
		dto.setModificationId(modification.getId());
		IModel model = modification.getModel();
		dto.setModelId(model.getId());
		dto.setModelName(model.getName());
		

		dto.setReleaseDate(entity.getReleaseDate());
		dto.setVin(entity.getVin());

		final IColor color = entity.getColor();
		dto.setColorId(color.getId());
		dto.setColorName(color.getName());

		dto.setMileage(entity.getMileage());
		dto.setCondition(entity.getCondition().name());

		dto.setCreated(entity.getCreated());
		dto.setUpdated(entity.getUpdated());

		return dto;

	}
}
