package org.covn.dto;

/* Fields that are specific to patients, in addition to common fields in UserDto
 * 
 * For the lack of a better word, those under quarantine (i.e. infection not yet confirmed) 
 * and under isolation (i.e. infection is confirmed) are all called 'patients'. The word
 * 'Patient' does not imply that the person is infected or ill.
 *  
 */

public class PatientDto extends UserDto {

	// Following fields are specific to patients, in addition to common fields in UserDto
	
	// Following fields are from patient table
    private String householdId; // unique id for the household. multiple patients may be in a household.
    private boolean hasPreexistingConditions;
    private boolean hasMedications;
    private boolean hasAllergies;
    private boolean hasAdvanceDirectives;
    private boolean needsCarer;
    private boolean hasInterationalTravel;
    private boolean hasInterstateTravel;
    private boolean hasHighRiskFacilityVisit;
    private boolean isHighRiskHealthcareWorker;
    private String bloodGroup; // CHECK CONSTRAINT
    private boolean clinicalTrialStatus;
    private String comments;
    
}
