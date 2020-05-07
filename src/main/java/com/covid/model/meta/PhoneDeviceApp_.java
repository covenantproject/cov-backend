package com.covid.model.meta;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import com.covid.model.db.PhoneDeviceApp;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(PhoneDeviceApp.class)
public abstract class PhoneDeviceApp_ {

	public static volatile SingularAttribute<PhoneDeviceApp, String> appVersion;
	public static volatile SingularAttribute<PhoneDeviceApp, String> devicePhoneNumber;
	public static volatile SingularAttribute<PhoneDeviceApp, String> deviceImei;
	public static volatile SingularAttribute<PhoneDeviceApp, Integer> deviceAppId;
	public static volatile SingularAttribute<PhoneDeviceApp, String> deviceOs;
	public static volatile SingularAttribute<PhoneDeviceApp, String> deviceMacId;
	public static volatile SingularAttribute<PhoneDeviceApp, String> devicePhoneServiceProvider;
	public static volatile SingularAttribute<PhoneDeviceApp, String> deviceModel;
	public static volatile SingularAttribute<PhoneDeviceApp, String> deviceOsVersion;
	public static volatile SingularAttribute<PhoneDeviceApp, String> deviceManufacturer;
	public static volatile SingularAttribute<PhoneDeviceApp, Integer> phoneNumberId;
	public static volatile SingularAttribute<PhoneDeviceApp, Date> appInstalledDateTime;

	public static final String APP_VERSION = "appVersion";
	public static final String DEVICE_PHONE_NUMBER = "devicePhoneNumber";
	public static final String DEVICE_IMEI = "deviceImei";
	public static final String DEVICE_APP_ID = "deviceAppId";
	public static final String DEVICE_OS = "deviceOs";
	public static final String DEVICE_MAC_ID = "deviceMacId";
	public static final String DEVICE_PHONE_SERVICE_PROVIDER = "devicePhoneServiceProvider";
	public static final String DEVICE_MODEL = "deviceModel";
	public static final String DEVICE_OS_VERSION = "deviceOsVersion";
	public static final String DEVICE_MANUFACTURER = "deviceManufacturer";
	public static final String PHONE_NUMBER_ID = "phoneNumberId";
	public static final String APP_INSTALLED_DATE_TIME = "appInstalledDateTime";

}

