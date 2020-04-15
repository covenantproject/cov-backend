package com.covid.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.covid.model.LocationHistory;
import com.covid.model.Patient;
import com.covid.model.PatientCurrentStatus;


@Repository
public interface LocationHistoryRepo  extends CrudRepository<LocationHistory ,Long>{

	LocationHistory findByPatientId(long patientId);

}
