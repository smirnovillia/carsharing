package com.itacademy.jd2.is.carsharing.dao.api;

import java.util.List;

import com.itacademy.jd2.is.carsharing.dao.api.entity.IColor;
import com.itacademy.jd2.is.carsharing.dao.api.filter.ColorFilter;

public interface IColorDao extends IBaseDao<IColor, Integer> {

	List<IColor> find(ColorFilter filter);

	long getCount(ColorFilter filter);

}
