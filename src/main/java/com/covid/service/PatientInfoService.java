package com.covid.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.covid.dto.LocationAndRoleDto;
import com.covid.dto.PatientInfoDto;
import com.covid.model.Address;
import com.covid.model.LocationHistory;
import com.covid.model.Patient;
import com.covid.model.PatientCurrentStatus;
import com.covid.model.PhoneNumber;
import com.covid.repository.AddressRepo;
import com.covid.repository.LocationHistoryRepo;
import com.covid.repository.PatientCurrentStatusRepo;
import com.covid.repository.PatientRepo;
import com.covid.repository.PhoneNumberRepo;
import com.covid.repository.UserRepo;
import com.covid.vo.UserEntity;

@Service
public class PatientInfoService {
	
	@Autowired
	UserRepo userRepo;
	
	@Autowired
	PatientRepo patientRepo;
	
	@Autowired
	PatientCurrentStatusRepo patientCurrentStausRepo;
	
	@Autowired
	LocationHistoryRepo locationHistoryRepo;
	
	@Autowired
	PhoneNumberRepo phoneNoRepo;
	
	@Autowired
	AddressRepo adressRepo;

	public PatientInfoDto getPatientForLocation(long patientId) {
		
		PatientInfoDto patientInfo=new PatientInfoDto();
		
		Patient patient=patientRepo.findByPatientId(patientId);
		patientInfo.setPatientID(patient.getPatientId());
		UserEntity user=userRepo.findByUserId(patient.getUserId());
		patientInfo.setFirstName(user.getFirstName());
		patientInfo.setLastName(user.getLastName());
		patientInfo.setSex(user.getGender());
		patientInfo.setDateOfBirth(user.getDateOfBirth());
		
		PatientCurrentStatus patientStaus=patientCurrentStausRepo.findByPatientId(patientId);
		patientInfo.setCovid19Status(patientStaus.getCOVID19Status());
		patientInfo.setQuarantineStatus(patientStaus.getCurrentQuarantineStatus());
		patientInfo.setIsolationStatus(patientStaus.getCurrentIsolationStatus());
		patientInfo.setQuarantineStartDate(patientStaus.getQuarantineStartDateTime());
		patientInfo.setQuarantineEndDate(patientStaus.getQuarantineEndDateTime());
		
		LocationHistory locHistory=locationHistoryRepo.findByPatientId(patientId);
		patientInfo.setLatitude(locHistory.getLatitude());
		patientInfo.setLongitude(locHistory.getLongitude());
		
		PhoneNumber phoneDetails=phoneNoRepo.findByUserId(patient.getUserId());
		patientInfo.setPhoneNumber1(phoneDetails.getPhoneNumber());
		patientInfo.setPhoneNumber1HasInternet(phoneDetails.isHasInternetAccess());
		patientInfo.setPhoneNumber1HasSMS(phoneDetails.isHasSMSAccess());
		patientInfo.setPhoneNumber1HasWhatsapp(phoneDetails.isHasWhatsAppAccess());
		patientInfo.setPhoneNumber1IsPrimaryUser(phoneDetails.isIsPrimaryUser());
		patientInfo.setPhoneNumber1Type(phoneDetails.getPhoneType());
		
		Address adress=adressRepo.findByUserId(patient.getUserId());
		
		String adr=adress.getAddressLine1().concat(", ".concat(adress.getCity().concat(", ").concat(adress.getState().concat(", ").concat(adress.getCountry()))));
		patientInfo.setQuarantineAddress(adr);		
		return patientInfo;
	}

}
