package com.itacademy.jd2.is.carsharing.web.converter;

import java.util.function.Function;

import org.springframework.stereotype.Component;

import com.itacademy.jd2.is.carsharing.dao.api.entity.IBrand;
import com.itacademy.jd2.is.carsharing.dao.api.entity.IModel;
import com.itacademy.jd2.is.carsharing.web.dto.ModelDTO;

@Component
public class ModelToDTOConverter implements Function<IModel, ModelDTO> {

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

		return dto;
	}

}
