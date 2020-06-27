package org.covn.controller;

import java.util.List;

import org.covn.dto.UserDto;
import org.covn.model.db.Users;
import org.covn.model.type.AdminGender;
import org.covn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

public class UserController extends BaseController{

	@Autowired
	private UserService service;
	
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public @ResponseBody Integer save(@RequestBody UserDto user) {
        return service.save(user);

    }
	
    @RequestMapping(value = "/findAgeOverAndNotSet", method = RequestMethod.POST)
    public @ResponseBody List<UserDto> findAgeOverAndNotSet(@RequestBody Users user) {
    	List<UserDto> dtos = service.findByAgeOverAndNotSex(user.getAgeYrs(), AdminGender.valueOf(user.getAdminGender()));
        return dtos;
    }
    
	
}
