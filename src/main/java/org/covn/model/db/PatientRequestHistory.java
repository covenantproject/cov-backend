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
@Table(name = "patient_request_history", schema = "release1", uniqueConstraints={@UniqueConstraint(columnNames = {"patient_request_history_id"})
})
public class PatientRequestHistory extends BaseModel<PatientRequestHistory, Integer> implements java.io.Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "patient_request_history_id", nullable = false, length = 10)
	private Integer patientRequestHistoryId;

	@Column(name = "patient_id", nullable = false, length = 10, updatable = false, insertable = false)
	private Integer patientId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "patient_id")
	private Patient patient;

	@Column(name = "request_type", nullable = true, length = 16)
	private String requestType;

	@Column(name = "request_date_time", nullable = true, length = 29)
	private Timestamp requestDateTime;

	@Column(name = "request_status", nullable = true, length = 2147483647)
	private String requestStatus;

	@Column(name = "request_comments", nullable = true, length = 255)
	private String requestComments;

	@Column(name = "response_type", nullable = true, length = 16)
	private String responseType;

	@Column(name = "response_user_id", nullable = true, length = 10, updatable = false, insertable = false)
	private Integer responseUserId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "response_user_id")
	private Users users;

	@Column(name = "response_date_time", nullable = true, length = 29)
	private Timestamp responseDateTime;

	@Column(name = "response_comments", nullable = true, length = 255)
	private String responseComments;


	public Integer getPatientRequestHistoryId(){
		return this.patientRequestHistoryId;
	}
	public PatientRequestHistory setPatientRequestHistoryId(Integer patientRequestHistoryId){
		this.patientRequestHistoryId = patientRequestHistoryId;
		
		return this;
	}

	public Integer getPatientId(){
		return this.patientId;
	}
	public PatientRequestHistory setPatientId(Integer patientId){
		this.patientId = patientId;
		
		return this;
	}

	public Patient getPatient(){
		return this.patient;
	}
	public PatientRequestHistory setPatient(Patient patient){
		this.patient = patient;
		this.patientId = (this.patient == null)? null: this.patient.getPatientId();
		return this;
	}

	public String getRequestType(){
		return this.requestType;
	}
	public PatientRequestHistory setRequestType(String requestType){
		this.requestType = requestType;
		
		return this;
	}

	public Timestamp getRequestDateTime(){
		return this.requestDateTime;
	}
	public PatientRequestHistory setRequestDateTime(Timestamp requestDateTime){
		this.requestDateTime = requestDateTime;
		
		return this;
	}

	public String getRequestStatus(){
		return this.requestStatus;
	}
	public PatientRequestHistory setRequestStatus(String requestStatus){
		this.requestStatus = requestStatus;
		
		return this;
	}

	public String getRequestComments(){
		return this.requestComments;
	}
	public PatientRequestHistory setRequestComments(String requestComments){
		this.requestComments = requestComments;
		
		return this;
	}

	public String getResponseType(){
		return this.responseType;
	}
	public PatientRequestHistory setResponseType(String responseType){
		this.responseType = responseType;
		
		return this;
	}

	public Integer getResponseUserId(){
		return this.responseUserId;
	}
	public PatientRequestHistory setResponseUserId(Integer responseUserId){
		this.responseUserId = responseUserId;
		
		return this;
	}

	public Users getUsers(){
		return this.users;
	}
	public PatientRequestHistory setUsers(Users users){
		this.users = users;
		this.responseUserId = (this.users == null)? null: this.users.getUserId();
		return this;
	}

	public Timestamp getResponseDateTime(){
		return this.responseDateTime;
	}
	public PatientRequestHistory setResponseDateTime(Timestamp responseDateTime){
		this.responseDateTime = responseDateTime;
		
		return this;
	}

	public String getResponseComments(){
		return this.responseComments;
	}
	public PatientRequestHistory setResponseComments(String responseComments){
		this.responseComments = responseComments;
		
		return this;
	}


	@Override
	public Integer getKey() {
		return this.patientRequestHistoryId;
	}

	
	public static PatientRequestHistory of(){
		return new PatientRequestHistory();
	}
	
	public static PatientRequestHistory copy(PatientRequestHistory src, int depth){
		PatientRequestHistory copy = null;
		if(depth > 0){
			copy = new PatientRequestHistory();
			copy.patientRequestHistoryId = src.getPatientRequestHistoryId();
			copy.patientId = src.getPatientId();
			copy.patient = (src.getPatient() == null)? null : Patient.copy(src.getPatient(), --depth);
			copy.requestType = src.getRequestType();
			copy.requestDateTime = src.getRequestDateTime();
			copy.requestStatus = src.getRequestStatus();
			copy.requestComments = src.getRequestComments();
			copy.responseType = src.getResponseType();
			copy.responseUserId = src.getResponseUserId();
			copy.users = (src.getUsers() == null)? null : Users.copy(src.getUsers(), --depth);
			copy.responseDateTime = src.getResponseDateTime();
			copy.responseComments = src.getResponseComments();
		}
		return copy;
	}

	@Override
	public PatientRequestHistory copy() {
		return copy(this, copyDepth);
	}	
}