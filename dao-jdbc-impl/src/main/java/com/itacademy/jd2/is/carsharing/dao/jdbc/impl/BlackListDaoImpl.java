package com.itacademy.jd2.is.carsharing.dao.jdbc.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.springframework.stereotype.Repository;

import com.itacademy.jd2.is.carsharing.dao.api.IBlackListDao;
import com.itacademy.jd2.is.carsharing.dao.api.entity.IBlackList;
import com.itacademy.jd2.is.carsharing.dao.api.entity.ICustomer;
import com.itacademy.jd2.is.carsharing.dao.jdbc.impl.entity.BlackList;
import com.itacademy.jd2.is.carsharing.dao.jdbc.impl.entity.Customer;
import com.itacademy.jd2.is.carsharing.dao.jdbc.impl.util.PreparedStatementAction;

@Repository
public class BlackListDaoImpl extends AbstractDaoImpl<IBlackList, Integer> implements IBlackListDao {

	@Override
	public IBlackList createEntity() {
		return new BlackList();
	}

	@Override
	public void insert(final IBlackList entity) {
		executeStatement(new PreparedStatementAction<IBlackList>(
				String.format("insert into %s (customer_id, reason, created, updated) values(?,?,?,?)", getTableName()),
				true) {
			
			@Override
			public IBlackList doWithPreparedStatement(final PreparedStatement pStmt) throws SQLException {
				pStmt.setInt(1, entity.getCustomer().getId());
				pStmt.setString(2, entity.getReason());
				pStmt.setObject(3, entity.getCreated(), Types.TIMESTAMP);
				pStmt.setObject(4, entity.getUpdated(), Types.TIMESTAMP);

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
	public void update(final IBlackList entity) {
		executeStatement(new PreparedStatementAction<IBlackList>(
				String.format("update %s set customer_id=?, reason=?, updated=? where id=?", getTableName())) {
			
			@Override
			public IBlackList doWithPreparedStatement(final PreparedStatement pStmt) throws SQLException {
				pStmt.setInt(1, entity.getCustomer().getId());
				pStmt.setString(2, entity.getReason());
				pStmt.setObject(2, entity.getUpdated(), Types.TIMESTAMP);
				pStmt.setInt(3, entity.getId());

				pStmt.executeUpdate();
				return entity;
			}
		});
	}

	@Override
	protected String getTableName() {
		return "black_list";
	}

	@Override
	protected IBlackList parseRow(final ResultSet resultSet) throws SQLException {
		final IBlackList entity = createEntity();
		entity.setId((Integer) resultSet.getObject("id"));
		entity.setReason(resultSet.getString("reason"));
		entity.setCreated(resultSet.getTimestamp("created"));
		entity.setUpdated(resultSet.getTimestamp("updated"));
		
		final ICustomer customer = new Customer();
		customer.setId((Integer) resultSet.getObject("customer_id"));
		entity.setCustomer(customer);
		return entity;
	}

}
