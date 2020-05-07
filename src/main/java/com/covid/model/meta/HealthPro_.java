package com.covid.model.meta;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import com.covid.model.db.HealthPro;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(HealthPro.class)
public abstract class HealthPro_ {

	public static volatile SingularAttribute<HealthPro, Integer> jobId;
	public static volatile SingularAttribute<HealthPro, Integer> workLocationId;
	public static volatile SingularAttribute<HealthPro, String> jobTitle;
	public static volatile SingularAttribute<HealthPro, Integer> healthProId;
	public static volatile SingularAttribute<HealthPro, Integer> supervisorId;
	public static volatile SingularAttribute<HealthPro, Boolean> isActive;

	public static final String JOB_ID = "jobId";
	public static final String WORK_LOCATION_ID = "workLocationId";
	public static final String JOB_TITLE = "jobTitle";
	public static final String HEALTH_PRO_ID = "healthProId";
	public static final String SUPERVISOR_ID = "supervisorId";
	public static final String IS_ACTIVE = "isActive";

}

