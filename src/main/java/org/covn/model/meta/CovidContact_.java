package org.covn.model.meta;


import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.covn.model.db.CovidContact;
import java.sql.Timestamp;


@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CovidContact.class)
public abstract class CovidContact_{

	public static volatile SingularAttribute<CovidContact, Integer> contactId;
	public static volatile SingularAttribute<CovidContact, Integer> contactUserId1;
	public static volatile SingularAttribute<CovidContact, Integer> contactUserId2;
	public static volatile SingularAttribute<CovidContact, Timestamp> contactTimeStart;
	public static volatile SingularAttribute<CovidContact, Timestamp> contactTimeEnd;
	public static volatile SingularAttribute<CovidContact, Integer> contactLocationId;
	public static volatile SingularAttribute<CovidContact, String> contactRelationship;
	public static volatile SingularAttribute<CovidContact, String> contactExposure;

	public static final String s_contactId = "contactId";
	public static final String s_contactUserId1 = "contactUserId1";
	public static final String s_contactUserId2 = "contactUserId2";
	public static final String s_contactTimeStart = "contactTimeStart";
	public static final String s_contactTimeEnd = "contactTimeEnd";
	public static final String s_contactLocationId = "contactLocationId";
	public static final String s_contactRelationship = "contactRelationship";
	public static final String s_contactExposure = "contactExposure";
	
}

