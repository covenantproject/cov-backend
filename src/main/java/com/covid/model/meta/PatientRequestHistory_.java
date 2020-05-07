package com.covid.model.meta;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import com.covid.model.db.PatientRequestHistory;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(PatientRequestHistory.class)
public abstract class PatientRequestHistory_ {

	public static volatile SingularAttribute<PatientRequestHistory, String> responseComments;
	public static volatile SingularAttribute<PatientRequestHistory, String> responseType;
	public static volatile SingularAttribute<PatientRequestHistory, Integer> patientRequestHistoryId;
	public static volatile SingularAttribute<PatientRequestHistory, String> requestType;
	public static volatile SingularAttribute<PatientRequestHistory, Date> responseDateTime;
	public static volatile SingularAttribute<PatientRequestHistory, Integer> patientId;
	public static volatile SingularAttribute<PatientRequestHistory, Date> requestDateTime;
	public static volatile SingularAttribute<PatientRequestHistory, String> requestComments;
	public static volatile SingularAttribute<PatientRequestHistory, Integer> responseUserId;
	public static volatile SingularAttribute<PatientRequestHistory, String> requestStatus;

	public static final String RESPONSE_COMMENTS = "responseComments";
	public static final String RESPONSE_TYPE = "responseType";
	public static final String PATIENT_REQUEST_HISTORY_ID = "patientRequestHistoryId";
	public static final String REQUEST_TYPE = "requestType";
	public static final String RESPONSE_DATE_TIME = "responseDateTime";
	public static final String PATIENT_ID = "patientId";
	public static final String REQUEST_DATE_TIME = "requestDateTime";
	public static final String REQUEST_COMMENTS = "requestComments";
	public static final String RESPONSE_USER_ID = "responseUserId";
	public static final String REQUEST_STATUS = "requestStatus";

}

