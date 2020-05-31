package org.covn.controller;

import java.util.ArrayList;
import java.util.List;

import org.covn.model.db.LocationHierarchy;
import org.covn.service.LocationHierarchyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/web/api")
public class LocationHierarchyController {

	public static final Logger logger = LoggerFactory.getLogger(LocationRoleController.class);
	@Autowired
	LocationHierarchyService locationHierarchyService;

	@GetMapping("/getLocationHierarchy")
	@PreAuthorize("hasAuthority('ROLE_USER')")
	public @ResponseBody ModelMap getLocationhierarchy(@RequestParam int locationID) {
		ModelMap model = new ModelMap();
		List<LocationHierarchy> locHierarchy = new ArrayList<LocationHierarchy>();
		try {
			locHierarchy = locationHierarchyService.getLocHierarchy(locationID);
		} catch (Exception ex) {
			logger.error("EXCEPTION_IN_locationHierarchy", ex);
			throw new RuntimeException("REC_NOT_FOUND");
		}
		model.addAttribute("locationHierarchy", locHierarchy);
		return model;
	}
}
