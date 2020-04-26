package com.covid.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.covid.model.GeofenceLocation;

@Repository
public interface GeofenceLocationRepo  extends CrudRepository<GeofenceLocation ,Long>{

	//GeofenceLocation findByUserId(long userId);


}
