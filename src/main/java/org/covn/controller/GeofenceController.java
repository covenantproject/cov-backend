package org.covn.controller;

import java.util.ArrayList;
import java.util.List;

import org.covn.dto.PatientGeofencedLocationDto;
import org.covn.model.db.PatientGeofencedLocation;
import org.covn.service.GeofenceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api")
public class GeofenceController {

	public static final Logger logger = LoggerFactory.getLogger(LocationRoleController.class);
	@Autowired
	GeofenceService geofenceService;

	@PostMapping("/updategeofence")
	public @ResponseBody ModelMap geofenceRegister(@RequestBody PatientGeofencedLocationDto geofenceDto) {
		ModelMap model = new ModelMap();
		try {
			String geo = geofenceService.updateGeofence(geofenceDto);
		} catch (Exception ex) {
			logger.error("EXCEPTION_IN_Geofence", ex);
			throw new RuntimeException("Save Couldn't Complete");
		}
		model.addAttribute("status", "Success");
		return model;
	}

	@GetMapping("/getgeofence")
	public @ResponseBody ModelMap getGeofence(@RequestParam int patientId) {
		ModelMap model = new ModelMap();
		List<PatientGeofencedLocation> geofence = new ArrayList<PatientGeofencedLocation>();
		try {
			geofence = geofenceService.getGeofence(patientId);
		} catch (Exception ex) {
			logger.error("EXCEPTION_IN_Geofence", ex);
			throw new RuntimeException("REC_NOT_FOUND");
		}
		model.addAttribute("locationHierarchy", geofence);
		return model;
	}
}
