package com.itacademy.jd2.is.carsharing.dao.api;

import java.util.List;

import com.itacademy.jd2.is.carsharing.dao.api.entity.ICustomer;
import com.itacademy.jd2.is.carsharing.dao.api.filter.CustomerFilter;

public interface ICustomerDao extends IBaseDao<ICustomer, Integer>{

	List<ICustomer> find(CustomerFilter filter);

	long getCount(CustomerFilter filter);

}
