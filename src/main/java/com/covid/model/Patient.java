package com.covid.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "\"Patient\"")
public class Patient {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="\"PatientId\"")
	private long patientId;
	
	@Column(name="\"Nationality\"")
	private boolean Nationality;
	
	@Column(name="\"EmergencyContact1\"")
	private String EmergencyContact1;
	
	@Column(name="\"EContact1RelToPt\"")
	private String EContact1RelToPt;
	
	@Column(name="\"EmergencyContact2\"")
	private String EmergencyContact2;
	
	@Column(name="\"EContact2RelToPt\"")
	private String EContact2RelToPt;
	
	@Column(name="\"NextOfKin1\"")
	private boolean NextOfKin1;
	
	@Column(name="\"NofKin1RelToPt\"")
	private String NofKin1RelToPt;
	
	@Column(name="\"NextofKin2\"")
	private boolean NextofKin2;
	
	@Column(name="\"NofKin2RelToPt\"")
	private String NofKin2RelToPt;
	
	@Column(name="\"HasPreExistingConditions\"")
	private boolean HasPreExistingConditions;
	
	@Column(name="\"HasMedications\"")
	private boolean HasMedications;
	
	@Column(name="\"HasAllergies\"")
	private boolean HasAllergies;
	
	@Column(name="\"HasAdvanceDirectives\"")
	private boolean HasAdvanceDirectives;
	
	@Column(name="\"NeedsCarer\"")
	private boolean NeedsCarer;
	
	@Column(name="\"HasInternationalTravel\"")
	private boolean HasInternationalTravel;
	
	@Column(name="\"HasInterstateTravel\"")
	private boolean HasInterstateTravel;
	
	@Column(name="\"HasHighRiskFacilityVisit\"")
	private boolean HasHighRiskFacilityVisit;
	
	@Column(name="\"IsHighRiskHealthWorker\"")
	private boolean IsHighRiskHealthWorker;
	
	@Column(name="\"ClinicalTrialStatus\"")
	private String ClinicalTrialStatus;
	
	@Column(name="\"Comments\"")
	private String Comments;

	public long getPatientId() {
		return patientId;
	}

	public void setPatientId(long patientId) {
		this.patientId = patientId;
	}


	public boolean isNationality() {
		return Nationality;
	}

	public void setNationality(boolean nationality) {
		Nationality = nationality;
	}

	public String getEmergencyContact1() {
		return EmergencyContact1;
	}

	public void setEmergencyContact1(String emergencyContact1) {
		EmergencyContact1 = emergencyContact1;
	}

	public String getEContact1RelToPt() {
		return EContact1RelToPt;
	}

	public void setEContact1RelToPt(String eContact1RelToPt) {
		EContact1RelToPt = eContact1RelToPt;
	}

	public String getEmergencyContact2() {
		return EmergencyContact2;
	}

	public void setEmergencyContact2(String emergencyContact2) {
		EmergencyContact2 = emergencyContact2;
	}

	public String getEContact2RelToPt() {
		return EContact2RelToPt;
	}

	public void setEContact2RelToPt(String eContact2RelToPt) {
		EContact2RelToPt = eContact2RelToPt;
	}

	public boolean isNextOfKin1() {
		return NextOfKin1;
	}

	public void setNextOfKin1(boolean nextOfKin1) {
		NextOfKin1 = nextOfKin1;
	}

	public String getNofKin1RelToPt() {
		return NofKin1RelToPt;
	}

	public void setNofKin1RelToPt(String nofKin1RelToPt) {
		NofKin1RelToPt = nofKin1RelToPt;
	}

	public boolean isNextofKin2() {
		return NextofKin2;
	}

	public void setNextofKin2(boolean nextofKin2) {
		NextofKin2 = nextofKin2;
	}

	public String getNofKin2RelToPt() {
		return NofKin2RelToPt;
	}

	public void setNofKin2RelToPt(String nofKin2RelToPt) {
		NofKin2RelToPt = nofKin2RelToPt;
	}

	public boolean isHasPreExistingConditions() {
		return HasPreExistingConditions;
	}

	public void setHasPreExistingConditions(boolean hasPreExistingConditions) {
		HasPreExistingConditions = hasPreExistingConditions;
	}

	public boolean isHasMedications() {
		return HasMedications;
	}

	public void setHasMedications(boolean hasMedications) {
		HasMedications = hasMedications;
	}

	public boolean isHasAllergies() {
		return HasAllergies;
	}

	public void setHasAllergies(boolean hasAllergies) {
		HasAllergies = hasAllergies;
	}

	public boolean isHasAdvanceDirectives() {
		return HasAdvanceDirectives;
	}

	public void setHasAdvanceDirectives(boolean hasAdvanceDirectives) {
		HasAdvanceDirectives = hasAdvanceDirectives;
	}

	public boolean isNeedsCarer() {
		return NeedsCarer;
	}

	public void setNeedsCarer(boolean needsCarer) {
		NeedsCarer = needsCarer;
	}

	public boolean isHasInternationalTravel() {
		return HasInternationalTravel;
	}

	public void setHasInternationalTravel(boolean hasInternationalTravel) {
		HasInternationalTravel = hasInternationalTravel;
	}

	public boolean isHasInterstateTravel() {
		return HasInterstateTravel;
	}

	public void setHasInterstateTravel(boolean hasInterstateTravel) {
		HasInterstateTravel = hasInterstateTravel;
	}

	public boolean isHasHighRiskFacilityVisit() {
		return HasHighRiskFacilityVisit;
	}

	public void setHasHighRiskFacilityVisit(boolean hasHighRiskFacilityVisit) {
		HasHighRiskFacilityVisit = hasHighRiskFacilityVisit;
	}

	public boolean isIsHighRiskHealthWorker() {
		return IsHighRiskHealthWorker;
	}

	public void setIsHighRiskHealthWorker(boolean isHighRiskHealthWorker) {
		IsHighRiskHealthWorker = isHighRiskHealthWorker;
	}

	public String getClinicalTrialStatus() {
		return ClinicalTrialStatus;
	}

	public void setClinicalTrialStatus(String clinicalTrialStatus) {
		ClinicalTrialStatus = clinicalTrialStatus;
	}

	public String getComments() {
		return Comments;
	}

	public void setComments(String comments) {
		Comments = comments;
	}
	
	

}
