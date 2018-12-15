package com.itacademy.jd2.is.carsharing.web.converter;

import java.util.function.Function;

import org.springframework.stereotype.Component;

import com.itacademy.jd2.is.carsharing.dao.api.entity.IModel;
import com.itacademy.jd2.is.carsharing.web.dto.ModelDTO;

@Component
public class ModelFromDTOConverter implements Function<ModelDTO, IModel> {

	@Override
	public IModel apply(ModelDTO t) {
		// TODO Auto-generated method stub
		return null;
	}

}
