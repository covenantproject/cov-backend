package com.covid.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.covid.model.Location;


@Repository
public interface LocationRepo extends CrudRepository<Location,Long> {

	Location findByLocationId(long locationId);



}
