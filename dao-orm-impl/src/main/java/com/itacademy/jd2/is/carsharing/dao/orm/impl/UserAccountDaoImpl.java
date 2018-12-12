package com.itacademy.jd2.is.carsharing.dao.orm.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.FetchType;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.jpa.criteria.OrderImpl;
import org.springframework.stereotype.Repository;

import com.itacademy.jd2.is.carsharing.dao.api.IUserAccountDao;
import com.itacademy.jd2.is.carsharing.dao.api.entity.ICustomer;
import com.itacademy.jd2.is.carsharing.dao.api.entity.IUserAccount;
import com.itacademy.jd2.is.carsharing.dao.api.filter.CustomerFilter;
import com.itacademy.jd2.is.carsharing.dao.api.filter.UserAccountFilter;
import com.itacademy.jd2.is.carsharing.dao.orm.impl.entity.Customer;
import com.itacademy.jd2.is.carsharing.dao.orm.impl.entity.Customer_;
import com.itacademy.jd2.is.carsharing.dao.orm.impl.entity.UserAccount;
import com.itacademy.jd2.is.carsharing.dao.orm.impl.entity.UserAccount_;

@Repository
public class UserAccountDaoImpl extends AbstractDaoImpl<IUserAccount, Integer> implements IUserAccountDao {

	protected UserAccountDaoImpl() {
		super(UserAccount.class);
	}

	@Override
	public IUserAccount createEntity() {
		return new UserAccount();
	}
	
	@Override
	public List<IUserAccount> find(UserAccountFilter filter) {
		final EntityManager em = getEntityManager();
        final CriteriaBuilder cb = em.getCriteriaBuilder();
        final CriteriaQuery<IUserAccount> cq = cb.createQuery(IUserAccount.class);
        final Root<UserAccount> from = cq.from(UserAccount.class);
        cq.select(from);

        applyFilter(filter, cb, cq, from);

        // set sort params
        if (filter.getSortColumn() != null) {
            final Path<?> expression = getSortPath(from, filter.getSortColumn());
            cq.orderBy(new OrderImpl(expression, filter.getSortOrder()));
        }

        final TypedQuery<IUserAccount> q = em.createQuery(cq);
        setPaging(filter, q);
        return q.getResultList();
	}
	
	 private void applyFilter(final UserAccountFilter filter, final CriteriaBuilder cb,
	            final CriteriaQuery<?> cq, final Root<UserAccount> from) {
	        final List<Predicate> ands = new ArrayList<>();

	        if (!ands.isEmpty()) {
	            cq.where(cb.and(ands.toArray(new Predicate[0])));
	        }
	    }
		
		private Path<?> getSortPath(final Root<UserAccount> from, final String sortColumn) {
	        switch (sortColumn) {
	        case "created":
	            return from.get(UserAccount_.created);
	        case "updated":
	            return from.get(UserAccount_.updated);
	        case "id":
	            return from.get(UserAccount_.id);
	        case "login":
	            return from.get(UserAccount_.login);
	        case "firstName":
	            return from.join(UserAccount_.customer, JoinType.LEFT).get(Customer_.firstName);
	        case "lastName":
	            return from.join(UserAccount_.customer, JoinType.LEFT).get(Customer_.lastName);
	        case "birthday":
	            return from.join(UserAccount_.customer, JoinType.LEFT).get(Customer_.birthday);
	        default:
	            throw new UnsupportedOperationException(
	                    "sorting is not supported by column:" + sortColumn);
	        }
	    }

	@Override
	public long getCount(UserAccountFilter filter) {
		final EntityManager em = getEntityManager();
		final CriteriaBuilder cb = em.getCriteriaBuilder();
		final CriteriaQuery<Long> cq = cb.createQuery(Long.class); 
		final Root<UserAccount> from = cq.from(UserAccount.class); 
		cq.select(cb.count(from)); 
		final TypedQuery<Long> q = em.createQuery(cq);
		return q.getSingleResult(); 
	}

}
