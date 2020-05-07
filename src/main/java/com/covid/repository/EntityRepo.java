package com.covid.repository;

import java.util.ArrayList;
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

import org.apache.commons.lang3.tuple.Pair;
import org.apache.commons.lang3.tuple.Triple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.covid.model.QuadFunction;
import com.covid.model.TriFunction;
import com.covid.repository.EntityRepo.Cond.Oper;
import com.covid.repository.EntityRepo.Cond.Sort;

@Repository("entityRepo")
@Transactional
@org.springframework.core.annotation.Order(Ordered.HIGHEST_PRECEDENCE)
public class EntityRepo{

	@Autowired
    @PersistenceContext
    private EntityManager em;
        
    
	public EntityManager getEntityManager() {
		return this.em;
	}
	
	public<T> Cond<T> get(Class<T> clazz) {
		return Cond.of(clazz);
	}
	
    public <T> T findByPrimaryKey(Class<T> entityClass, Object primaryKey) {
    	return em.find(entityClass, primaryKey);
    }
    
    public<T> T execStoredProcedureQuery(Function<EntityManager, T> exec){
    	return exec.apply(em);
    	
    }
    
    public<T> T execute(Function<EntityManager, T> module) {
    	return module.apply(em);
    }
    

    public <E> List<E> find(Cond<E> cond){
    	CriteriaBuilder cb = em.getCriteriaBuilder();
    	CriteriaQuery<E> query = cb.createQuery(cond.getEntityClass());
    	Root<E> from = query.from(cond.getEntityClass());
    	CriteriaQuery<E> select = query.select(from);
   
        //ManagedType<Account> o = em.getMetamodel().managedType(Account.class);
        //SingularAttribute<? super Account, ?> c = o.getSingularAttribute(Account_.s_status);
        
    	int index = 0;
    	Predicate[] preds = new Predicate[cond.getConditions().size()];
    	for(Triple<SingularAttribute<E, ?>, Oper, Comparable<?>> con: cond.getConditions()) {
    		SingularAttribute<E, ?> column = con.getLeft();
    		Comparable<?> value = con.getRight();
    		Oper op = con.getMiddle();
    		Predicate pred = op.getPredicate().exec(cb, from, column, value);
    		preds[index++] = pred;
    	}
    	
    	query.where(preds);
    	
    	
    	if(cond.getOrderList().isEmpty() == false) {
    		List<Order> orders = new ArrayList<>();
    		for(Pair<SingularAttribute<E, ?>, Sort> item: cond.getOrderList()) {
    			SingularAttribute<E, ?> column = item.getKey();
    			Sort sort = item.getValue();
    			Order order = sort.getOrder().exec(cb, from, column);
    			orders.add(order);
    		}
    		select.orderBy(orders);
    	}

    	TypedQuery<E> typedQuery = em.createQuery(select);
    	List<E> result = typedQuery.getResultList();
    	
    	return result;
    }
	
    
	public final <E> E findOne(Cond<E> conditions){
    	List<E> results = find(conditions);
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
    	em.flush();
    	
    }
    
	@SuppressWarnings({"unchecked", "rawtypes"})
    public static class Cond<E> {

    	public enum Oper{
			gt((cb, root, column, value) -> cb.greaterThan(root.get(column), value)),
    		gte((cb, root, column, value) -> cb.greaterThanOrEqualTo(root.get(column), value)),
    		eq((cb, root, column, value) -> cb.equal(root.get(column), value)),
    		lt((cb, root, column, value) -> cb.lessThan(root.get(column), value)),
    		lte((cb, root, column, value) -> cb.lessThanOrEqualTo(root.get(column), value)),
    		;

    		
			private final QuadFunction<CriteriaBuilder, Root, SingularAttribute, Comparable, Predicate> predicate;

			private Oper(QuadFunction<CriteriaBuilder, Root, SingularAttribute, Comparable, Predicate> predicate) {
				this.predicate = predicate;
			}

			public QuadFunction<CriteriaBuilder, Root, SingularAttribute, Comparable, Predicate> getPredicate() {
				return predicate;
			}
    		
    	}
    	public enum Sort{
    		asc((cb, root, column) -> cb.asc(root.get(column))),
    		desc((cb, root, column) -> cb.desc(root.get(column))),
    		;
    		private final TriFunction<CriteriaBuilder, Root, SingularAttribute, Order> order;
    		
			private Sort(TriFunction<CriteriaBuilder, Root, SingularAttribute, Order> order) {
				this.order = order;
			}

			public TriFunction<CriteriaBuilder, Root, SingularAttribute, Order> getOrder() {
				return order;
			}

    		
    		
    		
    	}
    	
    	private final Class<E> clazz;
    	private final List<Triple<SingularAttribute<E, ?>, Oper, Comparable<?>>> conditions;
    	private final List<Pair<SingularAttribute<E, ?>, Sort>> orderList;
    	
    	public Cond(Class<E> clazz) {
    		this.clazz = clazz;
    		conditions = new ArrayList<>();
    		orderList = new ArrayList<>();
    	}
    	
    	public static<E> Cond<E> of(Class<E> clazz){
    		return new Cond<E>(clazz);
    	}
    	
    	public<T extends Comparable<T>> Cond<E> add(SingularAttribute<E, T> column, T value){
    		return this.add(column, Oper.eq, value);
    	}
    	
    	public<T extends Comparable<T>> Cond<E> add(SingularAttribute<E, T> column, Oper op, T value){
    		conditions.add(Triple.of(column, op, value));
    		return this;
    	}
    	
    	public<T> Cond<E> order(Sort orderBy, SingularAttribute<E, T> column){
    		orderList.add(Pair.of(column, orderBy));
    		return this;
    	}

		protected Class<E> getEntityClass() {
			return clazz;
		}

		public List<Triple<SingularAttribute<E, ?>, Oper, Comparable<?>>> getConditions() {
			return conditions;
		}

		protected List<Pair<SingularAttribute<E, ?>, Sort>> getOrderList() {
			return orderList;
		}
    	
    	
    }
    
    
}


