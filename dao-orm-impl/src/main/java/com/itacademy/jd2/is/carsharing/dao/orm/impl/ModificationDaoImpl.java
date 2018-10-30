package com.itacademy.jd2.is.carsharing.dao.orm.impl;

import org.springframework.stereotype.Repository;

import com.itacademy.jd2.is.carsharing.dao.api.IModificationDao;
import com.itacademy.jd2.is.carsharing.dao.api.entity.IModification;
import com.itacademy.jd2.is.carsharing.dao.orm.impl.entity.Modification;

@Repository
public class ModificationDaoImpl extends AbstractDaoImpl<IModification, Integer> implements IModificationDao {
	
	protected ModificationDaoImpl() {
		super(Modification.class);
	}

	@Override
	public IModification createEntity() {
		return new Modification();
	}

	

}
