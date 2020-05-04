package com.covid.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.covid.dto.HistoryDto;
import com.covid.model.HealthHistory;
import com.covid.service.HealthHistoryService;
import com.covid.service.HistoryService;

@Controller
@RequestMapping("/api")
public class HealthHistoryController {

	public static final Logger logger = LoggerFactory.getLogger(LocationRoleController.class);
	@Autowired
	HealthHistoryService healthService;

	@Autowired
	HistoryService historyService;

	@Value("${mobileApp.apiKey}")
	private String mobileApikey;

	@PostMapping("/updatehealthinfo")
	public ResponseEntity<Object> healthHistoryRegister(HttpServletRequest request,
			@RequestBody HealthHistory healthHistory) {
		String apiKey = request.getHeader("api-key");
		if (apiKey.equals(mobileApikey)) {
			HealthHistory health = new HealthHistory();
			try {
				health = healthService.updatehealthinfo(healthHistory);
			} catch (Exception ex) {
				logger.error("EXCEPTION_IN_HealthHistory", ex);
				throw new RuntimeException("Save Couldn't Complete");
			}

			return new ResponseEntity<>(health, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("FAILED", HttpStatus.FORBIDDEN);
		}
	}

	@GetMapping("/history")
	public @ResponseBody ResponseEntity<Object> getAllHistory(HttpServletRequest request,
			@RequestParam int userId) {
		String apiKey = request.getHeader("api-key");
		if (apiKey.equals(mobileApikey)) {
			ModelMap model = new ModelMap();
			List<HistoryDto> historyList = new ArrayList<HistoryDto>();
			try {
				historyList = historyService.getAllHistory(userId);
			} catch (Exception ex) {
				logger.error("EXCEPTION_IN_history", ex);
				throw new RuntimeException("REC_NOT_FOUND");
			}
			model.addAttribute("history", historyList);
			return new ResponseEntity<>(model, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("FAILED", HttpStatus.FORBIDDEN);
		}
	}
}
