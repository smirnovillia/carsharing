package com.itacademy.jd2.is.carsharing.dao.jdbc.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import com.itacademy.jd2.is.carsharing.dao.api.IModificationDao;
import com.itacademy.jd2.is.carsharing.dao.api.entity.IModification;
import com.itacademy.jd2.is.carsharing.dao.api.mod.Body;
import com.itacademy.jd2.is.carsharing.dao.api.mod.Drive;
import com.itacademy.jd2.is.carsharing.dao.api.mod.Fuel;
import com.itacademy.jd2.is.carsharing.dao.api.mod.Gearbox;
import com.itacademy.jd2.is.carsharing.dao.jdbc.impl.entity.Modification;
import com.itacademy.jd2.is.carsharing.dao.jdbc.impl.util.PreparedStatementAction;

public class ModificationDaoImpl extends AbstractDaoImpl<IModification, Integer> implements IModificationDao {

	@Override
	public IModification createEntity() {
		return new Modification();
	}

	@Override
	public void update(IModification entity) {
		executeStatement(new PreparedStatementAction<IModification>(String.format(
				"update %s set body=?, fuel=?, engine_capacity=?, drive=?, gearbox=?, tank_capacity=?, updated=? where id=?",
				getTableName())) {

			@Override
			public IModification doWithPreparedStatement(PreparedStatement pStmt) throws SQLException {
				pStmt.setString(1, entity.getBody().toString());
				pStmt.setString(2, entity.getFuel().toString());
				pStmt.setInt(3, entity.getEngineCapacity());
				pStmt.setString(4, entity.getDrive().toString());
				pStmt.setString(5, entity.getGearbox().toString());
				pStmt.setInt(6, entity.getTankCapacity());
				pStmt.setObject(7, entity.getUpdated(), Types.TIMESTAMP);

				pStmt.executeUpdate();
				return entity;
			}
		});

	}

	@Override
	public void insert(IModification entity) {
		executeStatement(new PreparedStatementAction<IModification>(String.format(
				"insert into %s (body, fuel, engine_capacity, drive, gearbox, tank_capacity, created, updated) values (?,?,?,?,?,?,?,?)",
				getTableName(), true)) {

			@Override
			public IModification doWithPreparedStatement(PreparedStatement pStmt) throws SQLException {
				pStmt.setString(1, entity.getBody().toString());
				pStmt.setString(2, entity.getFuel().toString());
				pStmt.setInt(3, entity.getEngineCapacity());
				pStmt.setString(4, entity.getDrive().toString());
				pStmt.setString(5, entity.getGearbox().toString());
				pStmt.setInt(6, entity.getTankCapacity());
				pStmt.setObject(7, entity.getCreated(), Types.TIMESTAMP);
				pStmt.setObject(8, entity.getUpdated(), Types.TIMESTAMP);

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
	protected IModification parseRow(ResultSet resultSet) throws SQLException {
		final IModification entity = new Modification();
		entity.setId((Integer) resultSet.getObject("id"));
		entity.setBody(Body.valueOf(resultSet.getString("body")));
		entity.setFuel(Fuel.valueOf(resultSet.getString("fuel")));
		entity.setEngineCapacity(resultSet.getInt("engine_capacity"));
		entity.setDrive(Drive.valueOf(resultSet.getString("drive")));
		entity.setGearbox(Gearbox.valueOf(resultSet.getString("gearbox")));
		entity.setTankCapacity(resultSet.getInt("tank_capacity"));
		entity.setCreated(resultSet.getTimestamp("created"));
		entity.setUpdated(resultSet.getTimestamp("updated"));

		return entity;
	}

	@Override
	protected String getTableName() {
		return "modification";
	}

}
