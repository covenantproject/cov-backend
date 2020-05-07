package com.covid.model.meta;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import com.covid.model.db.PatientGeofencedLocation;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(PatientGeofencedLocation.class)
public abstract class PatientGeofencedLocation_ {

	public static volatile SingularAttribute<PatientGeofencedLocation, Double> radiusMetres;
	public static volatile SingularAttribute<PatientGeofencedLocation, String> geofenceStatus;
	public static volatile SingularAttribute<PatientGeofencedLocation, Integer> patientId;
	public static volatile SingularAttribute<PatientGeofencedLocation, BigDecimal> latitude;
	public static volatile SingularAttribute<PatientGeofencedLocation, Integer> geofencedLocationId;
	public static volatile SingularAttribute<PatientGeofencedLocation, Integer> addressId;
	public static volatile SingularAttribute<PatientGeofencedLocation, BigDecimal> longitude;

	public static final String RADIUS_METRES = "radiusMetres";
	public static final String GEOFENCE_STATUS = "geofenceStatus";
	public static final String PATIENT_ID = "patientId";
	public static final String LATITUDE = "latitude";
	public static final String GEOFENCED_LOCATION_ID = "geofencedLocationId";
	public static final String ADDRESS_ID = "addressId";
	public static final String LONGITUDE = "longitude";

}

