package com.itacademy.jd2.is.carsharing.web.converter;

import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.itacademy.jd2.is.carsharing.dao.api.entity.IColor;
import com.itacademy.jd2.is.carsharing.service.IColorService;
import com.itacademy.jd2.is.carsharing.web.dto.ColorDTO;

@Component
public class ColorFromDTOConverter implements Function<ColorDTO, IColor> {

	@Autowired
	private IColorService colorService;

	@Override
	public IColor apply(ColorDTO dto) {
		final IColor entity = colorService.createEntity();
		entity.setId(dto.getId());
		entity.setName(dto.getName());
		return entity;
	}

}
