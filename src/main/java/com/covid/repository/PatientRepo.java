package com.covid.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.covid.model.Patient;
import com.covid.vo.UserEntity;

@Repository
public interface PatientRepo  extends CrudRepository<Patient ,Long>{

	Patient findByUserId(long userId);
}
