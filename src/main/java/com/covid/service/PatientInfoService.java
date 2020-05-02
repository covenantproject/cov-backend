package com.covid.service;

import static com.covid.util.CovidUtils.cast;

import java.util.Arrays;

import org.apache.commons.lang3.tuple.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.covid.dto.PatientInfoDto;
import com.covid.dto.PatientLocationDto;
import com.covid.model.Address;
import com.covid.model.Address_;
import com.covid.model.AppHeartbeat;
import com.covid.model.Patient;
import com.covid.model.PatientRequestHistory;
import com.covid.model.PatientRequestHistory_;
import com.covid.model.PatientStatus;
import com.covid.model.PatientStatus_;
import com.covid.model.PhoneNumber;
import com.covid.model.PhoneNumber_;
import com.covid.model.Users;
import com.covid.model.Users_;
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

        Users user = repo.findOne(Users.class, Pair.of(Users_.userId, patient.getPatientId()));
        if (user != null) {
            patientInfo.setFirstName(user.getFirstName());
            patientInfo.setLastName(user.getLastName());
            patientInfo.setSex(user.getAdminGender());
            patientInfo.setDateOfBirth(user.getDateOfBirth());
        }

        PatientStatus patientStaus = repo.findOne(PatientStatus.class, Pair.of(PatientStatus_.patientId, patientId));
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

        PhoneNumber phoneDetails = repo.findOne(PhoneNumber.class,
        		Arrays.asList(
        				cast(Pair.of(PhoneNumber_.userId, patientId))
        				,cast(Pair.of(PhoneNumber_.isPreferred, Boolean.TRUE))
        		)
        );
        if (phoneDetails != null) {
            patientInfo.setPhoneNumber1(phoneDetails.getPhoneNumber());
            patientInfo.setPhoneNumber1HasInternet(phoneDetails.getHasInternetAccess());
            patientInfo.setPhoneNumber1HasSMS(phoneDetails.getHasSmsaccess());
            patientInfo.setPhoneNumber1HasWhatsapp(phoneDetails.getHasWhatsappAccess());
            patientInfo.setPhoneNumber1IsPrimaryUser(phoneDetails.getIsPrimaryUser());
            patientInfo.setPhoneNumber1Type(phoneDetails.getPhoneType());
        }

        PatientRequestHistory prHistory = repo.findOne(PatientRequestHistory.class, Pair.of(PatientRequestHistory_.patientId, patientId));
        if (prHistory != null) {
            patientInfo.setHealthRequestStatus(prHistory.getRequestStatus());
            patientInfo.setHealthRequestMessage(prHistory.getRequestComments());
        }

        AppHeartbeat heartbeat = null;//TODO get the AppHeartbeat by userId
        if (heartbeat != null) {
            patientInfo.setHeartbeatStatus(heartbeat.getHeartbeatStatus());
            patientInfo.setHeartbeatTime(heartbeat.getHeartbeatDateTime());
        }

        Address address = repo.findOne(Address.class,
        		Arrays.asList(
        				cast(Pair.of(Address_.userId, patientId))
        				,cast(Pair.of(Address_.addressType, "")) //TODO
        		)
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
