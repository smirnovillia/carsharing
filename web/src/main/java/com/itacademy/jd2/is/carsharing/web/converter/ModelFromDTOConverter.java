package com.itacademy.jd2.is.carsharing.web.converter;

import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.itacademy.jd2.is.carsharing.dao.api.entity.IBrand;
import com.itacademy.jd2.is.carsharing.dao.api.entity.IColor;
import com.itacademy.jd2.is.carsharing.dao.api.entity.IModel;
import com.itacademy.jd2.is.carsharing.service.IBrandService;
import com.itacademy.jd2.is.carsharing.service.IColorService;
import com.itacademy.jd2.is.carsharing.service.IModelService;
import com.itacademy.jd2.is.carsharing.web.dto.ModelDTO;

@Component
public class ModelFromDTOConverter implements Function<ModelDTO, IModel> {

	@Autowired
	private IColorService colorService;
	
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
		
		
		  final Set<Integer> colorIds = dto.getColorIds();
	        if (CollectionUtils.isNotEmpty(colorIds)) {
	            entity.setColors(colorIds.stream().map((id) -> {
	                final IColor color = colorService.createEntity();
	                color.setId(id);
	                return color;
	            }).collect(Collectors.toSet()));
	        }
		return entity;
	}

}
