package com.covid.controller;

import javax.servlet.http.HttpServletRequest;

import com.covid.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AuthenticationController {

    @Autowired
    AuthenticationService authenticationService;

    @Value("${mobileApp.apiKey}")
    private String mobileApikey;

    @PostMapping("/otp")
    public ResponseEntity<Object> setOtp(HttpServletRequest request, @RequestParam String mobileNo) {
        String apiKey = request.getHeader("api-key");
        if (apiKey.equals(mobileApikey)) {
            authenticationService.sendOtp(mobileNo);
            return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("FAILED", HttpStatus.FORBIDDEN);
        }
    }

    @PostMapping("/validateOtp")
    public ResponseEntity<Object> verifyOtp(HttpServletRequest request, @RequestParam String mobileNo,
            @RequestParam String otpCode) {
        String apiKey = request.getHeader("api-key");
        if (apiKey.equals(mobileApikey)) {
            long userId = authenticationService.verifyOtp(mobileNo, otpCode);
            return new ResponseEntity<>(userId, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("FAILED", HttpStatus.FORBIDDEN);
        }
    }
}
