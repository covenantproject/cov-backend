package org.covn.model.meta;


import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import java.math.BigDecimal;
import org.covn.model.db.PatientGeofencedLocation;
import org.covn.model.db.Patient;
import javax.persistence.metamodel.SetAttribute;
import org.covn.model.db.Address;


@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(PatientGeofencedLocation.class)
public abstract class PatientGeofencedLocation_{

	public static volatile SingularAttribute<PatientGeofencedLocation, Integer> geofencedLocationId;
	public static volatile SingularAttribute<PatientGeofencedLocation, Integer> patientId;
	public static volatile SingularAttribute<PatientGeofencedLocation, Patient> patient;
	public static volatile SingularAttribute<PatientGeofencedLocation, Integer> addressId;
	public static volatile SingularAttribute<PatientGeofencedLocation, Address> address;
	public static volatile SingularAttribute<PatientGeofencedLocation, BigDecimal> latitude;
	public static volatile SingularAttribute<PatientGeofencedLocation, BigDecimal> longitude;
	public static volatile SingularAttribute<PatientGeofencedLocation, Double> radiusMetres;
	public static volatile SingularAttribute<PatientGeofencedLocation, String> geofenceStatus;

	public static final String s_geofencedLocationId = "geofencedLocationId";
	public static final String s_patientId = "patientId";
	public static final String s_patient = "patient";
	public static final String s_addressId = "addressId";
	public static final String s_address = "address";
	public static final String s_latitude = "latitude";
	public static final String s_longitude = "longitude";
	public static final String s_radiusMetres = "radiusMetres";
	public static final String s_geofenceStatus = "geofenceStatus";
	
}

