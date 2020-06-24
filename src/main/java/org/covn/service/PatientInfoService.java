package org.covn.service;

import static org.covn.util.CovidUtils.cast;

import java.util.Arrays;

import org.apache.commons.lang3.tuple.Pair;
import org.covn.dto.PatientInfoDto;
import org.covn.dto.PatientSearchResultsDto;
import org.covn.model.db.Address;
import org.covn.model.db.AppHeartbeat;
import org.covn.model.db.Patient;
import org.covn.model.db.PatientRequestHistory;
import org.covn.model.db.PatientStatus;
import org.covn.model.db.PhoneNumber;
import org.covn.model.db.Users;
import org.covn.model.meta.Address_;
import org.covn.model.meta.PatientRequestHistory_;
import org.covn.model.meta.PatientStatus_;
import org.covn.model.meta.PhoneNumber_;
import org.covn.model.meta.Users_;
import org.covn.repository.EntityRepo;
import org.covn.repository.PatientDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
            //patientInfo.setFirstName(user.getFirstName());
            //patientInfo.setLastName(user.getLastName());
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

    public PatientSearchResultsDto searchPatients(Long locationId, Long healthProId, String phoneNumber, int size, int from,
                                             String firstName, String lastName, String covid19Status, String quarantineStatus, String isolationStatus,
                                             String quarantineRequestStatus, String medicalRequestStatus, String suppliesRequestStatus,
                                             String geofenceStatus, String heartbeatStatus, String healthStatusAlert) {

        return patientDao.searchPatients(locationId, healthProId, phoneNumber, size, from, firstName, lastName, covid19Status, quarantineStatus, isolationStatus,
                quarantineRequestStatus, medicalRequestStatus, suppliesRequestStatus, geofenceStatus, heartbeatStatus, healthStatusAlert);
    }
}
