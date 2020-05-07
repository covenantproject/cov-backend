package com.covid.model.meta;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import com.covid.model.db.HealthCheckHistory;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(HealthCheckHistory.class)
public abstract class HealthCheckHistory_ {

	public static volatile SingularAttribute<HealthCheckHistory, Integer> spo2Percent;
	public static volatile SingularAttribute<HealthCheckHistory, Boolean> coughPresent;
	public static volatile SingularAttribute<HealthCheckHistory, String> comments;
	public static volatile SingularAttribute<HealthCheckHistory, Integer> heartRatePerMin;
	public static volatile SingularAttribute<HealthCheckHistory, Integer> patientId;
	public static volatile SingularAttribute<HealthCheckHistory, String> healthCheckReason;
	public static volatile SingularAttribute<HealthCheckHistory, Integer> appHeartbeatId;
	public static volatile SingularAttribute<HealthCheckHistory, Integer> diastolicBpMmhg;
	public static volatile SingularAttribute<HealthCheckHistory, Double> temperatureCelsius;
	public static volatile SingularAttribute<HealthCheckHistory, Integer> systolicBpMmhg;
	public static volatile SingularAttribute<HealthCheckHistory, Integer> healthHistoryId;
	public static volatile SingularAttribute<HealthCheckHistory, Integer> respRatePerMin;
	public static volatile SingularAttribute<HealthCheckHistory, Boolean> feverPresent;
	public static volatile SingularAttribute<HealthCheckHistory, Integer> locationId;
	public static volatile SingularAttribute<HealthCheckHistory, String> progressStatus;
	public static volatile SingularAttribute<HealthCheckHistory, Integer> enteredByUserId;
	public static volatile SingularAttribute<HealthCheckHistory, String> healthCheckByUserType;
	public static volatile SingularAttribute<HealthCheckHistory, Boolean> breathingDifficultyPresent;
	public static volatile SingularAttribute<HealthCheckHistory, Date> healthCheckDateTime;

	public static final String SPO2_PERCENT = "spo2Percent";
	public static final String COUGH_PRESENT = "coughPresent";
	public static final String COMMENTS = "comments";
	public static final String HEART_RATE_PER_MIN = "heartRatePerMin";
	public static final String PATIENT_ID = "patientId";
	public static final String HEALTH_CHECK_REASON = "healthCheckReason";
	public static final String APP_HEARTBEAT_ID = "appHeartbeatId";
	public static final String DIASTOLIC_BP_MMHG = "diastolicBpMmhg";
	public static final String TEMPERATURE_CELSIUS = "temperatureCelsius";
	public static final String SYSTOLIC_BP_MMHG = "systolicBpMmhg";
	public static final String HEALTH_HISTORY_ID = "healthHistoryId";
	public static final String RESP_RATE_PER_MIN = "respRatePerMin";
	public static final String FEVER_PRESENT = "feverPresent";
	public static final String LOCATION_ID = "locationId";
	public static final String PROGRESS_STATUS = "progressStatus";
	public static final String ENTERED_BY_USER_ID = "enteredByUserId";
	public static final String HEALTH_CHECK_BY_USER_TYPE = "healthCheckByUserType";
	public static final String BREATHING_DIFFICULTY_PRESENT = "breathingDifficultyPresent";
	public static final String HEALTH_CHECK_DATE_TIME = "healthCheckDateTime";

}

