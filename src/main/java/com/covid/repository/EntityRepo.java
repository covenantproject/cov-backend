package com.covid.repository;

import java.util.List;
import java.util.function.BiFunction;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EntityRepo {

    @Autowired
    @PersistenceContext
    private EntityManager em;
    
    
    public<T> List<T> find(Class<T> clazz, BiFunction<CriteriaBuilder, Root<T>, List<Order>> orderByFunc){
    	CriteriaBuilder builder = em.getCriteriaBuilder();
    	CriteriaQuery<T> query = builder.createQuery(clazz);
    	Root<T> from = query.from(clazz);
    	
    	CriteriaQuery<T> select = query.select(from);    	
    	if(orderByFunc != null) {
    		List<Order> orders = orderByFunc.apply(builder, from);
    		select.orderBy(orders);
    	}


    	TypedQuery<T> typedQuery = em.createQuery(select);
    	List<T> resultlist = typedQuery.getResultList();

    	
    	return resultlist;
    }
	
    @SuppressWarnings("unchecked")
	public static<IN, OUT> OUT cast(IN in) {
    	return (OUT) in;
    }
    
}
