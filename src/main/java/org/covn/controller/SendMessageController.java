package org.covn.controller;

import org.covn.service.SendMessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/web/api")
public class SendMessageController {

	@Autowired
	SendMessageService sendSmsService;

	public static final Logger logger = LoggerFactory.getLogger(LocationRoleController.class);

	@PostMapping("/sendSms")
	@PreAuthorize("hasAuthority('ROLE_USER')")
	public @ResponseBody ModelMap setOtp(@RequestParam String mobileNos, @RequestParam String message) {
		ModelMap model = new ModelMap();
		String[] numberList = mobileNos.split(",");
		try {
			for (int i = 0; i < numberList.length; i++) {
				sendSmsService.sendSMS(numberList[i], message);
			}
		} catch (Exception ex) {
			logger.error("EXCEPTION_IN_SendMessage", ex);
			throw new RuntimeException("SMS_FAILED");
		}
		model.addAttribute("status", "Success");
		return model;
	}
}
