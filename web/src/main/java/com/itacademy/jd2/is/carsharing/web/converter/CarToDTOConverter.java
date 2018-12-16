package com.itacademy.jd2.is.carsharing.web.converter;

import java.util.function.Function;

import org.springframework.stereotype.Component;

import com.itacademy.jd2.is.carsharing.dao.api.entity.ICar;
import com.itacademy.jd2.is.carsharing.dao.api.entity.IColor;
import com.itacademy.jd2.is.carsharing.dao.api.entity.IModel;
import com.itacademy.jd2.is.carsharing.dao.api.entity.IModification;
import com.itacademy.jd2.is.carsharing.web.dto.CarDTO;
import com.itacademy.jd2.is.carsharing.web.dto.ModificationDTO;

@Component
public class CarToDTOConverter implements Function<ICar, CarDTO> {

	@Override
	public CarDTO apply(final ICar entity) {
		final CarDTO dto = new CarDTO();
		dto.setId(entity.getId());

		final IModel model = entity.getModel();
		dto.setModelId(model.getId());
		dto.setModelName(model.getName());

		final IModification modification = entity.getModification();
		if (modification != null) {
			final ModificationDTO modificationDTO = dto.getModification();
			modificationDTO.setId(modification.getId());
			modificationDTO.setBody(modification.getBody().toString());
			modificationDTO.setFuel(modification.getFuel().toString());
			modificationDTO.setEngineCapacity(modification.getEngineCapacity());
			modificationDTO.setDrive(modification.getDrive().toString());
			modificationDTO.setGearbox(modification.getGearbox().toString());
			modificationDTO.setTankCapacity(modification.getTankCapacity());
		}

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
