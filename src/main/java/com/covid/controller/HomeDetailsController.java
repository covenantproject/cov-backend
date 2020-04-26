package com.covid.controller;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.covid.dto.homeDetailsFnDto;
import com.covid.service.HomeDetailsService;

@Controller
@RequestMapping("/api")
public class HomeDetailsController {

	public static final Logger logger = LoggerFactory.getLogger(LocationRoleController.class);
	@Autowired
	HomeDetailsService homeDetailService;

	@GetMapping("/homedetails")
	public @ResponseBody ModelMap getHomeDetailById(@RequestParam int userId) {
		ModelMap model = new ModelMap();
		homeDetailsFnDto hm = new homeDetailsFnDto();
		try {
			List<Object> homeDetails = homeDetailService.getHomeDetailById(userId);
			if (homeDetails != null) {
				Iterator<Object> itr = homeDetails.iterator();
				while (itr.hasNext()) {
					Object[] obj = (Object[]) itr.next();
					if (obj[0] != null) {
						hm.setPatientid(Integer.parseInt(String.valueOf(obj[0])));
					}
					if (obj[1] != null) {
						hm.setFirstname(String.valueOf(obj[1]));
					}
					if (obj[2] != null) {
						hm.setLastname(String.valueOf(obj[2]));
					}
					if (obj[3] != null) {
						hm.setLatitude(Double.parseDouble(String.valueOf(obj[3])));
					}
					if (obj[4] != null) {
						hm.setLongitude(Double.parseDouble(String.valueOf(obj[4])));
					}
					if (obj[5] != null) {
						hm.setEmergencycontact1(String.valueOf(obj[5]));
					}
					if(obj[6]!=null) {
						DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						Date dt=dateFormat.parse(String.valueOf(obj[6]));
						hm.setRequestdatetime(dt);
					}
				}

			} else {
				throw new RuntimeException("REC_NOT_FOUND");
			}
		} catch (Exception ex) {
			logger.error("EXCEPTION_IN_ HomeDetails", ex);
			throw new RuntimeException("REC_NOT_FOUND");
		}
		model.addAttribute("status", "Success");
		model.addAttribute("homeDetails", hm);
		return model;
	}
}
