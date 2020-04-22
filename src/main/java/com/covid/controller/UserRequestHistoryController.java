package com.covid.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.covid.model.UserRequestHistory;
import com.covid.service.UserRequestHistoryService;

@Controller
@RequestMapping("/api")
public class UserRequestHistoryController {
	
	@Autowired
	UserRequestHistoryService userRequestService;
	
	
	@PostMapping("/raiseyourhand")
	public  @ResponseBody ModelMap healthHistoryRegister(@RequestBody UserRequestHistory userRequest){
		ModelMap model=new ModelMap();
		String userrequest=userRequestService.updateUserRequest(userRequest);
		model.addAttribute("status", "Success");
		model.addAttribute("error", "");
		return model;
	}

}
