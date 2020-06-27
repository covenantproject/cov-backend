package org.covn.controller;

import org.covn.dto.UserDto;
import org.covn.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api")
public class CovidController {

    @Autowired
    private PatientService service;

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public UserDto getUserProfileInfo(@RequestParam Long userId) {
        //return covidService.getUserProfile(userId);
    	return null;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public int registerUser(@RequestBody UserDto user) {
       
        return -1;
    }

    @RequestMapping(value = "/doUpload", method = RequestMethod.POST, consumes = {"multipart/form-data"})
    public Long upload(@RequestParam MultipartFile file) {
        return null;
    }
}
