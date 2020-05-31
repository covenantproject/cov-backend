package org.covn.controller;

import org.covn.dto.HealthInfoDto;
import org.covn.service.HealthInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api")
public class HealthInfoController {

	public static final Logger logger = LoggerFactory.getLogger(LocationRoleController.class);
	@Autowired
	HealthInfoService healthService;

	@PostMapping("/updateHealth")
	public @ResponseBody ModelMap healthHistoryRegister(@RequestBody HealthInfoDto userRequest) {
		ModelMap model = new ModelMap();
		try {
			String healthInfo = healthService.updateHealthInfo(userRequest);
		} catch (Exception ex) {
			logger.error("EXCEPTION_IN_HealthInfo", ex);
			throw new RuntimeException("Save Couldn't Complete");
		}

		HealthInfoDto h = new HealthInfoDto();
		model.addAttribute("status", "Success");
		return model;
	}
}
