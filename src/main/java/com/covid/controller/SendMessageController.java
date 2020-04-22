package com.covid.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.covid.service.SendMessageService;

@Controller
@RequestMapping("/api")
public class SendMessageController {
	
	@Autowired
	SendMessageService sendSmsService;
	
	 @PostMapping("/sendSms")
	    public @ResponseBody ModelMap setOtp(@RequestParam String mobileNos,@RequestParam String message) {
		 ModelMap model=new ModelMap();
		 String[] numberList=mobileNos.split(",");
		 for(int i=0;i<numberList.length;i++) {
			 sendSmsService.sendSMS(numberList[i],message);
		 }
		 model.addAttribute("status", "Success");
		 return model;
	    }
	

}
