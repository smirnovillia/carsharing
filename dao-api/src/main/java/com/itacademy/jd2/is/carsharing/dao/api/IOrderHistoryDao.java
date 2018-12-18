package com.itacademy.jd2.is.carsharing.dao.api;

import java.util.List;

import com.itacademy.jd2.is.carsharing.dao.api.entity.IOrderHistory;
import com.itacademy.jd2.is.carsharing.dao.api.filter.OrderHistoryFilter;

public interface IOrderHistoryDao extends IBaseDao<IOrderHistory, Integer>{

	IOrderHistory getFullInfo(Integer id);

	List<IOrderHistory> find(OrderHistoryFilter filter);

	long getCount(OrderHistoryFilter filter);

}
