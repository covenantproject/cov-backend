package com.covid.model.meta;


import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import com.covid.model.db.Users;
import com.covid.model.db.Address;
import com.covid.model.db.Demographics;
import com.covid.model.db.PhoneNumber;
import java.sql.Timestamp;
import com.covid.model.db.HealthCheckHistory;
import com.covid.model.db.Patient;
import javax.persistence.metamodel.SetAttribute;
import com.covid.model.db.EmailAddress;
import com.covid.model.db.ExternalIdentifier;
import com.covid.model.db.PatientRequestHistory;
import com.covid.model.db.HealthPro;
import com.covid.model.db.UserPhoto;


@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Users.class)
public abstract class Users_{

	public static volatile SingularAttribute<Users, Integer> userId;
	public static volatile SingularAttribute<Users, String> title;
	public static volatile SingularAttribute<Users, String> firstName;
	public static volatile SingularAttribute<Users, String> middleName;
	public static volatile SingularAttribute<Users, String> lastName;
	public static volatile SingularAttribute<Users, String> maidenName;
	public static volatile SingularAttribute<Users, String> displayName;
	public static volatile SingularAttribute<Users, String> lsFirstName;
	public static volatile SingularAttribute<Users, String> lsMiddleName;
	public static volatile SingularAttribute<Users, String> lsLastName;
	public static volatile SingularAttribute<Users, String> lsMaidenName;
	public static volatile SingularAttribute<Users, String> lsDisplayName;
	public static volatile SingularAttribute<Users, String> standardName;
	public static volatile SingularAttribute<Users, String> suffix;
	public static volatile SingularAttribute<Users, String> degree;
	public static volatile SingularAttribute<Users, Timestamp> dateOfBirth;
	public static volatile SingularAttribute<Users, Integer> ageYrs;
	public static volatile SingularAttribute<Users, String> adminGender;
	public static volatile SingularAttribute<Users, String> biologicalSex;
	public static volatile SingularAttribute<Users, String> username;
	public static volatile SingularAttribute<Users, String> comments;
	public static volatile SetAttribute<Users, ExternalIdentifier> externalIdentifierSet;
	public static volatile SingularAttribute<Users, Demographics> demographics;
	public static volatile SetAttribute<Users, UserPhoto> userPhotoSet;
	public static volatile SetAttribute<Users, PhoneNumber> phoneNumberByPrimaryUserIdSet;
	public static volatile SetAttribute<Users, EmailAddress> emailAddressByUserIdSet;
	public static volatile SetAttribute<Users, HealthCheckHistory> healthCheckHistorySet;
	public static volatile SingularAttribute<Users, HealthPro> healthPro;
	public static volatile SingularAttribute<Users, Patient> patient;
	public static volatile SetAttribute<Users, PatientRequestHistory> patientRequestHistorySet;
	public static volatile SetAttribute<Users, PhoneNumber> phoneNumberByUserIdSet;
	public static volatile SetAttribute<Users, Address> addressSet;
	public static volatile SetAttribute<Users, EmailAddress> emailAddressByPrimaryUserIdSet;

	public static final String s_userId = "userId";
	public static final String s_title = "title";
	public static final String s_firstName = "firstName";
	public static final String s_middleName = "middleName";
	public static final String s_lastName = "lastName";
	public static final String s_maidenName = "maidenName";
	public static final String s_displayName = "displayName";
	public static final String s_lsFirstName = "lsFirstName";
	public static final String s_lsMiddleName = "lsMiddleName";
	public static final String s_lsLastName = "lsLastName";
	public static final String s_lsMaidenName = "lsMaidenName";
	public static final String s_lsDisplayName = "lsDisplayName";
	public static final String s_standardName = "standardName";
	public static final String s_suffix = "suffix";
	public static final String s_degree = "degree";
	public static final String s_dateOfBirth = "dateOfBirth";
	public static final String s_ageYrs = "ageYrs";
	public static final String s_adminGender = "adminGender";
	public static final String s_biologicalSex = "biologicalSex";
	public static final String s_username = "username";
	public static final String s_comments = "comments";
	public static final String s_externalIdentifierSet = "externalIdentifierSet";
	public static final String s_demographics = "demographics";
	public static final String s_userPhotoSet = "userPhotoSet";
	public static final String s_phoneNumberByPrimaryUserIdSet = "phoneNumberByPrimaryUserIdSet";
	public static final String s_emailAddressByUserIdSet = "emailAddressByUserIdSet";
	public static final String s_healthCheckHistorySet = "healthCheckHistorySet";
	public static final String s_healthPro = "healthPro";
	public static final String s_patient = "patient";
	public static final String s_patientRequestHistorySet = "patientRequestHistorySet";
	public static final String s_phoneNumberByUserIdSet = "phoneNumberByUserIdSet";
	public static final String s_addressSet = "addressSet";
	public static final String s_emailAddressByPrimaryUserIdSet = "emailAddressByPrimaryUserIdSet";
	
}

