package com.covid.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Address.class)
public abstract class Address_ {

	public static volatile SingularAttribute<Address, String> country;
	public static volatile SingularAttribute<Address, String> inCareOf;
	public static volatile SingularAttribute<Address, String> city;
	public static volatile SingularAttribute<Address, String> addressType;
	public static volatile SingularAttribute<Address, String> companyName;
	public static volatile SingularAttribute<Address, String> stateTerritory;
	public static volatile SingularAttribute<Address, Integer> userId;
	public static volatile SingularAttribute<Address, Integer> addressId;
	public static volatile SingularAttribute<Address, String> addressLine1;
	public static volatile SingularAttribute<Address, String> addressLine2;
	public static volatile SingularAttribute<Address, String> postCode;
	public static volatile SingularAttribute<Address, String> addressLine3;
	public static volatile SingularAttribute<Address, String> districtCounty;

	public static final String COUNTRY = "country";
	public static final String IN_CARE_OF = "inCareOf";
	public static final String CITY = "city";
	public static final String ADDRESS_TYPE = "addressType";
	public static final String COMPANY_NAME = "companyName";
	public static final String STATE_TERRITORY = "stateTerritory";
	public static final String USER_ID = "userId";
	public static final String ADDRESS_ID = "addressId";
	public static final String ADDRESS_LINE1 = "addressLine1";
	public static final String ADDRESS_LINE2 = "addressLine2";
	public static final String POST_CODE = "postCode";
	public static final String ADDRESS_LINE3 = "addressLine3";
	public static final String DISTRICT_COUNTY = "districtCounty";

}

