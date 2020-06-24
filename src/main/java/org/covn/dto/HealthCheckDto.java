package org.covn.dto;

import java.sql.Timestamp;

public class HealthCheckDto {
	
	private int patientId;
	private boolean coughPresent;
	private boolean feverPresent;
	private boolean breathingDifficultyPresent;
	private String progressStatus;
	
	// logistics
	private int locationId;
	private int appHeartbeatId;
	private int enteredByUserId;
	private String healthCheckByUserType; // type of user who did the health check
	private Timestamp healthCheckDateTime;
	private String healthCheckReason;
	
	// following health fields are optional
	private double temperatureCelsius;
	private int heartRate; // heart/pulse rate per minute
	private int respRate; // respiratory rate per minute
	private int spO2; // peripheral oxygen saturation percentage
	private int systolicBP; // systolic blood pressure mmHg
	private int diastolicBP; // diastolic blood pressure mmHg
	private String comments;
	
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public boolean isCoughPresent() {
		return coughPresent;
	}
	public void setCoughPresent(boolean coughPresent) {
		this.coughPresent = coughPresent;
	}
	public boolean isFeverPresent() {
		return feverPresent;
	}
	public void setFeverPresent(boolean feverPresent) {
		this.feverPresent = feverPresent;
	}
	public boolean isBreathingDifficultyPresent() {
		return breathingDifficultyPresent;
	}
	public void setBreathingDifficultyPresent(boolean breathingDifficultyPresent) {
		this.breathingDifficultyPresent = breathingDifficultyPresent;
	}
	public String getProgressStatus() {
		return progressStatus;
	}
	public void setProgressStatus(String progressStatus) {
		this.progressStatus = progressStatus;
	}
	public int getLocationId() {
		return locationId;
	}
	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}
	public int getAppHeartbeatId() {
		return appHeartbeatId;
	}
	public void setAppHeartbeatId(int appHeartbeatId) {
		this.appHeartbeatId = appHeartbeatId;
	}
	public int getEnteredByUserId() {
		return enteredByUserId;
	}
	public void setEnteredByUserId(int enteredByUserId) {
		this.enteredByUserId = enteredByUserId;
	}
	public String getHealthCheckByUserType() {
		return healthCheckByUserType;
	}
	public void setHealthCheckByUserType(String healthCheckByUserType) {
		this.healthCheckByUserType = healthCheckByUserType;
	}
	public Timestamp getHealthCheckDateTime() {
		return healthCheckDateTime;
	}
	public void setHealthCheckDateTime(Timestamp healthCheckDateTime) {
		this.healthCheckDateTime = healthCheckDateTime;
	}
	public String getHealthCheckReason() {
		return healthCheckReason;
	}
	public void setHealthCheckReason(String healthCheckReason) {
		this.healthCheckReason = healthCheckReason;
	}
	public double getTemperatureCelsius() {
		return temperatureCelsius;
	}
	public void setTemperatureCelsius(double temperatureCelsius) {
		this.temperatureCelsius = temperatureCelsius;
	}
	public int getHeartRate() {
		return heartRate;
	}
	public void setHeartRate(int heartRate) {
		this.heartRate = heartRate;
	}
	public int getRespRate() {
		return respRate;
	}
	public void setRespRate(int respRate) {
		this.respRate = respRate;
	}
	public int getSpO2() {
		return spO2;
	}
	public void setSpO2(int spO2) {
		this.spO2 = spO2;
	}
	public int getSystolicBP() {
		return systolicBP;
	}
	public void setSystolicBP(int systolicBP) {
		this.systolicBP = systolicBP;
	}
	public int getDiastolicBP() {
		return diastolicBP;
	}
	public void setDiastolicBP(int diastolicBP) {
		this.diastolicBP = diastolicBP;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	
	

}
