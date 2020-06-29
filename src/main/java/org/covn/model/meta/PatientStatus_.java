package org.covn.model.meta;


import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import java.math.BigDecimal;
import java.sql.Timestamp;
import org.covn.model.db.Patient;
import org.covn.model.db.PatientStatus;
import javax.persistence.metamodel.SetAttribute;


@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(PatientStatus.class)
public abstract class PatientStatus_{

	public static volatile SingularAttribute<PatientStatus, Integer> patientStatusId;
	public static volatile SingularAttribute<PatientStatus, Integer> patientId;
	public static volatile SingularAttribute<PatientStatus, Patient> patient;
	public static volatile SingularAttribute<PatientStatus, String> covid19Status;
	public static volatile SingularAttribute<PatientStatus, String> healthStatus;
	public static volatile SingularAttribute<PatientStatus, String> quarIsltStatus;
	public static volatile SingularAttribute<PatientStatus, Timestamp> quarIsltStartDateTime;
	public static volatile SingularAttribute<PatientStatus, Timestamp> quarIsltEndDateTime;
	public static volatile SingularAttribute<PatientStatus, String> quarIsltRequestStatus;
	public static volatile SingularAttribute<PatientStatus, String> medicalRequestStatus;
	public static volatile SingularAttribute<PatientStatus, String> suppliesRequestStatus;
	public static volatile SingularAttribute<PatientStatus, String> geofenceStatus;
	public static volatile SingularAttribute<PatientStatus, String> appHeartbeatStatus;
	public static volatile SingularAttribute<PatientStatus, Timestamp> updatedDateTime;
	public static volatile SingularAttribute<PatientStatus, BigDecimal> latitude;
	public static volatile SingularAttribute<PatientStatus, BigDecimal> longitude;
	public static volatile SingularAttribute<PatientStatus, String> comments;

	public static final String s_patientStatusId = "patientStatusId";
	public static final String s_patientId = "patientId";
	public static final String s_patient = "patient";
	public static final String s_covid19Status = "covid19Status";
	public static final String s_healthStatus = "healthStatus";
	public static final String s_quarIsltStatus = "quarIsltStatus";
	public static final String s_quarIsltStartDateTime = "quarIsltStartDateTime";
	public static final String s_quarIsltEndDateTime = "quarIsltEndDateTime";
	public static final String s_quarIsltRequestStatus = "quarIsltRequestStatus";
	public static final String s_medicalRequestStatus = "medicalRequestStatus";
	public static final String s_suppliesRequestStatus = "suppliesRequestStatus";
	public static final String s_geofenceStatus = "geofenceStatus";
	public static final String s_appHeartbeatStatus = "appHeartbeatStatus";
	public static final String s_updatedDateTime = "updatedDateTime";
	public static final String s_latitude = "latitude";
	public static final String s_longitude = "longitude";
	public static final String s_comments = "comments";
	
}

