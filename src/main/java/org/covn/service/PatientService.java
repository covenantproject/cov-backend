package org.covn.service;

import org.covn.dto.PatientDto;
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

	private void registerNewPatient (PatientDto patientDto) {
		// use UserService to register the new User
		// and then save patient-specific information in the Patient table
		// change return value to a status code or the patient_id rather than void
	}
	
	private PatientDto getPatientInfo (int patient_id) {
		return null;
	}
	
	private void savePatientInfo (PatientDto patientDto) {
		// change return value to a status code or the patient_id rather than void
	}
	
	
}
