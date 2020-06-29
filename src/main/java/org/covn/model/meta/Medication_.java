package org.covn.model.meta;


import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.covn.model.db.Patient;
import javax.persistence.metamodel.SetAttribute;
import org.covn.model.db.Medication;


@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Medication.class)
public abstract class Medication_{

	public static volatile SingularAttribute<Medication, Integer> medicationId;
	public static volatile SingularAttribute<Medication, Integer> patientId;
	public static volatile SingularAttribute<Medication, Patient> patient;
	public static volatile SingularAttribute<Medication, String> ingredientCodeSystem;
	public static volatile SingularAttribute<Medication, String> ingredientConceptCode;
	public static volatile SingularAttribute<Medication, String> ingredientDescription;
	public static volatile SingularAttribute<Medication, String> brandedName;
	public static volatile SingularAttribute<Medication, Boolean> isActive;
	public static volatile SingularAttribute<Medication, Integer> durationNum;
	public static volatile SingularAttribute<Medication, String> durationUnits;
	public static volatile SingularAttribute<Medication, String> strengthNumAndUnits;
	public static volatile SingularAttribute<Medication, String> doseNumAndUnits;
	public static volatile SingularAttribute<Medication, String> frequency;
	public static volatile SingularAttribute<Medication, String> route;
	public static volatile SingularAttribute<Medication, String> indication;
	public static volatile SingularAttribute<Medication, String> intentType;
	public static volatile SingularAttribute<Medication, String> comments;

	public static final String s_medicationId = "medicationId";
	public static final String s_patientId = "patientId";
	public static final String s_patient = "patient";
	public static final String s_ingredientCodeSystem = "ingredientCodeSystem";
	public static final String s_ingredientConceptCode = "ingredientConceptCode";
	public static final String s_ingredientDescription = "ingredientDescription";
	public static final String s_brandedName = "brandedName";
	public static final String s_isActive = "isActive";
	public static final String s_durationNum = "durationNum";
	public static final String s_durationUnits = "durationUnits";
	public static final String s_strengthNumAndUnits = "strengthNumAndUnits";
	public static final String s_doseNumAndUnits = "doseNumAndUnits";
	public static final String s_frequency = "frequency";
	public static final String s_route = "route";
	public static final String s_indication = "indication";
	public static final String s_intentType = "intentType";
	public static final String s_comments = "comments";
	
}

