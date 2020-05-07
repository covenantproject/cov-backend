package com.covid.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.metamodel.SingularAttribute;

import org.apache.commons.lang3.tuple.Pair;

public class Cond<E> {

	private final List<Pair<SingularAttribute<E, ?>, ?>> conditions;
	
	public Cond() {
		conditions = new ArrayList<>();
	}
	
	public static<E> Cond<E> of(){
		return new Cond<E>();
	}
	
	public<T> Cond<E> add(SingularAttribute<E, T> column, T value){
		conditions.add(Pair.of(column, value));
		return this;
	}
	
	
	
}
