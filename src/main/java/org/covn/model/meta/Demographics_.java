package org.covn.model.meta;


import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.covn.model.db.Users;
import javax.persistence.metamodel.SetAttribute;
import org.covn.model.db.Demographics;


@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Demographics.class)
public abstract class Demographics_{

	public static volatile SingularAttribute<Demographics, Integer> userId;
	public static volatile SingularAttribute<Demographics, Users> users;
	public static volatile SingularAttribute<Demographics, String> nationality;
	public static volatile SingularAttribute<Demographics, String> residencyStatus;
	public static volatile SingularAttribute<Demographics, String> occupation;
	public static volatile SingularAttribute<Demographics, Integer> emergencyContactId1;
	public static volatile SingularAttribute<Demographics, String> emerContact1RelToPat;
	public static volatile SingularAttribute<Demographics, Integer> emergencyContactId2;
	public static volatile SingularAttribute<Demographics, String> emerContact2RelToPat;
	public static volatile SingularAttribute<Demographics, Integer> nextOfKinId1;
	public static volatile SingularAttribute<Demographics, String> nextOfKin1RelToPat;
	public static volatile SingularAttribute<Demographics, Integer> nextOfKinId2;
	public static volatile SingularAttribute<Demographics, String> nextOfKin2RelToPat;
	public static volatile SingularAttribute<Demographics, String> comments;

	public static final String s_userId = "userId";
	public static final String s_users = "users";
	public static final String s_nationality = "nationality";
	public static final String s_residencyStatus = "residencyStatus";
	public static final String s_occupation = "occupation";
	public static final String s_emergencyContactId1 = "emergencyContactId1";
	public static final String s_emerContact1RelToPat = "emerContact1RelToPat";
	public static final String s_emergencyContactId2 = "emergencyContactId2";
	public static final String s_emerContact2RelToPat = "emerContact2RelToPat";
	public static final String s_nextOfKinId1 = "nextOfKinId1";
	public static final String s_nextOfKin1RelToPat = "nextOfKin1RelToPat";
	public static final String s_nextOfKinId2 = "nextOfKinId2";
	public static final String s_nextOfKin2RelToPat = "nextOfKin2RelToPat";
	public static final String s_comments = "comments";
	
}

