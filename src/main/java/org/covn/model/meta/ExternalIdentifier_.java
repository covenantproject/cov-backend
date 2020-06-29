package org.covn.model.meta;


import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.covn.model.db.ExternalIdentifier;
import org.covn.model.db.Users;
import javax.persistence.metamodel.SetAttribute;


@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ExternalIdentifier.class)
public abstract class ExternalIdentifier_{

	public static volatile SingularAttribute<ExternalIdentifier, Integer> identificationId;
	public static volatile SingularAttribute<ExternalIdentifier, Integer> userId;
	public static volatile SingularAttribute<ExternalIdentifier, Users> users;
	public static volatile SingularAttribute<ExternalIdentifier, String> idType;
	public static volatile SingularAttribute<ExternalIdentifier, String> idTypeUri;
	public static volatile SingularAttribute<ExternalIdentifier, String> issuingAuthorityName;
	public static volatile SingularAttribute<ExternalIdentifier, String> issuingAuthorityId;
	public static volatile SingularAttribute<ExternalIdentifier, String> issuingAuthorityUri;
	public static volatile SingularAttribute<ExternalIdentifier, String> idNumber;
	public static volatile SingularAttribute<ExternalIdentifier, String> issueDate;
	public static volatile SingularAttribute<ExternalIdentifier, String> expiryDate;

	public static final String s_identificationId = "identificationId";
	public static final String s_userId = "userId";
	public static final String s_users = "users";
	public static final String s_idType = "idType";
	public static final String s_idTypeUri = "idTypeUri";
	public static final String s_issuingAuthorityName = "issuingAuthorityName";
	public static final String s_issuingAuthorityId = "issuingAuthorityId";
	public static final String s_issuingAuthorityUri = "issuingAuthorityUri";
	public static final String s_idNumber = "idNumber";
	public static final String s_issueDate = "issueDate";
	public static final String s_expiryDate = "expiryDate";
	
}

