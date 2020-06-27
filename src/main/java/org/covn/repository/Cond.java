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

	public enum Oper {
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

	private final Class<E> clazz;
	private final List<Triple<SingularAttribute<E, ?>, Cond.Oper, Comparable<?>>> conditions;
	private final List<Pair<SingularAttribute<E, ?>, Cond.Sort>> orderList;

	public Cond(Class<E> clazz) {
		this.clazz = clazz;
		conditions = new ArrayList<>();
		orderList = new ArrayList<>();
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

}