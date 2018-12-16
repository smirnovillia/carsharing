package com.itacademy.jd2.is.carsharing.dao.orm.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.jpa.criteria.OrderImpl;
import org.springframework.stereotype.Repository;

import com.itacademy.jd2.is.carsharing.dao.api.ICarDao;
import com.itacademy.jd2.is.carsharing.dao.api.entity.ICar;
import com.itacademy.jd2.is.carsharing.dao.api.filter.CarFilter;
import com.itacademy.jd2.is.carsharing.dao.orm.impl.entity.Car;
import com.itacademy.jd2.is.carsharing.dao.orm.impl.entity.Car_;
import com.itacademy.jd2.is.carsharing.dao.orm.impl.entity.Color_;
import com.itacademy.jd2.is.carsharing.dao.orm.impl.entity.Model;
import com.itacademy.jd2.is.carsharing.dao.orm.impl.entity.Model_;
import com.itacademy.jd2.is.carsharing.dao.orm.impl.entity.Modification_;

@Repository
public class CarDaoImpl extends AbstractDaoImpl<ICar, Integer> implements ICarDao {

	protected CarDaoImpl() {
		super(Car.class);
	}

	@Override
	public ICar createEntity() {
		return new Car();
	}

	@Override
	public List<ICar> find(CarFilter filter) {
		final EntityManager em = getEntityManager();
		final CriteriaBuilder cb = em.getCriteriaBuilder();
		final CriteriaQuery<ICar> cq = cb.createQuery(ICar.class);
		final Root<Car> from = cq.from(Car.class);
		cq.select(from);

		from.fetch(Car_.color, JoinType.LEFT);
		from.fetch(Car_.modification, JoinType.LEFT).fetch(Modification_.model, JoinType.LEFT);

		applyFilter(filter, cb, cq, from);

		if (filter.getSortColumn() != null) {
			final Path<?> expression = getSortPath(from, filter.getSortColumn());
			cq.orderBy(new OrderImpl(expression, filter.getSortOrder()));
		}

		final TypedQuery<ICar> q = em.createQuery(cq);
		setPaging(filter, q);
		return q.getResultList();
	}

	private void applyFilter(final CarFilter filter, final CriteriaBuilder cb, final CriteriaQuery<?> cq,
			final Root<Car> from) {
		final List<Predicate> ands = new ArrayList<>();

		if (!ands.isEmpty()) {
			cq.where(cb.and(ands.toArray(new Predicate[0])));
		}
	}

	private Path<?> getSortPath(final Root<Car> from, final String sortColumn) {
		switch (sortColumn) {
		case "created":
			return from.get(Car_.created);
		case "updated":
			return from.get(Car_.updated);
		case "id":
			return from.get(Car_.id);
		case "releaseDate":
			return from.get(Car_.releaseDate);
		case "color":
			return from.join(Car_.color, JoinType.LEFT).get(Color_.name);
		case "mileage":
			return from.get(Car_.mileage);
		default:
			throw new UnsupportedOperationException("sorting is not supported by column:" + sortColumn);
		}
	}

	@Override
	public long getCount(CarFilter filter) {
		final EntityManager em = getEntityManager();
		final CriteriaBuilder cb = em.getCriteriaBuilder();
		final CriteriaQuery<Long> cq = cb.createQuery(Long.class);
		final Root<Car> from = cq.from(Car.class);
		cq.select(cb.count(from));
		final TypedQuery<Long> q = em.createQuery(cq);
		return q.getSingleResult();
	}

	@Override
	public ICar getFullInfo(Integer id) {
		final EntityManager em = getEntityManager();
		final CriteriaBuilder cb = em.getCriteriaBuilder();
		final CriteriaQuery<ICar> cq = cb.createQuery(ICar.class);
		final Root<Car> from = cq.from(Car.class);
		cq.select(from);

		from.fetch(Car_.color, JoinType.LEFT);
		from.fetch(Car_.modification, JoinType.LEFT).fetch(Modification_.model, JoinType.LEFT);

		cq.where(cb.equal(from.get(Car_.id), id));

		return em.createQuery(cq).getSingleResult();
	}

}
