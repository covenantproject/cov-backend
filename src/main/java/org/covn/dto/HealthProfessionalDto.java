package org.covn.dto;

import java.util.Date;

public class HealthProfessionalDto {
	
	// TODO - this first set of fields need to be updated to be the same as in RegisterDto.java
	// [Senthil's question]:
	// what is the best way to reuse what's defined in RegisterDto.java?
	// also, how to use the same service logic for both health professional and patient registration for these common fields?
	
	private String title;
	private String firstName;
	private String lastName;
	private String suffix;
	private String gender;
	private Date dateOfBirth;
	private String emailAddress;
	private String phoneNumber;
	
	// this second set of fields are unique to health professionals. these are in addition to common fields in RegisterDto.java
	
	private int healthProJobId; // A single health professional may have multiple jobs. 
	// Start with 1 for the first job of each person and then increment automatically 
	private String healthProJobTitle;
	private int healthProWorkLocationId;
	private int supervisorId;
	private int isActive; // default true. set to false if this person doesn't do this job anymore instead of deleting the row
	
	// TODO - add getters and setters
	
	
	

}
