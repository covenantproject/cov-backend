package com.covid.controller;

import java.util.ArrayList;
import java.util.List;
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
import com.covid.dto.GeofenceDto;
import com.covid.model.GeofenceLocation;
import com.covid.service.GeofenceService;

@Controller
@RequestMapping("/api")
public class GeofenceController {

	public static final Logger logger = LoggerFactory.getLogger(LocationRoleController.class);
	@Autowired
	GeofenceService geofenceService;

	@PostMapping("/updategeofence")
	public @ResponseBody ModelMap geofenceRegister(@RequestBody GeofenceDto geofenceDto) {
		ModelMap model = new ModelMap();
		try {
			geofenceService.updateGeofence(geofenceDto);
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
		List<GeofenceLocation> geofence = new ArrayList<GeofenceLocation>();
		try {
			geofence = geofenceService.getGeofence(patientId);
		} catch (Exception ex) {
			logger.error("EXCEPTION_IN_Geofence", ex);
			throw new RuntimeException("REC_NOT_FOUND");
		}
		model.addAttribute("geoFenceData", geofence);
		return model;
	}
}
