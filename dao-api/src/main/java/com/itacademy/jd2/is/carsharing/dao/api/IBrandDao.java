package com.itacademy.jd2.is.carsharing.dao.api;

import java.util.List;

import com.itacademy.jd2.is.carsharing.dao.api.entity.IBrand;
import com.itacademy.jd2.is.carsharing.dao.api.filter.BrandFilter;

public interface IBrandDao extends IBaseDao<IBrand, Integer> {
	
	  List<IBrand> find(BrandFilter filter);

}
