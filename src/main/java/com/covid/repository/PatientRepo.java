package com.covid.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.covid.model.Patient;

@Repository
public interface PatientRepo  extends CrudRepository<Patient ,Long>{

	Patient findByUserId(long userId);

	//@Query("select count(*) from Patient ex where ex.healthProfessionalId = :healthProfid")
	//long findByHealthProfessionalIdCount(@Param("healthProfid") long healthProfid);


	List<Patient> findAllByUserId(long userId);

	List<Patient> findTop100ByUserId(long userId);
}
