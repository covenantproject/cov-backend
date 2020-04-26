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
import com.covid.dto.HealthProfessionalDto;
import com.covid.service.HealthProfessionalService;

@Controller
@RequestMapping("/web/api")
public class HealthProfessionalController {

	public static final Logger logger = LoggerFactory.getLogger(LocationRoleController.class);
	@Autowired
	HealthProfessionalService healthProService;

	@PostMapping("/registerNewHealthPro")
	@PreAuthorize("hasAuthority('ROLE_USER')")
	public @ResponseBody ModelMap saveHealthPro(@RequestBody HealthProfessionalDto healthProf) {
		ModelMap model = new ModelMap();
		try {
			healthProService.saveHealthPro(healthProf);
		} catch (Exception ex) {
			logger.error("EXCEPTION_IN_HealthProfessional", ex);
			throw new RuntimeException("Save Couldn't Complete");
		}

		model.addAttribute("status", "Success");
		model.addAttribute("error", "");
		return model;
	}
}
