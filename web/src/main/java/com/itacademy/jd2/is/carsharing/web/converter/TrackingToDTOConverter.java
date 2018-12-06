package com.itacademy.jd2.is.carsharing.web.converter;

import java.util.function.Function;

import org.springframework.stereotype.Component;

import com.itacademy.jd2.is.carsharing.dao.api.entity.ICar;
import com.itacademy.jd2.is.carsharing.dao.api.entity.ITracking;
import com.itacademy.jd2.is.carsharing.web.dto.TrackingDTO;

@Component
public class TrackingToDTOConverter implements Function<ITracking, TrackingDTO> {

	@Override
	public TrackingDTO apply(ITracking entity) {
		final TrackingDTO dto = new TrackingDTO();
		dto.setId(entity.getId());

		final ICar car = entity.getCar();
		dto.setCarId(car.getId());

		dto.setLatitude(entity.getLatitude());
		dto.setLongitude(entity.getLongitude());

		dto.setCreated(entity.getCreated());
		dto.setUpdated(entity.getUpdated());

		return dto;
	}

}
