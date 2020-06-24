package org.covn.dto;

import org.covn.model.db.PatientStatus;

/** Current quarantine/isolation, health and request status of a patient
 * 
 */
public class PatientStatusDto {

	private PatientStatus patientStatus;

	public PatientStatus getPatientStatus() {
		return patientStatus;
	}

	public void setPatientStatus(PatientStatus patientStatus) {
		this.patientStatus = patientStatus;
	}

	
}
