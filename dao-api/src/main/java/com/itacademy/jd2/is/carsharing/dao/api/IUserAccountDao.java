package com.itacademy.jd2.is.carsharing.dao.api;

import java.util.List;

import com.itacademy.jd2.is.carsharing.dao.api.entity.IUserAccount;
import com.itacademy.jd2.is.carsharing.dao.api.filter.UserAccountFilter;

public interface IUserAccountDao extends IBaseDao<IUserAccount, Integer>{
	

	List<IUserAccount> find(UserAccountFilter filter);

	long getCount(UserAccountFilter filter);

}
