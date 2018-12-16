package com.itacademy.jd2.is.carsharing.dao.api;

import java.util.List;

import com.itacademy.jd2.is.carsharing.dao.api.entity.IModel;
import com.itacademy.jd2.is.carsharing.dao.api.filter.ModelFilter;

public interface IModelDao extends IBaseDao<IModel, Integer> {

	List<IModel> find(ModelFilter filter);

	long getCount(ModelFilter filter);

	IModel getFullInfo(Integer id);

}
