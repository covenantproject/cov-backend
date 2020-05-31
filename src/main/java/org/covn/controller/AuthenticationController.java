package org.covn.controller;

import org.covn.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AuthenticationController {

    @Autowired
    AuthenticationService authenticationService;

    @PostMapping("/otp")
    public String setOtp(@RequestParam String mobileNo) {
        authenticationService.sendOtp(mobileNo);
        return "SUCCESS";
    }

    @PostMapping("/validateOtp")
    public long verifyOtp(@RequestParam String mobileNo, @RequestParam String otpCode) {
        long userId = authenticationService.verifyOtp(mobileNo, otpCode);
        return userId;
    }

}
