package org.covn.dto;

import java.util.Date;

import org.covn.model.db.HealthPro;

/** Fields that are specific to health professionals, in addition to common fields in UserDto
 * 
 */

public class HealthProDto extends UserDto {

	// Following of fields are unique to health professionals. These are in addition to common fields in UserDto
	// A single health professional user may have multiple jobs. Following fields are unique to each job.
	// isActive: default true. set to false if this person doesn't do this job anymore instead of deleting the row

	HealthPro healthPro;
}
