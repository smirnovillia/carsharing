package com.itacademy.jd2.is.carsharing.dao.jdbc.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import com.itacademy.jd2.is.carsharing.dao.api.ICarServiceDetailDao;
import com.itacademy.jd2.is.carsharing.dao.api.entity.ICarServiceDetail;
import com.itacademy.jd2.is.carsharing.dao.api.entity.ICarServiceHistory;
import com.itacademy.jd2.is.carsharing.dao.api.entity.IServiceOperation;
import com.itacademy.jd2.is.carsharing.dao.jdbc.impl.entity.CarServiceDetail;
import com.itacademy.jd2.is.carsharing.dao.jdbc.impl.entity.CarServiceHistory;
import com.itacademy.jd2.is.carsharing.dao.jdbc.impl.entity.ServiceOperation;
import com.itacademy.jd2.is.carsharing.dao.jdbc.impl.util.PreparedStatementAction;

public class CarServiceDetailDaoImpl extends AbstractDaoImpl<ICarServiceDetail, Integer>
		implements ICarServiceDetailDao {

	@Override
	public ICarServiceDetail createEntity() {
		return new CarServiceDetail();
	}

	@Override
	public void update(ICarServiceDetail entity) {
		executeStatement(new PreparedStatementAction<ICarServiceDetail>(
				String.format("update %s set car_service_history_id=?, service_operation_id=?, updated=? where id=?",
						getTableName())) {

			@Override
			public ICarServiceDetail doWithPreparedStatement(final PreparedStatement pStmt) throws SQLException {
				pStmt.setInt(1, entity.getCarServiceHistory().getId());
				pStmt.setInt(2, entity.getServiceOperation().getId());
				pStmt.setObject(3, entity.getUpdated(), Types.TIMESTAMP);
				pStmt.setInt(4, entity.getId());

				pStmt.executeUpdate();
				return entity;
			}
		});
	}

	@Override
	public void insert(ICarServiceDetail entity) {
		executeStatement(new PreparedStatementAction<ICarServiceDetail>(String.format(
				"insert into %s (car_service_history_id, service_operation_id, created, updated) values(?,?,?,?)",
				getTableName()), true) {

			@Override
			public ICarServiceDetail doWithPreparedStatement(final PreparedStatement pStmt) throws SQLException {
				pStmt.setInt(1, entity.getCarServiceHistory().getId());
				pStmt.setInt(2, entity.getServiceOperation().getId());
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
	protected String getTableName() {
		return "car_service_detail";
	}

	@Override
	protected ICarServiceDetail parseRow(final ResultSet resultSet) throws SQLException {
		final ICarServiceDetail entity = createEntity();
		entity.setId((Integer) resultSet.getObject("id"));
		entity.setCreated(resultSet.getTimestamp("created"));
		entity.setUpdated(resultSet.getTimestamp("updated"));

		final ICarServiceHistory carServiceHistory = new CarServiceHistory();
		carServiceHistory.setId((Integer) resultSet.getObject("car_service_history_id"));
		entity.setCarServiceHistory(carServiceHistory);

		final IServiceOperation serviceOperation = new ServiceOperation();
		serviceOperation.setId((Integer) resultSet.getObject("service_operation_id"));
		entity.setServiceOperation(serviceOperation);

		return entity;
	}

}
