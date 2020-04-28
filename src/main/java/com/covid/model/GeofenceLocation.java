package com.covid.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "\"GeofenceLocation\"")
public class GeofenceLocation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "\"GeofenceLocationId\"")
	private int GeofenceLocationId;
	
	@Column(name = "\"PatientId\"")
	private int PatientId;
	
	@Column(name = "\"GeoFenceLatitude\"")
	private double GeoFenceLatitude;
	
	@Column(name = "\"GeoFenceLongitude\"")
	private double GeoFenceLongitude;
	
	@Column(name = "\"GeoFenceRadiusMetres\"")
	private double GeoFenceRadiusMetres;

	@Column(name = "\"GeoFenceStartDate\"")
	private Date GeoFenceStartDate;

	@Column(name = "\"GeoFenceEndDate\"")
	private Date GeoFenceEndDate;

	private Boolean geoFenceSet;

	public int getGeofenceLocationId() {
		return GeofenceLocationId;
	}

	public void setGeofenceLocationId(int geofenceLocationId) {
		GeofenceLocationId = geofenceLocationId;
	}

	public int getPatientId() {
		return PatientId;
	}

	public void setPatientId(int patientId) {
		PatientId = patientId;
	}

	public double getGeoFenceLatitude() {
		return GeoFenceLatitude;
	}

	public void setGeoFenceLatitude(double geoFenceLatitude) {
		GeoFenceLatitude = geoFenceLatitude;
	}

	public double getGeoFenceLongitude() {
		return GeoFenceLongitude;
	}

	public void setGeoFenceLongitude(double geoFenceLongitude) {
		GeoFenceLongitude = geoFenceLongitude;
	}

	public double getGeoFenceRadiusMetres() {
		return GeoFenceRadiusMetres;
	}

	public void setGeoFenceRadiusMetres(double geoFenceRadiusMetres) {
		GeoFenceRadiusMetres = geoFenceRadiusMetres;
	}

	public Date getGeoFenceStartDate() {
		return GeoFenceStartDate;
	}

	public void setGeoFenceStartDate(Date geoFenceStartDate) {
		GeoFenceStartDate = geoFenceStartDate;
	}

	public Date getGeoFenceEndDate() {
		return GeoFenceEndDate;
	}

	public void setGeoFenceEndDate(Date geoFenceEndDate) {
		GeoFenceEndDate = geoFenceEndDate;
	}

	public Boolean getGeoFenceSet() {
		return geoFenceSet;
	}

	public void setGeoFenceSet(Boolean geoFenceSet) {
		this.geoFenceSet = geoFenceSet;
	}

}
