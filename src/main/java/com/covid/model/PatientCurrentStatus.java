package com.covid.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="\"PatientCurrentStatus\"")
public class PatientCurrentStatus {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="\"PatientCurrentStatusId\"")
	private long PatientCurrentStatusId;
	
	@Column(name="\"PatientId\"")
	private long patientId;
	
	@Column(name="\"COVID19Status\"")
	private String COVID19Status;
	
	@Column(name="\"PatientType\"")
	private String PatientType;
	
	@Column(name="\"CurrentQuarantineStatus\"")
	private String CurrentQuarantineStatus;
	
	@Column(name="\"CurrentIsolationStatus\"")
	private String CurrentIsolationStatus;
	
	@Column(name="\"QuarantineStartDateTime\"")
	private Date QuarantineStartDateTime;
	
	@Column(name="\"QuarantineEndDateTime\"")
	private Date QuarantineEndDateTime;
	
	@Column(name="\"IsolationStartDateTime\"")
	private Date IsolationStartDateTime;
	
	@Column(name="\"IsolationEndDateTime\"")
	private Date IsolationEndDateTime;

	public long getPatientCurrentStatusId() {
		return PatientCurrentStatusId;
	}

	public void setPatientCurrentStatusId(long patientCurrentStatusId) {
		PatientCurrentStatusId = patientCurrentStatusId;
	}


	public long getPatientId() {
		return patientId;
	}

	public void setPatientId(long patientId) {
		this.patientId = patientId;
	}

	public String getCOVID19Status() {
		return COVID19Status;
	}

	public void setCOVID19Status(String cOVID19Status) {
		COVID19Status = cOVID19Status;
	}

	public String getPatientType() {
		return PatientType;
	}

	public void setPatientType(String patientType) {
		PatientType = patientType;
	}

	public String getCurrentQuarantineStatus() {
		return CurrentQuarantineStatus;
	}

	public void setCurrentQuarantineStatus(String currentQuarantineStatus) {
		CurrentQuarantineStatus = currentQuarantineStatus;
	}

	public String getCurrentIsolationStatus() {
		return CurrentIsolationStatus;
	}

	public void setCurrentIsolationStatus(String currentIsolationStatus) {
		CurrentIsolationStatus = currentIsolationStatus;
	}

	public Date getQuarantineStartDateTime() {
		return QuarantineStartDateTime;
	}

	public void setQuarantineStartDateTime(Date quarantineStartDateTime) {
		QuarantineStartDateTime = quarantineStartDateTime;
	}

	public Date getQuarantineEndDateTime() {
		return QuarantineEndDateTime;
	}

	public void setQuarantineEndDateTime(Date quarantineEndDateTime) {
		QuarantineEndDateTime = quarantineEndDateTime;
	}

	public Date getIsolationStartDateTime() {
		return IsolationStartDateTime;
	}

	public void setIsolationStartDateTime(Date isolationStartDateTime) {
		IsolationStartDateTime = isolationStartDateTime;
	}

	public Date getIsolationEndDateTime() {
		return IsolationEndDateTime;
	}

	public void setIsolationEndDateTime(Date isolationEndDateTime) {
		IsolationEndDateTime = isolationEndDateTime;
	}
	
}
