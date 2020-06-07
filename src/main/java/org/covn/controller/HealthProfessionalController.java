package org.covn.controller;

import org.covn.dto.HealthProfessionalDto;
import org.covn.exception.CovnServiceException;
import org.covn.service.HealthProfessionalService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

import static org.slf4j.LoggerFactory.getLogger;

@Controller
@RequestMapping("/web/api")
public class HealthProfessionalController {

	public static final Logger LOGGER = getLogger(HealthProfessionalController.class);
	@Autowired
	private HealthProfessionalService healthProService;

	@PostMapping("/registerNewHealthPro")
	@PreAuthorize("hasAuthority('ROLE_USER')")
	public @ResponseBody
	ModelMap saveHealthPro(@Valid @RequestBody HealthProfessionalDto healthProf) {
		ModelMap model = new ModelMap();
		try {
			healthProService.registerNewHealthProfessional(healthProf);
			LOGGER.info("Successfully registered the user..");
		} catch (Exception ex) {
			LOGGER.error("EXCEPTION_IN_HealthProfessional", ex);
			throw new CovnServiceException("Save Couldn't Complete");
		}
		model.addAttribute("status", "Success");
		model.addAttribute("error", "");
		return model;
	}
}
