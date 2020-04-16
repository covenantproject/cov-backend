package com.covid.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.covid.vo.UserEntity;


@Repository
public interface UserRepo  extends CrudRepository<UserEntity ,Long>{

	UserEntity findByUserId(long userId);

}
