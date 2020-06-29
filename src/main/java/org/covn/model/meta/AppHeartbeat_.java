package org.covn.model.meta;


import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.covn.model.db.HealthCheckHistory;
import java.sql.Timestamp;
import org.covn.model.db.AppHeartbeat;
import javax.persistence.metamodel.SetAttribute;
import org.covn.model.db.PhoneDeviceApp;


@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(AppHeartbeat.class)
public abstract class AppHeartbeat_{

	public static volatile SingularAttribute<AppHeartbeat, Integer> appHeartbeatId;
	public static volatile SingularAttribute<AppHeartbeat, Integer> deviceAppId;
	public static volatile SingularAttribute<AppHeartbeat, PhoneDeviceApp> phoneDeviceApp;
	public static volatile SingularAttribute<AppHeartbeat, Timestamp> heartbeatDateTime;
	public static volatile SingularAttribute<AppHeartbeat, String> heartbeatIp4Address;
	public static volatile SingularAttribute<AppHeartbeat, String> heartbeatIp6Address;
	public static volatile SingularAttribute<AppHeartbeat, String> heartbeatStatus;
	public static volatile SetAttribute<AppHeartbeat, HealthCheckHistory> healthCheckHistorySet;

	public static final String s_appHeartbeatId = "appHeartbeatId";
	public static final String s_deviceAppId = "deviceAppId";
	public static final String s_phoneDeviceApp = "phoneDeviceApp";
	public static final String s_heartbeatDateTime = "heartbeatDateTime";
	public static final String s_heartbeatIp4Address = "heartbeatIp4Address";
	public static final String s_heartbeatIp6Address = "heartbeatIp6Address";
	public static final String s_heartbeatStatus = "heartbeatStatus";
	public static final String s_healthCheckHistorySet = "healthCheckHistorySet";
	
}

