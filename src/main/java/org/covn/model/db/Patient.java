package org.covn.model.db;

import javax.persistence.Entity;
import javax.persistence.UniqueConstraint;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.Set;
import javax.persistence.OneToOne;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.SequenceGenerator;
import javax.persistence.FetchType;
import org.covn.model.BaseModel;
import javax.persistence.Id;

import java.io.Serializable;


@Entity
@Table(name = "patient", schema = "release1", uniqueConstraints={@UniqueConstraint(columnNames = {"patient_id"})
})
public class Patient extends BaseModel<Patient, Integer> implements java.io.Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "patient_id", nullable = false, length = 10)
	private Integer patientId;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "patient_id")
	private Users users;

	@Column(name = "household_id", nullable = true, length = 10)
	private Integer householdId;

	@Column(name = "has_preexisting_conditions", nullable = true)
	private Boolean hasPreexistingConditions;

	@Column(name = "has_medications", nullable = true)
	private Boolean hasMedications;

	@Column(name = "has_allergies", nullable = true)
	private Boolean hasAllergies;

	@Column(name = "has_advance_directives", nullable = true)
	private Boolean hasAdvanceDirectives;

	@Column(name = "needs_carer", nullable = true)
	private Boolean needsCarer;

	@Column(name = "has_international_travel", nullable = true)
	private Boolean hasInternationalTravel;

	@Column(name = "has_interstate_travel", nullable = true)
	private Boolean hasInterstateTravel;

	@Column(name = "has_high_risk_facility_visit", nullable = true)
	private Boolean hasHighRiskFacilityVisit;

	@Column(name = "is_high_risk_health_worker", nullable = true)
	private Boolean isHighRiskHealthWorker;

	@Column(name = "blood_group", nullable = true, length = 32)
	private String bloodGroup;

	@Column(name = "clinical_trial_status", nullable = true, length = 10)
	private String clinicalTrialStatus;

	@Column(name = "comments", nullable = true, length = 10)
	private String comments;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "patient")
	private Set<Medication> medicationSet;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "patient")
	private Set<Allergy> allergySet;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "patient")
	private Set<PreExistingCondition> preExistingConditionSet;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "patient")
	private Set<PatientGeofencedLocation> patientGeofencedLocationSet;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "patient")
	private Set<PatientProviderRel> patientProviderRelSet;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "patient")
	private Set<PreExistingConditionCovidDenorm> preExistingConditionCovidDenormSet;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "patient")
	private Set<PatientRequestHistory> patientRequestHistorySet;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "patient")
	private Set<HealthCheckHistory> healthCheckHistorySet;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "patient")
	private Set<PatientStatus> patientStatusSet;


	public Integer getPatientId(){
		return this.patientId;
	}
	public Patient setPatientId(Integer patientId){
		this.patientId = patientId;
		
		return this;
	}

	public Users getUsers(){
		return this.users;
	}
	public Patient setUsers(Users users){
		this.users = users;
		this.patientId = (this.users == null)? null: this.users.getUserId();
		return this;
	}

	public Integer getHouseholdId(){
		return this.householdId;
	}
	public Patient setHouseholdId(Integer householdId){
		this.householdId = householdId;
		
		return this;
	}

	public Boolean getHasPreexistingConditions(){
		return this.hasPreexistingConditions;
	}
	public Patient setHasPreexistingConditions(Boolean hasPreexistingConditions){
		this.hasPreexistingConditions = hasPreexistingConditions;
		
		return this;
	}

	public Boolean getHasMedications(){
		return this.hasMedications;
	}
	public Patient setHasMedications(Boolean hasMedications){
		this.hasMedications = hasMedications;
		
		return this;
	}

	public Boolean getHasAllergies(){
		return this.hasAllergies;
	}
	public Patient setHasAllergies(Boolean hasAllergies){
		this.hasAllergies = hasAllergies;
		
		return this;
	}

	public Boolean getHasAdvanceDirectives(){
		return this.hasAdvanceDirectives;
	}
	public Patient setHasAdvanceDirectives(Boolean hasAdvanceDirectives){
		this.hasAdvanceDirectives = hasAdvanceDirectives;
		
		return this;
	}

	public Boolean getNeedsCarer(){
		return this.needsCarer;
	}
	public Patient setNeedsCarer(Boolean needsCarer){
		this.needsCarer = needsCarer;
		
		return this;
	}

	public Boolean getHasInternationalTravel(){
		return this.hasInternationalTravel;
	}
	public Patient setHasInternationalTravel(Boolean hasInternationalTravel){
		this.hasInternationalTravel = hasInternationalTravel;
		
		return this;
	}

	public Boolean getHasInterstateTravel(){
		return this.hasInterstateTravel;
	}
	public Patient setHasInterstateTravel(Boolean hasInterstateTravel){
		this.hasInterstateTravel = hasInterstateTravel;
		
		return this;
	}

	public Boolean getHasHighRiskFacilityVisit(){
		return this.hasHighRiskFacilityVisit;
	}
	public Patient setHasHighRiskFacilityVisit(Boolean hasHighRiskFacilityVisit){
		this.hasHighRiskFacilityVisit = hasHighRiskFacilityVisit;
		
		return this;
	}

	public Boolean getIsHighRiskHealthWorker(){
		return this.isHighRiskHealthWorker;
	}
	public Patient setIsHighRiskHealthWorker(Boolean isHighRiskHealthWorker){
		this.isHighRiskHealthWorker = isHighRiskHealthWorker;
		
		return this;
	}

	public String getBloodGroup(){
		return this.bloodGroup;
	}
	public Patient setBloodGroup(String bloodGroup){
		this.bloodGroup = bloodGroup;
		
		return this;
	}

	public String getClinicalTrialStatus(){
		return this.clinicalTrialStatus;
	}
	public Patient setClinicalTrialStatus(String clinicalTrialStatus){
		this.clinicalTrialStatus = clinicalTrialStatus;
		
		return this;
	}

	public String getComments(){
		return this.comments;
	}
	public Patient setComments(String comments){
		this.comments = comments;
		
		return this;
	}

	public Set<Medication> getMedicationSet(){
		return this.medicationSet;
	}
	public Patient setMedicationSet(Set<Medication> medicationSet){
		this.medicationSet = medicationSet;
		
		return this;
	}

	public Set<Allergy> getAllergySet(){
		return this.allergySet;
	}
	public Patient setAllergySet(Set<Allergy> allergySet){
		this.allergySet = allergySet;
		
		return this;
	}

	public Set<PreExistingCondition> getPreExistingConditionSet(){
		return this.preExistingConditionSet;
	}
	public Patient setPreExistingConditionSet(Set<PreExistingCondition> preExistingConditionSet){
		this.preExistingConditionSet = preExistingConditionSet;
		
		return this;
	}

	public Set<PatientGeofencedLocation> getPatientGeofencedLocationSet(){
		return this.patientGeofencedLocationSet;
	}
	public Patient setPatientGeofencedLocationSet(Set<PatientGeofencedLocation> patientGeofencedLocationSet){
		this.patientGeofencedLocationSet = patientGeofencedLocationSet;
		
		return this;
	}

	public Set<PatientProviderRel> getPatientProviderRelSet(){
		return this.patientProviderRelSet;
	}
	public Patient setPatientProviderRelSet(Set<PatientProviderRel> patientProviderRelSet){
		this.patientProviderRelSet = patientProviderRelSet;
		
		return this;
	}

	public Set<PreExistingConditionCovidDenorm> getPreExistingConditionCovidDenormSet(){
		return this.preExistingConditionCovidDenormSet;
	}
	public Patient setPreExistingConditionCovidDenormSet(Set<PreExistingConditionCovidDenorm> preExistingConditionCovidDenormSet){
		this.preExistingConditionCovidDenormSet = preExistingConditionCovidDenormSet;
		
		return this;
	}

	public Set<PatientRequestHistory> getPatientRequestHistorySet(){
		return this.patientRequestHistorySet;
	}
	public Patient setPatientRequestHistorySet(Set<PatientRequestHistory> patientRequestHistorySet){
		this.patientRequestHistorySet = patientRequestHistorySet;
		
		return this;
	}

	public Set<HealthCheckHistory> getHealthCheckHistorySet(){
		return this.healthCheckHistorySet;
	}
	public Patient setHealthCheckHistorySet(Set<HealthCheckHistory> healthCheckHistorySet){
		this.healthCheckHistorySet = healthCheckHistorySet;
		
		return this;
	}

	public Set<PatientStatus> getPatientStatusSet(){
		return this.patientStatusSet;
	}
	public Patient setPatientStatusSet(Set<PatientStatus> patientStatusSet){
		this.patientStatusSet = patientStatusSet;
		
		return this;
	}


	@Override
	public Integer getKey() {
		return this.patientId;
	}

	
	public static Patient of(){
		return new Patient();
	}
	
	public static Patient copy(Patient src, int depth){
		Patient copy = null;
		if(depth > 0){
			copy = new Patient();
			copy.patientId = src.getPatientId();
			copy.users = (src.getUsers() == null)? null : Users.copy(src.getUsers(), --depth);
			copy.householdId = src.getHouseholdId();
			copy.hasPreexistingConditions = src.getHasPreexistingConditions();
			copy.hasMedications = src.getHasMedications();
			copy.hasAllergies = src.getHasAllergies();
			copy.hasAdvanceDirectives = src.getHasAdvanceDirectives();
			copy.needsCarer = src.getNeedsCarer();
			copy.hasInternationalTravel = src.getHasInternationalTravel();
			copy.hasInterstateTravel = src.getHasInterstateTravel();
			copy.hasHighRiskFacilityVisit = src.getHasHighRiskFacilityVisit();
			copy.isHighRiskHealthWorker = src.getIsHighRiskHealthWorker();
			copy.bloodGroup = src.getBloodGroup();
			copy.clinicalTrialStatus = src.getClinicalTrialStatus();
			copy.comments = src.getComments();
		}
		return copy;
	}

	@Override
	public Patient copy() {
		return copy(this, copyDepth);
	}	
}