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
@Table(name = "allergy", schema = "release1", uniqueConstraints={@UniqueConstraint(columnNames = {"allergy_id"})
})
public class Allergy extends BaseModel<Allergy, Integer> implements java.io.Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "allergy_id", nullable = false, length = 10)
	private Integer allergyId;

	@Column(name = "patient_id", nullable = false, length = 10, updatable = false, insertable = false)
	private Integer patientId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "patient_id")
	private Patient patient;

	@Column(name = "allergen_type", nullable = true, length = 32)
	private String allergenType;

	@Column(name = "allergen_code_system", nullable = true, length = 32)
	private String allergenCodeSystem;

	@Column(name = "allergen_concept_code", nullable = true, length = 32)
	private String allergenConceptCode;

	@Column(name = "allergen_description", nullable = true, length = 255)
	private String allergenDescription;

	@Column(name = "allergic_rxn_code_system", nullable = true, length = 32)
	private String allergicRxnCodeSystem;

	@Column(name = "allergic_rxn_concept_code", nullable = true, length = 32)
	private String allergicRxnConceptCode;

	@Column(name = "allergic_rxn_description", nullable = true, length = 255)
	private String allergicRxnDescription;

	@Column(name = "allergy_severity", nullable = true, length = 10)
	private String allergySeverity;

	@Column(name = "is_active", nullable = true)
	private Boolean isActive;

	@Column(name = "duration_num", nullable = true, length = 10)
	private Integer durationNum;

	@Column(name = "duration_units", nullable = true, length = 10)
	private String durationUnits;


	public Integer getAllergyId(){
		return this.allergyId;
	}
	public Allergy setAllergyId(Integer allergyId){
		this.allergyId = allergyId;
		
		return this;
	}

	public Integer getPatientId(){
		return this.patientId;
	}
	public Allergy setPatientId(Integer patientId){
		this.patientId = patientId;
		
		return this;
	}

	public Patient getPatient(){
		return this.patient;
	}
	public Allergy setPatient(Patient patient){
		this.patient = patient;
		this.patientId = (this.patient == null)? null: this.patient.getPatientId();
		return this;
	}

	public String getAllergenType(){
		return this.allergenType;
	}
	public Allergy setAllergenType(String allergenType){
		this.allergenType = allergenType;
		
		return this;
	}

	public String getAllergenCodeSystem(){
		return this.allergenCodeSystem;
	}
	public Allergy setAllergenCodeSystem(String allergenCodeSystem){
		this.allergenCodeSystem = allergenCodeSystem;
		
		return this;
	}

	public String getAllergenConceptCode(){
		return this.allergenConceptCode;
	}
	public Allergy setAllergenConceptCode(String allergenConceptCode){
		this.allergenConceptCode = allergenConceptCode;
		
		return this;
	}

	public String getAllergenDescription(){
		return this.allergenDescription;
	}
	public Allergy setAllergenDescription(String allergenDescription){
		this.allergenDescription = allergenDescription;
		
		return this;
	}

	public String getAllergicRxnCodeSystem(){
		return this.allergicRxnCodeSystem;
	}
	public Allergy setAllergicRxnCodeSystem(String allergicRxnCodeSystem){
		this.allergicRxnCodeSystem = allergicRxnCodeSystem;
		
		return this;
	}

	public String getAllergicRxnConceptCode(){
		return this.allergicRxnConceptCode;
	}
	public Allergy setAllergicRxnConceptCode(String allergicRxnConceptCode){
		this.allergicRxnConceptCode = allergicRxnConceptCode;
		
		return this;
	}

	public String getAllergicRxnDescription(){
		return this.allergicRxnDescription;
	}
	public Allergy setAllergicRxnDescription(String allergicRxnDescription){
		this.allergicRxnDescription = allergicRxnDescription;
		
		return this;
	}

	public String getAllergySeverity(){
		return this.allergySeverity;
	}
	public Allergy setAllergySeverity(String allergySeverity){
		this.allergySeverity = allergySeverity;
		
		return this;
	}

	public Boolean getIsActive(){
		return this.isActive;
	}
	public Allergy setIsActive(Boolean isActive){
		this.isActive = isActive;
		
		return this;
	}

	public Integer getDurationNum(){
		return this.durationNum;
	}
	public Allergy setDurationNum(Integer durationNum){
		this.durationNum = durationNum;
		
		return this;
	}

	public String getDurationUnits(){
		return this.durationUnits;
	}
	public Allergy setDurationUnits(String durationUnits){
		this.durationUnits = durationUnits;
		
		return this;
	}


	@Override
	public Integer getKey() {
		return this.allergyId;
	}

	
	public static Allergy of(){
		return new Allergy();
	}
	
	public static Allergy copy(Allergy src, int depth){
		Allergy copy = null;
		if(depth > 0){
			copy = new Allergy();
			copy.allergyId = src.getAllergyId();
			copy.patientId = src.getPatientId();
			copy.patient = (src.getPatient() == null)? null : Patient.copy(src.getPatient(), --depth);
			copy.allergenType = src.getAllergenType();
			copy.allergenCodeSystem = src.getAllergenCodeSystem();
			copy.allergenConceptCode = src.getAllergenConceptCode();
			copy.allergenDescription = src.getAllergenDescription();
			copy.allergicRxnCodeSystem = src.getAllergicRxnCodeSystem();
			copy.allergicRxnConceptCode = src.getAllergicRxnConceptCode();
			copy.allergicRxnDescription = src.getAllergicRxnDescription();
			copy.allergySeverity = src.getAllergySeverity();
			copy.isActive = src.getIsActive();
			copy.durationNum = src.getDurationNum();
			copy.durationUnits = src.getDurationUnits();
		}
		return copy;
	}

	@Override
	public Allergy copy() {
		return copy(this, copyDepth);
	}	
}