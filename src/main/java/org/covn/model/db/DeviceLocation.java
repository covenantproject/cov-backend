package org.covn.model.db;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.UniqueConstraint;
import javax.persistence.JoinColumn;
import java.sql.Timestamp;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import java.math.BigDecimal;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.SequenceGenerator;
import javax.persistence.FetchType;
import org.covn.model.BaseModel;
import javax.persistence.Id;

import java.io.Serializable;


@Entity
@Table(name = "device_location", schema = "release1", uniqueConstraints={@UniqueConstraint(columnNames = {"device_location_id"})
})
public class DeviceLocation extends BaseModel<DeviceLocation, Integer> implements java.io.Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "device_location_id", nullable = false, length = 10)
	private Integer deviceLocationId;

	@Column(name = "device_app_id", nullable = false, length = 10)
	private Integer deviceAppId;

	@Column(name = "latitude", nullable = true, precision = 10, scale = 8)
	private BigDecimal latitude;

	@Column(name = "longitude", nullable = true, precision = 11, scale = 8)
	private BigDecimal longitude;

	@Column(name = "location_id", nullable = true, length = 10, updatable = false, insertable = false)
	private Integer locationId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "location_id")
	private LocationHierarchy locationHierarchy;

	@Column(name = "address_id", nullable = true, length = 10, updatable = false, insertable = false)
	private Integer addressId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "address_id")
	private Address address;

	@Column(name = "location_service_type", nullable = true, length = 10)
	private String locationServiceType;

	@Column(name = "location_date_time", nullable = true, length = 29)
	private Timestamp locationDateTime;

	@Column(name = "location_check_reason", nullable = true, length = 16)
	private String locationCheckReason;

	@Column(name = "location_check_result", nullable = true, length = 16)
	private String locationCheckResult;

	@Column(name = "geofence_status", nullable = true, length = 16)
	private String geofenceStatus;

	@Column(name = "geofence_action", nullable = true, length = 255)
	private String geofenceAction;

	@Column(name = "comments", nullable = true, length = 255)
	private String comments;


	public Integer getDeviceLocationId(){
		return this.deviceLocationId;
	}
	public DeviceLocation setDeviceLocationId(Integer deviceLocationId){
		this.deviceLocationId = deviceLocationId;
		
		return this;
	}

	public Integer getDeviceAppId(){
		return this.deviceAppId;
	}
	public DeviceLocation setDeviceAppId(Integer deviceAppId){
		this.deviceAppId = deviceAppId;
		
		return this;
	}

	public BigDecimal getLatitude(){
		return this.latitude;
	}
	public DeviceLocation setLatitude(BigDecimal latitude){
		this.latitude = latitude;
		
		return this;
	}

	public BigDecimal getLongitude(){
		return this.longitude;
	}
	public DeviceLocation setLongitude(BigDecimal longitude){
		this.longitude = longitude;
		
		return this;
	}

	public Integer getLocationId(){
		return this.locationId;
	}
	public DeviceLocation setLocationId(Integer locationId){
		this.locationId = locationId;
		
		return this;
	}

	public LocationHierarchy getLocationHierarchy(){
		return this.locationHierarchy;
	}
	public DeviceLocation setLocationHierarchy(LocationHierarchy locationHierarchy){
		this.locationHierarchy = locationHierarchy;
		this.locationId = (this.locationHierarchy == null)? null: this.locationHierarchy.getLocationId();
		return this;
	}

	public Integer getAddressId(){
		return this.addressId;
	}
	public DeviceLocation setAddressId(Integer addressId){
		this.addressId = addressId;
		
		return this;
	}

	public Address getAddress(){
		return this.address;
	}
	public DeviceLocation setAddress(Address address){
		this.address = address;
		this.addressId = (this.address == null)? null: this.address.getAddressId();
		return this;
	}

	public String getLocationServiceType(){
		return this.locationServiceType;
	}
	public DeviceLocation setLocationServiceType(String locationServiceType){
		this.locationServiceType = locationServiceType;
		
		return this;
	}

	public Timestamp getLocationDateTime(){
		return this.locationDateTime;
	}
	public DeviceLocation setLocationDateTime(Timestamp locationDateTime){
		this.locationDateTime = locationDateTime;
		
		return this;
	}

	public String getLocationCheckReason(){
		return this.locationCheckReason;
	}
	public DeviceLocation setLocationCheckReason(String locationCheckReason){
		this.locationCheckReason = locationCheckReason;
		
		return this;
	}

	public String getLocationCheckResult(){
		return this.locationCheckResult;
	}
	public DeviceLocation setLocationCheckResult(String locationCheckResult){
		this.locationCheckResult = locationCheckResult;
		
		return this;
	}

	public String getGeofenceStatus(){
		return this.geofenceStatus;
	}
	public DeviceLocation setGeofenceStatus(String geofenceStatus){
		this.geofenceStatus = geofenceStatus;
		
		return this;
	}

	public String getGeofenceAction(){
		return this.geofenceAction;
	}
	public DeviceLocation setGeofenceAction(String geofenceAction){
		this.geofenceAction = geofenceAction;
		
		return this;
	}

	public String getComments(){
		return this.comments;
	}
	public DeviceLocation setComments(String comments){
		this.comments = comments;
		
		return this;
	}


	@Override
	public Integer getKey() {
		return this.deviceLocationId;
	}

	
	public static DeviceLocation of(){
		return new DeviceLocation();
	}
	
	public static DeviceLocation copy(DeviceLocation src, int depth){
		DeviceLocation copy = null;
		if(depth > 0){
			copy = new DeviceLocation();
			copy.deviceLocationId = src.getDeviceLocationId();
			copy.deviceAppId = src.getDeviceAppId();
			copy.latitude = src.getLatitude();
			copy.longitude = src.getLongitude();
			copy.locationId = src.getLocationId();
			copy.locationHierarchy = (src.getLocationHierarchy() == null)? null : LocationHierarchy.copy(src.getLocationHierarchy(), --depth);
			copy.addressId = src.getAddressId();
			copy.address = (src.getAddress() == null)? null : Address.copy(src.getAddress(), --depth);
			copy.locationServiceType = src.getLocationServiceType();
			copy.locationDateTime = src.getLocationDateTime();
			copy.locationCheckReason = src.getLocationCheckReason();
			copy.locationCheckResult = src.getLocationCheckResult();
			copy.geofenceStatus = src.getGeofenceStatus();
			copy.geofenceAction = src.getGeofenceAction();
			copy.comments = src.getComments();
		}
		return copy;
	}

	@Override
	public DeviceLocation copy() {
		return copy(this, copyDepth);
	}	
}