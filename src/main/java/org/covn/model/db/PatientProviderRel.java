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

	@Column(name = "health_pro_job_id", nullable = true, length = 10, updatable = false, insertable = false)
	private Integer healthProJobId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "health_pro_job_id")
	private HealthPro healthPro;

	@Column(name = "rel_type", nullable = true, length = 32)
	private String relType;

	@Column(name = "rel_start_date", nullable = true, length = 29)
	private Timestamp relStartDate;

	@Column(name = "rel_end_date", nullable = true, length = 29)
	private Timestamp relEndDate;

	@Column(name = "location_id", nullable = true, length = 10, updatable = false, insertable = false)
	private Integer locationId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "location_id")
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

	public Integer getHealthProJobId(){
		return this.healthProJobId;
	}
	public PatientProviderRel setHealthProJobId(Integer healthProJobId){
		this.healthProJobId = healthProJobId;
		
		return this;
	}

	public HealthPro getHealthPro(){
		return this.healthPro;
	}
	public PatientProviderRel setHealthPro(HealthPro healthPro){
		this.healthPro = healthPro;
		this.healthProJobId = (this.healthPro == null)? null: this.healthPro.getHealthProJobId();
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

	public Integer getLocationId(){
		return this.locationId;
	}
	public PatientProviderRel setLocationId(Integer locationId){
		this.locationId = locationId;
		
		return this;
	}

	public LocationHierarchy getLocationHierarchy(){
		return this.locationHierarchy;
	}
	public PatientProviderRel setLocationHierarchy(LocationHierarchy locationHierarchy){
		this.locationHierarchy = locationHierarchy;
		this.locationId = (this.locationHierarchy == null)? null: this.locationHierarchy.getLocationId();
		return this;
	}


	@Override
	public Integer getKey() {
		return this.patProRelId;
	}

	
	public static PatientProviderRel of(){
		return new PatientProviderRel();
	}
	
	public static PatientProviderRel copy(PatientProviderRel src, int depth){
		PatientProviderRel copy = null;
		if(depth > 0){
			copy = new PatientProviderRel();
			copy.patProRelId = src.getPatProRelId();
			copy.patientId = src.getPatientId();
			copy.patient = (src.getPatient() == null)? null : Patient.copy(src.getPatient(), --depth);
			copy.healthProJobId = src.getHealthProJobId();
			copy.healthPro = (src.getHealthPro() == null)? null : HealthPro.copy(src.getHealthPro(), --depth);
			copy.relType = src.getRelType();
			copy.relStartDate = src.getRelStartDate();
			copy.relEndDate = src.getRelEndDate();
			copy.locationId = src.getLocationId();
			copy.locationHierarchy = (src.getLocationHierarchy() == null)? null : LocationHierarchy.copy(src.getLocationHierarchy(), --depth);
		}
		return copy;
	}

	@Override
	public PatientProviderRel copy() {
		return copy(this, copyDepth);
	}	
}