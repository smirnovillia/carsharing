package com.itacademy.jd2.is.carsharing.dao.jdbc.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.itacademy.jd2.is.carsharing.dao.api.IUserAccountDao;
import com.itacademy.jd2.is.carsharing.dao.api.entity.IUserAccount;

public class UserAccountDaoImpl extends AbstractDaoImpl<IUserAccount, Integer> implements IUserAccountDao{

	@Override
	public IUserAccount createEntity() {
		return null;
	}

	@Override
	public void update(IUserAccount entity) {
		
	}

	@Override
	public void insert(IUserAccount entity) {
		
	}

	@Override
	protected IUserAccount parseRow(ResultSet resultSet) throws SQLException {
		return super.parseRow(resultSet);
	}

	@Override
	protected String getTableName() {
		return null;
	}

}
