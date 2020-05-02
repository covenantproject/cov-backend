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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.covid.dto.GeofenceDto;
import com.covid.model.GeofenceLocation;
import com.covid.service.GeofenceService;

@Controller
@RequestMapping("/api")
public class GeofenceController {

	public static final Logger logger = LoggerFactory.getLogger(LocationRoleController.class);
	@Autowired
	GeofenceService geofenceService;

	@Value("${mobileApp.apiKey}")
	private String mobileApikey;

	@PostMapping("/updategeofence")
	public @ResponseBody ResponseEntity<Object> geofenceRegister(HttpServletRequest request,
			@RequestBody GeofenceDto geofenceDto) {
		String apiKey = request.getHeader("api-key");
		if (apiKey.equals(mobileApikey)) {
			ModelMap model = new ModelMap();
			try {
				geofenceService.updateGeofence(geofenceDto);
			} catch (Exception ex) {
				logger.error("EXCEPTION_IN_Geofence", ex);
				throw new RuntimeException("Save Couldn't Complete");
			}
			model.addAttribute("status", "Success");
			return new ResponseEntity<>(model, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("FAILED", HttpStatus.FORBIDDEN);
		}
	}

	@GetMapping("/getgeofence")
	public @ResponseBody ResponseEntity<Object> getGeofence(HttpServletRequest request, @RequestParam int patientId) {
		String apiKey = request.getHeader("api-key");
		if (apiKey.equals(mobileApikey)) {
			ModelMap model = new ModelMap();
			List<GeofenceLocation> geofence = new ArrayList<GeofenceLocation>();
			try {
				geofence = geofenceService.getGeofence(patientId);
			} catch (Exception ex) {
				logger.error("EXCEPTION_IN_Geofence", ex);
				throw new RuntimeException("REC_NOT_FOUND");
			}
			model.addAttribute("geoFenceData", geofence);
			return new ResponseEntity<>(model, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("FAILED", HttpStatus.FORBIDDEN);
		}
	}
}
