package com.itacademy.jd2.is.carsharing.dao.orm.impl;

import org.springframework.stereotype.Repository;

import com.itacademy.jd2.is.carsharing.dao.api.ICarServiceHistoryDao;
import com.itacademy.jd2.is.carsharing.dao.api.entity.ICarServiceHistory;
import com.itacademy.jd2.is.carsharing.dao.orm.impl.entity.CarServiceHistory;

@Repository
public class CarServiceHistoryDaoImpl extends AbstractDaoImpl<ICarServiceHistory, Integer>
		implements ICarServiceHistoryDao {

	protected CarServiceHistoryDaoImpl() {
		super(CarServiceHistory.class);
	}

	@Override
	public ICarServiceHistory createEntity() {
		return new CarServiceHistory();
	}

	
}
