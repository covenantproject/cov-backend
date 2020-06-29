package org.covn.model.meta;


import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.covn.model.db.Users;
import javax.persistence.metamodel.SetAttribute;
import org.covn.model.db.PhoneDeviceApp;
import org.covn.model.db.PhoneNumber;


@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(PhoneNumber.class)
public abstract class PhoneNumber_{

	public static volatile SingularAttribute<PhoneNumber, Integer> phoneNumberId;
	public static volatile SingularAttribute<PhoneNumber, Integer> userId;
	public static volatile SingularAttribute<PhoneNumber, Users> usersByUserId;
	public static volatile SingularAttribute<PhoneNumber, String> phoneType;
	public static volatile SingularAttribute<PhoneNumber, String> phoneNumber;
	public static volatile SingularAttribute<PhoneNumber, String> phoneNumberExtn;
	public static volatile SingularAttribute<PhoneNumber, String> phoneNumberFormatted;
	public static volatile SingularAttribute<PhoneNumber, Boolean> isPreferred;
	public static volatile SingularAttribute<PhoneNumber, Boolean> isPrimaryUser;
	public static volatile SingularAttribute<PhoneNumber, Integer> primaryUserId;
	public static volatile SingularAttribute<PhoneNumber, Users> usersByPrimaryUserId;
	public static volatile SingularAttribute<PhoneNumber, Boolean> hasInternet;
	public static volatile SingularAttribute<PhoneNumber, Boolean> hasSms;
	public static volatile SingularAttribute<PhoneNumber, Boolean> hasWhatsapp;
	public static volatile SingularAttribute<PhoneNumber, Boolean> hasTelegram;
	public static volatile SingularAttribute<PhoneNumber, Boolean> providesLocation;
	public static volatile SingularAttribute<PhoneNumber, String> otpCode;
	public static volatile SingularAttribute<PhoneNumber, String> phoneHash;
	public static volatile SetAttribute<PhoneNumber, PhoneDeviceApp> phoneDeviceAppSet;

	public static final String s_phoneNumberId = "phoneNumberId";
	public static final String s_userId = "userId";
	public static final String s_usersByUserId = "usersByUserId";
	public static final String s_phoneType = "phoneType";
	public static final String s_phoneNumber = "phoneNumber";
	public static final String s_phoneNumberExtn = "phoneNumberExtn";
	public static final String s_phoneNumberFormatted = "phoneNumberFormatted";
	public static final String s_isPreferred = "isPreferred";
	public static final String s_isPrimaryUser = "isPrimaryUser";
	public static final String s_primaryUserId = "primaryUserId";
	public static final String s_usersByPrimaryUserId = "usersByPrimaryUserId";
	public static final String s_hasInternet = "hasInternet";
	public static final String s_hasSms = "hasSms";
	public static final String s_hasWhatsapp = "hasWhatsapp";
	public static final String s_hasTelegram = "hasTelegram";
	public static final String s_providesLocation = "providesLocation";
	public static final String s_otpCode = "otpCode";
	public static final String s_phoneHash = "phoneHash";
	public static final String s_phoneDeviceAppSet = "phoneDeviceAppSet";
	
}

