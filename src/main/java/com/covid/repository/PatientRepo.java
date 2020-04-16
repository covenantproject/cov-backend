package com.covid.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.covid.model.Patient;
import com.covid.vo.UserEntity;

@Repository
public interface PatientRepo  extends CrudRepository<Patient ,Long>{

	Patient findByUserId(long userId);

	@Query("select count(*) from Patient ex where ex.healthProfessionalId = :healthProfid")
	long findByHealthProfessionalIdCount(@Param("healthProfid") long healthProfid);

	Patient findByPatientId(long patientId);

	List<Patient> findAllByUserId(long userId);

	List<Patient> findTop100ByUserId(long userId);
}
