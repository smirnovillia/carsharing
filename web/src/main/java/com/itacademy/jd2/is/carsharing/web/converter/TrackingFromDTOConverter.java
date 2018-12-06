package com.itacademy.jd2.is.carsharing.web.converter;

import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.itacademy.jd2.is.carsharing.dao.api.entity.ICar;
import com.itacademy.jd2.is.carsharing.dao.api.entity.ITracking;
import com.itacademy.jd2.is.carsharing.service.ICarService;
import com.itacademy.jd2.is.carsharing.service.ITrackingService;
import com.itacademy.jd2.is.carsharing.web.dto.TrackingDTO;

@Component
public class TrackingFromDTOConverter implements Function<TrackingDTO, ITracking> {

	@Autowired
	private ITrackingService trackingService;
	@Autowired
	private ICarService carService;

	@Override
	public ITracking apply(TrackingDTO dto) {
		final ITracking entity = trackingService.createEntity();
		entity.setId(dto.getId());

		final ICar car = carService.createEntity();
		car.setId(dto.getCarId());
		entity.setCar(car);

		entity.setLatitude(dto.getLatitude());
		entity.setLongitude(dto.getLongitude());

		return entity;
	}

}
