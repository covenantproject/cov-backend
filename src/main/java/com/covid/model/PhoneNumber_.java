package com.covid.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(PhoneNumber.class)
public abstract class PhoneNumber_ {

	public static volatile SingularAttribute<PhoneNumber, String> phoneType;
	public static volatile SingularAttribute<PhoneNumber, String> phoneNumberExtn;
	public static volatile SingularAttribute<PhoneNumber, Boolean> hasWhatsappAccess;
	public static volatile SingularAttribute<PhoneNumber, String> phoneNumberFormatted;
	public static volatile SingularAttribute<PhoneNumber, Boolean> isPreferred;
	public static volatile SingularAttribute<PhoneNumber, Integer> phoneNumberId;
	public static volatile SingularAttribute<PhoneNumber, Integer> userId;
	public static volatile SingularAttribute<PhoneNumber, Boolean> providesLocation;
	public static volatile SingularAttribute<PhoneNumber, Boolean> hasInternetAccess;
	public static volatile SingularAttribute<PhoneNumber, String> phoneNumber;
	public static volatile SingularAttribute<PhoneNumber, Boolean> hasSmsaccess;
	public static volatile SingularAttribute<PhoneNumber, Boolean> hasTelegramAccess;
	public static volatile SingularAttribute<PhoneNumber, Boolean> isPrimaryUser;
	public static volatile SingularAttribute<PhoneNumber, Integer> primaryUserId;

	public static final String PHONE_TYPE = "phoneType";
	public static final String PHONE_NUMBER_EXTN = "phoneNumberExtn";
	public static final String HAS_WHATSAPP_ACCESS = "hasWhatsappAccess";
	public static final String PHONE_NUMBER_FORMATTED = "phoneNumberFormatted";
	public static final String IS_PREFERRED = "isPreferred";
	public static final String PHONE_NUMBER_ID = "phoneNumberId";
	public static final String USER_ID = "userId";
	public static final String PROVIDES_LOCATION = "providesLocation";
	public static final String HAS_INTERNET_ACCESS = "hasInternetAccess";
	public static final String PHONE_NUMBER = "phoneNumber";
	public static final String HAS_SMSACCESS = "hasSmsaccess";
	public static final String HAS_TELEGRAM_ACCESS = "hasTelegramAccess";
	public static final String IS_PRIMARY_USER = "isPrimaryUser";
	public static final String PRIMARY_USER_ID = "primaryUserId";

}

