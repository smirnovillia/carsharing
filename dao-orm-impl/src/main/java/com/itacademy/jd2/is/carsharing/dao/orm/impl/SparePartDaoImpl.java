package com.itacademy.jd2.is.carsharing.dao.orm.impl;

import org.springframework.stereotype.Repository;

import com.itacademy.jd2.is.carsharing.dao.api.ISparePartDao;
import com.itacademy.jd2.is.carsharing.dao.api.entity.ISparePart;
import com.itacademy.jd2.is.carsharing.dao.orm.impl.entity.SparePart;

@Repository
public class SparePartDaoImpl extends AbstractDaoImpl<ISparePart, Integer> implements ISparePartDao {

	protected SparePartDaoImpl() {
		super(SparePart.class);
	}

	@Override
	public ISparePart createEntity() {
		return new SparePart();
	}

}
