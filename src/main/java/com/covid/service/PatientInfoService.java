package com.covid.service;

import com.covid.dto.PatientLocationDto;
import com.covid.repository.PatientDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.covid.dto.PatientInfoDto;
import com.covid.model.Address;
import com.covid.model.AppHeartbeatHistory;
import com.covid.model.Patient;
import com.covid.model.PatientCurrentStatus;
import com.covid.model.PhoneNumber;
import com.covid.model.UserRequestHistory;
import com.covid.repository.AddressRepo;
import com.covid.repository.AppHeartbeatHistoryRepo;
import com.covid.repository.PatientCurrentStatusRepo;
import com.covid.repository.PhoneNumberRepo;
import com.covid.repository.UserRepo;
import com.covid.repository.UserRequestHistoryRepo;
import com.covid.vo.UserEntity;

import javax.persistence.EntityManager;

@Service
public class PatientInfoService {

    @Autowired
    UserRepo userRepo;

    @Autowired
    private EntityManager entityManager;

    @Autowired
    PatientCurrentStatusRepo patientCurrentStatusRepo;

    @Autowired
    PhoneNumberRepo phoneNoRepo;

    @Autowired
    AddressRepo addressRepo;

    @Autowired
    UserRequestHistoryRepo userRequestRepo;

    @Autowired
    AppHeartbeatHistoryRepo heartbeatRepo;

    @Autowired
    PatientDao patientDao;

    public PatientInfoDto getPatientForLocation(long patientId) {
        PatientInfoDto patientInfo = new PatientInfoDto();

        Patient patient = entityManager.find(Patient.class, patientId);
        if (patient == null) {
            throw new RuntimeException("NO_PATIENT_FOUND");
        }
        patientInfo.setPatientID(patient.getPatientId());

        UserEntity user = userRepo.findByUserId(patient.getUserId());
        if (user != null) {
            patientInfo.setFirstName(user.getFirstName());
            patientInfo.setLastName(user.getLastName());
            patientInfo.setSex(user.getGender());
            patientInfo.setDateOfBirth(user.getDateOfBirth());
        }

        PatientCurrentStatus patientStaus = patientCurrentStatusRepo.findByPatientId(patientId);
        if (patientStaus != null) {
            patientInfo.setCovid19Status(patientStaus.getCOVID19Status());
            patientInfo.setQuarantineStatus(patientStaus.getQuarantineStatus());
            patientInfo.setIsolationStatus(patientStaus.getIsolationStatus());
            patientInfo.setQuarantineStartDate(patientStaus.getQuarantineStartDateTime());
            patientInfo.setQuarantineEndDate(patientStaus.getQuarantineEndDateTime());
            patientInfo.setQuarantineRequestStatus(patientStaus.getQuarantineRequestStatus());
            patientInfo.setSuppliesRequestStatus(patientStaus.getSuppliesRequestStatus());
            patientInfo.setGeofenceStatus(patientStaus.getGeofenceStatus());
            patientInfo.setHealthStatusAlert(patientStaus.getHealthStatusAlert());
            patientInfo.setLatitude(patientStaus.getLatitude());
            patientInfo.setLongitude(patientStaus.getLongitude());
        }

        PhoneNumber phoneDetails = phoneNoRepo.findByUserId(patient.getUserId());
        if (phoneDetails != null) {
            patientInfo.setPhoneNumber1(phoneDetails.getPhoneNumber());
            patientInfo.setPhoneNumber1HasInternet(phoneDetails.getHasInternetAccess());
            patientInfo.setPhoneNumber1HasSMS(phoneDetails.getHasSMSAccess());
            patientInfo.setPhoneNumber1HasWhatsapp(phoneDetails.getHasWhatsAppAccess());
            patientInfo.setPhoneNumber1IsPrimaryUser(phoneDetails.getPrimaryUser());
            patientInfo.setPhoneNumber1Type(phoneDetails.getPhoneType());
        }

        UserRequestHistory userReq = userRequestRepo.findByUserId(patient.getUserId());
        if (userReq != null) {
            patientInfo.setHealthRequestStatus(userReq.getRequestStatus());
            patientInfo.setHealthRequestMessage(userReq.getRequestComments());
        }

        AppHeartbeatHistory heartbeat = heartbeatRepo.findByPrimaryUserId(patient.getUserId());
        if (heartbeat != null) {
            patientInfo.setHeartbeatStatus(heartbeat.getHeartBeatStatus());
            patientInfo.setHeartbeatTime(heartbeat.getHeartbeatDateTime());
        }

        Address address = addressRepo.findByUserId(patient.getUserId());
        if (address != null) {
            String adr = address.getAddressLine1().concat(", ".concat(address.getCity().concat(", ").concat(address.getState().concat(", ").concat(address.getCountry()))));
            patientInfo.setQuarantineAddress(adr);
        }
        return patientInfo;
    }

    public PatientLocationDto searchPatients(Long locationId, Long healthProId, String phoneNumber, int size, int from,
                                             String firstName, String lastName, String covid19Status, String quarantineStatus, String isolationStatus,
                                             String quarantineRequestStatus, String medicalRequestStatus, String suppliesRequestStatus,
                                             String geofenceStatus, String heartbeatStatus, String healthStatusAlert) {

        return patientDao.searchPatients(locationId, healthProId, phoneNumber, size, from, firstName, lastName, covid19Status, quarantineStatus, isolationStatus,
                quarantineRequestStatus, medicalRequestStatus, suppliesRequestStatus, geofenceStatus, heartbeatStatus, healthStatusAlert);
    }
}
