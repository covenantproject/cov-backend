package com.covid.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.covid.model.LocationHierarchy;
import com.covid.service.LocationHierarchyService;

@Controller
@RequestMapping("/api")
public class LocationsController {

	public static final Logger logger = LoggerFactory.getLogger(LocationsController.class);
	@Autowired
	LocationHierarchyService locationHierarchyService;

	@Value("${mobileApp.apiKey}")
	private String mobileApikey;

	@GetMapping("/getLocationHierarchy")
	public @ResponseBody ResponseEntity<Object> getLocationhierarchy(HttpServletRequest request,
			@RequestParam int locationID) {
		String apiKey = request.getHeader("api-key");
		if (apiKey.equals(mobileApikey)) {
			ModelMap model = new ModelMap();
			List<LocationHierarchy> locHierarchy = new ArrayList<LocationHierarchy>();
			try {
				locHierarchy = locationHierarchyService.getLocHierarchy(locationID);
			} catch (Exception ex) {
				logger.error("EXCEPTION_IN_locationHierarchy", ex);
				throw new RuntimeException("REC_NOT_FOUND");
			}
			
			model.addAttribute("locationHierarchy", locHierarchy);
			return new ResponseEntity<>(model, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("FAILED", HttpStatus.FORBIDDEN);
		}
	}
}
