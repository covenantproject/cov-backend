package org.covn.model.db;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.UniqueConstraint;
import javax.persistence.JoinColumn;
import java.sql.Timestamp;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import java.math.BigDecimal;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.SequenceGenerator;
import javax.persistence.FetchType;
import org.covn.model.BaseModel;
import javax.persistence.Id;

import java.io.Serializable;


@Entity
@Table(name = "patient_status", schema = "release1", uniqueConstraints={@UniqueConstraint(columnNames = {"patient_status_id"})
})
public class PatientStatus extends BaseModel<PatientStatus, Integer> implements java.io.Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "patient_status_id", nullable = false, length = 10)
	private Integer patientStatusId;

	@Column(name = "patient_id", nullable = false, length = 10, updatable = false, insertable = false)
	private Integer patientId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "patient_id")
	private Patient patient;

	@Column(name = "covid19_status", nullable = true, length = 32)
	private String covid19Status;

	@Column(name = "health_status", nullable = true, length = 32)
	private String healthStatus;

	@Column(name = "quar_islt_status", nullable = true, length = 32)
	private String quarIsltStatus;

	@Column(name = "quar_islt_start_date_time", nullable = true, length = 29)
	private Timestamp quarIsltStartDateTime;

	@Column(name = "quar_islt_end_date_time", nullable = true, length = 29)
	private Timestamp quarIsltEndDateTime;

	@Column(name = "quar_islt_request_status", nullable = true, length = 32)
	private String quarIsltRequestStatus;

	@Column(name = "medical_request_status", nullable = true, length = 32)
	private String medicalRequestStatus;

	@Column(name = "supplies_request_status", nullable = true, length = 32)
	private String suppliesRequestStatus;

	@Column(name = "geofence_status", nullable = true, length = 16)
	private String geofenceStatus;

	@Column(name = "app_heartbeat_status", nullable = true, length = 16)
	private String appHeartbeatStatus;

	@Column(name = "updated_date_time", nullable = true, length = 29)
	private Timestamp updatedDateTime;

	@Column(name = "latitude", nullable = true, precision = 10, scale = 8)
	private BigDecimal latitude;

	@Column(name = "longitude", nullable = true, precision = 11, scale = 8)
	private BigDecimal longitude;

	@Column(name = "comments", nullable = true, length = 128)
	private String comments;


	public Integer getPatientStatusId(){
		return this.patientStatusId;
	}
	public PatientStatus setPatientStatusId(Integer patientStatusId){
		this.patientStatusId = patientStatusId;
		
		return this;
	}

	public Integer getPatientId(){
		return this.patientId;
	}
	public PatientStatus setPatientId(Integer patientId){
		this.patientId = patientId;
		
		return this;
	}

	public Patient getPatient(){
		return this.patient;
	}
	public PatientStatus setPatient(Patient patient){
		this.patient = patient;
		this.patientId = (this.patient == null)? null: this.patient.getPatientId();
		return this;
	}

	public String getCovid19Status(){
		return this.covid19Status;
	}
	public PatientStatus setCovid19Status(String covid19Status){
		this.covid19Status = covid19Status;
		
		return this;
	}

	public String getHealthStatus(){
		return this.healthStatus;
	}
	public PatientStatus setHealthStatus(String healthStatus){
		this.healthStatus = healthStatus;
		
		return this;
	}

	public String getQuarIsltStatus(){
		return this.quarIsltStatus;
	}
	public PatientStatus setQuarIsltStatus(String quarIsltStatus){
		this.quarIsltStatus = quarIsltStatus;
		
		return this;
	}

	public Timestamp getQuarIsltStartDateTime(){
		return this.quarIsltStartDateTime;
	}
	public PatientStatus setQuarIsltStartDateTime(Timestamp quarIsltStartDateTime){
		this.quarIsltStartDateTime = quarIsltStartDateTime;
		
		return this;
	}

	public Timestamp getQuarIsltEndDateTime(){
		return this.quarIsltEndDateTime;
	}
	public PatientStatus setQuarIsltEndDateTime(Timestamp quarIsltEndDateTime){
		this.quarIsltEndDateTime = quarIsltEndDateTime;
		
		return this;
	}

	public String getQuarIsltRequestStatus(){
		return this.quarIsltRequestStatus;
	}
	public PatientStatus setQuarIsltRequestStatus(String quarIsltRequestStatus){
		this.quarIsltRequestStatus = quarIsltRequestStatus;
		
		return this;
	}

	public String getMedicalRequestStatus(){
		return this.medicalRequestStatus;
	}
	public PatientStatus setMedicalRequestStatus(String medicalRequestStatus){
		this.medicalRequestStatus = medicalRequestStatus;
		
		return this;
	}

	public String getSuppliesRequestStatus(){
		return this.suppliesRequestStatus;
	}
	public PatientStatus setSuppliesRequestStatus(String suppliesRequestStatus){
		this.suppliesRequestStatus = suppliesRequestStatus;
		
		return this;
	}

	public String getGeofenceStatus(){
		return this.geofenceStatus;
	}
	public PatientStatus setGeofenceStatus(String geofenceStatus){
		this.geofenceStatus = geofenceStatus;
		
		return this;
	}

	public String getAppHeartbeatStatus(){
		return this.appHeartbeatStatus;
	}
	public PatientStatus setAppHeartbeatStatus(String appHeartbeatStatus){
		this.appHeartbeatStatus = appHeartbeatStatus;
		
		return this;
	}

	public Timestamp getUpdatedDateTime(){
		return this.updatedDateTime;
	}
	public PatientStatus setUpdatedDateTime(Timestamp updatedDateTime){
		this.updatedDateTime = updatedDateTime;
		
		return this;
	}

	public BigDecimal getLatitude(){
		return this.latitude;
	}
	public PatientStatus setLatitude(BigDecimal latitude){
		this.latitude = latitude;
		
		return this;
	}

	public BigDecimal getLongitude(){
		return this.longitude;
	}
	public PatientStatus setLongitude(BigDecimal longitude){
		this.longitude = longitude;
		
		return this;
	}

	public String getComments(){
		return this.comments;
	}
	public PatientStatus setComments(String comments){
		this.comments = comments;
		
		return this;
	}


	@Override
	public Integer getKey() {
		return this.patientStatusId;
	}

	
	public static PatientStatus of(){
		return new PatientStatus();
	}
	
	public static PatientStatus copy(PatientStatus src, int depth){
		PatientStatus copy = null;
		if(depth > 0){
			copy = new PatientStatus();
			copy.patientStatusId = src.getPatientStatusId();
			copy.patientId = src.getPatientId();
			copy.patient = (src.getPatient() == null)? null : Patient.copy(src.getPatient(), --depth);
			copy.covid19Status = src.getCovid19Status();
			copy.healthStatus = src.getHealthStatus();
			copy.quarIsltStatus = src.getQuarIsltStatus();
			copy.quarIsltStartDateTime = src.getQuarIsltStartDateTime();
			copy.quarIsltEndDateTime = src.getQuarIsltEndDateTime();
			copy.quarIsltRequestStatus = src.getQuarIsltRequestStatus();
			copy.medicalRequestStatus = src.getMedicalRequestStatus();
			copy.suppliesRequestStatus = src.getSuppliesRequestStatus();
			copy.geofenceStatus = src.getGeofenceStatus();
			copy.appHeartbeatStatus = src.getAppHeartbeatStatus();
			copy.updatedDateTime = src.getUpdatedDateTime();
			copy.latitude = src.getLatitude();
			copy.longitude = src.getLongitude();
			copy.comments = src.getComments();
		}
		return copy;
	}

	@Override
	public PatientStatus copy() {
		return copy(this, copyDepth);
	}	
}