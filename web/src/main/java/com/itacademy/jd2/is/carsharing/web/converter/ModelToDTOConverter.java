package com.itacademy.jd2.is.carsharing.web.converter;

import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.itacademy.jd2.is.carsharing.dao.api.entity.IBrand;
import com.itacademy.jd2.is.carsharing.dao.api.entity.IColor;
import com.itacademy.jd2.is.carsharing.dao.api.entity.IModel;
import com.itacademy.jd2.is.carsharing.web.dto.ModelDTO;

@Component
public class ModelToDTOConverter implements Function<IModel, ModelDTO> {

	private static final Logger LOGGER = LoggerFactory.getLogger(ModelToDTOConverter.class);

	@Override
	public ModelDTO apply(IModel entity) {
		final ModelDTO dto = new ModelDTO();
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		dto.setCreated(entity.getCreated());
		dto.setUpdated(entity.getUpdated());

		final IBrand brand = entity.getBrand();
		if (brand != null) {
			dto.setBrandId(brand.getId());
			dto.setBrandName(brand.getName());
		}

		try {
			final Set<IColor> colors = entity.getColors();
			if (colors != null) {
				dto.setColorIds(colors.stream().map(IColor::getId).collect(Collectors.toSet()));
			}
		} catch (final Exception e) {
			LOGGER.warn("ignore conversion of 'colors' collection because of:" + e.getMessage());
		}

		return dto;
	}

}
