package com.itacademy.jd2.is.carsharing.dao.orm.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.jpa.criteria.OrderImpl;
import org.springframework.stereotype.Repository;

import com.itacademy.jd2.is.carsharing.dao.api.IColorDao;
import com.itacademy.jd2.is.carsharing.dao.api.entity.IColor;
import com.itacademy.jd2.is.carsharing.dao.api.filter.ColorFilter;
import com.itacademy.jd2.is.carsharing.dao.orm.impl.entity.Color;
import com.itacademy.jd2.is.carsharing.dao.orm.impl.entity.Color_;

@Repository
public class ColorDaoImpl extends AbstractDaoImpl<IColor, Integer> implements IColorDao{

	protected ColorDaoImpl() {
		super(Color.class);
	}

	@Override
	public IColor createEntity() {
		return new Color();
	}
	
	@Override
	public List<IColor> find(ColorFilter filter) {
		final EntityManager em = getEntityManager();
        final CriteriaBuilder cb = em.getCriteriaBuilder();
        final CriteriaQuery<IColor> cq = cb.createQuery(IColor.class);
        final Root<Color> from = cq.from(Color.class);
        cq.select(from);

        applyFilter(filter, cb, cq, from);

        if (filter.getSortColumn() != null) {
            final Path<?> expression = getSortPath(from, filter.getSortColumn());
            cq.orderBy(new OrderImpl(expression, filter.getSortOrder()));
        }

        final TypedQuery<IColor> q = em.createQuery(cq);
        setPaging(filter, q);
        return q.getResultList();
	}
	
    private void applyFilter(final ColorFilter filter, final CriteriaBuilder cb,
            final CriteriaQuery<?> cq, final Root<Color> from) {
        final List<Predicate> ands = new ArrayList<>();

        if (!ands.isEmpty()) {
            cq.where(cb.and(ands.toArray(new Predicate[0])));
        }
    }
	
	private Path<?> getSortPath(final Root<Color> from, final String sortColumn) {
        switch (sortColumn) {
        case "created":
            return from.get(Color_.created);
        case "updated":
            return from.get(Color_.updated);
        case "id":
            return from.get(Color_.id);
        case "name":
            return from.get(Color_.name);
        default:
            throw new UnsupportedOperationException(
                    "sorting is not supported by column:" + sortColumn);
        }
    }
	
	@Override
	public long getCount(ColorFilter filter) {
		final EntityManager em = getEntityManager();
		final CriteriaBuilder cb = em.getCriteriaBuilder();
		final CriteriaQuery<Long> cq = cb.createQuery(Long.class); 
		final Root<Color> from = cq.from(Color.class); 
		cq.select(cb.count(from)); 
		final TypedQuery<Long> q = em.createQuery(cq);
		return q.getSingleResult(); 
	}


}
