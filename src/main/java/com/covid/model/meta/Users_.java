package com.covid.model.meta;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import com.covid.model.db.Users;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Users.class)
public abstract class Users_ {

	public static volatile SingularAttribute<Users, String> lastName;
	public static volatile SingularAttribute<Users, String> shortFullName;
	public static volatile SingularAttribute<Users, String> lsFirstName;
	public static volatile SingularAttribute<Users, String> lsLongFullName;
	public static volatile SingularAttribute<Users, String> displayName;
	public static volatile SingularAttribute<Users, String> degree;
	public static volatile SingularAttribute<Users, String> otpCode;
	public static volatile SingularAttribute<Users, String> lsShortFullName;
	public static volatile SingularAttribute<Users, Date> dateOfBirth;
	public static volatile SingularAttribute<Users, String> title;
	public static volatile SingularAttribute<Users, String> suffix;
	public static volatile SingularAttribute<Users, Integer> userId;
	public static volatile SingularAttribute<Users, String> lsDisplayName;
	public static volatile SingularAttribute<Users, String> firstName;
	public static volatile SingularAttribute<Users, String> biologicalSex;
	public static volatile SingularAttribute<Users, String> longFullName;
	public static volatile SingularAttribute<Users, String> middleName;
	public static volatile SingularAttribute<Users, Short> ageYrs;
	public static volatile SingularAttribute<Users, String> lsLastName;
	public static volatile SingularAttribute<Users, String> lsMiddleName;
	public static volatile SingularAttribute<Users, String> adminGender;

	public static final String LAST_NAME = "lastName";
	public static final String SHORT_FULL_NAME = "shortFullName";
	public static final String LS_FIRST_NAME = "lsFirstName";
	public static final String LS_LONG_FULL_NAME = "lsLongFullName";
	public static final String DISPLAY_NAME = "displayName";
	public static final String DEGREE = "degree";
	public static final String OTP_CODE = "otpCode";
	public static final String LS_SHORT_FULL_NAME = "lsShortFullName";
	public static final String DATE_OF_BIRTH = "dateOfBirth";
	public static final String TITLE = "title";
	public static final String SUFFIX = "suffix";
	public static final String USER_ID = "userId";
	public static final String LS_DISPLAY_NAME = "lsDisplayName";
	public static final String FIRST_NAME = "firstName";
	public static final String BIOLOGICAL_SEX = "biologicalSex";
	public static final String LONG_FULL_NAME = "longFullName";
	public static final String MIDDLE_NAME = "middleName";
	public static final String AGE_YRS = "ageYrs";
	public static final String LS_LAST_NAME = "lsLastName";
	public static final String LS_MIDDLE_NAME = "lsMiddleName";
	public static final String ADMIN_GENDER = "adminGender";

}

