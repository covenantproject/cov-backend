package com.covid.controller;

import javax.servlet.http.HttpServletRequest;

import com.covid.dto.RegisterDto;
import com.covid.dto.UserDto;
import com.covid.service.CovidService;
import com.covid.vo.Register;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api")
public class CovidController {

    @Autowired
    private CovidService covidService;

    @Value("${mobileApp.apiKey}")
    private String mobileApikey;

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public ResponseEntity<Object> getUserProfileInfo(HttpServletRequest request, @RequestParam Long userId) {
        String apiKey = request.getHeader("api-key");
        if (apiKey.equals(mobileApikey)) {
            return new ResponseEntity<>(covidService.getUserProfile(userId), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("FAILED", HttpStatus.FORBIDDEN);
        }
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<Object> registerUser(HttpServletRequest request, @RequestBody Register register) {
        String apiKey = request.getHeader("api-key");
        if (apiKey.equals(mobileApikey)) {
            return new ResponseEntity<>(covidService.registerUser(register), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("FAILED", HttpStatus.FORBIDDEN);
        }
    }

    @RequestMapping(value = "/doUpload", method = RequestMethod.POST, consumes = { "multipart/form-data" })
    public ResponseEntity<Object> upload(HttpServletRequest request, @RequestParam MultipartFile file) {
        String apiKey = request.getHeader("api-key");
        if (apiKey.equals(mobileApikey)) {
            return new ResponseEntity<>(covidService.uploadFile(file), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("FAILED", HttpStatus.FORBIDDEN);
        }
    }
}
