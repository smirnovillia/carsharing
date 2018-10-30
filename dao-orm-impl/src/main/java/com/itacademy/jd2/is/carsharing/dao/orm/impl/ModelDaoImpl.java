package com.itacademy.jd2.is.carsharing.dao.orm.impl;

import org.springframework.stereotype.Repository;

import com.itacademy.jd2.is.carsharing.dao.api.IModelDao;
import com.itacademy.jd2.is.carsharing.dao.api.entity.IModel;
import com.itacademy.jd2.is.carsharing.dao.orm.impl.entity.Model;

@Repository
public class ModelDaoImpl extends AbstractDaoImpl<IModel, Integer> implements IModelDao {

	protected ModelDaoImpl() {
		super(Model.class);
	}

	@Override
	public IModel createEntity() {
		return new Model();
	}

	

}
