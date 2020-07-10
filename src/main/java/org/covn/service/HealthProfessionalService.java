package org.covn.service;

import javax.persistence.EntityManager;

import org.covn.dto.HealthProDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@RequestScope
@Component
public class HealthProfessionalService {
	
	@Autowired
	private EntityManager entityManager;
	
	// TODO - many fields are common for both health professionals and patients. need a way to reuse this common logic.
	// rather than using custom stored procedures for health professionals only.

	/*
	 * PatinetService should both register Patients and retrieve their information
	 * 
	 */

	private void registerNewHealthProfessional (HealthProDto healthProDto) {
		// use UserService to register the new User
		// and then save health-pro-specific information in the health_pro table
		// change return value to a status code or the patient_id rather than void
		// note that a single user may have multiple health_pro_job_id if they have multiple jobs
	}
	
	private HealthProDto getHealthProfessionalInfo (int health_pro) {
		return null;
	}
	
	private void saveHealthProfessionalInfo (HealthProDto healthProDto) {
		// change return value to a status code or the patient_id rather than void
	}
	


}
