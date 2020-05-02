package com.covid.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

import com.covid.model.UserRequestHistory;
import com.covid.service.UserRequestHistoryService;

@Controller
@RequestMapping("/api")
public class UserRequestHistoryController {

	@Autowired
	UserRequestHistoryService userRequestService;
	public static final Logger logger = LoggerFactory.getLogger(LocationRoleController.class);

	@Value("${mobileApp.apiKey}")
	private String mobileApikey;

	@PostMapping("/raiseyourhand")
	public @ResponseBody ResponseEntity<Object> healthHistoryRegister(HttpServletRequest request,
			@RequestBody UserRequestHistory userRequest) {
		String apiKey = request.getHeader("api-key");
		if (apiKey.equals(mobileApikey)) {
			ModelMap model = new ModelMap();
			try {
				userRequestService.updateUserRequest(userRequest);
			} catch (Exception ex) {
				logger.error("EXCEPTION_IN_UserRequestHistory", ex);
				throw new RuntimeException("Save Couldn't Complete");
			}

			model.addAttribute("status", "Success");
			return new ResponseEntity<>(model, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("FAILED", HttpStatus.FORBIDDEN);
		}
	}
}
