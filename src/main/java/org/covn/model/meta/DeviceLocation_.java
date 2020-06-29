package org.covn.model.meta;


import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import java.math.BigDecimal;
import org.covn.model.db.LocationHierarchy;
import java.sql.Timestamp;
import org.covn.model.db.DeviceLocation;
import javax.persistence.metamodel.SetAttribute;
import org.covn.model.db.Address;


@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(DeviceLocation.class)
public abstract class DeviceLocation_{

	public static volatile SingularAttribute<DeviceLocation, Integer> deviceLocationId;
	public static volatile SingularAttribute<DeviceLocation, Integer> deviceAppId;
	public static volatile SingularAttribute<DeviceLocation, BigDecimal> latitude;
	public static volatile SingularAttribute<DeviceLocation, BigDecimal> longitude;
	public static volatile SingularAttribute<DeviceLocation, Integer> locationId;
	public static volatile SingularAttribute<DeviceLocation, LocationHierarchy> locationHierarchy;
	public static volatile SingularAttribute<DeviceLocation, Integer> addressId;
	public static volatile SingularAttribute<DeviceLocation, Address> address;
	public static volatile SingularAttribute<DeviceLocation, String> locationServiceType;
	public static volatile SingularAttribute<DeviceLocation, Timestamp> locationDateTime;
	public static volatile SingularAttribute<DeviceLocation, String> locationCheckReason;
	public static volatile SingularAttribute<DeviceLocation, String> locationCheckResult;
	public static volatile SingularAttribute<DeviceLocation, String> geofenceStatus;
	public static volatile SingularAttribute<DeviceLocation, String> geofenceAction;
	public static volatile SingularAttribute<DeviceLocation, String> comments;

	public static final String s_deviceLocationId = "deviceLocationId";
	public static final String s_deviceAppId = "deviceAppId";
	public static final String s_latitude = "latitude";
	public static final String s_longitude = "longitude";
	public static final String s_locationId = "locationId";
	public static final String s_locationHierarchy = "locationHierarchy";
	public static final String s_addressId = "addressId";
	public static final String s_address = "address";
	public static final String s_locationServiceType = "locationServiceType";
	public static final String s_locationDateTime = "locationDateTime";
	public static final String s_locationCheckReason = "locationCheckReason";
	public static final String s_locationCheckResult = "locationCheckResult";
	public static final String s_geofenceStatus = "geofenceStatus";
	public static final String s_geofenceAction = "geofenceAction";
	public static final String s_comments = "comments";
	
}

