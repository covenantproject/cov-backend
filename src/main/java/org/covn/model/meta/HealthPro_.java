package org.covn.model.meta;


import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.covn.model.db.PatientProviderRel;
import org.covn.model.db.HealthPro;
import org.covn.model.db.Users;
import org.covn.model.db.LocationHierarchy;
import javax.persistence.metamodel.SetAttribute;


@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(HealthPro.class)
public abstract class HealthPro_{

	public static volatile SingularAttribute<HealthPro, Integer> healthProJobId;
	public static volatile SingularAttribute<HealthPro, Integer> userId;
	public static volatile SingularAttribute<HealthPro, Users> users;
	public static volatile SingularAttribute<HealthPro, Integer> supervisorId;
	public static volatile SingularAttribute<HealthPro, HealthPro> parent;
	public static volatile SingularAttribute<HealthPro, String> jobTitle;
	public static volatile SingularAttribute<HealthPro, Integer> workLocationId;
	public static volatile SingularAttribute<HealthPro, LocationHierarchy> locationHierarchy;
	public static volatile SingularAttribute<HealthPro, Boolean> isActive;
	public static volatile SetAttribute<HealthPro, PatientProviderRel> patientProviderRelSet;
	public static volatile SetAttribute<HealthPro, HealthPro> children;

	public static final String s_healthProJobId = "healthProJobId";
	public static final String s_userId = "userId";
	public static final String s_users = "users";
	public static final String s_supervisorId = "supervisorId";
	public static final String s_parent = "parent";
	public static final String s_jobTitle = "jobTitle";
	public static final String s_workLocationId = "workLocationId";
	public static final String s_locationHierarchy = "locationHierarchy";
	public static final String s_isActive = "isActive";
	public static final String s_patientProviderRelSet = "patientProviderRelSet";
	public static final String s_children = "children";
	
}

