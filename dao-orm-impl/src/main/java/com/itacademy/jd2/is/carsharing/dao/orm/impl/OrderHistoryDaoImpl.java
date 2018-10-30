package com.itacademy.jd2.is.carsharing.dao.orm.impl;

import org.springframework.stereotype.Repository;

import com.itacademy.jd2.is.carsharing.dao.api.IOrderHistoryDao;
import com.itacademy.jd2.is.carsharing.dao.api.entity.IOrderHistory;
import com.itacademy.jd2.is.carsharing.dao.orm.impl.entity.OrderHistory;

@Repository
public class OrderHistoryDaoImpl extends AbstractDaoImpl<IOrderHistory, Integer> implements IOrderHistoryDao {

	protected OrderHistoryDaoImpl() {
		super(OrderHistory.class);
	}

	@Override
	public IOrderHistory createEntity() {
		return new OrderHistory();
	}

	

}
