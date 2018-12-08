package com.itacademy.jd2.is.carsharing.web.converter;

import java.util.function.Function;

import org.springframework.stereotype.Component;

import com.itacademy.jd2.is.carsharing.dao.api.entity.ICar;
import com.itacademy.jd2.is.carsharing.dao.api.entity.ICustomer;
import com.itacademy.jd2.is.carsharing.dao.api.entity.IOrderHistory;
import com.itacademy.jd2.is.carsharing.web.dto.OrderHistoryDTO;

@Component
public class OrderHistoryToDTOConverter implements Function<IOrderHistory, OrderHistoryDTO>{

	@Override
	public OrderHistoryDTO apply(IOrderHistory entity) {
		final OrderHistoryDTO dto = new OrderHistoryDTO();
		
		dto.setId(entity.getId());
		
		final ICar car = entity.getCar();
		dto.setCarId(car.getId());
		
		final ICustomer customer = entity.getCustomer();
		dto.setCustomerId(customer.getId());
		
		dto.setOrderDate(entity.getOrderDate());
		dto.setOrderMileage(entity.getOrderMileage());
		dto.setRate(entity.getRate());
		dto.setPrice(entity.getPrice());
		dto.setCreated(entity.getCreated());
		dto.setUpdated(entity.getUpdated());
		return dto;
	}

	
}
