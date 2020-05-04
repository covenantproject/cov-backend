package com.covid.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.covid.model.Address;


@Repository
public interface AddressRepo extends CrudRepository<Address,Long> {

	Address findByUserId(long userId);

	Address findFirstByUserId(long userId);

}
