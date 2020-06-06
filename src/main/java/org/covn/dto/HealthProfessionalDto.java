package org.covn.dto;

import java.util.Date;

/* Fields that are specific to health professionals, in addition to common fields in UserDto
 * 
 */

public class HealthProfessionalDto extends UserDto {

	// Following of fields are unique to health professionals. These are in addition to common fields in UserDto
	// A single health professional user may have multiple jobs. Following fields are unique to each job.
	
	private int healthProJobId; 
	private String healthProJobTitle;
	private int healthProWorkLocationId;
	private int supervisorId;
	private int isActive; // default true. set to false if this person doesn't do this job anymore instead of deleting the row

	public int getHealthProJobId() {
		return healthProJobId;
	}
	public void setHealthProJobId(int healthProJobId) {
		this.healthProJobId = healthProJobId;
	}
	public String getHealthProJobTitle() {
		return healthProJobTitle;
	}
	public void setHealthProJobTitle(String healthProJobTitle) {
		this.healthProJobTitle = healthProJobTitle;
	}
	public int getHealthProWorkLocationId() {
		return healthProWorkLocationId;
	}
	public void setHealthProWorkLocationId(int healthProWorkLocationId) {
		this.healthProWorkLocationId = healthProWorkLocationId;
	}
	public int getSupervisorId() {
		return supervisorId;
	}
	public void setSupervisorId(int supervisorId) {
		this.supervisorId = supervisorId;
	}
	public int getIsActive() {
		return isActive;
	}
	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

}
