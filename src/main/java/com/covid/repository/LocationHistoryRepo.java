package com.covid.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.covid.model.LocationHistory;


@Repository
public interface LocationHistoryRepo  extends CrudRepository<LocationHistory ,Long>{

	LocationHistory findByUserId(long userId);

}
