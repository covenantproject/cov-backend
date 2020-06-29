package org.covn.model.meta;


import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.covn.model.db.PreExistingConditionCovidDenorm;
import org.covn.model.db.Patient;
import javax.persistence.metamodel.SetAttribute;
import org.covn.model.db.PreExistingCondition;


@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(PreExistingConditionCovidDenorm.class)
public abstract class PreExistingConditionCovidDenorm_{

	public static volatile SingularAttribute<PreExistingConditionCovidDenorm, Integer> covidPreExistingConditionId;
	public static volatile SingularAttribute<PreExistingConditionCovidDenorm, Integer> patientId;
	public static volatile SingularAttribute<PreExistingConditionCovidDenorm, Patient> patient;
	public static volatile SingularAttribute<PreExistingConditionCovidDenorm, Integer> preExistingConditionId;
	public static volatile SingularAttribute<PreExistingConditionCovidDenorm, PreExistingCondition> preExistingCondition;
	public static volatile SingularAttribute<PreExistingConditionCovidDenorm, Boolean> copd;
	public static volatile SingularAttribute<PreExistingConditionCovidDenorm, Boolean> bronchitis;
	public static volatile SingularAttribute<PreExistingConditionCovidDenorm, Boolean> diabetesMellitus;
	public static volatile SingularAttribute<PreExistingConditionCovidDenorm, Boolean> diabetesMellitusType1;
	public static volatile SingularAttribute<PreExistingConditionCovidDenorm, Boolean> diabetesMellitusType2;
	public static volatile SingularAttribute<PreExistingConditionCovidDenorm, Boolean> hypertension;
	public static volatile SingularAttribute<PreExistingConditionCovidDenorm, Boolean> chronicRenalDisease;
	public static volatile SingularAttribute<PreExistingConditionCovidDenorm, Boolean> malignancy;
	public static volatile SingularAttribute<PreExistingConditionCovidDenorm, Boolean> heartDisease;
	public static volatile SingularAttribute<PreExistingConditionCovidDenorm, Boolean> asthma;
	public static volatile SingularAttribute<PreExistingConditionCovidDenorm, Boolean> obesity;
	public static volatile SingularAttribute<PreExistingConditionCovidDenorm, String> comments;

	public static final String s_covidPreExistingConditionId = "covidPreExistingConditionId";
	public static final String s_patientId = "patientId";
	public static final String s_patient = "patient";
	public static final String s_preExistingConditionId = "preExistingConditionId";
	public static final String s_preExistingCondition = "preExistingCondition";
	public static final String s_copd = "copd";
	public static final String s_bronchitis = "bronchitis";
	public static final String s_diabetesMellitus = "diabetesMellitus";
	public static final String s_diabetesMellitusType1 = "diabetesMellitusType1";
	public static final String s_diabetesMellitusType2 = "diabetesMellitusType2";
	public static final String s_hypertension = "hypertension";
	public static final String s_chronicRenalDisease = "chronicRenalDisease";
	public static final String s_malignancy = "malignancy";
	public static final String s_heartDisease = "heartDisease";
	public static final String s_asthma = "asthma";
	public static final String s_obesity = "obesity";
	public static final String s_comments = "comments";
	
}

