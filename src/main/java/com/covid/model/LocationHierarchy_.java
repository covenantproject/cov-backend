package com.covid.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(LocationHierarchy.class)
public abstract class LocationHierarchy_ {

	public static volatile SingularAttribute<LocationHierarchy, Integer> parentLocationId;
	public static volatile SingularAttribute<LocationHierarchy, String> locationName;
	public static volatile SingularAttribute<LocationHierarchy, Integer> locationId;
	public static volatile SingularAttribute<LocationHierarchy, String> countryCode;
	public static volatile SingularAttribute<LocationHierarchy, Boolean> assignPatients;
	public static volatile SingularAttribute<LocationHierarchy, String> locationAbbr;
	public static volatile SingularAttribute<LocationHierarchy, Integer> addressId;

	public static final String PARENT_LOCATION_ID = "parentLocationId";
	public static final String LOCATION_NAME = "locationName";
	public static final String LOCATION_ID = "locationId";
	public static final String COUNTRY_CODE = "countryCode";
	public static final String ASSIGN_PATIENTS = "assignPatients";
	public static final String LOCATION_ABBR = "locationAbbr";
	public static final String ADDRESS_ID = "addressId";

}

