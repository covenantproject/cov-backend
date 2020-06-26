package org.covn.model.db;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.UniqueConstraint;
import javax.persistence.JoinColumn;
import java.sql.Timestamp;
import javax.persistence.OneToMany;
import java.util.Set;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.SequenceGenerator;
import javax.persistence.FetchType;
import org.covn.model.BaseModel;
import javax.persistence.Id;

import java.io.Serializable;


@Entity
@Table(name = "phone_device_app", schema = "release1", uniqueConstraints={@UniqueConstraint(columnNames = {"device_app_id"})
})
public class PhoneDeviceApp extends BaseModel<PhoneDeviceApp, Integer> implements java.io.Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "device_app_id", nullable = false, length = 10)
	private Integer deviceAppId;

	@Column(name = "phone_number_id", nullable = false, length = 10, updatable = false, insertable = false)
	private Integer phoneNumberId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "phone_number_id")
	private PhoneNumber phoneNumber;

	@Column(name = "device_imei", nullable = true, length = 20)
	private String deviceImei;

	@Column(name = "device_mac_id", nullable = true, length = 20)
	private String deviceMacId;

	@Column(name = "device_os", nullable = true, length = 10)
	private String deviceOs;

	@Column(name = "device_os_version", nullable = true, length = 10)
	private String deviceOsVersion;

	@Column(name = "device_manufacturer", nullable = true, length = 16)
	private String deviceManufacturer;

	@Column(name = "device_model", nullable = true, length = 16)
	private String deviceModel;

	@Column(name = "device_phone_number", nullable = true, length = 20)
	private String devicePhoneNumber;

	@Column(name = "device_phone_service_provider", nullable = true, length = 20)
	private String devicePhoneServiceProvider;

	@Column(name = "app_version", nullable = true, length = 10)
	private String appVersion;

	@Column(name = "app_installed_date_time", nullable = true, length = 29)
	private Timestamp appInstalledDateTime;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "phoneDeviceApp")
	private Set<AppHeartbeat> appHeartbeatSet;


	public Integer getDeviceAppId(){
		return this.deviceAppId;
	}
	public PhoneDeviceApp setDeviceAppId(Integer deviceAppId){
		this.deviceAppId = deviceAppId;
		
		return this;
	}

	public Integer getPhoneNumberId(){
		return this.phoneNumberId;
	}
	public PhoneDeviceApp setPhoneNumberId(Integer phoneNumberId){
		this.phoneNumberId = phoneNumberId;
		
		return this;
	}

	public PhoneNumber getPhoneNumber(){
		return this.phoneNumber;
	}
	public PhoneDeviceApp setPhoneNumber(PhoneNumber phoneNumber){
		this.phoneNumber = phoneNumber;
		this.phoneNumberId = (this.phoneNumber == null)? null: this.phoneNumber.getPhoneNumberId();
		return this;
	}

	public String getDeviceImei(){
		return this.deviceImei;
	}
	public PhoneDeviceApp setDeviceImei(String deviceImei){
		this.deviceImei = deviceImei;
		
		return this;
	}

	public String getDeviceMacId(){
		return this.deviceMacId;
	}
	public PhoneDeviceApp setDeviceMacId(String deviceMacId){
		this.deviceMacId = deviceMacId;
		
		return this;
	}

	public String getDeviceOs(){
		return this.deviceOs;
	}
	public PhoneDeviceApp setDeviceOs(String deviceOs){
		this.deviceOs = deviceOs;
		
		return this;
	}

	public String getDeviceOsVersion(){
		return this.deviceOsVersion;
	}
	public PhoneDeviceApp setDeviceOsVersion(String deviceOsVersion){
		this.deviceOsVersion = deviceOsVersion;
		
		return this;
	}

	public String getDeviceManufacturer(){
		return this.deviceManufacturer;
	}
	public PhoneDeviceApp setDeviceManufacturer(String deviceManufacturer){
		this.deviceManufacturer = deviceManufacturer;
		
		return this;
	}

	public String getDeviceModel(){
		return this.deviceModel;
	}
	public PhoneDeviceApp setDeviceModel(String deviceModel){
		this.deviceModel = deviceModel;
		
		return this;
	}

	public String getDevicePhoneNumber(){
		return this.devicePhoneNumber;
	}
	public PhoneDeviceApp setDevicePhoneNumber(String devicePhoneNumber){
		this.devicePhoneNumber = devicePhoneNumber;
		
		return this;
	}

	public String getDevicePhoneServiceProvider(){
		return this.devicePhoneServiceProvider;
	}
	public PhoneDeviceApp setDevicePhoneServiceProvider(String devicePhoneServiceProvider){
		this.devicePhoneServiceProvider = devicePhoneServiceProvider;
		
		return this;
	}

	public String getAppVersion(){
		return this.appVersion;
	}
	public PhoneDeviceApp setAppVersion(String appVersion){
		this.appVersion = appVersion;
		
		return this;
	}

	public Timestamp getAppInstalledDateTime(){
		return this.appInstalledDateTime;
	}
	public PhoneDeviceApp setAppInstalledDateTime(Timestamp appInstalledDateTime){
		this.appInstalledDateTime = appInstalledDateTime;
		
		return this;
	}

	public Set<AppHeartbeat> getAppHeartbeatSet(){
		return this.appHeartbeatSet;
	}
	public PhoneDeviceApp setAppHeartbeatSet(Set<AppHeartbeat> appHeartbeatSet){
		this.appHeartbeatSet = appHeartbeatSet;
		
		return this;
	}


	@Override
	public Integer getKey() {
		return this.deviceAppId;
	}

	
	public static PhoneDeviceApp of(){
		return new PhoneDeviceApp();
	}
	
	public static PhoneDeviceApp copy(PhoneDeviceApp src, int depth){
		PhoneDeviceApp copy = null;
		if(depth > 0){
			copy = new PhoneDeviceApp();
			copy.deviceAppId = src.getDeviceAppId();
			copy.phoneNumberId = src.getPhoneNumberId();
			copy.phoneNumber = (src.getPhoneNumber() == null)? null : PhoneNumber.copy(src.getPhoneNumber(), --depth);
			copy.deviceImei = src.getDeviceImei();
			copy.deviceMacId = src.getDeviceMacId();
			copy.deviceOs = src.getDeviceOs();
			copy.deviceOsVersion = src.getDeviceOsVersion();
			copy.deviceManufacturer = src.getDeviceManufacturer();
			copy.deviceModel = src.getDeviceModel();
			copy.devicePhoneNumber = src.getDevicePhoneNumber();
			copy.devicePhoneServiceProvider = src.getDevicePhoneServiceProvider();
			copy.appVersion = src.getAppVersion();
			copy.appInstalledDateTime = src.getAppInstalledDateTime();
		}
		return copy;
	}

	@Override
	public PhoneDeviceApp copy() {
		return copy(this, copyDepth);
	}	
}