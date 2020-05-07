package com.covid.model.meta;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import com.covid.model.db.DeviceLocation;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(DeviceLocation.class)
public abstract class DeviceLocation_ {

	public static volatile SingularAttribute<DeviceLocation, String> locationServiceType;
	public static volatile SingularAttribute<DeviceLocation, String> locationCheckResult;
	public static volatile SingularAttribute<DeviceLocation, String> geofenceStatus;
	public static volatile SingularAttribute<DeviceLocation, String> comments;
	public static volatile SingularAttribute<DeviceLocation, String> geofenceAction;
	public static volatile SingularAttribute<DeviceLocation, Integer> deviceAppId;
	public static volatile SingularAttribute<DeviceLocation, BigDecimal> latitude;
	public static volatile SingularAttribute<DeviceLocation, Date> locationDateTime;
	public static volatile SingularAttribute<DeviceLocation, Integer> deviceLocationId;
	public static volatile SingularAttribute<DeviceLocation, Integer> addressId;
	public static volatile SingularAttribute<DeviceLocation, Integer> locationId;
	public static volatile SingularAttribute<DeviceLocation, String> locationCheckReason;
	public static volatile SingularAttribute<DeviceLocation, BigDecimal> longitude;

	public static final String LOCATION_SERVICE_TYPE = "locationServiceType";
	public static final String LOCATION_CHECK_RESULT = "locationCheckResult";
	public static final String GEOFENCE_STATUS = "geofenceStatus";
	public static final String COMMENTS = "comments";
	public static final String GEOFENCE_ACTION = "geofenceAction";
	public static final String DEVICE_APP_ID = "deviceAppId";
	public static final String LATITUDE = "latitude";
	public static final String LOCATION_DATE_TIME = "locationDateTime";
	public static final String DEVICE_LOCATION_ID = "deviceLocationId";
	public static final String ADDRESS_ID = "addressId";
	public static final String LOCATION_ID = "locationId";
	public static final String LOCATION_CHECK_REASON = "locationCheckReason";
	public static final String LONGITUDE = "longitude";

}

