package org.covn.service;

import javax.persistence.EntityManager;

import org.covn.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author SunilAnand
 * @since 2020-04-14
 * 
 * Modified by Senthil N
 **/
@Component
public class UserService {

	/*
	 * UserService should both register users and retrieve their information
	 * Formerly called CovidService
	 * 
	 * Feel free to delete all the old methods and properties
	 * 
	 */
	
	/** Create a new user record if it doesn't exist for a new user.
	* 	A user record may already exist for a new patient if the user is already a health professional.
	* 	A user record may already exist for a new health professional if the user is already a patient.
	* 
	* This method can also be used to update the user record if the user id is provided.
	*/
	public void saveUser (UserDto userDto) {
		
	}

	
	public UserDto getUserProfile (int userId) {
		return null;
	}

	public void saveUserProfile (UserDto userDto) {
	}

	public void uploadPhoto () {
		
	}
	
	public void getPhoto () {
		
	}
	
	public void deletePhoto() {
		
	}
	
	public void savePhoneNumber() {
		
	}
	
	public void getPhoneNumber() {
		
	}
	
	public void deletePhoneNumber() {
		
	}
	
	public void saveAddress() {
		
	}
	
	public void getAddress() {
		
	}
	
	public void deleteAddress() {
		
	}
	
	public void saveEmailAddress() {
		
	}
	
	public void getEmailAddress() {
		
	}
	
	public void deleteEmailAddress() {
		
	}
	
	public void saveExternalId() {
		
	}
	
	public void getExternalId() {
		
	}
	
	public void deleteExternalId() {
		
	}	
	
}

