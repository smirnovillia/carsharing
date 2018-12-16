package com.itacademy.jd2.is.carsharing.dao.orm.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.itacademy.jd2.is.carsharing.dao.api.IModificationDao;
import com.itacademy.jd2.is.carsharing.dao.api.entity.IModification;
import com.itacademy.jd2.is.carsharing.dao.api.filter.ModificationFilter;
import com.itacademy.jd2.is.carsharing.dao.orm.impl.entity.Model_;
import com.itacademy.jd2.is.carsharing.dao.orm.impl.entity.Modification;
import com.itacademy.jd2.is.carsharing.dao.orm.impl.entity.Modification_;

@Repository
public class ModificationDaoImpl extends AbstractDaoImpl<IModification, Integer> implements IModificationDao {

	protected ModificationDaoImpl() {
		super(Modification.class);
	}

	@Override
	public IModification createEntity() {
		return new Modification();
	}

	@Override
	public List<IModification> find(ModificationFilter filter) {
		final EntityManager em = getEntityManager();
		final CriteriaBuilder cb = em.getCriteriaBuilder();
		final CriteriaQuery<IModification> cq = cb.createQuery(IModification.class);
		final Root<Modification> from = cq.from(Modification.class);
		cq.select(from);

		from.fetch(Modification_.model, JoinType.LEFT);

		Integer modelId = filter.getModelId();
		if (modelId != null) {
			cq.where(cb.equal(from.get(Modification_.model).get(Model_.id), modelId));
		}

		return em.createQuery(cq).getResultList();
	}

}
