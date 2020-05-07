package com.covid.model.meta;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import com.covid.model.db.EmailAddress;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(EmailAddress.class)
public abstract class EmailAddress_ {

	public static volatile SingularAttribute<EmailAddress, String> emailAddressType;
	public static volatile SingularAttribute<EmailAddress, String> emailAddress;
	public static volatile SingularAttribute<EmailAddress, Integer> emailAddressId;
	public static volatile SingularAttribute<EmailAddress, Boolean> isPreferred;
	public static volatile SingularAttribute<EmailAddress, Boolean> isPrimaryUser;
	public static volatile SingularAttribute<EmailAddress, Integer> userId;
	public static volatile SingularAttribute<EmailAddress, Integer> primaryUserId;

	public static final String EMAIL_ADDRESS_TYPE = "emailAddressType";
	public static final String EMAIL_ADDRESS = "emailAddress";
	public static final String EMAIL_ADDRESS_ID = "emailAddressId";
	public static final String IS_PREFERRED = "isPreferred";
	public static final String IS_PRIMARY_USER = "isPrimaryUser";
	public static final String USER_ID = "userId";
	public static final String PRIMARY_USER_ID = "primaryUserId";

}

