package com.covid.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.SingularAttribute;
import javax.transaction.Transactional;

import org.apache.commons.lang3.tuple.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EntityRepo {

    @Autowired
    @PersistenceContext
    private EntityManager em;
    
    
    public <T> T findByPrimaryKey(Class<T> entityClass, Object primaryKey) {
    	return em.find(entityClass, primaryKey);
    }
    
    public<T> T execStoredProcedureQuery(Function<EntityManager, T> exec){
    	return exec.apply(em);
    	
    }
    
    public<E, T extends Object> List<E> find(Class<E> clazz, List<Pair<SingularAttribute<E, T>, T>> conditions, List<Order> orders){
    	CriteriaBuilder cb = em.getCriteriaBuilder();
    	CriteriaQuery<E> query = cb.createQuery(clazz);
    	Root<E> from = query.from(clazz);
    	CriteriaQuery<E> select = query.select(from);
   
    	
    	List<Predicate> preds = new ArrayList<>(conditions.size());
    	for(Pair<SingularAttribute<E, T>, T> con: conditions) {
    		SingularAttribute<E, T> column = con.getLeft();
    		Object value = con.getRight();
    		Predicate pred = cb.equal(from.get(column), value);
    		preds.add(pred);
    	}
    	
    	
    	Predicate[] array = new Predicate[preds.size()];
    	array = preds.toArray(array);
    	Predicate conds = cb.and(array);
    	query.where(conds);
    	
    	if(orders != null && orders.isEmpty() == false) {
    		select.orderBy(orders);
    	}

    	TypedQuery<E> typedQuery = em.createQuery(select);
    	List<E> result = typedQuery.getResultList();
    	
    	return result;
    }
	
    public<E, T extends Object> List<E> find(Class<E> clazz, Pair<SingularAttribute<E, T>, T> condition){
    	return find(clazz, Arrays.asList(condition), null);
    }
    
    public<E, T extends Object> E findOne(Class<E> clazz, List<Pair<SingularAttribute<E, T>, T> > conditions){
    	List<E> results = find(clazz, conditions, null);
    	E result = null;
    	if(results.isEmpty() == false) {
    		result = results.get(0);
    	}
    	return result;  	
    }
    
    public<E, T extends Object> E findOne(Class<E> clazz, Pair<SingularAttribute<E, T>, T> condition){
    	List<E> results = find(clazz, Arrays.asList(condition), null);
    	E result = null;
    	if(results.isEmpty() == false) {
    		result = results.get(0);
    	}
    	return result;
    }
    
    @Transactional
    public<T> void save(@SuppressWarnings("unchecked") T... entities) {
    	for(T en: entities) {
    		em.persist(en);
    	}
    }
    
}
