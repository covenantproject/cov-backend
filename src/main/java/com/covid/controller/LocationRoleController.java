package com.covid.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.covid.dto.LocationAndRoleDto;
import com.covid.service.LocationRoleService;


@Controller
@RequestMapping("/api")
public class LocationRoleController {
	
	@Autowired
	LocationRoleService locationService;
	
	@GetMapping("/getLocationAndRole")
	@PreAuthorize("hasAuthority('ROLE_USER')")
	public @ResponseBody ModelMap getLocationAndRole(@RequestParam long userId) {
		ModelMap model = new ModelMap();
		List<LocationAndRoleDto> locationRoles = locationService.getLocationAndRoles(userId);
		model.addAttribute("status", "Success");
		model.addAttribute("homeDetails", locationRoles);
		return model;
	}

}
