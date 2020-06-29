package org.covn.model.meta;


import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.covn.model.db.PreExistingConditionCovidDenorm;
import org.covn.model.db.Patient;
import javax.persistence.metamodel.SetAttribute;
import org.covn.model.db.PreExistingCondition;


@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(PreExistingCondition.class)
public abstract class PreExistingCondition_{

	public static volatile SingularAttribute<PreExistingCondition, Integer> preExistingConditionId;
	public static volatile SingularAttribute<PreExistingCondition, Integer> patientId;
	public static volatile SingularAttribute<PreExistingCondition, Patient> patient;
	public static volatile SingularAttribute<PreExistingCondition, String> preExistingConditionCodeSystem;
	public static volatile SingularAttribute<PreExistingCondition, String> preExistingCondtionConceptCode;
	public static volatile SingularAttribute<PreExistingCondition, String> preExistingCondtionDescription;
	public static volatile SingularAttribute<PreExistingCondition, Boolean> isActive;
	public static volatile SingularAttribute<PreExistingCondition, Boolean> isControlled;
	public static volatile SingularAttribute<PreExistingCondition, Integer> durationNum;
	public static volatile SingularAttribute<PreExistingCondition, String> durationUnits;
	public static volatile SetAttribute<PreExistingCondition, PreExistingConditionCovidDenorm> preExistingConditionCovidDenormSet;

	public static final String s_preExistingConditionId = "preExistingConditionId";
	public static final String s_patientId = "patientId";
	public static final String s_patient = "patient";
	public static final String s_preExistingConditionCodeSystem = "preExistingConditionCodeSystem";
	public static final String s_preExistingCondtionConceptCode = "preExistingCondtionConceptCode";
	public static final String s_preExistingCondtionDescription = "preExistingCondtionDescription";
	public static final String s_isActive = "isActive";
	public static final String s_isControlled = "isControlled";
	public static final String s_durationNum = "durationNum";
	public static final String s_durationUnits = "durationUnits";
	public static final String s_preExistingConditionCovidDenormSet = "preExistingConditionCovidDenormSet";
	
}

