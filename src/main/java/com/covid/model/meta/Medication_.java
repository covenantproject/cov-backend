package com.covid.model.meta;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import com.covid.model.db.Medication;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Medication.class)
public abstract class Medication_ {

	public static volatile SingularAttribute<Medication, String> comments;
	public static volatile SingularAttribute<Medication, Integer> patientId;
	public static volatile SingularAttribute<Medication, String> durationUnits;
	public static volatile SingularAttribute<Medication, Boolean> isActive;
	public static volatile SingularAttribute<Medication, String> ingredientCodeSystem;
	public static volatile SingularAttribute<Medication, String> brandedName;
	public static volatile SingularAttribute<Medication, String> frequency;
	public static volatile SingularAttribute<Medication, String> intentType;
	public static volatile SingularAttribute<Medication, Integer> durationNum;
	public static volatile SingularAttribute<Medication, String> route;
	public static volatile SingularAttribute<Medication, Integer> medicationId;
	public static volatile SingularAttribute<Medication, String> doseNumAndUnits;
	public static volatile SingularAttribute<Medication, String> strengthNumAndUnits;
	public static volatile SingularAttribute<Medication, String> indication;
	public static volatile SingularAttribute<Medication, String> ingredientConceptCode;
	public static volatile SingularAttribute<Medication, String> ingredientDescription;

	public static final String COMMENTS = "comments";
	public static final String PATIENT_ID = "patientId";
	public static final String DURATION_UNITS = "durationUnits";
	public static final String IS_ACTIVE = "isActive";
	public static final String INGREDIENT_CODE_SYSTEM = "ingredientCodeSystem";
	public static final String BRANDED_NAME = "brandedName";
	public static final String FREQUENCY = "frequency";
	public static final String INTENT_TYPE = "intentType";
	public static final String DURATION_NUM = "durationNum";
	public static final String ROUTE = "route";
	public static final String MEDICATION_ID = "medicationId";
	public static final String DOSE_NUM_AND_UNITS = "doseNumAndUnits";
	public static final String STRENGTH_NUM_AND_UNITS = "strengthNumAndUnits";
	public static final String INDICATION = "indication";
	public static final String INGREDIENT_CONCEPT_CODE = "ingredientConceptCode";
	public static final String INGREDIENT_DESCRIPTION = "ingredientDescription";

}

