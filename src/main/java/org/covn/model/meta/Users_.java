package org.covn.model.meta;


import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.covn.model.db.UserPhoto;
import org.covn.model.db.ExternalIdentifier;
import org.covn.model.db.Users;
import org.covn.model.db.HealthCheckHistory;
import java.util.Date;
import org.covn.model.db.Patient;
import javax.persistence.metamodel.SetAttribute;
import org.covn.model.db.Demographics;
import org.covn.model.db.EmailAddress;
import org.covn.model.db.HealthPro;
import org.covn.model.db.PatientRequestHistory;
import org.covn.model.db.Address;
import org.covn.model.db.PhoneNumber;


@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Users.class)
public abstract class Users_{

	public static volatile SingularAttribute<Users, Integer> userId;
	public static volatile SingularAttribute<Users, String> lsTitle;
	public static volatile SingularAttribute<Users, String> lsFirstName;
	public static volatile SingularAttribute<Users, String> lsMiddleName;
	public static volatile SingularAttribute<Users, String> lsLastName;
	public static volatile SingularAttribute<Users, String> lsMaidenName;
	public static volatile SingularAttribute<Users, String> lsDisplayName;
	public static volatile SingularAttribute<Users, String> lsSuffix;
	public static volatile SingularAttribute<Users, String> lsDegree;
	public static volatile SingularAttribute<Users, String> lsAliasName1;
	public static volatile SingularAttribute<Users, String> lsAliasName2;
	public static volatile SingularAttribute<Users, String> nsTitle;
	public static volatile SingularAttribute<Users, String> nsFirstName;
	public static volatile SingularAttribute<Users, String> nsMiddleName;
	public static volatile SingularAttribute<Users, String> nsLastName;
	public static volatile SingularAttribute<Users, String> nsMaidenName;
	public static volatile SingularAttribute<Users, String> nsDisplayName;
	public static volatile SingularAttribute<Users, String> nsSuffix;
	public static volatile SingularAttribute<Users, String> nsDegree;
	public static volatile SingularAttribute<Users, String> nsAliasName1;
	public static volatile SingularAttribute<Users, String> nsAliasName2;
	public static volatile SingularAttribute<Users, String> standardName;
	public static volatile SingularAttribute<Users, Date> dateOfBirth;
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
	public static volatile SingularAttribute<Users, Patient> patient;
	public static volatile SetAttribute<Users, PatientRequestHistory> patientRequestHistorySet;
	public static volatile SetAttribute<Users, PhoneNumber> phoneNumberByUserIdSet;
	public static volatile SetAttribute<Users, Address> addressSet;
	public static volatile SetAttribute<Users, EmailAddress> emailAddressByPrimaryUserIdSet;
	public static volatile SetAttribute<Users, HealthPro> healthProSet;

	public static final String s_userId = "userId";
	public static final String s_lsTitle = "lsTitle";
	public static final String s_lsFirstName = "lsFirstName";
	public static final String s_lsMiddleName = "lsMiddleName";
	public static final String s_lsLastName = "lsLastName";
	public static final String s_lsMaidenName = "lsMaidenName";
	public static final String s_lsDisplayName = "lsDisplayName";
	public static final String s_lsSuffix = "lsSuffix";
	public static final String s_lsDegree = "lsDegree";
	public static final String s_lsAliasName1 = "lsAliasName1";
	public static final String s_lsAliasName2 = "lsAliasName2";
	public static final String s_nsTitle = "nsTitle";
	public static final String s_nsFirstName = "nsFirstName";
	public static final String s_nsMiddleName = "nsMiddleName";
	public static final String s_nsLastName = "nsLastName";
	public static final String s_nsMaidenName = "nsMaidenName";
	public static final String s_nsDisplayName = "nsDisplayName";
	public static final String s_nsSuffix = "nsSuffix";
	public static final String s_nsDegree = "nsDegree";
	public static final String s_nsAliasName1 = "nsAliasName1";
	public static final String s_nsAliasName2 = "nsAliasName2";
	public static final String s_standardName = "standardName";
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
	public static final String s_patient = "patient";
	public static final String s_patientRequestHistorySet = "patientRequestHistorySet";
	public static final String s_phoneNumberByUserIdSet = "phoneNumberByUserIdSet";
	public static final String s_addressSet = "addressSet";
	public static final String s_emailAddressByPrimaryUserIdSet = "emailAddressByPrimaryUserIdSet";
	public static final String s_healthProSet = "healthProSet";
	
}

