package org.covn.dto;

import org.covn.model.db.PatientProviderRel;

/** Patient provider relationship, used for access control and viewing individual patient info in dashboards
 * Only health pros who have a patient-provider relationship to a patient can view that patient's info in the dashboard.
 * Patient-provider relationship has a location (e.g. public health department of a city for patients under home quarantine,
 * or a hospital for inpatients), start and end dates.
 * 
 * Without a current patient-provider relationship, a provider may view aggregate statistical information and trends for a given 
 * location  * based on their job location or its administrative subdivisions. But they SHALL not see personally identifiable 
 * information or protected health information of a patient. 
 */
public class PatientProviderRelationshipDto {

	private PatientProviderRel patProRel;

	public PatientProviderRel getPatProRel() {
		return patProRel;
	}

	public void setPatProRel(PatientProviderRel patProRel) {
		this.patProRel = patProRel;
	}
	
}
