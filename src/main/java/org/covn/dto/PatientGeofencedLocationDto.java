package org.covn.dto;

import java.math.BigDecimal;
import java.util.Date;

import org.joda.time.DateTime;

public class PatientGeofencedLocationDto {
	 /** Location where the patient is geofenced while under quarantine or isolation
	  *  The geofenced location may (optionally) correspond to a street address denoted by the addressId
	  *  Radius is set to 30m (100 ft) by default but it can be changed by the quarantine officer
	  */
	
	private int geofencedLocationId;
	private int patientId;
	private int addressId;
	private BigDecimal latitude; // precision = 10, scale = 8
	private BigDecimal longitude; // precision = 11, scale = 8
	private Double radiusMetres;
	private String geofenceStatus;
	
	public int getGeofencedLocationId() {
		return geofencedLocationId;
	}
	public void setGeofencedLocationId(int geofencedLocationId) {
		this.geofencedLocationId = geofencedLocationId;
	}
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
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
	public Double getRadiusMetres() {
		return radiusMetres;
	}
	public void setRadiusMetres(Double radiusMetres) {
		this.radiusMetres = radiusMetres;
	}
	public String getGeofenceStatus() {
		return geofenceStatus;
	}
	public void setGeofenceStatus(String geofenceStatus) {
		this.geofenceStatus = geofenceStatus;
	}
	
}	

