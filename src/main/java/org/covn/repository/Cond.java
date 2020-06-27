package org.covn.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.SingularAttribute;

import org.apache.commons.lang3.tuple.Pair;
import org.apache.commons.lang3.tuple.Triple;
import org.covn.support.QuadFunction;
import org.covn.support.TriFunction;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class Cond<E> {

	public static enum Aon{
		and((cb, root, cond) -> cb.and(cond.getPredictes(cb, root))),
		or((cb, root, cond) -> cb.or(cond.getPredictes(cb, root))),
		
		;

		private final TriFunction<CriteriaBuilder, Root, Cond<?>, Predicate> predicate;

		private Aon(TriFunction<CriteriaBuilder, Root, Cond<?>, Predicate> predicate) {
			this.predicate = predicate;
		}

		public TriFunction<CriteriaBuilder, Root, Cond<?>, Predicate> getPredicate() {
			return predicate;
		}
		
		
		
		
	}
	
	public static enum Oper {
		gt((cb, root, column, value) -> cb.greaterThan(root.get(column), value)),
		gte((cb, root, column, value) -> cb.greaterThanOrEqualTo(root.get(column), value)),
		eq((cb, root, column, value) -> cb.equal(root.get(column), value)),
		ne((cb, root, column, value) -> cb.notEqual(root.get(column), value)),
		lt((cb, root, column, value) -> cb.lessThan(root.get(column), value)),
		lte((cb, root, column, value) -> cb.lessThanOrEqualTo(root.get(column), value)),;

		private final QuadFunction<CriteriaBuilder, Root, SingularAttribute, Comparable, Predicate> predicate;

		private Oper(QuadFunction<CriteriaBuilder, Root, SingularAttribute, Comparable, Predicate> predicate) {
			this.predicate = predicate;
		}

		public QuadFunction<CriteriaBuilder, Root, SingularAttribute, Comparable, Predicate> getPredicate() {
			return predicate;
		}

	}

	public enum Sort {
		asc((cb, root, column) -> cb.asc(root.get(column))), desc((cb, root, column) -> cb.desc(root.get(column))),;

		private final TriFunction<CriteriaBuilder, Root, SingularAttribute, Order> order;

		private Sort(TriFunction<CriteriaBuilder, Root, SingularAttribute, Order> order) {
			this.order = order;
		}

		public TriFunction<CriteriaBuilder, Root, SingularAttribute, Order> getOrder() {
			return order;
		}

	}

	private final Aon aon;
	private final Class<E> clazz;
	private final List<Triple<SingularAttribute<E, ?>, Cond.Oper, Comparable<?>>> conditions;
	private final List<Pair<SingularAttribute<E, ?>, Cond.Sort>> orderList;
	private final List<Cond<E>> nestedList;

	public Cond(Class<E> clazz) {
		this(clazz, Aon.and);
	}
	
	public Cond(Class<E> clazz, Aon aon) {
		this.clazz = clazz;
		this.aon = aon;
		conditions = new ArrayList<>();
		orderList = new ArrayList<>();
		nestedList = new ArrayList<>();
	}

	public static <E> Cond<E> of(Class<E> clazz) {
		return new Cond<E>(clazz);
	}

	public <T extends Comparable<T>> Cond<E> add(SingularAttribute<E, T> column, T value) {
		return this.add(column, Oper.eq, value);
	}

	public <T extends Comparable<T>> Cond<E> add(SingularAttribute<E, T> column, Cond.Oper op, T value) {
		conditions.add(Triple.of(column, op, value));
		return this;
	}

	public Cond<E> add(Cond<E> nested) {
		nestedList.add(nested);
		return this;
	}
	
	
	public <T> Cond<E> order(Cond.Sort orderBy, SingularAttribute<E, T> column) {
		orderList.add(Pair.of(column, orderBy));
		return this;
	}

	protected Class<E> getEntityClass() {
		return clazz;
	}

	public List<Triple<SingularAttribute<E, ?>, Cond.Oper, Comparable<?>>> getConditions() {
		return conditions;
	}

	protected List<Pair<SingularAttribute<E, ?>, Cond.Sort>> getOrderList() {
		return orderList;
	}
	
	protected Predicate[] getPredictes(CriteriaBuilder cb, Root from) {
		int index = 0;
		Predicate[] preds = new Predicate[this.getConditions().size() + this.nestedList.size()];
		for (Triple<SingularAttribute<E, ?>, Oper, Comparable<?>> con : this.getConditions()) {
			SingularAttribute<E, ?> column = con.getLeft();
			Comparable<?> value = con.getRight();
			Oper op = con.getMiddle();
			Predicate pred = op.getPredicate().exec(cb, from, column, value);
			preds[index++] = pred;
		}
		
		for(Cond<E> cond: this.nestedList) {
			Predicate pred = cond.get(cb, from);
			preds[index++] = pred;
		}
		
		
		return preds;
	}	
	
	public Predicate get(CriteriaBuilder cb, Root from) {
		Predicate predicate = this.aon.getPredicate().exec(cb, from, this);
		return predicate;
		
	}

}