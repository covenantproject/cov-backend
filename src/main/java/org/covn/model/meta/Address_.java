package org.covn.model.meta;


import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.covn.model.db.Users;
import org.covn.model.db.PatientGeofencedLocation;
import javax.persistence.metamodel.SetAttribute;
import org.covn.model.db.DeviceLocation;
import org.covn.model.db.Address;


@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Address.class)
public abstract class Address_{

	public static volatile SingularAttribute<Address, Integer> addressId;
	public static volatile SingularAttribute<Address, Integer> userId;
	public static volatile SingularAttribute<Address, Users> users;
	public static volatile SingularAttribute<Address, String> addressType;
	public static volatile SingularAttribute<Address, String> companyName;
	public static volatile SingularAttribute<Address, String> inCareOf;
	public static volatile SingularAttribute<Address, String> addressLine1;
	public static volatile SingularAttribute<Address, String> addressLine2;
	public static volatile SingularAttribute<Address, String> addressLine3;
	public static volatile SingularAttribute<Address, String> city;
	public static volatile SingularAttribute<Address, String> districtCounty;
	public static volatile SingularAttribute<Address, String> stateTerritory;
	public static volatile SingularAttribute<Address, String> postCode;
	public static volatile SingularAttribute<Address, String> country;
	public static volatile SetAttribute<Address, PatientGeofencedLocation> patientGeofencedLocationSet;
	public static volatile SetAttribute<Address, DeviceLocation> deviceLocationSet;

	public static final String s_addressId = "addressId";
	public static final String s_userId = "userId";
	public static final String s_users = "users";
	public static final String s_addressType = "addressType";
	public static final String s_companyName = "companyName";
	public static final String s_inCareOf = "inCareOf";
	public static final String s_addressLine1 = "addressLine1";
	public static final String s_addressLine2 = "addressLine2";
	public static final String s_addressLine3 = "addressLine3";
	public static final String s_city = "city";
	public static final String s_districtCounty = "districtCounty";
	public static final String s_stateTerritory = "stateTerritory";
	public static final String s_postCode = "postCode";
	public static final String s_country = "country";
	public static final String s_patientGeofencedLocationSet = "patientGeofencedLocationSet";
	public static final String s_deviceLocationSet = "deviceLocationSet";
	
}

