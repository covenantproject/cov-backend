package com.covid.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.covid.dto.PatientProviderRelationshipDto;
import com.covid.model.UserRequestHistory;
import com.covid.service.PatientProviderRelationshipService;

@Controller
@RequestMapping("/api")
public class PatientProviderRelationshipController {
	
	@Autowired
	PatientProviderRelationshipService patientProService;
	
	@PostMapping("/savePatientProviderRela")
	public  @ResponseBody ModelMap savePatientProvider(@RequestBody PatientProviderRelationshipDto patientProvider){
		ModelMap model=new ModelMap();
		String userrequest=patientProService.savePatientProvider(patientProvider);
		model.addAttribute("status", "Success");
		model.addAttribute("error", "");
		return model;
	}

}
