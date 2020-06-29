package org.covn.model.meta;


import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.covn.model.db.Users;
import org.covn.model.db.HealthCheckHistory;
import org.covn.model.db.LocationHierarchy;
import java.sql.Timestamp;
import org.covn.model.db.Patient;
import org.covn.model.db.AppHeartbeat;
import javax.persistence.metamodel.SetAttribute;


@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(HealthCheckHistory.class)
public abstract class HealthCheckHistory_{

	public static volatile SingularAttribute<HealthCheckHistory, Integer> healthHistoryId;
	public static volatile SingularAttribute<HealthCheckHistory, Integer> patientId;
	public static volatile SingularAttribute<HealthCheckHistory, Patient> patient;
	public static volatile SingularAttribute<HealthCheckHistory, Integer> enteredByUserId;
	public static volatile SingularAttribute<HealthCheckHistory, Users> users;
	public static volatile SingularAttribute<HealthCheckHistory, String> healthCheckByUserType;
	public static volatile SingularAttribute<HealthCheckHistory, Integer> appHeartbeatId;
	public static volatile SingularAttribute<HealthCheckHistory, AppHeartbeat> appHeartbeat;
	public static volatile SingularAttribute<HealthCheckHistory, Integer> locationId;
	public static volatile SingularAttribute<HealthCheckHistory, LocationHierarchy> locationHierarchy;
	public static volatile SingularAttribute<HealthCheckHistory, Timestamp> healthCheckDateTime;
	public static volatile SingularAttribute<HealthCheckHistory, String> healthCheckReason;
	public static volatile SingularAttribute<HealthCheckHistory, Boolean> coughPresent;
	public static volatile SingularAttribute<HealthCheckHistory, Boolean> feverPresent;
	public static volatile SingularAttribute<HealthCheckHistory, Boolean> breathingDifficultyPresent;
	public static volatile SingularAttribute<HealthCheckHistory, String> progressStatus;
	public static volatile SingularAttribute<HealthCheckHistory, Double> temperatureCelsius;
	public static volatile SingularAttribute<HealthCheckHistory, Integer> heartRatePerMin;
	public static volatile SingularAttribute<HealthCheckHistory, Integer> respRatePerMin;
	public static volatile SingularAttribute<HealthCheckHistory, Integer> spo2Percent;
	public static volatile SingularAttribute<HealthCheckHistory, Integer> systolicBpMmhg;
	public static volatile SingularAttribute<HealthCheckHistory, Integer> diastolicBpMmhg;
	public static volatile SingularAttribute<HealthCheckHistory, String> comments;

	public static final String s_healthHistoryId = "healthHistoryId";
	public static final String s_patientId = "patientId";
	public static final String s_patient = "patient";
	public static final String s_enteredByUserId = "enteredByUserId";
	public static final String s_users = "users";
	public static final String s_healthCheckByUserType = "healthCheckByUserType";
	public static final String s_appHeartbeatId = "appHeartbeatId";
	public static final String s_appHeartbeat = "appHeartbeat";
	public static final String s_locationId = "locationId";
	public static final String s_locationHierarchy = "locationHierarchy";
	public static final String s_healthCheckDateTime = "healthCheckDateTime";
	public static final String s_healthCheckReason = "healthCheckReason";
	public static final String s_coughPresent = "coughPresent";
	public static final String s_feverPresent = "feverPresent";
	public static final String s_breathingDifficultyPresent = "breathingDifficultyPresent";
	public static final String s_progressStatus = "progressStatus";
	public static final String s_temperatureCelsius = "temperatureCelsius";
	public static final String s_heartRatePerMin = "heartRatePerMin";
	public static final String s_respRatePerMin = "respRatePerMin";
	public static final String s_spo2Percent = "spo2Percent";
	public static final String s_systolicBpMmhg = "systolicBpMmhg";
	public static final String s_diastolicBpMmhg = "diastolicBpMmhg";
	public static final String s_comments = "comments";
	
}

