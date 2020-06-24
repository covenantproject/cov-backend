package org.covn.dto;

import org.covn.model.type.PersonalRelationshipType;

public class DemographicsDto {
	private int userId;
	private int emergencyContact1UserId;
	private PersonalRelationshipType emergencyContact1RelToPatient;
	private int emergencyContact2UserId;
	private PersonalRelationshipType emergencyContact2RelToPatient;
	private int nextOfKin1UserId;
	private PersonalRelationshipType nextOfKin1RelToPatient;
	private int nextOfKin2UserId;
	private PersonalRelationshipType nextOfKin2RelToPatient;
	private String nationality;
	private String residencyStatus;
	private String occupation;
	private String comments;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getEmergencyContact1UserId() {
		return emergencyContact1UserId;
	}
	public void setEmergencyContact1UserId(int emergencyContact1UserId) {
		this.emergencyContact1UserId = emergencyContact1UserId;
	}
	public PersonalRelationshipType getEmergencyContact1RelToPatient() {
		return emergencyContact1RelToPatient;
	}
	public void setEmergencyContact1RelToPatient(PersonalRelationshipType emergencyContact1RelToPatient) {
		this.emergencyContact1RelToPatient = emergencyContact1RelToPatient;
	}
	public int getEmergencyContact2UserId() {
		return emergencyContact2UserId;
	}
	public void setEmergencyContact2UserId(int emergencyContact2UserId) {
		this.emergencyContact2UserId = emergencyContact2UserId;
	}
	public PersonalRelationshipType getEmergencyContact2RelToPatient() {
		return emergencyContact2RelToPatient;
	}
	public void setEmergencyContact2RelToPatient(PersonalRelationshipType emergencyContact2RelToPatient) {
		this.emergencyContact2RelToPatient = emergencyContact2RelToPatient;
	}
	public int getNextOfKin1UserId() {
		return nextOfKin1UserId;
	}
	public void setNextOfKin1UserId(int nextOfKin1UserId) {
		this.nextOfKin1UserId = nextOfKin1UserId;
	}
	public PersonalRelationshipType getNextOfKin1RelToPatient() {
		return nextOfKin1RelToPatient;
	}
	public void setNextOfKin1RelToPatient(PersonalRelationshipType nextOfKin1RelToPatient) {
		this.nextOfKin1RelToPatient = nextOfKin1RelToPatient;
	}
	public int getNextOfKin2UserId() {
		return nextOfKin2UserId;
	}
	public void setNextOfKin2UserId(int nextOfKin2UserId) {
		this.nextOfKin2UserId = nextOfKin2UserId;
	}
	public PersonalRelationshipType getNextOfKin2RelToPatient() {
		return nextOfKin2RelToPatient;
	}
	public void setNextOfKin2RelToPatient(PersonalRelationshipType nextOfKin2RelToPatient) {
		this.nextOfKin2RelToPatient = nextOfKin2RelToPatient;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public String getResidencyStatus() {
		return residencyStatus;
	}
	public void setResidencyStatus(String residencyStatus) {
		this.residencyStatus = residencyStatus;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	
	
	
}
