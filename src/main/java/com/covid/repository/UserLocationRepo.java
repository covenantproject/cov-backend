package com.covid.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.covid.model.UserLocation;

@Repository
public interface UserLocationRepo extends CrudRepository<UserLocation,Long> {
	List<UserLocation> findAllByUserId(long userId);
}
