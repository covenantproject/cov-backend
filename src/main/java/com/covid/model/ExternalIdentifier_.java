package com.covid.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ExternalIdentifier.class)
public abstract class ExternalIdentifier_ {

	public static volatile SingularAttribute<ExternalIdentifier, String> expiryDate;
	public static volatile SingularAttribute<ExternalIdentifier, String> idTypeUri;
	public static volatile SingularAttribute<ExternalIdentifier, String> issuingAuthorityId;
	public static volatile SingularAttribute<ExternalIdentifier, String> issuingAuthorityName;
	public static volatile SingularAttribute<ExternalIdentifier, String> idType;
	public static volatile SingularAttribute<ExternalIdentifier, String> issuingAuthorityUri;
	public static volatile SingularAttribute<ExternalIdentifier, String> idNumber;
	public static volatile SingularAttribute<ExternalIdentifier, String> issueDate;
	public static volatile SingularAttribute<ExternalIdentifier, Integer> userId;
	public static volatile SingularAttribute<ExternalIdentifier, Integer> identificationId;

	public static final String EXPIRY_DATE = "expiryDate";
	public static final String ID_TYPE_URI = "idTypeUri";
	public static final String ISSUING_AUTHORITY_ID = "issuingAuthorityId";
	public static final String ISSUING_AUTHORITY_NAME = "issuingAuthorityName";
	public static final String ID_TYPE = "idType";
	public static final String ISSUING_AUTHORITY_URI = "issuingAuthorityUri";
	public static final String ID_NUMBER = "idNumber";
	public static final String ISSUE_DATE = "issueDate";
	public static final String USER_ID = "userId";
	public static final String IDENTIFICATION_ID = "identificationId";

}

