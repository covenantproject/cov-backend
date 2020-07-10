package org.covn.service;

import javax.persistence.EntityManager;

import org.covn.dto.PatientProviderRelationshipDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@RequestScope
@Component
public class PatientProviderRelationshipService {
	
	@Autowired
	private EntityManager entityManager;

	/** Add or update based on whether pkey is present
	 * Modify return values as needed
	 */
	public void savePatientProvider(PatientProviderRelationshipDto patProRel) {

	}

	/**
	 * Delete existing patient provider relationship
	 * Modify return values as needed
	 */
	public void removePatientProviderRel(PatientProviderRelationshipDto patProRel) {
		
	}
}
