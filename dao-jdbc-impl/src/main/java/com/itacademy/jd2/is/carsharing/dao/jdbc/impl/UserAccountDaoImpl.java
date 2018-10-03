package com.itacademy.jd2.is.carsharing.dao.jdbc.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.itacademy.jd2.is.carsharing.dao.api.IUserAccountDao;
import com.itacademy.jd2.is.carsharing.dao.api.entity.IUserAccount;
import com.itacademy.jd2.is.carsharing.dao.jdbc.impl.entity.UserAccount;
import com.itacademy.jd2.is.carsharing.dao.jdbc.impl.util.PreparedStatementAction;

public class UserAccountDaoImpl extends AbstractDaoImpl<IUserAccount, Integer> implements IUserAccountDao {

	@Override
	public IUserAccount createEntity() {
		return new UserAccount();
	}

	@Override
	public void update(IUserAccount entity) {
		executeStatement(new PreparedStatementAction<IUserAccount>(
				String.format("update %s set login=?, password=?, role_id=?, updated=? where id=?", getTableName())) {

			@Override
			public IUserAccount doWithPreparedStatement(PreparedStatement pStmt) throws SQLException {
				
				return null;
			}
		});
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
		return "user_account";
	}

}
