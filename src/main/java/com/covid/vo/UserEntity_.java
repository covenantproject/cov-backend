package com.covid.vo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(UserEntity.class)
public abstract class UserEntity_ {

	public static volatile SingularAttribute<UserEntity, String> lastName;
	public static volatile SingularAttribute<UserEntity, AddressEntity> address;
	public static volatile SingularAttribute<UserEntity, String> gender;
	public static volatile SingularAttribute<UserEntity, String> otpCode;
	public static volatile SingularAttribute<UserEntity, Long> photoId;
	public static volatile SingularAttribute<UserEntity, Date> dateOfBirth;
	public static volatile SingularAttribute<UserEntity, String> title;
	public static volatile SingularAttribute<UserEntity, String> suffix;
	public static volatile SingularAttribute<UserEntity, Long> userId;
	public static volatile SingularAttribute<UserEntity, String> firstName;
	public static volatile SingularAttribute<UserEntity, PhoneNumberEntity> phoneNumber;
	public static volatile SingularAttribute<UserEntity, String> middleName;
	public static volatile SingularAttribute<UserEntity, String> preferredName;
	public static volatile SingularAttribute<UserEntity, String> shortName;

	public static final String LAST_NAME = "lastName";
	public static final String ADDRESS = "address";
	public static final String GENDER = "gender";
	public static final String OTP_CODE = "otpCode";
	public static final String PHOTO_ID = "photoId";
	public static final String DATE_OF_BIRTH = "dateOfBirth";
	public static final String TITLE = "title";
	public static final String SUFFIX = "suffix";
	public static final String USER_ID = "userId";
	public static final String FIRST_NAME = "firstName";
	public static final String PHONE_NUMBER = "phoneNumber";
	public static final String MIDDLE_NAME = "middleName";
	public static final String PREFERRED_NAME = "preferredName";
	public static final String SHORT_NAME = "shortName";

}

