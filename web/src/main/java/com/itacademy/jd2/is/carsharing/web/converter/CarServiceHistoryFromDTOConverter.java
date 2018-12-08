package com.itacademy.jd2.is.carsharing.web.converter;

import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.itacademy.jd2.is.carsharing.dao.api.entity.ICar;
import com.itacademy.jd2.is.carsharing.dao.api.entity.ICarServiceHistory;
import com.itacademy.jd2.is.carsharing.service.ICarService;
import com.itacademy.jd2.is.carsharing.service.ICarServiceHistoryService;
import com.itacademy.jd2.is.carsharing.web.dto.CarServiceHistoryDTO;

@Component
public class CarServiceHistoryFromDTOConverter implements Function<CarServiceHistoryDTO, ICarServiceHistory> {

	@Autowired
	private ICarServiceHistoryService carServiceHistoryService;
	@Autowired
	private ICarService carService;
	
	@Override
	public ICarServiceHistory apply(CarServiceHistoryDTO dto) {
		final ICarServiceHistory entity = carServiceHistoryService.createEntity();
		entity.setId(dto.getId());
		
		final ICar car = carService.createEntity();
		car.setId(dto.getCarId());
		entity.setCar(car);
		
		entity.setServiceDate(dto.getServiceDate());
		entity.setCarMileage(dto.getCarMileage());
		entity.setServiceCompany(dto.getServiceCompany());
		entity.setServicePrice(dto.getServicePrice());
		return entity;
	}
	
	
	
}
