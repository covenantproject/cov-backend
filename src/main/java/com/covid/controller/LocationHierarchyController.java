package com.covid.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.covid.model.LocationHierarchy;
import com.covid.service.LocationHierarchyService;

@Controller
@RequestMapping("/api")
public class LocationHierarchyController {

	@Autowired
	LocationHierarchyService locationHierarchyService;

	@GetMapping("/getLocationHierarchy")
	@PreAuthorize("hasAuthority('ROLE_USER')")
	public @ResponseBody ModelMap getLocationhierarchy(@RequestParam int locationID) {
		ModelMap model = new ModelMap();
		List<LocationHierarchy> locHierarchy = new ArrayList<LocationHierarchy>();
		locHierarchy = locationHierarchyService.getLocHierarchy(locationID);
		model.addAttribute("locationHierarchy", locHierarchy);
		return model;
	}

}
