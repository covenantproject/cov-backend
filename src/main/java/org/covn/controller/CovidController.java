package org.covn.controller;

import org.covn.dto.UserDto;
import org.covn.service.UserService;
import org.covn.vo.Register;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
    private UserService covidService;

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public UserDto getUserProfileInfo(@RequestParam Long userId) {
        return covidService.getUserProfile(userId);
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Long registerUser(@RequestBody Register register) {
        return covidService.registerUser(register);
    }

    @RequestMapping(value = "/doUpload", method = RequestMethod.POST, consumes = {"multipart/form-data"})
    public Long upload(@RequestParam MultipartFile file) {
        return covidService.uploadFile(file);
    }
}
