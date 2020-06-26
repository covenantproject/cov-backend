package org.covn.model.db;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.UniqueConstraint;
import javax.persistence.JoinColumn;
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
@Table(name = "patient_geofenced_location", schema = "release1", uniqueConstraints={@UniqueConstraint(columnNames = {"geofenced_location_id"})
})
public class PatientGeofencedLocation extends BaseModel<PatientGeofencedLocation, Integer> implements java.io.Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "geofenced_location_id", nullable = false, length = 10)
	private Integer geofencedLocationId;

	@Column(name = "patient_id", nullable = false, length = 10, updatable = false, insertable = false)
	private Integer patientId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "patient_id")
	private Patient patient;

	@Column(name = "address_id", nullable = true, length = 10, updatable = false, insertable = false)
	private Integer addressId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "address_id")
	private Address address;

	@Column(name = "latitude", nullable = true, precision = 10, scale = 8)
	private BigDecimal latitude;

	@Column(name = "longitude", nullable = true, precision = 11, scale = 8)
	private BigDecimal longitude;

	@Column(name = "radius_metres", nullable = true, length = 17)
	private Double radiusMetres;

	@Column(name = "geofence_status", nullable = true, length = 32)
	private String geofenceStatus;


	public Integer getGeofencedLocationId(){
		return this.geofencedLocationId;
	}
	public PatientGeofencedLocation setGeofencedLocationId(Integer geofencedLocationId){
		this.geofencedLocationId = geofencedLocationId;
		
		return this;
	}

	public Integer getPatientId(){
		return this.patientId;
	}
	public PatientGeofencedLocation setPatientId(Integer patientId){
		this.patientId = patientId;
		
		return this;
	}

	public Patient getPatient(){
		return this.patient;
	}
	public PatientGeofencedLocation setPatient(Patient patient){
		this.patient = patient;
		this.patientId = (this.patient == null)? null: this.patient.getPatientId();
		return this;
	}

	public Integer getAddressId(){
		return this.addressId;
	}
	public PatientGeofencedLocation setAddressId(Integer addressId){
		this.addressId = addressId;
		
		return this;
	}

	public Address getAddress(){
		return this.address;
	}
	public PatientGeofencedLocation setAddress(Address address){
		this.address = address;
		this.addressId = (this.address == null)? null: this.address.getAddressId();
		return this;
	}

	public BigDecimal getLatitude(){
		return this.latitude;
	}
	public PatientGeofencedLocation setLatitude(BigDecimal latitude){
		this.latitude = latitude;
		
		return this;
	}

	public BigDecimal getLongitude(){
		return this.longitude;
	}
	public PatientGeofencedLocation setLongitude(BigDecimal longitude){
		this.longitude = longitude;
		
		return this;
	}

	public Double getRadiusMetres(){
		return this.radiusMetres;
	}
	public PatientGeofencedLocation setRadiusMetres(Double radiusMetres){
		this.radiusMetres = radiusMetres;
		
		return this;
	}

	public String getGeofenceStatus(){
		return this.geofenceStatus;
	}
	public PatientGeofencedLocation setGeofenceStatus(String geofenceStatus){
		this.geofenceStatus = geofenceStatus;
		
		return this;
	}


	@Override
	public Integer getKey() {
		return this.geofencedLocationId;
	}

	
	public static PatientGeofencedLocation of(){
		return new PatientGeofencedLocation();
	}
	
	public static PatientGeofencedLocation copy(PatientGeofencedLocation src, int depth){
		PatientGeofencedLocation copy = null;
		if(depth > 0){
			copy = new PatientGeofencedLocation();
			copy.geofencedLocationId = src.getGeofencedLocationId();
			copy.patientId = src.getPatientId();
			copy.patient = (src.getPatient() == null)? null : Patient.copy(src.getPatient(), --depth);
			copy.addressId = src.getAddressId();
			copy.address = (src.getAddress() == null)? null : Address.copy(src.getAddress(), --depth);
			copy.latitude = src.getLatitude();
			copy.longitude = src.getLongitude();
			copy.radiusMetres = src.getRadiusMetres();
			copy.geofenceStatus = src.getGeofenceStatus();
		}
		return copy;
	}

	@Override
	public PatientGeofencedLocation copy() {
		return copy(this, copyDepth);
	}	
}