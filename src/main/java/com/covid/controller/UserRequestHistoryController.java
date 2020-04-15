package com.covid.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.covid.model.HealthHistory;
import com.covid.model.UserRequestHistory;
import com.covid.service.UserRequestHistoryService;

@Controller
@RequestMapping("/api")
public class UserRequestHistoryController {
	
	@Autowired
	UserRequestHistoryService userRequestService;
	
	
	@PostMapping("/raiseyourhand")
	public  ResponseEntity<UserRequestHistory> healthHistoryRegister(@RequestBody UserRequestHistory userRequest){
		UserRequestHistory userrequest=userRequestService.updateUserRequest(userRequest);
		return new ResponseEntity<>(userrequest, HttpStatus.OK);
	}

}
