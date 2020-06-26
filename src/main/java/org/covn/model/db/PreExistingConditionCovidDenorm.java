package org.covn.model.db;

import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.UniqueConstraint;
import javax.persistence.SequenceGenerator;
import javax.persistence.JoinColumn;
import javax.persistence.FetchType;
import org.covn.model.BaseModel;
import javax.persistence.Id;

import java.io.Serializable;


@Entity
@Table(name = "pre_existing_condition_covid_denorm", schema = "release1", uniqueConstraints={@UniqueConstraint(columnNames = {"covid_pre_existing_condition_id"})
})
public class PreExistingConditionCovidDenorm extends BaseModel<PreExistingConditionCovidDenorm, Integer> implements java.io.Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "covid_pre_existing_condition_id", nullable = false, length = 10)
	private Integer covidPreExistingConditionId;

	@Column(name = "patient_id", nullable = false, length = 10, updatable = false, insertable = false)
	private Integer patientId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "patient_id")
	private Patient patient;

	@Column(name = "pre_existing_condition_id", nullable = true, length = 10, updatable = false, insertable = false)
	private Integer preExistingConditionId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pre_existing_condition_id")
	private PreExistingCondition preExistingCondition;

	@Column(name = "copd", nullable = true)
	private Boolean copd;

	@Column(name = "bronchitis", nullable = true)
	private Boolean bronchitis;

	@Column(name = "diabetes_mellitus", nullable = true)
	private Boolean diabetesMellitus;

	@Column(name = "diabetes_mellitus_type_1", nullable = true)
	private Boolean diabetesMellitusType1;

	@Column(name = "diabetes_mellitus_type_2", nullable = true)
	private Boolean diabetesMellitusType2;

	@Column(name = "hypertension", nullable = true)
	private Boolean hypertension;

	@Column(name = "chronic_renal_disease", nullable = true)
	private Boolean chronicRenalDisease;

	@Column(name = "malignancy", nullable = true)
	private Boolean malignancy;

	@Column(name = "heart_disease", nullable = true)
	private Boolean heartDisease;

	@Column(name = "asthma", nullable = true)
	private Boolean asthma;

	@Column(name = "obesity", nullable = true)
	private Boolean obesity;

	@Column(name = "comments", nullable = true, length = 255)
	private String comments;


	public Integer getCovidPreExistingConditionId(){
		return this.covidPreExistingConditionId;
	}
	public PreExistingConditionCovidDenorm setCovidPreExistingConditionId(Integer covidPreExistingConditionId){
		this.covidPreExistingConditionId = covidPreExistingConditionId;
		
		return this;
	}

	public Integer getPatientId(){
		return this.patientId;
	}
	public PreExistingConditionCovidDenorm setPatientId(Integer patientId){
		this.patientId = patientId;
		
		return this;
	}

	public Patient getPatient(){
		return this.patient;
	}
	public PreExistingConditionCovidDenorm setPatient(Patient patient){
		this.patient = patient;
		this.patientId = (this.patient == null)? null: this.patient.getPatientId();
		return this;
	}

	public Integer getPreExistingConditionId(){
		return this.preExistingConditionId;
	}
	public PreExistingConditionCovidDenorm setPreExistingConditionId(Integer preExistingConditionId){
		this.preExistingConditionId = preExistingConditionId;
		
		return this;
	}

	public PreExistingCondition getPreExistingCondition(){
		return this.preExistingCondition;
	}
	public PreExistingConditionCovidDenorm setPreExistingCondition(PreExistingCondition preExistingCondition){
		this.preExistingCondition = preExistingCondition;
		this.preExistingConditionId = (this.preExistingCondition == null)? null: this.preExistingCondition.getPreExistingConditionId();
		return this;
	}

	public Boolean getCopd(){
		return this.copd;
	}
	public PreExistingConditionCovidDenorm setCopd(Boolean copd){
		this.copd = copd;
		
		return this;
	}

	public Boolean getBronchitis(){
		return this.bronchitis;
	}
	public PreExistingConditionCovidDenorm setBronchitis(Boolean bronchitis){
		this.bronchitis = bronchitis;
		
		return this;
	}

	public Boolean getDiabetesMellitus(){
		return this.diabetesMellitus;
	}
	public PreExistingConditionCovidDenorm setDiabetesMellitus(Boolean diabetesMellitus){
		this.diabetesMellitus = diabetesMellitus;
		
		return this;
	}

	public Boolean getDiabetesMellitusType1(){
		return this.diabetesMellitusType1;
	}
	public PreExistingConditionCovidDenorm setDiabetesMellitusType1(Boolean diabetesMellitusType1){
		this.diabetesMellitusType1 = diabetesMellitusType1;
		
		return this;
	}

	public Boolean getDiabetesMellitusType2(){
		return this.diabetesMellitusType2;
	}
	public PreExistingConditionCovidDenorm setDiabetesMellitusType2(Boolean diabetesMellitusType2){
		this.diabetesMellitusType2 = diabetesMellitusType2;
		
		return this;
	}

	public Boolean getHypertension(){
		return this.hypertension;
	}
	public PreExistingConditionCovidDenorm setHypertension(Boolean hypertension){
		this.hypertension = hypertension;
		
		return this;
	}

	public Boolean getChronicRenalDisease(){
		return this.chronicRenalDisease;
	}
	public PreExistingConditionCovidDenorm setChronicRenalDisease(Boolean chronicRenalDisease){
		this.chronicRenalDisease = chronicRenalDisease;
		
		return this;
	}

	public Boolean getMalignancy(){
		return this.malignancy;
	}
	public PreExistingConditionCovidDenorm setMalignancy(Boolean malignancy){
		this.malignancy = malignancy;
		
		return this;
	}

	public Boolean getHeartDisease(){
		return this.heartDisease;
	}
	public PreExistingConditionCovidDenorm setHeartDisease(Boolean heartDisease){
		this.heartDisease = heartDisease;
		
		return this;
	}

	public Boolean getAsthma(){
		return this.asthma;
	}
	public PreExistingConditionCovidDenorm setAsthma(Boolean asthma){
		this.asthma = asthma;
		
		return this;
	}

	public Boolean getObesity(){
		return this.obesity;
	}
	public PreExistingConditionCovidDenorm setObesity(Boolean obesity){
		this.obesity = obesity;
		
		return this;
	}

	public String getComments(){
		return this.comments;
	}
	public PreExistingConditionCovidDenorm setComments(String comments){
		this.comments = comments;
		
		return this;
	}


	@Override
	public Integer getKey() {
		return this.covidPreExistingConditionId;
	}

	
	public static PreExistingConditionCovidDenorm of(){
		return new PreExistingConditionCovidDenorm();
	}
	
	public static PreExistingConditionCovidDenorm copy(PreExistingConditionCovidDenorm src, int depth){
		PreExistingConditionCovidDenorm copy = null;
		if(depth > 0){
			copy = new PreExistingConditionCovidDenorm();
			copy.covidPreExistingConditionId = src.getCovidPreExistingConditionId();
			copy.patientId = src.getPatientId();
			copy.patient = (src.getPatient() == null)? null : Patient.copy(src.getPatient(), --depth);
			copy.preExistingConditionId = src.getPreExistingConditionId();
			copy.preExistingCondition = (src.getPreExistingCondition() == null)? null : PreExistingCondition.copy(src.getPreExistingCondition(), --depth);
			copy.copd = src.getCopd();
			copy.bronchitis = src.getBronchitis();
			copy.diabetesMellitus = src.getDiabetesMellitus();
			copy.diabetesMellitusType1 = src.getDiabetesMellitusType1();
			copy.diabetesMellitusType2 = src.getDiabetesMellitusType2();
			copy.hypertension = src.getHypertension();
			copy.chronicRenalDisease = src.getChronicRenalDisease();
			copy.malignancy = src.getMalignancy();
			copy.heartDisease = src.getHeartDisease();
			copy.asthma = src.getAsthma();
			copy.obesity = src.getObesity();
			copy.comments = src.getComments();
		}
		return copy;
	}

	@Override
	public PreExistingConditionCovidDenorm copy() {
		return copy(this, copyDepth);
	}	
}