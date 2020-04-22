package com.covid.controller;

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
@RequestMapping("/api")
public class PatientProviderRelationshipController {

	@Autowired
	PatientProviderRelationshipService patientProService;

	@PostMapping("/savePatientProviderRela")
	@PreAuthorize("hasAuthority('ROLE_USER')")
	public @ResponseBody ModelMap savePatientProvider(@RequestBody PatientProviderRelationshipDto patientProvider) {
		ModelMap model = new ModelMap();
		try {
			String userrequest = patientProService.savePatientProvider(patientProvider);
		} catch (Exception ex) {
			throw new RuntimeException("Save Couldn't Complete");
		}
		model.addAttribute("status", "Success");
		return model;
	}

}
