package com.itacademy.jd2.is.carsharing.dao.orm.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.itacademy.jd2.is.carsharing.dao.api.ITrackingDao;
import com.itacademy.jd2.is.carsharing.dao.api.entity.ITracking;
import com.itacademy.jd2.is.carsharing.dao.api.filter.TrackingFilter;
import com.itacademy.jd2.is.carsharing.dao.orm.impl.entity.Car_;
import com.itacademy.jd2.is.carsharing.dao.orm.impl.entity.Tracking;
import com.itacademy.jd2.is.carsharing.dao.orm.impl.entity.Tracking_;

@Repository
public class TrackingDaoImpl extends AbstractDaoImpl<ITracking, Integer> implements ITrackingDao {

	
	protected TrackingDaoImpl() {
		super(Tracking.class);
	}

	@Override
	public ITracking createEntity() {
		return new Tracking();
	}
	
	@Override
	public List<ITracking> find(TrackingFilter filter) {
		final EntityManager em = getEntityManager();
		final CriteriaBuilder cb = em.getCriteriaBuilder();
		final CriteriaQuery<ITracking> cq = cb.createQuery(ITracking.class);
		final Root<Tracking> from = cq.from(Tracking.class);
		cq.select(from);

		from.fetch(Tracking_.car, JoinType.LEFT);

		Integer carId = filter.getCarId();
		if (carId != null) {
			cq.where(cb.equal(from.get(Tracking_.car).get(Car_.id), carId));
		}

		return em.createQuery(cq).getResultList();
	}

}
