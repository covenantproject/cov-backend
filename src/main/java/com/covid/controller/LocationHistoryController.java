package com.covid.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

import com.covid.model.LocationHistory;
import com.covid.service.LocationHistoryService;

@Controller
@RequestMapping("/api")
public class LocationHistoryController {

	public static final Logger logger = LoggerFactory.getLogger(LocationRoleController.class);
	@Autowired
	LocationHistoryService locationHistoryService;

	@Value("${mobileApp.apiKey}")
	private String mobileApikey;

	@PostMapping("/locationHistory")
	public ResponseEntity<Object> postLocationHistory(HttpServletRequest request,
			@RequestBody LocationHistory locationHistory) {
		String apiKey = request.getHeader("api-key");
		if (apiKey.equals(mobileApikey)) {
			LocationHistory location = new LocationHistory();
			try {
				location = locationHistoryService.postLocationHistory(locationHistory);
			} catch (Exception ex) {
				logger.error("EXCEPTION_IN_LocationHistory", ex);
				throw new RuntimeException("Save Couldn't Complete");
			}

			return new ResponseEntity<>(location, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("FAILED", HttpStatus.FORBIDDEN);
		}
	}
}
