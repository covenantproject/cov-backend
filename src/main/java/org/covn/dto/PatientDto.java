package org.covn.dto;

import java.util.ArrayList;
import java.util.List;

import org.covn.model.db.Address;
import org.covn.model.db.Allergy;
import org.covn.model.db.Demographics;
import org.covn.model.db.EmailAddress;
import org.covn.model.db.ExternalIdentifier;
import org.covn.model.db.Medication;
import org.covn.model.db.Patient;
import org.covn.model.db.PhoneNumber;
import org.covn.model.db.PreExistingCondition;
import org.covn.model.db.PreExistingConditionCovidDenorm;
import org.covn.model.db.UserPhoto;
import org.covn.model.db.Users;

/** Fields that are specific to patients, in addition to common fields in UserDto
 * 
 * For the lack of a better word, 'patient' denotes those under quarantine (i.e. infection 
 * not yet confirmed) or isolation (i.e. infection is confirmed). 
 * The word 'Patient' does not imply that the person is infected or ill.
 *  
 */

public class PatientDto extends UserDto {
	
	
	// patient is a subtype of user
	
	private Patient patient;
	
	/**
	 * enter at least 1 emergency contact and next of kin for a patient under demographics
	 */
	private Demographics demographics;

	/** Denormalized table containing pre-existing conditions that are of 
	 * high-risk for COVID outcomes, such as diabetes mellitus, obesity, etc.
	 * Needed for release1. 
	 */
	private PreExistingConditionCovidDenorm preExistingConditionsForCovid;

	/** List of pre-existing conditions of a patient.
	 * Conditions are denoted using SNOMED CT codes.
	 * Need to constrain to a SNOMED CT value set.
	 * Not needed for release1, may be deferred to release2.
	 */
	private ArrayList<PreExistingCondition> preExistingConditionList;


	/** List of substances to which a patient is allergic.
	 * Need to constrain to a SNOMED CT allergens value set.
	 * Not needed for release1, may be deferred to release2.
	 */
	private ArrayList<Allergy> allergyList;
	
	/** List of medications of a patient.
	 * Both active (more important) and inactive (less important) medications may be listed.
	 * Need to constrain to a SNOMED CT or RxNorm medications value set.
	 * Not needed for release1, may be deferred to release2.
	 */
	private ArrayList<Medication> medicationList;
	
	
	
	public Demographics getDemographics() {
		return demographics;
	}
	public void setDemographics(Demographics demographics) {
		this.demographics = demographics;
	}
	public PreExistingConditionCovidDenorm getPreExistingConditionsForCovid() {
		return preExistingConditionsForCovid;
	}
	public void setPreExistingConditionsForCovid(PreExistingConditionCovidDenorm preExistingConditionsForCovid) {
		this.preExistingConditionsForCovid = preExistingConditionsForCovid;
	}
	public ArrayList<PreExistingCondition> getPreExistingConditionList() {
		return preExistingConditionList;
	}
	public void setPreExistingConditionList(ArrayList<PreExistingCondition> preExistingConditionList) {
		this.preExistingConditionList = preExistingConditionList;
	}
	public ArrayList<Allergy> getAllergyList() {
		return allergyList;
	}
	public void setAllergyList(ArrayList<Allergy> allergyList) {
		this.allergyList = allergyList;
	}
	public ArrayList<Medication> getMedicationList() {
		return medicationList;
	}
	public void setMedicationList(ArrayList<Medication> medicationList) {
		this.medicationList = medicationList;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
    
    
    
    
}
