package com.itacademy.jd2.is.carsharing.dao.api;

import java.util.List;

import com.itacademy.jd2.is.carsharing.dao.api.entity.IModification;
import com.itacademy.jd2.is.carsharing.dao.api.filter.ModificationFilter;

public interface IModificationDao extends IBaseDao<IModification, Integer>{

	List<IModification> find(ModificationFilter filter);

}
