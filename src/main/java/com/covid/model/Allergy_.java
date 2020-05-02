package com.covid.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Allergy.class)
public abstract class Allergy_ {

	public static volatile SingularAttribute<Allergy, String> allergenType;
	public static volatile SingularAttribute<Allergy, Integer> allergyId;
	public static volatile SingularAttribute<Allergy, Integer> patientId;
	public static volatile SingularAttribute<Allergy, String> allergicRxnCodeSystem;
	public static volatile SingularAttribute<Allergy, String> durationUnits;
	public static volatile SingularAttribute<Allergy, String> allergenCodeSystem;
	public static volatile SingularAttribute<Allergy, Boolean> isActive;
	public static volatile SingularAttribute<Allergy, Integer> durationNum;
	public static volatile SingularAttribute<Allergy, String> allergySeverity;
	public static volatile SingularAttribute<Allergy, String> allergenConceptCode;
	public static volatile SingularAttribute<Allergy, String> allergenDescription;
	public static volatile SingularAttribute<Allergy, String> allergicRxnDescription;
	public static volatile SingularAttribute<Allergy, String> allergicRxnConceptCode;

	public static final String ALLERGEN_TYPE = "allergenType";
	public static final String ALLERGY_ID = "allergyId";
	public static final String PATIENT_ID = "patientId";
	public static final String ALLERGIC_RXN_CODE_SYSTEM = "allergicRxnCodeSystem";
	public static final String DURATION_UNITS = "durationUnits";
	public static final String ALLERGEN_CODE_SYSTEM = "allergenCodeSystem";
	public static final String IS_ACTIVE = "isActive";
	public static final String DURATION_NUM = "durationNum";
	public static final String ALLERGY_SEVERITY = "allergySeverity";
	public static final String ALLERGEN_CONCEPT_CODE = "allergenConceptCode";
	public static final String ALLERGEN_DESCRIPTION = "allergenDescription";
	public static final String ALLERGIC_RXN_DESCRIPTION = "allergicRxnDescription";
	public static final String ALLERGIC_RXN_CONCEPT_CODE = "allergicRxnConceptCode";

}

