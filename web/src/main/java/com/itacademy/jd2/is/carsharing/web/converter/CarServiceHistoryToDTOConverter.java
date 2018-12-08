package com.itacademy.jd2.is.carsharing.web.converter;

import java.util.function.Function;

import org.springframework.stereotype.Component;

import com.itacademy.jd2.is.carsharing.dao.api.entity.ICar;
import com.itacademy.jd2.is.carsharing.dao.api.entity.ICarServiceHistory;
import com.itacademy.jd2.is.carsharing.web.dto.CarServiceHistoryDTO;

@Component
public class CarServiceHistoryToDTOConverter implements Function<ICarServiceHistory, CarServiceHistoryDTO>{

	@Override
	public CarServiceHistoryDTO apply(ICarServiceHistory entity) {
		final CarServiceHistoryDTO dto = new CarServiceHistoryDTO();
		dto.setId(entity.getId());
		
		final ICar car = entity.getCar();
		dto.setCarId(car.getId());
		
		dto.setServiceDate(entity.getServiceDate());
		dto.setCarMileage(entity.getCarMileage());
		dto.setServiceCompany(entity.getServiceCompany());
		dto.setServicePrice(entity.getServicePrice());
		dto.setCreated(entity.getCreated());
		dto.setUpdated(entity.getUpdated());
		
		return dto;
	}

}
