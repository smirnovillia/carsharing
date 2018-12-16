package com.itacademy.jd2.is.carsharing.web.converter;

import java.util.function.Function;

import org.springframework.stereotype.Component;

import com.itacademy.jd2.is.carsharing.dao.api.entity.IModification;
import com.itacademy.jd2.is.carsharing.web.dto.ModificationDTO;

@Component
public class ModificationToDTOConverter implements Function<IModification, ModificationDTO> {

	@Override
	public ModificationDTO apply(IModification entity) {
		final ModificationDTO dto = new ModificationDTO();

		dto.setId(entity.getId());
		dto.setModelId(entity.getModel().getId());
		dto.setBody(entity.getBody().toString());
		dto.setFuel(entity.getFuel().toString());
		dto.setEngineCapacity(entity.getEngineCapacity());
		dto.setDrive(entity.getDrive().toString());
		dto.setGearbox(entity.getGearbox().toString());
		dto.setTankCapacity(entity.getTankCapacity());
		dto.setCreated(entity.getCreated());
		dto.setUpdated(entity.getUpdated());

		return dto;
	}

}
