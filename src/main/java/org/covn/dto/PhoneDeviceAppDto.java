package org.covn.dto;

import java.sql.Timestamp;

public class PhoneDeviceAppDto {
	private Timestamp appInstalledDateTime;
	private String appVersion;
	private String deviceImei;
	private String deviceMacId;
	private String deviceManufacturer;
	private String deviceModel;
	private String deviceOs;
	private String deviceOsVersion;
	private String phoneNumber;
	private String phoneServiceProvider;
	private int phoneNumberId;
	
	public Timestamp getAppInstalledDateTime() {
		return appInstalledDateTime;
	}
	public void setAppInstalledDateTime(Timestamp appInstalledDateTime) {
		this.appInstalledDateTime = appInstalledDateTime;
	}
	public String getAppVersion() {
		return appVersion;
	}
	public void setAppVersion(String appVersion) {
		this.appVersion = appVersion;
	}
	public String getDeviceImei() {
		return deviceImei;
	}
	public void setDeviceImei(String deviceImei) {
		this.deviceImei = deviceImei;
	}
	public String getDeviceMacId() {
		return deviceMacId;
	}
	public void setDeviceMacId(String deviceMacId) {
		this.deviceMacId = deviceMacId;
	}
	public String getDeviceManufacturer() {
		return deviceManufacturer;
	}
	public void setDeviceManufacturer(String deviceManufacturer) {
		this.deviceManufacturer = deviceManufacturer;
	}
	public String getDeviceModel() {
		return deviceModel;
	}
	public void setDeviceModel(String deviceModel) {
		this.deviceModel = deviceModel;
	}
	public String getDeviceOs() {
		return deviceOs;
	}
	public void setDeviceOs(String deviceOs) {
		this.deviceOs = deviceOs;
	}
	public String getDeviceOsVersion() {
		return deviceOsVersion;
	}
	public void setDeviceOsVersion(String deviceOsVersion) {
		this.deviceOsVersion = deviceOsVersion;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getPhoneServiceProvider() {
		return phoneServiceProvider;
	}
	public void setPhoneServiceProvider(String phoneServiceProvider) {
		this.phoneServiceProvider = phoneServiceProvider;
	}
	public int getPhoneNumberId() {
		return phoneNumberId;
	}
	public void setPhoneNumberId(int phoneNumberId) {
		this.phoneNumberId = phoneNumberId;
	}
	
	
	
}
