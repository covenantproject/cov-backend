package com.covid.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.covid.dto.HealthProfessionalDto;
import com.covid.service.HealthProfessionalService;

@Controller
@RequestMapping("/api")
public class HealthProfessionalController {

	@Autowired
	HealthProfessionalService healthProService;

	@PostMapping("/registerNewHealthPro")
	@PreAuthorize("hasAuthority('ROLE_USER')")
	public @ResponseBody ModelMap saveHealthPro(@RequestBody HealthProfessionalDto healthProf) {
		ModelMap model = new ModelMap();
		try {
			String healthInfo = healthProService.saveHealthPro(healthProf);
		} catch (Exception ex) {
			throw new RuntimeException("Save Couldn't Complete");
		}

		model.addAttribute("status", "Success");
		model.addAttribute("error", "");
		return model;
	}

}
