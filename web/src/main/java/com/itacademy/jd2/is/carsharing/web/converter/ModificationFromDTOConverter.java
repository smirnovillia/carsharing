package com.itacademy.jd2.is.carsharing.web.converter;

import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.itacademy.jd2.is.carsharing.dao.api.entity.IModification;
import com.itacademy.jd2.is.carsharing.dao.api.enums.Body;
import com.itacademy.jd2.is.carsharing.dao.api.enums.Drive;
import com.itacademy.jd2.is.carsharing.dao.api.enums.Fuel;
import com.itacademy.jd2.is.carsharing.dao.api.enums.Gearbox;
import com.itacademy.jd2.is.carsharing.service.IModificationService;
import com.itacademy.jd2.is.carsharing.web.dto.ModificationDTO;

@Component
public class ModificationFromDTOConverter implements Function<ModificationDTO, IModification> {

	@Autowired
	private IModificationService modificationService;

	@Override
	public IModification apply(ModificationDTO dto) {
		final IModification entity = modificationService.createEntity();

		entity.setId(dto.getId());
		entity.setBody(Body.valueOf(dto.getBody()));
		entity.setFuel(Fuel.valueOf(dto.getFuel()));
		entity.setEngineCapacity(dto.getEngineCapacity());
		entity.setDrive(Drive.valueOf(dto.getDrive()));
		entity.setGearbox(Gearbox.valueOf(dto.getGearbox()));
		entity.setTankCapacity(dto.getTankCapacity());

		return entity;
	}

}
