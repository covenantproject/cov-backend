package org.covn.model.meta;


import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.covn.model.db.Users;
import javax.persistence.metamodel.SetAttribute;
import org.covn.model.db.EmailAddress;


@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(EmailAddress.class)
public abstract class EmailAddress_{

	public static volatile SingularAttribute<EmailAddress, Integer> emailAddressId;
	public static volatile SingularAttribute<EmailAddress, Integer> userId;
	public static volatile SingularAttribute<EmailAddress, Users> usersByUserId;
	public static volatile SingularAttribute<EmailAddress, String> emailAddress;
	public static volatile SingularAttribute<EmailAddress, String> emailAddressType;
	public static volatile SingularAttribute<EmailAddress, Boolean> isPreferred;
	public static volatile SingularAttribute<EmailAddress, Boolean> isPrimaryUser;
	public static volatile SingularAttribute<EmailAddress, Integer> primaryUserId;
	public static volatile SingularAttribute<EmailAddress, Users> usersByPrimaryUserId;

	public static final String s_emailAddressId = "emailAddressId";
	public static final String s_userId = "userId";
	public static final String s_usersByUserId = "usersByUserId";
	public static final String s_emailAddress = "emailAddress";
	public static final String s_emailAddressType = "emailAddressType";
	public static final String s_isPreferred = "isPreferred";
	public static final String s_isPrimaryUser = "isPrimaryUser";
	public static final String s_primaryUserId = "primaryUserId";
	public static final String s_usersByPrimaryUserId = "usersByPrimaryUserId";
	
}

