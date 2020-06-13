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
    
	public String getHouseholdId() {
		return householdId;
	}
	public void setHouseholdId(String householdId) {
		this.householdId = householdId;
	}
	public boolean isHasPreexistingConditions() {
		return hasPreexistingConditions;
	}
	public void setHasPreexistingConditions(boolean hasPreexistingConditions) {
		this.hasPreexistingConditions = hasPreexistingConditions;
	}
	public boolean isHasMedications() {
		return hasMedications;
	}
	public void setHasMedications(boolean hasMedications) {
		this.hasMedications = hasMedications;
	}
	public boolean isHasAllergies() {
		return hasAllergies;
	}
	public void setHasAllergies(boolean hasAllergies) {
		this.hasAllergies = hasAllergies;
	}
	public boolean isHasAdvanceDirectives() {
		return hasAdvanceDirectives;
	}
	public void setHasAdvanceDirectives(boolean hasAdvanceDirectives) {
		this.hasAdvanceDirectives = hasAdvanceDirectives;
	}
	public boolean isNeedsCarer() {
		return needsCarer;
	}
	public void setNeedsCarer(boolean needsCarer) {
		this.needsCarer = needsCarer;
	}
	public boolean isHasInterationalTravel() {
		return hasInterationalTravel;
	}
	public void setHasInterationalTravel(boolean hasInterationalTravel) {
		this.hasInterationalTravel = hasInterationalTravel;
	}
	public boolean isHasInterstateTravel() {
		return hasInterstateTravel;
	}
	public void setHasInterstateTravel(boolean hasInterstateTravel) {
		this.hasInterstateTravel = hasInterstateTravel;
	}
	public boolean isHasHighRiskFacilityVisit() {
		return hasHighRiskFacilityVisit;
	}
	public void setHasHighRiskFacilityVisit(boolean hasHighRiskFacilityVisit) {
		this.hasHighRiskFacilityVisit = hasHighRiskFacilityVisit;
	}
	public boolean isHighRiskHealthcareWorker() {
		return isHighRiskHealthcareWorker;
	}
	public void setHighRiskHealthcareWorker(boolean isHighRiskHealthcareWorker) {
		this.isHighRiskHealthcareWorker = isHighRiskHealthcareWorker;
	}
	public String getBloodGroup() {
		return bloodGroup;
	}
	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}
	public boolean isClinicalTrialStatus() {
		return clinicalTrialStatus;
	}
	public void setClinicalTrialStatus(boolean clinicalTrialStatus) {
		this.clinicalTrialStatus = clinicalTrialStatus;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
    
    
    
    
}
