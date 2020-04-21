package com.covid.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.covid.model.UserRequestHistory;


@Repository
public interface UserRequestHistoryRepo  extends CrudRepository<UserRequestHistory,Long>{

	UserRequestHistory findByUserId(long userId);

}


