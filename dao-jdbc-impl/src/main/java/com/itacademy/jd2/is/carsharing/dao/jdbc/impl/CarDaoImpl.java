package com.itacademy.jd2.is.carsharing.dao.jdbc.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.itacademy.jd2.is.carsharing.dao.api.ICarDao;
import com.itacademy.jd2.is.carsharing.dao.api.entity.ICar;
import com.itacademy.jd2.is.carsharing.dao.api.entity.IColor;
import com.itacademy.jd2.is.carsharing.dao.api.entity.IModel;
import com.itacademy.jd2.is.carsharing.dao.api.entity.IModification;
import com.itacademy.jd2.is.carsharing.dao.api.enums.Condition;
import com.itacademy.jd2.is.carsharing.dao.api.filter.CarFilter;
import com.itacademy.jd2.is.carsharing.dao.jdbc.impl.entity.Car;
import com.itacademy.jd2.is.carsharing.dao.jdbc.impl.entity.Color;
import com.itacademy.jd2.is.carsharing.dao.jdbc.impl.entity.Model;
import com.itacademy.jd2.is.carsharing.dao.jdbc.impl.entity.Modification;
import com.itacademy.jd2.is.carsharing.dao.jdbc.impl.util.PreparedStatementAction;

@Repository
public class CarDaoImpl extends AbstractDaoImpl<ICar, Integer> implements ICarDao{
	
	@Override
	public ICar createEntity() {
		return new Car();
	}

	@Override
	public void insert(final ICar entity) {
		executeStatement(new PreparedStatementAction<ICar>(
				String.format("insert into %s (model_id, modification_id, release_date, vin, color_id,"
						+ " mileage, condition, created, updated) values(?,?,?,?,?,?,?,?,?)", getTableName()),
				true) {
			
			@Override
			public ICar doWithPreparedStatement(final PreparedStatement pStmt) throws SQLException {
				pStmt.setInt(2, entity.getModification().getId());
				pStmt.setInt(3, entity.getReleaseDate());
				pStmt.setString(4, entity.getVin());
				pStmt.setInt(5, entity.getColor().getId());
				pStmt.setDouble(6, entity.getMileage());
				pStmt.setString(7, entity.getCondition().toString());
				pStmt.setObject(8, entity.getCreated(), Types.TIMESTAMP);
				pStmt.setObject(9, entity.getUpdated(), Types.TIMESTAMP);

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
	public void update(final ICar entity) {
		executeStatement(new PreparedStatementAction<ICar>(
				String.format("update %s set model_id=?, modification_id=?, release_date=?, vin=?, "
						+ "color_id=?, mileage=?, condition=?, updated=? where id=?", getTableName())) {
			
			@Override
			public ICar doWithPreparedStatement(final PreparedStatement pStmt) throws SQLException {
				pStmt.setInt(2, entity.getModification().getId());
				pStmt.setInt(3, entity.getReleaseDate());
				pStmt.setString(4, entity.getVin());
				pStmt.setInt(5, entity.getColor().getId());
				pStmt.setDouble(6, entity.getMileage());
				pStmt.setString(7, entity.getCondition().toString());
				pStmt.setObject(8, entity.getUpdated(), Types.TIMESTAMP);
				pStmt.setInt(9, entity.getId());

				pStmt.executeUpdate();
				return entity;
			}
		});
	}

	@Override
	protected String getTableName() {
		return "car";
	}

	@Override
	protected ICar parseRow(final ResultSet resultSet) throws SQLException {
		final ICar entity = createEntity();
		entity.setId((Integer) resultSet.getObject("id"));
		entity.setReleaseDate(resultSet.getInt("release_date"));
		entity.setVin(resultSet.getString("vin"));
		entity.setMileage(resultSet.getDouble("mileage"));
		entity.setCondition(Condition.valueOf(resultSet.getString("condition")));
		entity.setCreated(resultSet.getTimestamp("created"));
		entity.setUpdated(resultSet.getTimestamp("updated"));
		
		final IModification modification = new Modification();
		modification.setId((Integer) resultSet.getObject("modification_id"));
		entity.setModification(modification);
		
		final IColor color = new Color();
		color.setId((Integer) resultSet.getObject("color_id"));
		entity.setColor(color);

		return entity;
	}

	@Override
	public List<ICar> find(CarFilter filter) {
		final StringBuilder sqlTile = new StringBuilder("");
		appendSort(filter, sqlTile);
		appendPaging(filter, sqlTile);
		return executeFindQuery(sqlTile.toString());
	}

	@Override
	public long getCount(CarFilter filter) {
		return executeCountQuery("");
	}

	@Override
	public ICar getFullInfo(Integer id) {
		throw new RuntimeException("not implemented");
	}

}
