package org.covn.dto;

import java.sql.Timestamp;

import org.covn.model.db.HealthCheck;

/** Health Check of a patient at a specific time. Captures important symptoms of COVID-19.
 * This is typically done once or twice a day, sometimes more frequently. 
 * 
 */
public class HealthCheckDto {
	
	HealthCheck healthCheck;

	public HealthCheck getHealthCheck() {
		return healthCheck;
	}

	public void setHealthCheck(HealthCheck healthCheck) {
		this.healthCheck = healthCheck;
	}
	
}
