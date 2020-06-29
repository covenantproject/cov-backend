package org.covn.model.meta;


import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.covn.model.db.PatientProviderRel;
import org.covn.model.db.HealthPro;
import org.covn.model.db.LocationHierarchy;
import java.sql.Timestamp;
import org.covn.model.db.Patient;
import javax.persistence.metamodel.SetAttribute;


@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(PatientProviderRel.class)
public abstract class PatientProviderRel_{

	public static volatile SingularAttribute<PatientProviderRel, Integer> patProRelId;
	public static volatile SingularAttribute<PatientProviderRel, Integer> patientId;
	public static volatile SingularAttribute<PatientProviderRel, Patient> patient;
	public static volatile SingularAttribute<PatientProviderRel, Integer> healthProJobId;
	public static volatile SingularAttribute<PatientProviderRel, HealthPro> healthPro;
	public static volatile SingularAttribute<PatientProviderRel, String> relType;
	public static volatile SingularAttribute<PatientProviderRel, Timestamp> relStartDate;
	public static volatile SingularAttribute<PatientProviderRel, Timestamp> relEndDate;
	public static volatile SingularAttribute<PatientProviderRel, Integer> locationId;
	public static volatile SingularAttribute<PatientProviderRel, LocationHierarchy> locationHierarchy;

	public static final String s_patProRelId = "patProRelId";
	public static final String s_patientId = "patientId";
	public static final String s_patient = "patient";
	public static final String s_healthProJobId = "healthProJobId";
	public static final String s_healthPro = "healthPro";
	public static final String s_relType = "relType";
	public static final String s_relStartDate = "relStartDate";
	public static final String s_relEndDate = "relEndDate";
	public static final String s_locationId = "locationId";
	public static final String s_locationHierarchy = "locationHierarchy";
	
}

