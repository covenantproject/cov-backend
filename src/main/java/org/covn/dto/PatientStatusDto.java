package org.covn.dto;

import java.math.BigDecimal;
import java.sql.Timestamp;

import org.covn.model.type.AppHeartbeatStatus;
import org.covn.model.type.Covid19Status;
import org.covn.model.type.GeofenceStatus;
import org.covn.model.type.HealthStatus;
import org.covn.model.type.QuarIsltStatus;
import org.covn.model.type.RequestStatus;

public class PatientStatusDto {

	private String patientId;
	private AppHeartbeatStatus appHeartBeatStatus;
	private Covid19Status covid19Status;
	private GeofenceStatus geofenceStatus;
	private BigDecimal latitude; // precision = 10, scale = 8
	private BigDecimal longitude; // precision = 11, scale = 8
	private HealthStatus healthStatus;
	private QuarIsltStatus quarIsltStatus; //quarantine or isolation status
	private Timestamp quarIsltStartDateTime;
	private Timestamp quarIsltEndDateTime;
	private RequestStatus quarIsltRequestStatus;
	private RequestStatus medicalRequestStatus;
	private RequestStatus suppliesRequestStatus;
	
	private String comments;
	private Timestamp updatedDateTime;
	
	public String getPatientId() {
		return patientId;
	}
	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}
	public AppHeartbeatStatus getAppHeartBeatStatus() {
		return appHeartBeatStatus;
	}
	public void setAppHeartBeatStatus(AppHeartbeatStatus appHeartBeatStatus) {
		this.appHeartBeatStatus = appHeartBeatStatus;
	}
	public Covid19Status getCovid19Status() {
		return covid19Status;
	}
	public void setCovid19Status(Covid19Status covid19Status) {
		this.covid19Status = covid19Status;
	}
	public GeofenceStatus getGeofenceStatus() {
		return geofenceStatus;
	}
	public void setGeofenceStatus(GeofenceStatus geofenceStatus) {
		this.geofenceStatus = geofenceStatus;
	}
	public BigDecimal getLatitude() {
		return latitude;
	}
	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
	}
	public BigDecimal getLongitude() {
		return longitude;
	}
	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	}
	public HealthStatus getHealthStatus() {
		return healthStatus;
	}
	public void setHealthStatus(HealthStatus healthStatus) {
		this.healthStatus = healthStatus;
	}
	public QuarIsltStatus getQuarIsltStatus() {
		return quarIsltStatus;
	}
	public void setQuarIsltStatus(QuarIsltStatus quarIsltStatus) {
		this.quarIsltStatus = quarIsltStatus;
	}
	public Timestamp getQuarIsltStartDateTime() {
		return quarIsltStartDateTime;
	}
	public void setQuarIsltStartDateTime(Timestamp quarIsltStartDateTime) {
		this.quarIsltStartDateTime = quarIsltStartDateTime;
	}
	public Timestamp getQuarIsltEndDateTime() {
		return quarIsltEndDateTime;
	}
	public void setQuarIsltEndDateTime(Timestamp quarIsltEndDateTime) {
		this.quarIsltEndDateTime = quarIsltEndDateTime;
	}
	public RequestStatus getQuarIsltRequestStatus() {
		return quarIsltRequestStatus;
	}
	public void setQuarIsltRequestStatus(RequestStatus quarIsltRequestStatus) {
		this.quarIsltRequestStatus = quarIsltRequestStatus;
	}
	public RequestStatus getMedicalRequestStatus() {
		return medicalRequestStatus;
	}
	public void setMedicalRequestStatus(RequestStatus medicalRequestStatus) {
		this.medicalRequestStatus = medicalRequestStatus;
	}
	public RequestStatus getSuppliesRequestStatus() {
		return suppliesRequestStatus;
	}
	public void setSuppliesRequestStatus(RequestStatus suppliesRequestStatus) {
		this.suppliesRequestStatus = suppliesRequestStatus;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public Timestamp getUpdatedDateTime() {
		return updatedDateTime;
	}
	public void setUpdatedDateTime(Timestamp updatedDateTime) {
		this.updatedDateTime = updatedDateTime;
	}
	
	
	
}
