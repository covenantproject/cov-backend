package com.covid.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.covid.model.GeofenceLocation;
import com.covid.vo.UserEntity;


@Repository
public interface GeofenceLocationRepo  extends CrudRepository<GeofenceLocation ,Long>{

	//GeofenceLocation findByUserId(long userId);


}
