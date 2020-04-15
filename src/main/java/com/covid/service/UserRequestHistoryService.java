package com.covid.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.covid.model.HealthHistory;
import com.covid.model.UserRequestHistory;
import com.covid.repository.UserRequestHistoryRepo;

@Service
public class UserRequestHistoryService {
	
	@Autowired
	UserRequestHistoryRepo userRequestRepo;
	
	public UserRequestHistory updateUserRequest(UserRequestHistory userRequest) {
		userRequest.setResponseUserId(null);
		return userRequestRepo.save(userRequest); 		
	}

}
