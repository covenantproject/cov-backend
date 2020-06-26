package org.covn.model.db;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.UniqueConstraint;
import javax.persistence.JoinColumn;
import java.sql.Timestamp;
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
@Table(name = "health_check_history", schema = "release1", uniqueConstraints={@UniqueConstraint(columnNames = {"health_history_id"})
})
public class HealthCheckHistory extends BaseModel<HealthCheckHistory, Integer> implements java.io.Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "health_history_id", nullable = false, length = 10)
	private Integer healthHistoryId;

	@Column(name = "patient_id", nullable = false, length = 10, updatable = false, insertable = false)
	private Integer patientId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "patient_id")
	private Patient patient;

	@Column(name = "entered_by_user_id", nullable = true, length = 10, updatable = false, insertable = false)
	private Integer enteredByUserId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "entered_by_user_id")
	private Users users;

	@Column(name = "health_check_by_user_type", nullable = true, length = 32)
	private String healthCheckByUserType;

	@Column(name = "app_heartbeat_id", nullable = true, length = 10, updatable = false, insertable = false)
	private Integer appHeartbeatId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "app_heartbeat_id")
	private AppHeartbeat appHeartbeat;

	@Column(name = "location_id", nullable = true, length = 10, updatable = false, insertable = false)
	private Integer locationId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "location_id")
	private LocationHierarchy locationHierarchy;

	@Column(name = "health_check_date_time", nullable = true, length = 29)
	private Timestamp healthCheckDateTime;

	@Column(name = "health_check_reason", nullable = true, length = 255)
	private String healthCheckReason;

	@Column(name = "cough_present", nullable = true)
	private Boolean coughPresent;

	@Column(name = "fever_present", nullable = true)
	private Boolean feverPresent;

	@Column(name = "breathing_difficulty_present", nullable = true)
	private Boolean breathingDifficultyPresent;

	@Column(name = "progress_status", nullable = true, length = 32)
	private String progressStatus;

	@Column(name = "temperature_celsius", nullable = true, length = 17)
	private Double temperatureCelsius;

	@Column(name = "heart_rate_per_min", nullable = true, length = 10)
	private Integer heartRatePerMin;

	@Column(name = "resp_rate_per_min", nullable = true, length = 10)
	private Integer respRatePerMin;

	@Column(name = "spo2_percent", nullable = true, length = 10)
	private Integer spo2Percent;

	@Column(name = "systolic_bp_mmhg", nullable = true, length = 10)
	private Integer systolicBpMmhg;

	@Column(name = "diastolic_bp_mmhg", nullable = true, length = 10)
	private Integer diastolicBpMmhg;

	@Column(name = "comments", nullable = true, length = 255)
	private String comments;


	public Integer getHealthHistoryId(){
		return this.healthHistoryId;
	}
	public HealthCheckHistory setHealthHistoryId(Integer healthHistoryId){
		this.healthHistoryId = healthHistoryId;
		
		return this;
	}

	public Integer getPatientId(){
		return this.patientId;
	}
	public HealthCheckHistory setPatientId(Integer patientId){
		this.patientId = patientId;
		
		return this;
	}

	public Patient getPatient(){
		return this.patient;
	}
	public HealthCheckHistory setPatient(Patient patient){
		this.patient = patient;
		this.patientId = (this.patient == null)? null: this.patient.getPatientId();
		return this;
	}

	public Integer getEnteredByUserId(){
		return this.enteredByUserId;
	}
	public HealthCheckHistory setEnteredByUserId(Integer enteredByUserId){
		this.enteredByUserId = enteredByUserId;
		
		return this;
	}

	public Users getUsers(){
		return this.users;
	}
	public HealthCheckHistory setUsers(Users users){
		this.users = users;
		this.enteredByUserId = (this.users == null)? null: this.users.getUserId();
		return this;
	}

	public String getHealthCheckByUserType(){
		return this.healthCheckByUserType;
	}
	public HealthCheckHistory setHealthCheckByUserType(String healthCheckByUserType){
		this.healthCheckByUserType = healthCheckByUserType;
		
		return this;
	}

	public Integer getAppHeartbeatId(){
		return this.appHeartbeatId;
	}
	public HealthCheckHistory setAppHeartbeatId(Integer appHeartbeatId){
		this.appHeartbeatId = appHeartbeatId;
		
		return this;
	}

	public AppHeartbeat getAppHeartbeat(){
		return this.appHeartbeat;
	}
	public HealthCheckHistory setAppHeartbeat(AppHeartbeat appHeartbeat){
		this.appHeartbeat = appHeartbeat;
		this.appHeartbeatId = (this.appHeartbeat == null)? null: this.appHeartbeat.getAppHeartbeatId();
		return this;
	}

	public Integer getLocationId(){
		return this.locationId;
	}
	public HealthCheckHistory setLocationId(Integer locationId){
		this.locationId = locationId;
		
		return this;
	}

	public LocationHierarchy getLocationHierarchy(){
		return this.locationHierarchy;
	}
	public HealthCheckHistory setLocationHierarchy(LocationHierarchy locationHierarchy){
		this.locationHierarchy = locationHierarchy;
		this.locationId = (this.locationHierarchy == null)? null: this.locationHierarchy.getLocationId();
		return this;
	}

	public Timestamp getHealthCheckDateTime(){
		return this.healthCheckDateTime;
	}
	public HealthCheckHistory setHealthCheckDateTime(Timestamp healthCheckDateTime){
		this.healthCheckDateTime = healthCheckDateTime;
		
		return this;
	}

	public String getHealthCheckReason(){
		return this.healthCheckReason;
	}
	public HealthCheckHistory setHealthCheckReason(String healthCheckReason){
		this.healthCheckReason = healthCheckReason;
		
		return this;
	}

	public Boolean getCoughPresent(){
		return this.coughPresent;
	}
	public HealthCheckHistory setCoughPresent(Boolean coughPresent){
		this.coughPresent = coughPresent;
		
		return this;
	}

	public Boolean getFeverPresent(){
		return this.feverPresent;
	}
	public HealthCheckHistory setFeverPresent(Boolean feverPresent){
		this.feverPresent = feverPresent;
		
		return this;
	}

	public Boolean getBreathingDifficultyPresent(){
		return this.breathingDifficultyPresent;
	}
	public HealthCheckHistory setBreathingDifficultyPresent(Boolean breathingDifficultyPresent){
		this.breathingDifficultyPresent = breathingDifficultyPresent;
		
		return this;
	}

	public String getProgressStatus(){
		return this.progressStatus;
	}
	public HealthCheckHistory setProgressStatus(String progressStatus){
		this.progressStatus = progressStatus;
		
		return this;
	}

	public Double getTemperatureCelsius(){
		return this.temperatureCelsius;
	}
	public HealthCheckHistory setTemperatureCelsius(Double temperatureCelsius){
		this.temperatureCelsius = temperatureCelsius;
		
		return this;
	}

	public Integer getHeartRatePerMin(){
		return this.heartRatePerMin;
	}
	public HealthCheckHistory setHeartRatePerMin(Integer heartRatePerMin){
		this.heartRatePerMin = heartRatePerMin;
		
		return this;
	}

	public Integer getRespRatePerMin(){
		return this.respRatePerMin;
	}
	public HealthCheckHistory setRespRatePerMin(Integer respRatePerMin){
		this.respRatePerMin = respRatePerMin;
		
		return this;
	}

	public Integer getSpo2Percent(){
		return this.spo2Percent;
	}
	public HealthCheckHistory setSpo2Percent(Integer spo2Percent){
		this.spo2Percent = spo2Percent;
		
		return this;
	}

	public Integer getSystolicBpMmhg(){
		return this.systolicBpMmhg;
	}
	public HealthCheckHistory setSystolicBpMmhg(Integer systolicBpMmhg){
		this.systolicBpMmhg = systolicBpMmhg;
		
		return this;
	}

	public Integer getDiastolicBpMmhg(){
		return this.diastolicBpMmhg;
	}
	public HealthCheckHistory setDiastolicBpMmhg(Integer diastolicBpMmhg){
		this.diastolicBpMmhg = diastolicBpMmhg;
		
		return this;
	}

	public String getComments(){
		return this.comments;
	}
	public HealthCheckHistory setComments(String comments){
		this.comments = comments;
		
		return this;
	}


	@Override
	public Integer getKey() {
		return this.healthHistoryId;
	}

	
	public static HealthCheckHistory of(){
		return new HealthCheckHistory();
	}
	
	public static HealthCheckHistory copy(HealthCheckHistory src, int depth){
		HealthCheckHistory copy = null;
		if(depth > 0){
			copy = new HealthCheckHistory();
			copy.healthHistoryId = src.getHealthHistoryId();
			copy.patientId = src.getPatientId();
			copy.patient = (src.getPatient() == null)? null : Patient.copy(src.getPatient(), --depth);
			copy.enteredByUserId = src.getEnteredByUserId();
			copy.users = (src.getUsers() == null)? null : Users.copy(src.getUsers(), --depth);
			copy.healthCheckByUserType = src.getHealthCheckByUserType();
			copy.appHeartbeatId = src.getAppHeartbeatId();
			copy.appHeartbeat = (src.getAppHeartbeat() == null)? null : AppHeartbeat.copy(src.getAppHeartbeat(), --depth);
			copy.locationId = src.getLocationId();
			copy.locationHierarchy = (src.getLocationHierarchy() == null)? null : LocationHierarchy.copy(src.getLocationHierarchy(), --depth);
			copy.healthCheckDateTime = src.getHealthCheckDateTime();
			copy.healthCheckReason = src.getHealthCheckReason();
			copy.coughPresent = src.getCoughPresent();
			copy.feverPresent = src.getFeverPresent();
			copy.breathingDifficultyPresent = src.getBreathingDifficultyPresent();
			copy.progressStatus = src.getProgressStatus();
			copy.temperatureCelsius = src.getTemperatureCelsius();
			copy.heartRatePerMin = src.getHeartRatePerMin();
			copy.respRatePerMin = src.getRespRatePerMin();
			copy.spo2Percent = src.getSpo2Percent();
			copy.systolicBpMmhg = src.getSystolicBpMmhg();
			copy.diastolicBpMmhg = src.getDiastolicBpMmhg();
			copy.comments = src.getComments();
		}
		return copy;
	}

	@Override
	public HealthCheckHistory copy() {
		return copy(this, copyDepth);
	}	
}