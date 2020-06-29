package org.covn.model.meta;


import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.covn.model.db.UserPhoto;
import org.covn.model.db.Users;
import java.sql.Timestamp;
import javax.persistence.metamodel.SetAttribute;


@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(UserPhoto.class)
public abstract class UserPhoto_{

	public static volatile SingularAttribute<UserPhoto, Integer> photoId;
	public static volatile SingularAttribute<UserPhoto, Integer> userId;
	public static volatile SingularAttribute<UserPhoto, Users> users;
	public static volatile SingularAttribute<UserPhoto, String> photoType;
	public static volatile SingularAttribute<UserPhoto, String> photoPath;
	public static volatile SingularAttribute<UserPhoto, Timestamp> fileSavedDatetime;

	public static final String s_photoId = "photoId";
	public static final String s_userId = "userId";
	public static final String s_users = "users";
	public static final String s_photoType = "photoType";
	public static final String s_photoPath = "photoPath";
	public static final String s_fileSavedDatetime = "fileSavedDatetime";
	
}

