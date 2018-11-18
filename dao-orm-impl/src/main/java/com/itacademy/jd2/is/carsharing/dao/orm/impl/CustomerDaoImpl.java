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

import com.itacademy.jd2.is.carsharing.dao.api.ICustomerDao;
import com.itacademy.jd2.is.carsharing.dao.api.entity.ICustomer;
import com.itacademy.jd2.is.carsharing.dao.api.filter.CustomerFilter;
import com.itacademy.jd2.is.carsharing.dao.orm.impl.entity.Customer;
import com.itacademy.jd2.is.carsharing.dao.orm.impl.entity.Customer_;

@Repository
public class CustomerDaoImpl extends AbstractDaoImpl<ICustomer, Integer> implements ICustomerDao {

	protected CustomerDaoImpl() {
		super(Customer.class);
	}

	@Override
	public ICustomer createEntity() {
		return new Customer();
	}

	@Override
	public List<ICustomer> find(CustomerFilter filter) {
		final EntityManager em = getEntityManager();
        final CriteriaBuilder cb = em.getCriteriaBuilder();
        final CriteriaQuery<ICustomer> cq = cb.createQuery(ICustomer.class);
        final Root<Customer> from = cq.from(Customer.class);
        cq.select(from);

        applyFilter(filter, cb, cq, from);

        // set sort params
        if (filter.getSortColumn() != null) {
            final Path<?> expression = getSortPath(from, filter.getSortColumn());
            cq.orderBy(new OrderImpl(expression, filter.getSortOrder()));
        }

        final TypedQuery<ICustomer> q = em.createQuery(cq);
        setPaging(filter, q);
        return q.getResultList();
	}
	
	 private void applyFilter(final CustomerFilter filter, final CriteriaBuilder cb,
	            final CriteriaQuery<?> cq, final Root<Customer> from) {
	        final List<Predicate> ands = new ArrayList<>();

	        if (!ands.isEmpty()) {
	            cq.where(cb.and(ands.toArray(new Predicate[0])));
	        }
	    }
		
		private Path<?> getSortPath(final Root<Customer> from, final String sortColumn) {
	        switch (sortColumn) {
	        case "created":
	            return from.get(Customer_.created);
	        case "updated":
	            return from.get(Customer_.updated);
	        case "id":
	            return from.get(Customer_.id);
	        case "firstName":
	            return from.get(Customer_.firstName);
	        case "lastName":
	            return from.get(Customer_.lastName);
	        default:
	            throw new UnsupportedOperationException(
	                    "sorting is not supported by column:" + sortColumn);
	        }
	    }

	@Override
	public long getCount(CustomerFilter filter) {
		final EntityManager em = getEntityManager();
		final CriteriaBuilder cb = em.getCriteriaBuilder();
		final CriteriaQuery<Long> cq = cb.createQuery(Long.class); 
		final Root<Customer> from = cq.from(Customer.class); 
		cq.select(cb.count(from)); 
		final TypedQuery<Long> q = em.createQuery(cq);
		return q.getSingleResult(); 
	}

}
