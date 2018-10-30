package com.itacademy.jd2.is.carsharing.dao.orm.impl;

import org.springframework.stereotype.Repository;

import com.itacademy.jd2.is.carsharing.dao.api.IServiceOperationDao;
import com.itacademy.jd2.is.carsharing.dao.api.entity.IServiceOperation;
import com.itacademy.jd2.is.carsharing.dao.orm.impl.entity.ServiceOperation;

@Repository
public class ServiceOperationDaoImpl extends AbstractDaoImpl<IServiceOperation, Integer>
		implements IServiceOperationDao {

	
	
	protected ServiceOperationDaoImpl() {
		super(ServiceOperation.class);
	}

	@Override
	public IServiceOperation createEntity() {
		return new ServiceOperation();
	}

	
}
