package com.covid.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.covid.model.HealthHistory;
import com.covid.service.HealthHistoryService;
import com.covid.vo.Register;

@Controller
@RequestMapping("/api")
public class HealthHistoryController {

	@Autowired
	HealthHistoryService healthService;

	@PostMapping("/updatehealthinfo")
	public ResponseEntity<HealthHistory> healthHistoryRegister(@RequestBody HealthHistory healthHistory) {
		HealthHistory health = healthService.updatehealthinfo(healthHistory);
		return new ResponseEntity<>(health, HttpStatus.OK);
	}
}
