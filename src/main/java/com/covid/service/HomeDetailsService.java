package com.covid.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.covid.dto.HomeDetailsDto;
import com.covid.model.LocationHistory;
import com.covid.model.Patient;
import com.covid.model.PatientCurrentStatus;
import com.covid.repository.LocationHistoryRepo;
import com.covid.repository.PatientCurrentStatusRepo;
import com.covid.repository.PatientRepo;
import com.covid.repository.UserRepo;
import com.covid.vo.UserEntity;


@Service
public class HomeDetailsService {
	
	@Autowired
	LocationHistoryRepo locationHistoryRepo;
	
	@Autowired
	PatientRepo patientRepo;
	
	@Autowired
	UserRepo userRepo;
	
	public HomeDetailsDto getHomeDetailsById(long userId) {
		HomeDetailsDto homeDetails=new HomeDetailsDto();
		UserEntity user=userRepo.findByUserId(userId);
		Patient patient=patientRepo.findByUserId(userId);
		LocationHistory status=locationHistoryRepo.findByPatientId(patient.getPatientId());
		homeDetails.setCurrentlatitude(status.getLatitude());
		homeDetails.setCurrentlongitutude(status.getLongitude());
		return homeDetails;	
		
	}

}
