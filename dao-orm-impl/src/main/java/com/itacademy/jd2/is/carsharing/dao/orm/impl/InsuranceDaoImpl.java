package com.itacademy.jd2.is.carsharing.dao.orm.impl;

import org.springframework.stereotype.Repository;

import com.itacademy.jd2.is.carsharing.dao.api.IInsuranceDao;
import com.itacademy.jd2.is.carsharing.dao.api.entity.IInsurance;
import com.itacademy.jd2.is.carsharing.dao.orm.impl.entity.Insurance;

@Repository
public class InsuranceDaoImpl extends AbstractDaoImpl<IInsurance, Integer> implements IInsuranceDao {
	
	protected InsuranceDaoImpl() {
		super(Insurance.class);
	}

	@Override
	public IInsurance createEntity() {
		return new Insurance();
	}

	
}
