package org.covn.service;

import org.covn.dto.PatientDto;
import org.covn.dto.UserDto;
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
	
	/**
	 * Create new patient or update existing based on whether pkey is provided
	 * 
	 */
	public void savePatient (PatientDto patientDto) {
		// change return value to a status code or the patient_id rather than void
	}
	
	public PatientDto getPatient (int patient_id) {
		return null;
	}
	
	/** Under records retention laws of a country, deletion may not be allowed for a number of years
	 * So, an audit trail database needs to be implemented to save old records before deleting them
	 * from the runtime database.	 * 
	 */
	public void deletePatient() {
		
	}

	public void saveDemographics(){
		
	}
	
	public void getDemographics() {
		
	}
	
	public void deleteDemographics() {
		
	}
	
	public void savePreExistingConditionForCovid(){
		
	}
	
	public void getPreExistingConditionForCovid() {
		
	}
	
	public void deletePreExistingConditionForCovid() {
		
	}
	
	// PreExistingCondition (the general one, not the COVID denormalized one above), allergies and 
	// medications will be implemented later. So I haven't stubbed them now - Senthil N. 
	
}
