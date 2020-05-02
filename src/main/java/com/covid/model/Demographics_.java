package com.covid.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Demographics.class)
public abstract class Demographics_ {

	public static volatile SingularAttribute<Demographics, Integer> emergencyContactId1;
	public static volatile SingularAttribute<Demographics, String> nextOfKin1RelToPat;
	public static volatile SingularAttribute<Demographics, String> residencyStatus;
	public static volatile SingularAttribute<Demographics, String> occupation;
	public static volatile SingularAttribute<Demographics, String> nationality;
	public static volatile SingularAttribute<Demographics, String> nextOfKin2RelToPat;
	public static volatile SingularAttribute<Demographics, String> emerContact2RelToPat;
	public static volatile SingularAttribute<Demographics, String> emerContact1RelToPat;
	public static volatile SingularAttribute<Demographics, Integer> nextOfKinId2;
	public static volatile SingularAttribute<Demographics, Integer> userId;
	public static volatile SingularAttribute<Demographics, Integer> nextOfKinId1;
	public static volatile SingularAttribute<Demographics, Integer> emergencyContactId2;

	public static final String EMERGENCY_CONTACT_ID1 = "emergencyContactId1";
	public static final String NEXT_OF_KIN1_REL_TO_PAT = "nextOfKin1RelToPat";
	public static final String RESIDENCY_STATUS = "residencyStatus";
	public static final String OCCUPATION = "occupation";
	public static final String NATIONALITY = "nationality";
	public static final String NEXT_OF_KIN2_REL_TO_PAT = "nextOfKin2RelToPat";
	public static final String EMER_CONTACT2_REL_TO_PAT = "emerContact2RelToPat";
	public static final String EMER_CONTACT1_REL_TO_PAT = "emerContact1RelToPat";
	public static final String NEXT_OF_KIN_ID2 = "nextOfKinId2";
	public static final String USER_ID = "userId";
	public static final String NEXT_OF_KIN_ID1 = "nextOfKinId1";
	public static final String EMERGENCY_CONTACT_ID2 = "emergencyContactId2";

}

