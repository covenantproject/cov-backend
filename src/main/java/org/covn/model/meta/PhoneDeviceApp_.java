package org.covn.model.meta;


import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import java.sql.Timestamp;
import javax.persistence.metamodel.SetAttribute;
import org.covn.model.db.AppHeartbeat;
import org.covn.model.db.PhoneDeviceApp;
import org.covn.model.db.PhoneNumber;


@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(PhoneDeviceApp.class)
public abstract class PhoneDeviceApp_{

	public static volatile SingularAttribute<PhoneDeviceApp, Integer> deviceAppId;
	public static volatile SingularAttribute<PhoneDeviceApp, Integer> phoneNumberId;
	public static volatile SingularAttribute<PhoneDeviceApp, PhoneNumber> phoneNumber;
	public static volatile SingularAttribute<PhoneDeviceApp, String> deviceImei;
	public static volatile SingularAttribute<PhoneDeviceApp, String> deviceMacId;
	public static volatile SingularAttribute<PhoneDeviceApp, String> deviceOs;
	public static volatile SingularAttribute<PhoneDeviceApp, String> deviceOsVersion;
	public static volatile SingularAttribute<PhoneDeviceApp, String> deviceManufacturer;
	public static volatile SingularAttribute<PhoneDeviceApp, String> deviceModel;
	public static volatile SingularAttribute<PhoneDeviceApp, String> devicePhoneNumber;
	public static volatile SingularAttribute<PhoneDeviceApp, String> devicePhoneServiceProvider;
	public static volatile SingularAttribute<PhoneDeviceApp, String> appVersion;
	public static volatile SingularAttribute<PhoneDeviceApp, Timestamp> appInstalledDateTime;
	public static volatile SetAttribute<PhoneDeviceApp, AppHeartbeat> appHeartbeatSet;

	public static final String s_deviceAppId = "deviceAppId";
	public static final String s_phoneNumberId = "phoneNumberId";
	public static final String s_phoneNumber = "phoneNumber";
	public static final String s_deviceImei = "deviceImei";
	public static final String s_deviceMacId = "deviceMacId";
	public static final String s_deviceOs = "deviceOs";
	public static final String s_deviceOsVersion = "deviceOsVersion";
	public static final String s_deviceManufacturer = "deviceManufacturer";
	public static final String s_deviceModel = "deviceModel";
	public static final String s_devicePhoneNumber = "devicePhoneNumber";
	public static final String s_devicePhoneServiceProvider = "devicePhoneServiceProvider";
	public static final String s_appVersion = "appVersion";
	public static final String s_appInstalledDateTime = "appInstalledDateTime";
	public static final String s_appHeartbeatSet = "appHeartbeatSet";
	
}

