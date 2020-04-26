package com.covid.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.covid.model.LocationHistory;
import com.covid.repository.LocationHistoryRepo;

@Service
public class LocationHistoryService {
	
	@Autowired
	LocationHistoryRepo locationHistoryRepo;
	
	public LocationHistory postLocationHistory(LocationHistory locationHistory) {
		return locationHistoryRepo.save(locationHistory); 		
	}

}
