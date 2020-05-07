package com.covid.model.meta;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import com.covid.model.db.PatientStatus;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(PatientStatus.class)
public abstract class PatientStatus_ {

	public static volatile SingularAttribute<PatientStatus, Date> quarIsltStartDateTime;
	public static volatile SingularAttribute<PatientStatus, Date> quarIsltEndDateTime;
	public static volatile SingularAttribute<PatientStatus, String> geofenceStatus;
	public static volatile SingularAttribute<PatientStatus, String> comments;
	public static volatile SingularAttribute<PatientStatus, Integer> patientId;
	public static volatile SingularAttribute<PatientStatus, BigDecimal> latitude;
	public static volatile SingularAttribute<PatientStatus, String> suppliesRequestStatus;
	public static volatile SingularAttribute<PatientStatus, Date> updatedDateTime;
	public static volatile SingularAttribute<PatientStatus, Integer> patientStatusId;
	public static volatile SingularAttribute<PatientStatus, String> medicalRequestStatus;
	public static volatile SingularAttribute<PatientStatus, String> healthStatus;
	public static volatile SingularAttribute<PatientStatus, String> covid19Status;
	public static volatile SingularAttribute<PatientStatus, String> quarIsltStatus;
	public static volatile SingularAttribute<PatientStatus, String> appHeartbeatStatus;
	public static volatile SingularAttribute<PatientStatus, String> quarIsltRequestStatus;
	public static volatile SingularAttribute<PatientStatus, BigDecimal> longitude;

	public static final String QUAR_ISLT_START_DATE_TIME = "quarIsltStartDateTime";
	public static final String QUAR_ISLT_END_DATE_TIME = "quarIsltEndDateTime";
	public static final String GEOFENCE_STATUS = "geofenceStatus";
	public static final String COMMENTS = "comments";
	public static final String PATIENT_ID = "patientId";
	public static final String LATITUDE = "latitude";
	public static final String SUPPLIES_REQUEST_STATUS = "suppliesRequestStatus";
	public static final String UPDATED_DATE_TIME = "updatedDateTime";
	public static final String PATIENT_STATUS_ID = "patientStatusId";
	public static final String MEDICAL_REQUEST_STATUS = "medicalRequestStatus";
	public static final String HEALTH_STATUS = "healthStatus";
	public static final String COVID19_STATUS = "covid19Status";
	public static final String QUAR_ISLT_STATUS = "quarIsltStatus";
	public static final String APP_HEARTBEAT_STATUS = "appHeartbeatStatus";
	public static final String QUAR_ISLT_REQUEST_STATUS = "quarIsltRequestStatus";
	public static final String LONGITUDE = "longitude";

}

