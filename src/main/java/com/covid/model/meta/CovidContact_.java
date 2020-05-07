package com.covid.model.meta;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import com.covid.model.db.CovidContact;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CovidContact.class)
public abstract class CovidContact_ {

	public static volatile SingularAttribute<CovidContact, Date> contactTimeStart;
	public static volatile SingularAttribute<CovidContact, Integer> contactId;
	public static volatile SingularAttribute<CovidContact, Integer> contactLocationId;
	public static volatile SingularAttribute<CovidContact, String> contactRelationship;
	public static volatile SingularAttribute<CovidContact, String> contactExposure;
	public static volatile SingularAttribute<CovidContact, Integer> contactUserId1;
	public static volatile SingularAttribute<CovidContact, Date> contactTimeEnd;
	public static volatile SingularAttribute<CovidContact, Integer> contactUserId2;

	public static final String CONTACT_TIME_START = "contactTimeStart";
	public static final String CONTACT_ID = "contactId";
	public static final String CONTACT_LOCATION_ID = "contactLocationId";
	public static final String CONTACT_RELATIONSHIP = "contactRelationship";
	public static final String CONTACT_EXPOSURE = "contactExposure";
	public static final String CONTACT_USER_ID1 = "contactUserId1";
	public static final String CONTACT_TIME_END = "contactTimeEnd";
	public static final String CONTACT_USER_ID2 = "contactUserId2";

}

