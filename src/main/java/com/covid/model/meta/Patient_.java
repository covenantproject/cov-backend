package com.covid.model.meta;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import com.covid.model.db.Patient;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Patient.class)
public abstract class Patient_ {

	public static volatile SingularAttribute<Patient, Boolean> hasAdvanceDirectives;
	public static volatile SingularAttribute<Patient, Boolean> hasMedications;
	public static volatile SingularAttribute<Patient, String> comments;
	public static volatile SingularAttribute<Patient, Integer> patientId;
	public static volatile SingularAttribute<Patient, Boolean> hasAllergies;
	public static volatile SingularAttribute<Patient, Boolean> needsCarer;
	public static volatile SingularAttribute<Patient, String> clinicalTrialStatus;
	public static volatile SingularAttribute<Patient, Integer> householdId;
	public static volatile SingularAttribute<Patient, String> bloodGroup;
	public static volatile SingularAttribute<Patient, Boolean> hasInternationalTravel;
	public static volatile SingularAttribute<Patient, Boolean> isHighRiskHealthWorker;
	public static volatile SingularAttribute<Patient, Boolean> hasPreexistingConditions;
	public static volatile SingularAttribute<Patient, Boolean> hasHighRiskFacilityVisit;
	public static volatile SingularAttribute<Patient, Boolean> hasInterstateTravel;

	public static final String HAS_ADVANCE_DIRECTIVES = "hasAdvanceDirectives";
	public static final String HAS_MEDICATIONS = "hasMedications";
	public static final String COMMENTS = "comments";
	public static final String PATIENT_ID = "patientId";
	public static final String HAS_ALLERGIES = "hasAllergies";
	public static final String NEEDS_CARER = "needsCarer";
	public static final String CLINICAL_TRIAL_STATUS = "clinicalTrialStatus";
	public static final String HOUSEHOLD_ID = "householdId";
	public static final String BLOOD_GROUP = "bloodGroup";
	public static final String HAS_INTERNATIONAL_TRAVEL = "hasInternationalTravel";
	public static final String IS_HIGH_RISK_HEALTH_WORKER = "isHighRiskHealthWorker";
	public static final String HAS_PREEXISTING_CONDITIONS = "hasPreexistingConditions";
	public static final String HAS_HIGH_RISK_FACILITY_VISIT = "hasHighRiskFacilityVisit";
	public static final String HAS_INTERSTATE_TRAVEL = "hasInterstateTravel";

}

