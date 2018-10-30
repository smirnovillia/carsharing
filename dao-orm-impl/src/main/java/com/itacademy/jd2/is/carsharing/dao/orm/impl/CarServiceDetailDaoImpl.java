package com.itacademy.jd2.is.carsharing.dao.orm.impl;

import org.springframework.stereotype.Repository;

import com.itacademy.jd2.is.carsharing.dao.api.ICarServiceDetailDao;
import com.itacademy.jd2.is.carsharing.dao.api.entity.ICarServiceDetail;
import com.itacademy.jd2.is.carsharing.dao.orm.impl.entity.CarServiceDetail;

@Repository
public class CarServiceDetailDaoImpl extends AbstractDaoImpl<ICarServiceDetail, Integer> implements ICarServiceDetailDao {

	protected CarServiceDetailDaoImpl() {
		super(CarServiceDetail.class);
	}
	
	@Override
	public ICarServiceDetail createEntity() {
		return new CarServiceDetail();
	}


}
