package org.covn.dto;

import java.math.BigDecimal;
import java.sql.Timestamp;

import org.covn.model.type.GeofenceStatus;
import org.covn.model.type.LocationCheckReason;
import org.covn.model.type.LocationCheckResult;
import org.covn.model.type.LocationServiceType;

public class DeviceLocationDto {
	/** Current location of the device
	 *  PatientId is the UserId of the primary user who owns the device.
	 *  PatientId is obtained by first joining the device_app_id to the phone_number
	 *  and then finding its primary_user_id
	 *   
	 */

	private int deviceAppId;
	private int patientId; // deviceAppId -> phoneNumber.PrimaryUserId = patientId
	private GeofenceStatus geofenceStatus;
	private BigDecimal latitude; // precision = 10, scale = 8
	private BigDecimal longitude; // precision = 11, scale = 8
	private LocationCheckReason locationCheckReason;
	private LocationCheckResult locationCheckType;
	private LocationServiceType locationServiceType;
	private Timestamp locationDateTime;
	private int locationId;
	private int addressId;
	// private String geofence_action; currently not used in release1
	public int getDeviceAppId() {
		return deviceAppId;
	}
	public void setDeviceAppId(int deviceAppId) {
		this.deviceAppId = deviceAppId;
	}
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public GeofenceStatus getGeofenceStatus() {
		return geofenceStatus;
	}
	public void setGeofenceStatus(GeofenceStatus geofenceStatus) {
		this.geofenceStatus = geofenceStatus;
	}
	public BigDecimal getLatitude() {
		return latitude;
	}
	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
	}
	public BigDecimal getLongitude() {
		return longitude;
	}
	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	}
	public LocationCheckReason getLocationCheckReason() {
		return locationCheckReason;
	}
	public void setLocationCheckReason(LocationCheckReason locationCheckReason) {
		this.locationCheckReason = locationCheckReason;
	}
	public LocationCheckResult getLocationCheckType() {
		return locationCheckType;
	}
	public void setLocationCheckType(LocationCheckResult locationCheckType) {
		this.locationCheckType = locationCheckType;
	}
	public LocationServiceType getLocationServiceType() {
		return locationServiceType;
	}
	public void setLocationServiceType(LocationServiceType locationServiceType) {
		this.locationServiceType = locationServiceType;
	}
	public Timestamp getLocationDateTime() {
		return locationDateTime;
	}
	public void setLocationDateTime(Timestamp locationDateTime) {
		this.locationDateTime = locationDateTime;
	}
	public int getLocationId() {
		return locationId;
	}
	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}



}
