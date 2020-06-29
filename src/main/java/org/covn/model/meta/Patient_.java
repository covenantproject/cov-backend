package org.covn.model.meta;


import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.covn.model.db.PatientProviderRel;
import org.covn.model.db.Allergy;
import org.covn.model.db.PreExistingConditionCovidDenorm;
import org.covn.model.db.Users;
import org.covn.model.db.PatientGeofencedLocation;
import org.covn.model.db.HealthCheckHistory;
import org.covn.model.db.Patient;
import javax.persistence.metamodel.SetAttribute;
import org.covn.model.db.PatientStatus;
import org.covn.model.db.Medication;
import org.covn.model.db.PreExistingCondition;
import org.covn.model.db.PatientRequestHistory;


@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Patient.class)
public abstract class Patient_{

	public static volatile SingularAttribute<Patient, Integer> patientId;
	public static volatile SingularAttribute<Patient, Users> users;
	public static volatile SingularAttribute<Patient, Integer> householdId;
	public static volatile SingularAttribute<Patient, Boolean> hasPreexistingConditions;
	public static volatile SingularAttribute<Patient, Boolean> hasMedications;
	public static volatile SingularAttribute<Patient, Boolean> hasAllergies;
	public static volatile SingularAttribute<Patient, Boolean> hasAdvanceDirectives;
	public static volatile SingularAttribute<Patient, Boolean> needsCarer;
	public static volatile SingularAttribute<Patient, Boolean> hasInternationalTravel;
	public static volatile SingularAttribute<Patient, Boolean> hasInterstateTravel;
	public static volatile SingularAttribute<Patient, Boolean> hasHighRiskFacilityVisit;
	public static volatile SingularAttribute<Patient, Boolean> isHighRiskHealthWorker;
	public static volatile SingularAttribute<Patient, String> bloodGroup;
	public static volatile SingularAttribute<Patient, String> clinicalTrialStatus;
	public static volatile SingularAttribute<Patient, String> comments;
	public static volatile SetAttribute<Patient, Medication> medicationSet;
	public static volatile SetAttribute<Patient, Allergy> allergySet;
	public static volatile SetAttribute<Patient, PreExistingCondition> preExistingConditionSet;
	public static volatile SetAttribute<Patient, PatientGeofencedLocation> patientGeofencedLocationSet;
	public static volatile SetAttribute<Patient, PatientProviderRel> patientProviderRelSet;
	public static volatile SetAttribute<Patient, PreExistingConditionCovidDenorm> preExistingConditionCovidDenormSet;
	public static volatile SetAttribute<Patient, PatientRequestHistory> patientRequestHistorySet;
	public static volatile SetAttribute<Patient, HealthCheckHistory> healthCheckHistorySet;
	public static volatile SetAttribute<Patient, PatientStatus> patientStatusSet;

	public static final String s_patientId = "patientId";
	public static final String s_users = "users";
	public static final String s_householdId = "householdId";
	public static final String s_hasPreexistingConditions = "hasPreexistingConditions";
	public static final String s_hasMedications = "hasMedications";
	public static final String s_hasAllergies = "hasAllergies";
	public static final String s_hasAdvanceDirectives = "hasAdvanceDirectives";
	public static final String s_needsCarer = "needsCarer";
	public static final String s_hasInternationalTravel = "hasInternationalTravel";
	public static final String s_hasInterstateTravel = "hasInterstateTravel";
	public static final String s_hasHighRiskFacilityVisit = "hasHighRiskFacilityVisit";
	public static final String s_isHighRiskHealthWorker = "isHighRiskHealthWorker";
	public static final String s_bloodGroup = "bloodGroup";
	public static final String s_clinicalTrialStatus = "clinicalTrialStatus";
	public static final String s_comments = "comments";
	public static final String s_medicationSet = "medicationSet";
	public static final String s_allergySet = "allergySet";
	public static final String s_preExistingConditionSet = "preExistingConditionSet";
	public static final String s_patientGeofencedLocationSet = "patientGeofencedLocationSet";
	public static final String s_patientProviderRelSet = "patientProviderRelSet";
	public static final String s_preExistingConditionCovidDenormSet = "preExistingConditionCovidDenormSet";
	public static final String s_patientRequestHistorySet = "patientRequestHistorySet";
	public static final String s_healthCheckHistorySet = "healthCheckHistorySet";
	public static final String s_patientStatusSet = "patientStatusSet";
	
}

