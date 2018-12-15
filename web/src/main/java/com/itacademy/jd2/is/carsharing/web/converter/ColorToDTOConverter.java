package com.itacademy.jd2.is.carsharing.web.converter;

import java.util.function.Function;

import org.springframework.stereotype.Component;

import com.itacademy.jd2.is.carsharing.dao.api.entity.IColor;
import com.itacademy.jd2.is.carsharing.web.dto.ColorDTO;

@Component
public class ColorToDTOConverter implements Function<IColor, ColorDTO> {

	@Override
	public ColorDTO apply(IColor entity) {
		final ColorDTO dto = new ColorDTO();
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		dto.setCreated(entity.getCreated());
		dto.setUpdated(entity.getUpdated());
		return dto;
	}

}
