package org.covn.dto;

import java.util.Date;

import org.covn.model.type.PatientProviderRelType;

public class PatientProviderRelationshipDto {
	
	private int patientId;
	private int providerJobId;
	private PatientProviderRelType relationshipType;
	private int locationId;
	private Date relationshipStartDate;
	private Date relationshipEndDate;
	
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public int getProviderJobId() {
		return providerJobId;
	}
	public void setProviderJobId(int providerJobId) {
		this.providerJobId = providerJobId;
	}
	public PatientProviderRelType getRelationshipType() {
		return relationshipType;
	}
	public void setRelationshipType(PatientProviderRelType relationshipType) {
		this.relationshipType = relationshipType;
	}
	public int getLocationId() {
		return locationId;
	}
	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}
	public Date getRelationshipStartDate() {
		return relationshipStartDate;
	}
	public void setRelationshipStartDate(Date relationshipStartDate) {
		this.relationshipStartDate = relationshipStartDate;
	}
	public Date getRelationshipEndDate() {
		return relationshipEndDate;
	}
	public void setRelationshipEndDate(Date relationshipEndDate) {
		this.relationshipEndDate = relationshipEndDate;
	}


}
