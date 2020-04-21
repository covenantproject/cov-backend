package com.covid.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.covid.dto.LocationAndRoleDto;
import com.covid.service.SendMessageService;

@Controller
@RequestMapping("/api")
public class SendMessageController {
	
	@Autowired
	SendMessageService sendSmsService;
	
	 @PostMapping("/sendSms")
	    public String setOtp(@RequestParam String mobileNos,@RequestParam String message) {
		 String[] numberList=mobileNos.split(",");
		 for(int i=0;i<numberList.length;i++) {
			 sendSmsService.sendSMS(numberList[i],message);
		 }
	        return "SUCCESS";
	    }

}
