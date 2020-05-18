package com.covid.model.meta;


import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import com.covid.model.db.PatientProviderRel;
import java.sql.Timestamp;
import com.covid.model.db.HealthPro;
import com.covid.model.db.Patient;
import com.covid.model.db.LocationHierarchy;
import javax.persistence.metamodel.SetAttribute;


@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(PatientProviderRel.class)
public abstract class PatientProviderRel_{

	public static volatile SingularAttribute<PatientProviderRel, Integer> patProRelId;
	public static volatile SingularAttribute<PatientProviderRel, Integer> patientId;
	public static volatile SingularAttribute<PatientProviderRel, Patient> patient;
	public static volatile SingularAttribute<PatientProviderRel, Integer> healthProId;
	public static volatile SingularAttribute<PatientProviderRel, HealthPro> healthPro;
	public static volatile SingularAttribute<PatientProviderRel, String> relType;
	public static volatile SingularAttribute<PatientProviderRel, Timestamp> relStartDate;
	public static volatile SingularAttribute<PatientProviderRel, Timestamp> relEndDate;
	public static volatile SingularAttribute<PatientProviderRel, Integer> relFacLocation;
	public static volatile SingularAttribute<PatientProviderRel, LocationHierarchy> locationHierarchy;

	public static final String s_patProRelId = "patProRelId";
	public static final String s_patientId = "patientId";
	public static final String s_patient = "patient";
	public static final String s_healthProId = "healthProId";
	public static final String s_healthPro = "healthPro";
	public static final String s_relType = "relType";
	public static final String s_relStartDate = "relStartDate";
	public static final String s_relEndDate = "relEndDate";
	public static final String s_relFacLocation = "relFacLocation";
	public static final String s_locationHierarchy = "locationHierarchy";
	
}

