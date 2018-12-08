package com.itacademy.jd2.is.carsharing.web.converter;

import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.itacademy.jd2.is.carsharing.dao.api.entity.ICar;
import com.itacademy.jd2.is.carsharing.dao.api.entity.ICustomer;
import com.itacademy.jd2.is.carsharing.dao.api.entity.IOrderHistory;
import com.itacademy.jd2.is.carsharing.service.ICarService;
import com.itacademy.jd2.is.carsharing.service.ICustomerService;
import com.itacademy.jd2.is.carsharing.service.IOrderHistoryService;
import com.itacademy.jd2.is.carsharing.web.dto.OrderHistoryDTO;

@Component
public class OrderHistoryFromDTOConverter implements Function<OrderHistoryDTO, IOrderHistory> {
	
	@Autowired
	private IOrderHistoryService orderHistoryService;
	
	@Autowired
	private ICarService carService;
	
	@Autowired
	private ICustomerService customerService;

	@Override
	public IOrderHistory apply(OrderHistoryDTO dto) {
		final IOrderHistory entity = orderHistoryService.createEntity();
		entity.setId(dto.getId());
		
		final ICar car = carService.createEntity();
		car.setId(dto.getCarId());
		entity.setCar(car);
		
		final ICustomer customer = customerService.createEntity();
		customer.setId(dto.getCustomerId());
		entity.setCustomer(customer);
		
		entity.setOrderDate(dto.getOrderDate());
		entity.setOrderMileage(dto.getOrderMileage());
		entity.setRate(dto.getRate());
		entity.setPrice(dto.getPrice());
		return entity;
	}

	
	
}
