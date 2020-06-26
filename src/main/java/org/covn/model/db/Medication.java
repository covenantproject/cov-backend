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
@Table(name = "medication", schema = "release1", uniqueConstraints={@UniqueConstraint(columnNames = {"medication_id"})
})
public class Medication extends BaseModel<Medication, Integer> implements java.io.Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "medication_id", nullable = false, length = 10)
	private Integer medicationId;

	@Column(name = "patient_id", nullable = false, length = 10, updatable = false, insertable = false)
	private Integer patientId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "patient_id")
	private Patient patient;

	@Column(name = "ingredient_code_system", nullable = true, length = 32)
	private String ingredientCodeSystem;

	@Column(name = "ingredient_concept_code", nullable = true, length = 32)
	private String ingredientConceptCode;

	@Column(name = "ingredient_description", nullable = true, length = 255)
	private String ingredientDescription;

	@Column(name = "branded_name", nullable = true, length = 255)
	private String brandedName;

	@Column(name = "is_active", nullable = true)
	private Boolean isActive;

	@Column(name = "duration_num", nullable = true, length = 10)
	private Integer durationNum;

	@Column(name = "duration_units", nullable = true, length = 10)
	private String durationUnits;

	@Column(name = "strength_num_and_units", nullable = true, length = 32)
	private String strengthNumAndUnits;

	@Column(name = "dose_num_and_units", nullable = true, length = 32)
	private String doseNumAndUnits;

	@Column(name = "frequency", nullable = true, length = 32)
	private String frequency;

	@Column(name = "route", nullable = true, length = 32)
	private String route;

	@Column(name = "indication", nullable = true, length = 32)
	private String indication;

	@Column(name = "intent_type", nullable = true, length = 32)
	private String intentType;

	@Column(name = "comments", nullable = true, length = 255)
	private String comments;


	public Integer getMedicationId(){
		return this.medicationId;
	}
	public Medication setMedicationId(Integer medicationId){
		this.medicationId = medicationId;
		
		return this;
	}

	public Integer getPatientId(){
		return this.patientId;
	}
	public Medication setPatientId(Integer patientId){
		this.patientId = patientId;
		
		return this;
	}

	public Patient getPatient(){
		return this.patient;
	}
	public Medication setPatient(Patient patient){
		this.patient = patient;
		this.patientId = (this.patient == null)? null: this.patient.getPatientId();
		return this;
	}

	public String getIngredientCodeSystem(){
		return this.ingredientCodeSystem;
	}
	public Medication setIngredientCodeSystem(String ingredientCodeSystem){
		this.ingredientCodeSystem = ingredientCodeSystem;
		
		return this;
	}

	public String getIngredientConceptCode(){
		return this.ingredientConceptCode;
	}
	public Medication setIngredientConceptCode(String ingredientConceptCode){
		this.ingredientConceptCode = ingredientConceptCode;
		
		return this;
	}

	public String getIngredientDescription(){
		return this.ingredientDescription;
	}
	public Medication setIngredientDescription(String ingredientDescription){
		this.ingredientDescription = ingredientDescription;
		
		return this;
	}

	public String getBrandedName(){
		return this.brandedName;
	}
	public Medication setBrandedName(String brandedName){
		this.brandedName = brandedName;
		
		return this;
	}

	public Boolean getIsActive(){
		return this.isActive;
	}
	public Medication setIsActive(Boolean isActive){
		this.isActive = isActive;
		
		return this;
	}

	public Integer getDurationNum(){
		return this.durationNum;
	}
	public Medication setDurationNum(Integer durationNum){
		this.durationNum = durationNum;
		
		return this;
	}

	public String getDurationUnits(){
		return this.durationUnits;
	}
	public Medication setDurationUnits(String durationUnits){
		this.durationUnits = durationUnits;
		
		return this;
	}

	public String getStrengthNumAndUnits(){
		return this.strengthNumAndUnits;
	}
	public Medication setStrengthNumAndUnits(String strengthNumAndUnits){
		this.strengthNumAndUnits = strengthNumAndUnits;
		
		return this;
	}

	public String getDoseNumAndUnits(){
		return this.doseNumAndUnits;
	}
	public Medication setDoseNumAndUnits(String doseNumAndUnits){
		this.doseNumAndUnits = doseNumAndUnits;
		
		return this;
	}

	public String getFrequency(){
		return this.frequency;
	}
	public Medication setFrequency(String frequency){
		this.frequency = frequency;
		
		return this;
	}

	public String getRoute(){
		return this.route;
	}
	public Medication setRoute(String route){
		this.route = route;
		
		return this;
	}

	public String getIndication(){
		return this.indication;
	}
	public Medication setIndication(String indication){
		this.indication = indication;
		
		return this;
	}

	public String getIntentType(){
		return this.intentType;
	}
	public Medication setIntentType(String intentType){
		this.intentType = intentType;
		
		return this;
	}

	public String getComments(){
		return this.comments;
	}
	public Medication setComments(String comments){
		this.comments = comments;
		
		return this;
	}


	@Override
	public Integer getKey() {
		return this.medicationId;
	}

	
	public static Medication of(){
		return new Medication();
	}
	
	public static Medication copy(Medication src, int depth){
		Medication copy = null;
		if(depth > 0){
			copy = new Medication();
			copy.medicationId = src.getMedicationId();
			copy.patientId = src.getPatientId();
			copy.patient = (src.getPatient() == null)? null : Patient.copy(src.getPatient(), --depth);
			copy.ingredientCodeSystem = src.getIngredientCodeSystem();
			copy.ingredientConceptCode = src.getIngredientConceptCode();
			copy.ingredientDescription = src.getIngredientDescription();
			copy.brandedName = src.getBrandedName();
			copy.isActive = src.getIsActive();
			copy.durationNum = src.getDurationNum();
			copy.durationUnits = src.getDurationUnits();
			copy.strengthNumAndUnits = src.getStrengthNumAndUnits();
			copy.doseNumAndUnits = src.getDoseNumAndUnits();
			copy.frequency = src.getFrequency();
			copy.route = src.getRoute();
			copy.indication = src.getIndication();
			copy.intentType = src.getIntentType();
			copy.comments = src.getComments();
		}
		return copy;
	}

	@Override
	public Medication copy() {
		return copy(this, copyDepth);
	}	
}