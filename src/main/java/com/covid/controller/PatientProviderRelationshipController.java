package com.covid.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.covid.dto.PatientProviderRelationshipDto;
import com.covid.service.PatientProviderRelationshipService;

@Controller
@RequestMapping("/web/api")
public class PatientProviderRelationshipController {

	public static final Logger logger = LoggerFactory.getLogger(LocationRoleController.class);
	@Autowired
	PatientProviderRelationshipService patientProService;

	@PostMapping("/savePatientProviderRelationship")
	@PreAuthorize("hasAuthority('ROLE_USER')")
	public @ResponseBody ModelMap savePatientProvider(@RequestBody PatientProviderRelationshipDto patientProvider) {
		ModelMap model = new ModelMap();
		try {
			patientProService.savePatientProvider(patientProvider);
		} catch (Exception ex) {
			logger.error("EXCEPTION_IN_PatientProvider", ex);
			throw new RuntimeException("Save Couldn't Complete");
		}
		model.addAttribute("status", "Success");
		return model;
	}
}
