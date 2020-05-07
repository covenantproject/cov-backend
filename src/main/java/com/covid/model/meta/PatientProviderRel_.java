package com.covid.model.meta;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import com.covid.model.db.PatientProviderRel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(PatientProviderRel.class)
public abstract class PatientProviderRel_ {

	public static volatile SingularAttribute<PatientProviderRel, Integer> relFacLocation;
	public static volatile SingularAttribute<PatientProviderRel, Integer> patientId;
	public static volatile SingularAttribute<PatientProviderRel, Date> relStartDate;
	public static volatile SingularAttribute<PatientProviderRel, Date> relEndDate;
	public static volatile SingularAttribute<PatientProviderRel, Integer> healthProId;
	public static volatile SingularAttribute<PatientProviderRel, String> relType;
	public static volatile SingularAttribute<PatientProviderRel, Integer> patProRelId;

	public static final String REL_FAC_LOCATION = "relFacLocation";
	public static final String PATIENT_ID = "patientId";
	public static final String REL_START_DATE = "relStartDate";
	public static final String REL_END_DATE = "relEndDate";
	public static final String HEALTH_PRO_ID = "healthProId";
	public static final String REL_TYPE = "relType";
	public static final String PAT_PRO_REL_ID = "patProRelId";

}

