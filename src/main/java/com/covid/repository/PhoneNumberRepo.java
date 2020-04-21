package com.covid.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.covid.model.PhoneNumber;

@Repository
public interface PhoneNumberRepo extends CrudRepository<PhoneNumber, Long> {

    PhoneNumber findByUserId(long userId);

    PhoneNumber findByPhoneNumber(String phoneNumber);
}
