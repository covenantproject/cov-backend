package com.covid.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.covid.model.LocationHistory;
import com.covid.service.LocationHistoryService;

@Controller
@RequestMapping("/api")
public class LocationHistoryController {

	@Autowired
	LocationHistoryService locationHistoryService;
	
	@PostMapping("/locationHistory")
	public  ResponseEntity<LocationHistory> postLocationHistory(@RequestBody LocationHistory locationHistory){
		LocationHistory location=locationHistoryService.postLocationHistory(locationHistory);
		return new ResponseEntity<>(location, HttpStatus.OK);
	}

}
