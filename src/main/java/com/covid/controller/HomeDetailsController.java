package com.covid.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.covid.dto.HomeDetailsDto;
import com.covid.service.HomeDetailsService;

@Controller
@RequestMapping("/api")
public class HomeDetailsController {

	@Autowired
	HomeDetailsService homeDetailService;
	
	@GetMapping("/homedetails")
	public @ResponseBody ModelMap getHomeDetailsById(@RequestParam long userId) {
		ModelMap model = new ModelMap();
		HomeDetailsDto homeDetails = homeDetailService.getHomeDetailsById(userId);
		model.addAttribute("status", "Success");
		model.addAttribute("homeDetails", homeDetails);
		return model;
	}
}
