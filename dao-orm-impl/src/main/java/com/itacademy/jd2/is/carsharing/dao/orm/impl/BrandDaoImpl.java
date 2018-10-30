package com.itacademy.jd2.is.carsharing.dao.orm.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.itacademy.jd2.is.carsharing.dao.api.IBrandDao;
import com.itacademy.jd2.is.carsharing.dao.api.entity.IBrand;
import com.itacademy.jd2.is.carsharing.dao.api.filter.BrandFilter;
import com.itacademy.jd2.is.carsharing.dao.orm.impl.entity.Brand;

@Repository
public class BrandDaoImpl extends AbstractDaoImpl<IBrand, Integer> implements IBrandDao {
	
	protected BrandDaoImpl() {
		super(Brand.class);
	}

	@Override
	    public IBrand createEntity() {
	        return new Brand();
	    }

	@Override
	public List<IBrand> find(BrandFilter filter)  {
		throw new RuntimeException("Unimpliment");
	}

	@Override
	public long getCount(BrandFilter filter) {
		throw new RuntimeException("Unimpliment");
	}

}
