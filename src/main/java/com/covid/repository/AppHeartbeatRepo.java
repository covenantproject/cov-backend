package com.covid.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.covid.model.Appheartbeat;


@Repository
public interface AppHeartbeatRepo extends CrudRepository<Appheartbeat,Long> {

	//Appheartbeat findByPrimaryUserId(long userId);

}

