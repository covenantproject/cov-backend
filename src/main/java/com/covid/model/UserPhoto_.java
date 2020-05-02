package com.covid.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(UserPhoto.class)
public abstract class UserPhoto_ {

	public static volatile SingularAttribute<UserPhoto, Date> fileSavedDatetime;
	public static volatile SingularAttribute<UserPhoto, String> photoPath;
	public static volatile SingularAttribute<UserPhoto, String> photoType;
	public static volatile SingularAttribute<UserPhoto, Integer> photoId;
	public static volatile SingularAttribute<UserPhoto, Integer> userId;

	public static final String FILE_SAVED_DATETIME = "fileSavedDatetime";
	public static final String PHOTO_PATH = "photoPath";
	public static final String PHOTO_TYPE = "photoType";
	public static final String PHOTO_ID = "photoId";
	public static final String USER_ID = "userId";

}

