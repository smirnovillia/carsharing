package com.itacademy.jd2.is.carsharing.web.converter;

import java.util.function.Function;

import com.itacademy.jd2.is.carsharing.dao.api.entity.IModification;
import com.itacademy.jd2.is.carsharing.web.dto.ModificationDTO;

public class ModificationToDTOConverter implements Function<IModification, ModificationDTO>{

	@Override
	public ModificationDTO apply(IModification entity) {
		final ModificationDTO dto = new ModificationDTO();
		dto.setId(entity.getId());
		
		
		
		return dto;
	}

}
