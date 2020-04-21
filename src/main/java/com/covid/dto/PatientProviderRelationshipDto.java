package com.covid.dto;

import java.util.Date;

public class PatientProviderRelationshipDto {
	
	private int patientId;
	private int providerId;
	private String relationshipType;
	private int locationId;
	private Date relationshipStartDate;
	private Date relationshipEndDate;
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public int getProviderId() {
		return providerId;
	}
	public void setProviderId(int providerId) {
		this.providerId = providerId;
	}
	public String getRelationshipType() {
		return relationshipType;
	}
	public void setRelationshipType(String relationshipType) {
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
