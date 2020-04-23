package com.covid.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

	public static final Logger logger = LoggerFactory.getLogger(LocationRoleController.class);
	@Autowired
	LocationHistoryService locationHistoryService;

	@PostMapping("/locationHistory")
	public ResponseEntity<LocationHistory> postLocationHistory(@RequestBody LocationHistory locationHistory) {
		LocationHistory location = new LocationHistory();
		try {
			location = locationHistoryService.postLocationHistory(locationHistory);
		} catch (Exception ex) {
			logger.error("EXCEPTION_IN_LocationHistory", ex);
			throw new RuntimeException("Save Couldn't Complete");

		}

		return new ResponseEntity<>(location, HttpStatus.OK);
	}
}
