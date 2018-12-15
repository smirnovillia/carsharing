package com.itacademy.jd2.is.carsharing.web.converter;

import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.itacademy.jd2.is.carsharing.dao.api.entity.IBrand;
import com.itacademy.jd2.is.carsharing.dao.api.entity.IModel;
import com.itacademy.jd2.is.carsharing.service.IBrandService;
import com.itacademy.jd2.is.carsharing.service.IModelService;
import com.itacademy.jd2.is.carsharing.web.dto.ModelDTO;

@Component
public class ModelFromDTOConverter implements Function<ModelDTO, IModel> {

	@Autowired
	private IModelService modelService;

	@Autowired
	private IBrandService brandService;

	@Override
	public IModel apply(ModelDTO dto) {
		final IModel entity = modelService.createEntity();
		entity.setId(dto.getId());
		entity.setName(dto.getName());

		final IBrand brand = brandService.createEntity();
		brand.setId(dto.getBrandId());
		entity.setBrand(brand);
		return entity;
	}

}
