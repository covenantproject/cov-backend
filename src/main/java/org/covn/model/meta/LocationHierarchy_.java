package org.covn.model.meta;


import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.covn.model.db.PatientProviderRel;
import org.covn.model.db.HealthPro;
import org.covn.model.db.LocationHierarchy;
import org.covn.model.db.HealthCheckHistory;
import javax.persistence.metamodel.SetAttribute;
import org.covn.model.db.DeviceLocation;


@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(LocationHierarchy.class)
public abstract class LocationHierarchy_{

	public static volatile SingularAttribute<LocationHierarchy, Integer> locationId;
	public static volatile SingularAttribute<LocationHierarchy, String> locationName;
	public static volatile SingularAttribute<LocationHierarchy, String> locationAbbr;
	public static volatile SingularAttribute<LocationHierarchy, Boolean> assignPatients;
	public static volatile SingularAttribute<LocationHierarchy, Integer> parentLocationId;
	public static volatile SingularAttribute<LocationHierarchy, LocationHierarchy> parent;
	public static volatile SingularAttribute<LocationHierarchy, String> countryCode;
	public static volatile SingularAttribute<LocationHierarchy, Integer> addressId;
	public static volatile SingularAttribute<LocationHierarchy, String> locationType;
	public static volatile SetAttribute<LocationHierarchy, LocationHierarchy> children;
	public static volatile SetAttribute<LocationHierarchy, HealthPro> healthProSet;
	public static volatile SetAttribute<LocationHierarchy, DeviceLocation> deviceLocationSet;
	public static volatile SetAttribute<LocationHierarchy, PatientProviderRel> patientProviderRelSet;
	public static volatile SetAttribute<LocationHierarchy, HealthCheckHistory> healthCheckHistorySet;

	public static final String s_locationId = "locationId";
	public static final String s_locationName = "locationName";
	public static final String s_locationAbbr = "locationAbbr";
	public static final String s_assignPatients = "assignPatients";
	public static final String s_parentLocationId = "parentLocationId";
	public static final String s_parent = "parent";
	public static final String s_countryCode = "countryCode";
	public static final String s_addressId = "addressId";
	public static final String s_locationType = "locationType";
	public static final String s_children = "children";
	public static final String s_healthProSet = "healthProSet";
	public static final String s_deviceLocationSet = "deviceLocationSet";
	public static final String s_patientProviderRelSet = "patientProviderRelSet";
	public static final String s_healthCheckHistorySet = "healthCheckHistorySet";
	
}

