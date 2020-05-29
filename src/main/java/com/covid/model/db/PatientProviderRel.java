package com.covid.model.db;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import com.covid.model.BaseModel;
import javax.persistence.UniqueConstraint;
import javax.persistence.JoinColumn;
import java.sql.Timestamp;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.SequenceGenerator;
import javax.persistence.FetchType;
import javax.persistence.Id;

import java.io.Serializable;


@Entity
@Table(name = "patient_provider_rel", schema = "release1", uniqueConstraints={@UniqueConstraint(columnNames = {"pat_pro_rel_id"})
})
public class PatientProviderRel extends BaseModel<PatientProviderRel, Integer> implements java.io.Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pat_pro_rel_id", nullable = false, length = 10)
	private Integer patProRelId;

	@Column(name = "patient_id", nullable = true, length = 10, updatable = false, insertable = false)
	private Integer patientId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "patient_id")
	private Patient patient;

	@Column(name = "health_pro_id", nullable = true, length = 10, updatable = false, insertable = false)
	private Integer healthProId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "health_pro_id")
	private HealthPro healthPro;

	@Column(name = "rel_type", nullable = true, length = 15)
	private String relType;

	@Column(name = "rel_start_date", nullable = true, length = 29)
	private Timestamp relStartDate;

	@Column(name = "rel_end_date", nullable = true, length = 29)
	private Timestamp relEndDate;

	@Column(name = "rel_fac_location", nullable = true, length = 10, updatable = false, insertable = false)
	private Integer relFacLocation;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "rel_fac_location")
	private LocationHierarchy locationHierarchy;


	public Integer getPatProRelId(){
		return this.patProRelId;
	}
	public PatientProviderRel setPatProRelId(Integer patProRelId){
		this.patProRelId = patProRelId;
		
		return this;
	}

	public Integer getPatientId(){
		return this.patientId;
	}
	public PatientProviderRel setPatientId(Integer patientId){
		this.patientId = patientId;
		
		return this;
	}

	public Patient getPatient(){
		return this.patient;
	}
	public PatientProviderRel setPatient(Patient patient){
		this.patient = patient;
		this.patientId = (this.patient == null)? null: this.patient.getPatientId();
		return this;
	}

	public Integer getHealthProId(){
		return this.healthProId;
	}
	public PatientProviderRel setHealthProId(Integer healthProId){
		this.healthProId = healthProId;
		
		return this;
	}

	public HealthPro getHealthPro(){
		return this.healthPro;
	}
	public PatientProviderRel setHealthPro(HealthPro healthPro){
		this.healthPro = healthPro;
		this.healthProId = (this.healthPro == null)? null: this.healthPro.getHealthProId();
		return this;
	}

	public String getRelType(){
		return this.relType;
	}
	public PatientProviderRel setRelType(String relType){
		this.relType = relType;
		
		return this;
	}

	public Timestamp getRelStartDate(){
		return this.relStartDate;
	}
	public PatientProviderRel setRelStartDate(Timestamp relStartDate){
		this.relStartDate = relStartDate;
		
		return this;
	}

	public Timestamp getRelEndDate(){
		return this.relEndDate;
	}
	public PatientProviderRel setRelEndDate(Timestamp relEndDate){
		this.relEndDate = relEndDate;
		
		return this;
	}

	public Integer getRelFacLocation(){
		return this.relFacLocation;
	}
	public PatientProviderRel setRelFacLocation(Integer relFacLocation){
		this.relFacLocation = relFacLocation;
		
		return this;
	}

	public LocationHierarchy getLocationHierarchy(){
		return this.locationHierarchy;
	}
	public PatientProviderRel setLocationHierarchy(LocationHierarchy locationHierarchy){
		this.locationHierarchy = locationHierarchy;
		this.relFacLocation = (this.locationHierarchy == null)? null: this.locationHierarchy.getLocationId();
		return this;
	}


	@Override
	public Integer getKey() {
		return this.patProRelId;
	}
	
	public static PatientProviderRel of(){
		return new PatientProviderRel();
	}
}