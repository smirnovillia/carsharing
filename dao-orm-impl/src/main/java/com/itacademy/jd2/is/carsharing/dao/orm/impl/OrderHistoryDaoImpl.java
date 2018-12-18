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

import com.itacademy.jd2.is.carsharing.dao.api.IOrderHistoryDao;
import com.itacademy.jd2.is.carsharing.dao.api.entity.ICar;
import com.itacademy.jd2.is.carsharing.dao.api.entity.IOrderHistory;
import com.itacademy.jd2.is.carsharing.dao.api.filter.OrderHistoryFilter;
import com.itacademy.jd2.is.carsharing.dao.orm.impl.entity.Car;
import com.itacademy.jd2.is.carsharing.dao.orm.impl.entity.Car_;
import com.itacademy.jd2.is.carsharing.dao.orm.impl.entity.Customer_;
import com.itacademy.jd2.is.carsharing.dao.orm.impl.entity.Modification_;
import com.itacademy.jd2.is.carsharing.dao.orm.impl.entity.OrderHistory;
import com.itacademy.jd2.is.carsharing.dao.orm.impl.entity.OrderHistory_;

@Repository
public class OrderHistoryDaoImpl extends AbstractDaoImpl<IOrderHistory, Integer> implements IOrderHistoryDao {

	protected OrderHistoryDaoImpl() {
		super(OrderHistory.class);
	}

	@Override
	public IOrderHistory createEntity() {
		return new OrderHistory();
	}
	
	@Override
	public List<IOrderHistory> find(OrderHistoryFilter filter) {
		final EntityManager em = getEntityManager();
		final CriteriaBuilder cb = em.getCriteriaBuilder();
		final CriteriaQuery<IOrderHistory> cq = cb.createQuery(IOrderHistory.class);
		final Root<OrderHistory> from = cq.from(OrderHistory.class);
		cq.select(from);

		from.fetch(OrderHistory_.car, JoinType.LEFT);
		from.fetch(OrderHistory_.customer, JoinType.LEFT);

		applyFilter(filter, cb, cq, from);

		if (filter.getSortColumn() != null) {
			final Path<?> expression = getSortPath(from, filter.getSortColumn());
			cq.orderBy(new OrderImpl(expression, filter.getSortOrder()));
		}

		final TypedQuery<IOrderHistory> q = em.createQuery(cq);
		setPaging(filter, q);
		return q.getResultList();
	}

	private void applyFilter(final OrderHistoryFilter filter, final CriteriaBuilder cb, final CriteriaQuery<?> cq,
			final Root<OrderHistory> from) {
		final List<Predicate> ands = new ArrayList<>();

		if (!ands.isEmpty()) {
			cq.where(cb.and(ands.toArray(new Predicate[0])));
		}
	}

	private Path<?> getSortPath(final Root<OrderHistory> from, final String sortColumn) {
		switch (sortColumn) {
		case "created":
			return from.get(OrderHistory_.created);
		case "updated":
			return from.get(OrderHistory_.updated);
		case "id":
			return from.get(OrderHistory_.id);
		case "car":
			return from.join(OrderHistory_.car, JoinType.LEFT).get(Car_.id);
		case "customer":
			return from.join(OrderHistory_.customer, JoinType.LEFT).get(Customer_.id);
		default:
			throw new UnsupportedOperationException("sorting is not supported by column:" + sortColumn);
		}
	}

	@Override
	public long getCount(OrderHistoryFilter filter) {
		final EntityManager em = getEntityManager();
		final CriteriaBuilder cb = em.getCriteriaBuilder();
		final CriteriaQuery<Long> cq = cb.createQuery(Long.class);
		final Root<OrderHistory> from = cq.from(OrderHistory.class);
		cq.select(cb.count(from));
		final TypedQuery<Long> q = em.createQuery(cq);
		return q.getSingleResult();
	}

	@Override
	public IOrderHistory getFullInfo(Integer id) {
		final EntityManager em = getEntityManager();
		final CriteriaBuilder cb = em.getCriteriaBuilder();
		final CriteriaQuery<IOrderHistory> cq = cb.createQuery(IOrderHistory.class);
		final Root<OrderHistory> from = cq.from(OrderHistory.class);
		cq.select(from);

		from.fetch(OrderHistory_.car, JoinType.LEFT);
		from.fetch(OrderHistory_.customer, JoinType.LEFT);

		cq.where(cb.equal(from.get(Car_.id), id));

		return em.createQuery(cq).getSingleResult();
	}

	

}
