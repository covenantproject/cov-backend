package org.covn.service;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import org.covn.dto.PatientProviderRelationshipDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
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
