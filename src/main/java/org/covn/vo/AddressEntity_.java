package org.covn.vo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(AddressEntity.class)
public abstract class AddressEntity_ {

	public static volatile SingularAttribute<AddressEntity, String> addressLine1;
	public static volatile SingularAttribute<AddressEntity, UserEntity> user;
	public static volatile SingularAttribute<AddressEntity, Long> addressId;

	public static final String ADDRESS_LINE1 = "addressLine1";
	public static final String USER = "user";
	public static final String ADDRESS_ID = "addressId";

}

