package com.covid.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

import com.covid.dto.*;
import com.covid.service.CovidService;
import com.covid.service.HealthProfessionalService;

@Controller
@RequestMapping("/web/api")
public class HealthProfessionalController {

	public static final Logger logger = LoggerFactory.getLogger(LocationRoleController.class);
	@Autowired
	HealthProfessionalService healthProService;

	@Autowired
    private CovidService covidService;

	@PostMapping("/registerNewHealthPro")
	@PreAuthorize("hasAuthority('ROLE_USER')")
	public @ResponseBody String saveHealthPro(@RequestBody HealthProfessionalDto healthProf) {
		String userId = "";
		try {
			userId = healthProService.saveHealthPro(healthProf);
		} catch (Exception ex) {
			logger.error("EXCEPTION_IN_HealthProfessional", ex);
			throw new RuntimeException("Save Couldn't Complete");
		}

		return userId;
	}

	@GetMapping("/getHealthProHierarchy")
	@PreAuthorize("hasAuthority('ROLE_USER')")
	public @ResponseBody List<HealthProHierarchyDto> getLocationhierarchy(@RequestParam int supervisorID) {
		List<HealthProHierarchyDto> usrHierarchy = new ArrayList<HealthProHierarchyDto>();
		try {
			usrHierarchy = healthProService.getUsrHierarchy(supervisorID);
		} catch (Exception ex) {
			logger.error("EXCEPTION_IN_getHealthProHierarchy", ex);
			throw new RuntimeException("REC_NOT_FOUND");
		}
		return usrHierarchy;
	}

	@RequestMapping(value = "/getUserId", method = RequestMethod.GET)
	@PreAuthorize("hasAuthority('ROLE_USER')")
    public @ResponseBody UserDto getUserId(@RequestParam String username) {
        return covidService.getUserId(username);
    }
}
