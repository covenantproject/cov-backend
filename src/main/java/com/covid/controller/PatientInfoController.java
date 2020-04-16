package com.covid.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.covid.dto.LocationAndRoleDto;
import com.covid.dto.PatientInfoDto;
import com.covid.service.PatientInfoService;

@Controller
@RequestMapping("/api")
public class PatientInfoController {
	
	@Autowired
	PatientInfoService patientService;
	
	@GetMapping("/getPatientForLocation")
	public @ResponseBody ModelMap getPatientForLocation(@RequestParam long patientId) {
		ModelMap model = new ModelMap();
		PatientInfoDto patientInfo = patientService.getPatientForLocation(patientId);
		model.addAttribute("status", "Success");
		model.addAttribute("patients", patientInfo);
		return model;
	}

}
