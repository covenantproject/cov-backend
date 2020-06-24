package org.covn.model.meta;


import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import org.covn.model.db.AppHeartbeat;
import org.covn.model.db.HealthCheck;
import org.covn.model.db.PhoneDeviceApp;

import java.sql.Timestamp;

import javax.persistence.metamodel.SetAttribute;


@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(AppHeartbeat.class)
public abstract class AppHeartbeat_{

	public static volatile SingularAttribute<AppHeartbeat, Integer> appHeartbeatId;
	public static volatile SingularAttribute<AppHeartbeat, Integer> deviceAppId;
	public static volatile SingularAttribute<AppHeartbeat, PhoneDeviceApp> phoneDeviceApp;
	public static volatile SingularAttribute<AppHeartbeat, Timestamp> heartbeatDateTime;
	public static volatile SingularAttribute<AppHeartbeat, String> heartBeatIp4Address;
	public static volatile SingularAttribute<AppHeartbeat, String> heartBeatIp6Address;
	public static volatile SingularAttribute<AppHeartbeat, String> heartbeatStatus;
	public static volatile SetAttribute<AppHeartbeat, HealthCheck> healthCheckHistorySet;

	public static final String s_appHeartbeatId = "appHeartbeatId";
	public static final String s_deviceAppId = "deviceAppId";
	public static final String s_phoneDeviceApp = "phoneDeviceApp";
	public static final String s_heartbeatDateTime = "heartbeatDateTime";
	public static final String s_heartBeatIp4Address = "heartBeatIp4Address";
	public static final String s_heartBeatIp6Address = "heartBeatIp6Address";
	public static final String s_heartbeatStatus = "heartbeatStatus";
	public static final String s_healthCheckHistorySet = "healthCheckHistorySet";
	
}

