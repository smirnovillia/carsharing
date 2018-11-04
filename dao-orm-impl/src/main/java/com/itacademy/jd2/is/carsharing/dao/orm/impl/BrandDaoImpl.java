package com.itacademy.jd2.is.carsharing.dao.orm.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.SingularAttribute;

import org.hibernate.jpa.criteria.OrderImpl;
import org.springframework.stereotype.Repository;

import com.itacademy.jd2.is.carsharing.dao.api.IBrandDao;
import com.itacademy.jd2.is.carsharing.dao.api.entity.IBrand;
import com.itacademy.jd2.is.carsharing.dao.api.filter.BrandFilter;
import com.itacademy.jd2.is.carsharing.dao.orm.impl.entity.Brand;
import com.itacademy.jd2.is.carsharing.dao.orm.impl.entity.Brand_;

@Repository
public class BrandDaoImpl extends AbstractDaoImpl<IBrand, Integer> implements IBrandDao {

	protected BrandDaoImpl() {
		super(Brand.class);
	}

	@Override
	public IBrand createEntity() {
		return new Brand();
	}

	@Override
	public List<IBrand> find(BrandFilter filter) {
		final EntityManager em = getEntityManager();
		final CriteriaBuilder cb = em.getCriteriaBuilder();
		final CriteriaQuery<IBrand> cq = cb.createQuery(IBrand.class); 
		final Root<Brand> from = cq.from(Brand.class);
		cq.select(from);

		if (filter.getSortColumn() != null) {
			final SingularAttribute<? super Brand, ?> sortProperty = toMetamodelFormat(filter.getSortColumn());
			final Path<?> expression = from.get(sortProperty); 
			cq.orderBy(new OrderImpl(expression, filter.getSortOrder())); 
		}

		final TypedQuery<IBrand> q = em.createQuery(cq);
		setPaging(filter, q);
		return q.getResultList();
	}

	@Override
	public long getCount(BrandFilter filter) {
		final EntityManager em = getEntityManager();
		final CriteriaBuilder cb = em.getCriteriaBuilder();
		final CriteriaQuery<Long> cq = cb.createQuery(Long.class); 
		final Root<Brand> from = cq.from(Brand.class); 
		cq.select(cb.count(from)); 
		final TypedQuery<Long> q = em.createQuery(cq);
		return q.getSingleResult(); 
	}

	private SingularAttribute<? super Brand, ?> toMetamodelFormat(final String sortColumn) {
		switch (sortColumn) {
		case "created":
			return Brand_.created;
		case "updated":
			return Brand_.updated;
		case "id":
			return Brand_.id;
		case "name":
			return Brand_.name;
		default:
			throw new UnsupportedOperationException("sorting is not supported by column:" + sortColumn);
		}
	}

}
