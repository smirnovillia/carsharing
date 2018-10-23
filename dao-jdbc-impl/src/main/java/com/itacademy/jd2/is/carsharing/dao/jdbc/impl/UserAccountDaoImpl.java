package com.itacademy.jd2.is.carsharing.dao.jdbc.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.springframework.stereotype.Repository;

import com.itacademy.jd2.is.carsharing.dao.api.IUserAccountDao;
import com.itacademy.jd2.is.carsharing.dao.api.entity.IUserAccount;
import com.itacademy.jd2.is.carsharing.dao.api.enums.Role;
import com.itacademy.jd2.is.carsharing.dao.jdbc.impl.entity.UserAccount;
import com.itacademy.jd2.is.carsharing.dao.jdbc.impl.util.PreparedStatementAction;

@Repository
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
				pStmt.setString(1, entity.getLogin());
				pStmt.setString(2, entity.getPassword());
				pStmt.setInt(3, entity.getUserRole().ordinal());
				pStmt.setObject(4, entity.getUpdated(), Types.TIMESTAMP);
				pStmt.setInt(5, entity.getId());
				pStmt.executeUpdate();
				return entity;
			}
		});
	}

	@Override
	public void insert(IUserAccount entity) {
		executeStatement(new PreparedStatementAction<IUserAccount>(
				String.format("insert into %s (login, password, role_id, created, updated) values (?,?,?,?,?)",
						getTableName()),
				true) {
			@Override
			public IUserAccount doWithPreparedStatement(PreparedStatement pStmt) throws SQLException {
				pStmt.setString(1, entity.getLogin());
				pStmt.setString(2, entity.getPassword());
				pStmt.setInt(3, entity.getUserRole().ordinal());
				pStmt.setObject(4, entity.getCreated(), Types.TIMESTAMP);
				pStmt.setObject(5, entity.getUpdated(), Types.TIMESTAMP);

				pStmt.executeUpdate();

				final ResultSet rs = pStmt.getGeneratedKeys();
				rs.next();
				final int id = rs.getInt("id");

				rs.close();

				entity.setId(id);
				return entity;
			}
		});
	}

	@Override
	protected IUserAccount parseRow(ResultSet resultSet) throws SQLException {
		final IUserAccount entity = new UserAccount();
		entity.setLogin(resultSet.getString("login"));
		entity.setPassword(resultSet.getString("password"));
		entity.setUserRole(Role.values()[resultSet.getInt("role_id")]);
		entity.setCreated(resultSet.getTimestamp("created"));
		entity.setUpdated(resultSet.getTimestamp("updated"));
		
		return entity;
	}

	@Override
	protected String getTableName() {
		return "user_account";
	}

}
