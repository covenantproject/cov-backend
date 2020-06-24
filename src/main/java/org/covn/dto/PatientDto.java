package org.covn.dto;

import org.covn.model.db.Patient;
import org.covn.model.db.Users;

/* Fields that are specific to patients, in addition to common fields in UserDto
 * 
 * For the lack of a better word, those under quarantine (i.e. infection not yet confirmed) 
 * and under isolation (i.e. infection is confirmed) are all called 'patients'. The word
 * 'Patient' does not imply that the person is infected or ill.
 *  
 */

public class PatientDto {

	private Users user;
	private Patient patient;
	
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
    
    
    
    
}
