package com.covid.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.covid.dto.HealthInfoDto;
import com.covid.dto.HealthProfessionalDto;
import com.covid.service.HealthProfessionalService;

@Controller
@RequestMapping("/api")
public class HealthProfessionalController {
	
	@Autowired
	HealthProfessionalService healthProService;
	
	
	@PostMapping("/registerNewHealthPro")
	public @ResponseBody ModelMap saveHealthPro(@RequestBody HealthProfessionalDto healthProf){
		ModelMap model=new ModelMap();
		String healthInfo=healthProService.saveHealthPro(healthProf);
		model.addAttribute("status", "Success");
		model.addAttribute("error", "");
		return model;
	}

	

}
