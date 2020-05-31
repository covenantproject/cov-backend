package org.covn.vo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(PhoneNumberEntity.class)
public abstract class PhoneNumberEntity_ {

	public static volatile SingularAttribute<PhoneNumberEntity, Long> phoneNumber;
	public static volatile SingularAttribute<PhoneNumberEntity, Long> phoneNumberId;
	public static volatile SingularAttribute<PhoneNumberEntity, UserEntity> user;

	public static final String PHONE_NUMBER = "phoneNumber";
	public static final String PHONE_NUMBER_ID = "phoneNumberId";
	public static final String USER = "user";

}

