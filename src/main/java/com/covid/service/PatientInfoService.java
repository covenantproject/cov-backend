package com.covid.service;

import static com.covid.util.CovidUtils.cast;

import java.util.Arrays;

import org.apache.commons.lang3.tuple.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.covid.dto.PatientInfoDto;
import com.covid.dto.PatientLocationDto;
import com.covid.model.db.Address;
import com.covid.model.db.AppHeartbeat;
import com.covid.model.db.Patient;
import com.covid.model.db.PatientRequestHistory;
import com.covid.model.db.PatientStatus;
import com.covid.model.db.PhoneNumber;
import com.covid.model.db.Users;
import com.covid.model.meta.Address_;
import com.covid.model.meta.PatientRequestHistory_;
import com.covid.model.meta.PatientStatus_;
import com.covid.model.meta.PhoneNumber_;
import com.covid.model.meta.Users_;
import com.covid.repository.EntityRepo;
import com.covid.repository.PatientDao;

@Service
public class PatientInfoService {

    @Autowired
    private EntityRepo repo;

    @Autowired
    private PatientDao patientDao;

    public PatientInfoDto getPatientForLocation(int patientId) {
        PatientInfoDto patientInfo = new PatientInfoDto();

        Patient patient = repo.findByPrimaryKey(Patient.class, patientId);
        if (patient == null) {
            throw new RuntimeException("NO_PATIENT_FOUND");
        }
        patientInfo.setPatientID(patient.getPatientId());

        Users user = repo.findOne(repo.get(Users.class).add(Users_.userId, patient.getPatientId()));
        if (user != null) {
            patientInfo.setFirstName(user.getFirstName());
            patientInfo.setLastName(user.getLastName());
            patientInfo.setSex(user.getAdminGender());
            patientInfo.setDateOfBirth(user.getDateOfBirth());
        }

        PatientStatus patientStaus = repo.findOne(repo.get(PatientStatus.class).add(PatientStatus_.patientId, patientId));
        if (patientStaus != null) {
            patientInfo.setCovid19Status(patientStaus.getCovid19Status());
            patientInfo.setQuarantineStatus(patientStaus.getQuarIsltStatus());
            patientInfo.setQuarantineStartDate(patientStaus.getQuarIsltStartDateTime());
            patientInfo.setQuarantineEndDate(patientStaus.getQuarIsltEndDateTime());
            patientInfo.setQuarantineRequestStatus(patientStaus.getQuarIsltRequestStatus());
            patientInfo.setSuppliesRequestStatus(patientStaus.getSuppliesRequestStatus());
            patientInfo.setGeofenceStatus(patientStaus.getGeofenceStatus());
            patientInfo.setHealthStatusAlert(patientStaus.getHealthStatus());
            patientInfo.setLatitude(patientStaus.getLatitude());
            patientInfo.setLongitude(patientStaus.getLongitude());
        }

        PhoneNumber phoneDetails = repo.findOne(repo.get(PhoneNumber.class)
   				.add(PhoneNumber_.userId, patientId)
   				.add(PhoneNumber_.isPreferred, Boolean.TRUE)
        );
        if (phoneDetails != null) {
            patientInfo.setPhoneNumber1(phoneDetails.getPhoneNumber());
            patientInfo.setPhoneNumber1HasInternet(phoneDetails.getHasInternet());
            patientInfo.setPhoneNumber1HasSMS(phoneDetails.getHasSms());
            patientInfo.setPhoneNumber1HasWhatsapp(phoneDetails.getHasWhatsapp());
            patientInfo.setPhoneNumber1IsPrimaryUser(phoneDetails.getIsPrimaryUser());
            patientInfo.setPhoneNumber1Type(phoneDetails.getPhoneType());
        }

        PatientRequestHistory prHistory = repo.findOne(repo.get(PatientRequestHistory.class).add(PatientRequestHistory_.patientId, patientId));
        if (prHistory != null) {
            patientInfo.setHealthRequestStatus(prHistory.getRequestStatus());
            patientInfo.setHealthRequestMessage(prHistory.getRequestComments());
        }

        AppHeartbeat heartbeat = null;//TODO get the AppHeartbeat by userId
        if (heartbeat != null) {
            patientInfo.setHeartbeatStatus(heartbeat.getHeartbeatStatus());
            patientInfo.setHeartbeatTime(heartbeat.getHeartbeatDateTime());
        }

        Address address = repo.findOne(repo.get(Address.class)
       				.add(Address_.userId, patientId)
       				.add(Address_.addressType, "") //TODO
        );
        
        if (address != null) {
            String adr = address.getAddressLine1().concat(", ".concat(address.getCity().concat(", ").concat(address.getStateTerritory().concat(", ").concat(address.getCountry()))));
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
