package com.covid.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.covid.model.HealthHistory;
import com.covid.repository.HealthHistoryRepo;

@Service
public class HealthHistoryService {

	@Autowired
	HealthHistoryRepo healthHistoryRepo;
	
	public HealthHistory updatehealthinfo(HealthHistory healthHistory) {
		healthHistoryRepo.save(healthHistory); 
		return healthHistory;			
	}
}
