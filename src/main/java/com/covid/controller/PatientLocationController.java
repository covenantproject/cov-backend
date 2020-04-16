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
import com.covid.dto.PatientDto;
import com.covid.dto.PatientLocationDto;
import com.covid.service.PatientLocationService;

@Controller
@RequestMapping("/api")
public class PatientLocationController {
	
	@Autowired
	PatientLocationService patientLocService;
	
	@GetMapping("/getPatientsForLocation")
	public @ResponseBody ModelMap getPatientsForLocation(@RequestParam(required =true )long locationId,@RequestParam(required =true ) long userId,@RequestParam(defaultValue = "100") long size,@RequestParam(defaultValue = "0") long from,@RequestParam(defaultValue = "0") long alertsOnly) {
		PatientLocationDto patients=new PatientLocationDto();
		ModelMap model = new ModelMap();
		List<PatientDto> patientList = patientLocService.getPatientsForLocation(locationId,userId,size,from,alertsOnly);
		patients.setTotal(patientList.size());
		patients.setSize(size);
		patients.setFrom(from);
		patients.setPatients(patientList);
		model.addAttribute("status", "Success");
		model.addAttribute("homeDetails", patients);
		return model;
	}
	
	@GetMapping("/searchPatient")
	public @ResponseBody ModelMap searchPatient(@RequestParam(required =true )long locationId,@RequestParam(required =true ) long userId,@RequestParam(defaultValue = "100") long size,@RequestParam(defaultValue = "0") long from,@RequestParam(defaultValue = "0") long alertsOnly) {
		PatientLocationDto patients=new PatientLocationDto();
		ModelMap model = new ModelMap();
		List<PatientDto> patientList = patientLocService.getPatientsForLocation(locationId,userId,size,from,alertsOnly);
		patients.setTotal(patientList.size());
		patients.setSize(size);
		patients.setFrom(from);
		patients.setPatients(patientList);
		model.addAttribute("status", "Success");
		model.addAttribute("homeDetails", patients);
		return model;
	}

}
