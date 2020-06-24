package org.covn.service;

import org.covn.dto.PatientDto;
import org.covn.model.db.Users;
import org.covn.repository.EntityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Senthil N
 **/
@Component
public class PatientService {

	/*
	 * PatinetService should both register Patients and retrieve their information
	 * 
	 */
	
	@Autowired
	private EntityRepo repo;
	

	public void registerNewPatient (Users user) {
		repo.save(user);
	}
	
	private PatientDto getPatientInfo (int patient_id) {
		return null;
	}
	
	private void savePatientInfo (PatientDto patientDto) {
		// change return value to a status code or the patient_id rather than void
	}
	
	
}
