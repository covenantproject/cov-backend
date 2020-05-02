package com.covid.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.covid.model.Locationhierarchy;


@Repository
public interface LocationHierarchyRepo  extends CrudRepository<Locationhierarchy ,Long>{

	Locationhierarchy findByUserId(long userId);

}
