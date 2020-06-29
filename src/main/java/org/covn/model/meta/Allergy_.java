package org.covn.model.meta;


import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.covn.model.db.Allergy;
import org.covn.model.db.Patient;
import javax.persistence.metamodel.SetAttribute;


@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Allergy.class)
public abstract class Allergy_{

	public static volatile SingularAttribute<Allergy, Integer> allergyId;
	public static volatile SingularAttribute<Allergy, Integer> patientId;
	public static volatile SingularAttribute<Allergy, Patient> patient;
	public static volatile SingularAttribute<Allergy, String> allergenType;
	public static volatile SingularAttribute<Allergy, String> allergenCodeSystem;
	public static volatile SingularAttribute<Allergy, String> allergenConceptCode;
	public static volatile SingularAttribute<Allergy, String> allergenDescription;
	public static volatile SingularAttribute<Allergy, String> allergicRxnCodeSystem;
	public static volatile SingularAttribute<Allergy, String> allergicRxnConceptCode;
	public static volatile SingularAttribute<Allergy, String> allergicRxnDescription;
	public static volatile SingularAttribute<Allergy, String> allergySeverity;
	public static volatile SingularAttribute<Allergy, Boolean> isActive;
	public static volatile SingularAttribute<Allergy, Integer> durationNum;
	public static volatile SingularAttribute<Allergy, String> durationUnits;

	public static final String s_allergyId = "allergyId";
	public static final String s_patientId = "patientId";
	public static final String s_patient = "patient";
	public static final String s_allergenType = "allergenType";
	public static final String s_allergenCodeSystem = "allergenCodeSystem";
	public static final String s_allergenConceptCode = "allergenConceptCode";
	public static final String s_allergenDescription = "allergenDescription";
	public static final String s_allergicRxnCodeSystem = "allergicRxnCodeSystem";
	public static final String s_allergicRxnConceptCode = "allergicRxnConceptCode";
	public static final String s_allergicRxnDescription = "allergicRxnDescription";
	public static final String s_allergySeverity = "allergySeverity";
	public static final String s_isActive = "isActive";
	public static final String s_durationNum = "durationNum";
	public static final String s_durationUnits = "durationUnits";
	
}

