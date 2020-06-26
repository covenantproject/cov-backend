package org.covn.model.db;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.UniqueConstraint;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.Set;
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
@Table(name = "pre_existing_condition", schema = "release1", uniqueConstraints={@UniqueConstraint(columnNames = {"pre_existing_condition_id"})
})
public class PreExistingCondition extends BaseModel<PreExistingCondition, Integer> implements java.io.Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pre_existing_condition_id", nullable = false, length = 10)
	private Integer preExistingConditionId;

	@Column(name = "patient_id", nullable = false, length = 10, updatable = false, insertable = false)
	private Integer patientId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "patient_id")
	private Patient patient;

	@Column(name = "pre_existing_condition_code_system", nullable = true, length = 32)
	private String preExistingConditionCodeSystem;

	@Column(name = "pre_existing_condtion_concept_code", nullable = true, length = 32)
	private String preExistingCondtionConceptCode;

	@Column(name = "pre_existing_condtion_description", nullable = true, length = 255)
	private String preExistingCondtionDescription;

	@Column(name = "is_active", nullable = true)
	private Boolean isActive;

	@Column(name = "is_controlled", nullable = true)
	private Boolean isControlled;

	@Column(name = "duration_num", nullable = true, length = 10)
	private Integer durationNum;

	@Column(name = "duration_units", nullable = true, length = 10)
	private String durationUnits;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "preExistingCondition")
	private Set<PreExistingConditionCovidDenorm> preExistingConditionCovidDenormSet;


	public Integer getPreExistingConditionId(){
		return this.preExistingConditionId;
	}
	public PreExistingCondition setPreExistingConditionId(Integer preExistingConditionId){
		this.preExistingConditionId = preExistingConditionId;
		
		return this;
	}

	public Integer getPatientId(){
		return this.patientId;
	}
	public PreExistingCondition setPatientId(Integer patientId){
		this.patientId = patientId;
		
		return this;
	}

	public Patient getPatient(){
		return this.patient;
	}
	public PreExistingCondition setPatient(Patient patient){
		this.patient = patient;
		this.patientId = (this.patient == null)? null: this.patient.getPatientId();
		return this;
	}

	public String getPreExistingConditionCodeSystem(){
		return this.preExistingConditionCodeSystem;
	}
	public PreExistingCondition setPreExistingConditionCodeSystem(String preExistingConditionCodeSystem){
		this.preExistingConditionCodeSystem = preExistingConditionCodeSystem;
		
		return this;
	}

	public String getPreExistingCondtionConceptCode(){
		return this.preExistingCondtionConceptCode;
	}
	public PreExistingCondition setPreExistingCondtionConceptCode(String preExistingCondtionConceptCode){
		this.preExistingCondtionConceptCode = preExistingCondtionConceptCode;
		
		return this;
	}

	public String getPreExistingCondtionDescription(){
		return this.preExistingCondtionDescription;
	}
	public PreExistingCondition setPreExistingCondtionDescription(String preExistingCondtionDescription){
		this.preExistingCondtionDescription = preExistingCondtionDescription;
		
		return this;
	}

	public Boolean getIsActive(){
		return this.isActive;
	}
	public PreExistingCondition setIsActive(Boolean isActive){
		this.isActive = isActive;
		
		return this;
	}

	public Boolean getIsControlled(){
		return this.isControlled;
	}
	public PreExistingCondition setIsControlled(Boolean isControlled){
		this.isControlled = isControlled;
		
		return this;
	}

	public Integer getDurationNum(){
		return this.durationNum;
	}
	public PreExistingCondition setDurationNum(Integer durationNum){
		this.durationNum = durationNum;
		
		return this;
	}

	public String getDurationUnits(){
		return this.durationUnits;
	}
	public PreExistingCondition setDurationUnits(String durationUnits){
		this.durationUnits = durationUnits;
		
		return this;
	}

	public Set<PreExistingConditionCovidDenorm> getPreExistingConditionCovidDenormSet(){
		return this.preExistingConditionCovidDenormSet;
	}
	public PreExistingCondition setPreExistingConditionCovidDenormSet(Set<PreExistingConditionCovidDenorm> preExistingConditionCovidDenormSet){
		this.preExistingConditionCovidDenormSet = preExistingConditionCovidDenormSet;
		
		return this;
	}


	@Override
	public Integer getKey() {
		return this.preExistingConditionId;
	}

	
	public static PreExistingCondition of(){
		return new PreExistingCondition();
	}
	
	public static PreExistingCondition copy(PreExistingCondition src, int depth){
		PreExistingCondition copy = null;
		if(depth > 0){
			copy = new PreExistingCondition();
			copy.preExistingConditionId = src.getPreExistingConditionId();
			copy.patientId = src.getPatientId();
			copy.patient = (src.getPatient() == null)? null : Patient.copy(src.getPatient(), --depth);
			copy.preExistingConditionCodeSystem = src.getPreExistingConditionCodeSystem();
			copy.preExistingCondtionConceptCode = src.getPreExistingCondtionConceptCode();
			copy.preExistingCondtionDescription = src.getPreExistingCondtionDescription();
			copy.isActive = src.getIsActive();
			copy.isControlled = src.getIsControlled();
			copy.durationNum = src.getDurationNum();
			copy.durationUnits = src.getDurationUnits();
		}
		return copy;
	}

	@Override
	public PreExistingCondition copy() {
		return copy(this, copyDepth);
	}	
}