package org.covn.service;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import org.covn.dto.HealthProfessionalDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HealthProfessionalService {
	
	@Autowired
	private EntityManager entityManager;
	
	// TODO - many fields are common for both health professionals and patients. need a way to reuse this common logic.
	// rather than using custom stored procedures for health professionals only.

	/*
	 * PatinetService should both register Patients and retrieve their information
	 * 
	 */

	private void registerNewHealthProfessional (HealthProfessionalDto healthProfessionalDto) {
		// use UserService to register the new User
		// and then save health-pro-specific information in the health_pro table
		// change return value to a status code or the patient_id rather than void
		// note that a single user may have multiple health_pro_job_id if they have multiple jobs
	}
	
	private HealthProfessionalDto getHealthProfessionalInfo (int health_pro) {
		return null;
	}
	
	private void saveHealthProfessionalInfo (HealthProfessionalDto healthProfessionalDto) {
		// change return value to a status code or the patient_id rather than void
	}
	


}
