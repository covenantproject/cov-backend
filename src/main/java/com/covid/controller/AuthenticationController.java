package com.covid.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.covid.model.UserRequestHistory;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Controller
@RequestMapping("/api")
public class AuthenticationController {
	
	@Autowired
    public AuthenticationController(
        @Value("${twilioAccountSid}") String twilioAccountSid,
        @Value("${twilioAuthToken}") String twilioAuthToken) {
        Twilio.init(twilioAccountSid, twilioAuthToken);
	}
	
	@Value("${TwilioFromNumber}")
    private String myTwilioPhoneNumber;
	
	@PostMapping("/otp")
	public  ModelMap postOTP(@RequestParam String mobileNo, @RequestHeader HttpHeaders headers){
		ModelMap model=new ModelMap();
		List<String> apikey=headers.get("apikey");

		//Send OTP to the number
		Message.creator(
			new PhoneNumber(mobileNo),
			new PhoneNumber(myTwilioPhoneNumber),
			"Your Covenant Verification code is: 1234").create();

		model.addAttribute("status","Sucess");
		model.addAttribute("errorcode","");
		return model;
	}
	
	@PostMapping("/validateotp")
	public  @ResponseBody ModelMap OTPValidation(@RequestParam String otpcode,@RequestHeader HttpHeaders headers){
		ModelMap model=new ModelMap();
		if(otpcode.contentEquals("1234")) {
			model.addAttribute("status","Sucess");
			model.addAttribute("errorcode","");
		}else {
			model.addAttribute("status","Failed");
			model.addAttribute("errorcode","400");
		}	
		return model;
	}

}
