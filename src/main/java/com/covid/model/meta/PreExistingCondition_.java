package com.covid.model.meta;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import com.covid.model.db.PreExistingCondition;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(PreExistingCondition.class)
public abstract class PreExistingCondition_ {

	public static volatile SingularAttribute<PreExistingCondition, Boolean> isControlled;
	public static volatile SingularAttribute<PreExistingCondition, Integer> durationNum;
	public static volatile SingularAttribute<PreExistingCondition, Integer> patientId;
	public static volatile SingularAttribute<PreExistingCondition, Integer> preExistingConditionId;
	public static volatile SingularAttribute<PreExistingCondition, String> durationUnits;
	public static volatile SingularAttribute<PreExistingCondition, String> preExistingCondtionConceptCode;
	public static volatile SingularAttribute<PreExistingCondition, String> preExistingCondtionDescription;
	public static volatile SingularAttribute<PreExistingCondition, Boolean> isActive;
	public static volatile SingularAttribute<PreExistingCondition, String> preExistingConditionCodeSystem;

	public static final String IS_CONTROLLED = "isControlled";
	public static final String DURATION_NUM = "durationNum";
	public static final String PATIENT_ID = "patientId";
	public static final String PRE_EXISTING_CONDITION_ID = "preExistingConditionId";
	public static final String DURATION_UNITS = "durationUnits";
	public static final String PRE_EXISTING_CONDTION_CONCEPT_CODE = "preExistingCondtionConceptCode";
	public static final String PRE_EXISTING_CONDTION_DESCRIPTION = "preExistingCondtionDescription";
	public static final String IS_ACTIVE = "isActive";
	public static final String PRE_EXISTING_CONDITION_CODE_SYSTEM = "preExistingConditionCodeSystem";

}

