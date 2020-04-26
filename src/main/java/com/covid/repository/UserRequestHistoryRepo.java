package com.covid.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.covid.model.UserRequestHistory;


@Repository
public interface UserRequestHistoryRepo  extends CrudRepository<UserRequestHistory,Long>{

	//UserRequestHistory findByUserId(int userId);

	UserRequestHistory findTopByUserId(int userId);

}


