package org.covn.controller;

import org.covn.model.db.PatientRequestHistory;
import org.covn.service.UserRequestHistoryService;
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
public class UserRequestHistoryController {

	@Autowired
	UserRequestHistoryService userRequestService;
	public static final Logger logger = LoggerFactory.getLogger(LocationRoleController.class);

	@PostMapping("/raiseyourhand")
	public @ResponseBody ModelMap healthHistoryRegister(@RequestBody PatientRequestHistory userRequest) {
		ModelMap model = new ModelMap();
		try {
			String userrequest = userRequestService.updateUserRequest(userRequest);
		} catch (Exception ex) {
			logger.error("EXCEPTION_IN_UserRequestHistory", ex);
			throw new RuntimeException("Save Couldn't Complete");
		}

		model.addAttribute("status", "Success");
		return model;
	}
}
