package com.covid.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.covid.model.PatientCurrentStatus;

@Repository
public interface PatientCurrentStatusRepo extends CrudRepository<PatientCurrentStatus ,Long> {

	PatientCurrentStatus findByPatientId(long patientId);

}
