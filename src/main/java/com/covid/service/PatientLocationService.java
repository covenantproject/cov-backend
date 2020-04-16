package com.covid.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.covid.dto.PatientDto;
import com.covid.dto.PatientLocationDto;
import com.covid.model.Patient;
import com.covid.model.PatientCurrentStatus;
import com.covid.repository.PatientCurrentStatusRepo;
import com.covid.repository.PatientRepo;
import com.covid.repository.UserRepo;
import com.covid.vo.UserEntity;

@Service
public class PatientLocationService {

	@Autowired
	UserRepo userRepo;
	
	@Autowired
	PatientRepo patientRepo;
	
	@Autowired
	PatientCurrentStatusRepo patientStatusRepo;

	public List<PatientDto> getPatientsForLocation(long locationId, long userId, long size, long from,
			long alertsOnly) {
		List<PatientDto> patients=new ArrayList<PatientDto>();
		
		UserEntity user=userRepo.findByUserId(userId);
		
		List<Patient> patientList=patientRepo.findTop100ByUserId(user.getUserId());
		for(int i=0;i<patientList.size();i++) {
			PatientDto patient=new PatientDto();
			patient.setPatientID(patientList.get(i).getPatientId());
			
			PatientCurrentStatus status=patientStatusRepo.findByPatientId(patientList.get(i).getPatientId());
			patient.setCovid19Status(status.getCOVID19Status());
			patient.setQuarantineStatus(status.getCurrentQuarantineStatus());
			patient.setIsolationStatus(status.getCurrentIsolationStatus());
			patients.add(patient);
			
		}

		return patients;
	}

}
