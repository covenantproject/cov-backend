package org.covn.controller;

import org.covn.dto.HealthCheckDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

	@PostMapping("/updateHealth")
	public @ResponseBody ModelMap healthHistoryRegister(@RequestBody HealthCheckDto userRequest) {
		ModelMap model = new ModelMap();
		try {
//			String healthInfo = healthService.updateHealthInfo(userRequest);
		} catch (Exception ex) {
			logger.error("EXCEPTION_IN_HealthInfo", ex);
			throw new RuntimeException("Save Couldn't Complete");
		}

		HealthCheckDto h = new HealthCheckDto();
		model.addAttribute("status", "Success");
		return model;
	}
}
