package org.covn.dto;

import org.covn.model.db.PatientRequestHistory;

/**
 * Medical, quarantine/isolation or supplies (food, medicines, etc.) of patients
 * and responses from quarantine and health care professionals.
 * 
 * @author Senthil N
 *
 */
public class PatientRequestDto {
	private PatientRequestHistory patientRequest;

	public PatientRequestHistory getPatientRequest() {
		return patientRequest;
	}

	public void setPatientRequest(PatientRequestHistory patientRequest) {
		this.patientRequest = patientRequest;
	}

}
