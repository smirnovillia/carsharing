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

import com.itacademy.jd2.is.carsharing.dao.api.IModelDao;
import com.itacademy.jd2.is.carsharing.dao.api.entity.IModel;
import com.itacademy.jd2.is.carsharing.dao.api.filter.ModelFilter;
import com.itacademy.jd2.is.carsharing.dao.orm.impl.entity.Brand_;
import com.itacademy.jd2.is.carsharing.dao.orm.impl.entity.Model;
import com.itacademy.jd2.is.carsharing.dao.orm.impl.entity.Model_;

@Repository
public class ModelDaoImpl extends AbstractDaoImpl<IModel, Integer> implements IModelDao {

	protected ModelDaoImpl() {
		super(Model.class);
	}

	@Override
	public IModel createEntity() {
		return new Model();
	}

	@Override
	public List<IModel> find(ModelFilter filter) {
		final EntityManager em = getEntityManager();
		final CriteriaBuilder cb = em.getCriteriaBuilder();
		final CriteriaQuery<IModel> cq = cb.createQuery(IModel.class);
		final Root<Model> from = cq.from(Model.class);
		cq.select(from);

		from.fetch(Model_.brand, JoinType.LEFT);

		applyFilter(filter, cb, cq, from);

		if (filter.getSortColumn() != null) {
			final Path<?> expression = getSortPath(from, filter.getSortColumn());
			cq.orderBy(new OrderImpl(expression, filter.getSortOrder()));
		}

		final TypedQuery<IModel> q = em.createQuery(cq);
		setPaging(filter, q);
		return q.getResultList();
	}

	private void applyFilter(final ModelFilter filter, final CriteriaBuilder cb, final CriteriaQuery<?> cq,
			final Root<Model> from) {
		final List<Predicate> ands = new ArrayList<>();

		if (!ands.isEmpty()) {
			cq.where(cb.and(ands.toArray(new Predicate[0])));
		}
	}

	@Override
	public long getCount(ModelFilter filter) {
		final EntityManager em = getEntityManager();
		final CriteriaBuilder cb = em.getCriteriaBuilder();
		final CriteriaQuery<Long> cq = cb.createQuery(Long.class);
		final Root<Model> from = cq.from(Model.class);
		cq.select(cb.count(from));
		final TypedQuery<Long> q = em.createQuery(cq);
		return q.getSingleResult();
	}

	private Path<?> getSortPath(final Root<Model> from, final String sortColumn) {
		switch (sortColumn) {
		case "created":
			return from.get(Model_.created);
		case "updated":
			return from.get(Model_.updated);
		case "id":
			return from.get(Model_.id);
		case "name":
			return from.get(Model_.name);
		case "brand":
			return from.get(Model_.brand).get(Brand_.name);
		default:
			throw new UnsupportedOperationException("sorting is not supported by column:" + sortColumn);
		}
	}

}
