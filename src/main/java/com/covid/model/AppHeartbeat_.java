package com.covid.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(AppHeartbeat.class)
public abstract class AppHeartbeat_ {

	public static volatile SingularAttribute<AppHeartbeat, String> heartBeatIp4Address;
	public static volatile SingularAttribute<AppHeartbeat, String> heartBeatIp6Address;
	public static volatile SingularAttribute<AppHeartbeat, String> heartbeatStatus;
	public static volatile SingularAttribute<AppHeartbeat, Integer> deviceAppId;
	public static volatile SingularAttribute<AppHeartbeat, Integer> appHeartbeatId;
	public static volatile SingularAttribute<AppHeartbeat, Date> heartbeatDateTime;

	public static final String HEART_BEAT_IP4_ADDRESS = "heartBeatIp4Address";
	public static final String HEART_BEAT_IP6_ADDRESS = "heartBeatIp6Address";
	public static final String HEARTBEAT_STATUS = "heartbeatStatus";
	public static final String DEVICE_APP_ID = "deviceAppId";
	public static final String APP_HEARTBEAT_ID = "appHeartbeatId";
	public static final String HEARTBEAT_DATE_TIME = "heartbeatDateTime";

}

