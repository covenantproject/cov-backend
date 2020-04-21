package com.covid.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.covid.model.AppHeartbeatHistory;


@Repository
public interface AppHeartbeatHistoryRepo extends CrudRepository<AppHeartbeatHistory,Long> {

	AppHeartbeatHistory findByPrimaryUserId(long userId);

}

