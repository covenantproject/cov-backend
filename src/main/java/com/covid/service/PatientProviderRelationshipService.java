package com.covid.service;

import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.covid.dto.PatientProviderRelationshipDto;

@Service
public class PatientProviderRelationshipService {
	
	@Autowired
	private EntityManager entityManager;

	public String savePatientProvider(PatientProviderRelationshipDto patientProvider) {
		StoredProcedureQuery query = entityManager.createStoredProcedureQuery("savePatientProviderRela")
				.registerStoredProcedureParameter("patientId", Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter("providerId", Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter("relationshipType", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("locationId", Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter("relationshipStartDate", Date.class, ParameterMode.IN)
				.registerStoredProcedureParameter("relationshipEndDate", Date.class, ParameterMode.IN)
				.setParameter("patientId", patientProvider.getPatientId()).setParameter("providerId", patientProvider.getProviderId())
				.setParameter("relationshipType", patientProvider.getRelationshipType()).setParameter("locationId", patientProvider.getLocationId())
				.setParameter("relationshipStartDate", patientProvider.getRelationshipStartDate()).setParameter("relationshipEndDate", patientProvider.getRelationshipEndDate());
		query.execute();
		List<Object> result = (List<Object>) query.getResultList();
		if (result.size() != 0) {
			Iterator itr = result.iterator();
			String msg="";
			while (itr.hasNext()) {
				String obj = (String) itr.next();
				msg=obj;
			}
			return msg;
			
		} else {
			return "failed";
		}
		
	}

}
