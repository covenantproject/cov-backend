package com.covid.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.covid.dto.HealthInfoDto;
import com.covid.service.HealthInfoService;

@Controller
@RequestMapping("/api")
public class HealthInfoController {
	
	@Autowired
	HealthInfoService healthService;
	
	@PostMapping("/updateHealth")
	public @ResponseBody ModelMap healthHistoryRegister(@RequestBody HealthInfoDto userRequest){
		ModelMap model=new ModelMap();
		String healthInfo=healthService.updateHealthInfo(userRequest);
		HealthInfoDto h=new HealthInfoDto();
		model.addAttribute("status", "Success");
		model.addAttribute("error", "");
		return model;
	}

}
