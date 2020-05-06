package com.covid.service;

import com.covid.dto.PatientLocationDto;
import com.covid.repository.PatientDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.covid.dto.PatientInfoDto;
import com.covid.repository.AppHeartbeatHistoryRepo;
import com.covid.repository.PatientCurrentStatusRepo;
import com.covid.repository.PhoneNumberRepo;
import com.covid.repository.UserRepo;
import com.covid.repository.UserRequestHistoryRepo;

import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

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

    //@Autowired
    //AddressRepo addressRepo;

    @Autowired
    UserRequestHistoryRepo userRequestRepo;

    @Autowired
    AppHeartbeatHistoryRepo heartbeatRepo;

    @Autowired
    PatientDao patientDao;

    public PatientInfoDto getPatientInfoByUserId(long userId) {
		StoredProcedureQuery query = entityManager.createStoredProcedureQuery("getpatientinfo")
				.registerStoredProcedureParameter("userid", Long.class, ParameterMode.IN)
				.setParameter("userid", userId);
		query.execute();
		List list= query.getResultList();	
		Iterator itr = list.iterator();
		PatientInfoDto patientInfo = new PatientInfoDto();
		while (itr.hasNext()) {
			Object[] obj = (Object[]) itr.next();
			if (obj[0] != null) {
				patientInfo.setPatientID(Integer.parseInt(String.valueOf(obj[0])));
			}
			if (obj[1] != null) {
				patientInfo.setFirstName(String.valueOf(obj[1]));
			}
			if (obj[2] != null) {
				patientInfo.setLastName(String.valueOf(obj[2]));
			}
			if (obj[3] != null) {
				patientInfo.setHouseholdId(String.valueOf(obj[3]));
			}
			if (obj[4] != null) {
				patientInfo.setCovid19Status(String.valueOf(obj[4]));
			}
			if (obj[5] != null) {
				patientInfo.setQuarantineStatus(String.valueOf(obj[5]));
            }
            if (obj[6] != null) {
				patientInfo.setIsolationStatus(String.valueOf(obj[6]));
            }
            if (obj[7] != null) {
				patientInfo.setHealthRequestStatus(String.valueOf(obj[7]));
            }
            if (obj[8] != null) {
				patientInfo.setHealthRequestMessage(String.valueOf(obj[8]));
            }
            if (obj[9] != null) {
				patientInfo.setQuarantineRequestStatus(String.valueOf(obj[9]));
            }
            if (obj[10] != null) {
				patientInfo.setSuppliesRequestStatus(String.valueOf(obj[10]));
            }
            if (obj[11] != null) {
				patientInfo.setSuppliesRequestMessage(String.valueOf(obj[11]));
            }
            if (obj[12] != null) {
				patientInfo.setHealthAlert(String.valueOf(obj[12]));
            }
            if (obj[13] != null) {
				patientInfo.setGeofenceStatus(String.valueOf(obj[13]));
            }
            if (obj[14] != null) {
				patientInfo.setHeartbeatStatus(String.valueOf(obj[14]));
            }
            if (obj[15] != null) {
                String dateTimeString = String.valueOf(obj[15]);
				dateTimeString = dateTimeString.replace(' ', 'T');
				String parsedDateTime = dateTimeString.split("\\.", 2)[0]+".000+0000";
				patientInfo.setHeartbeatTime(parsedDateTime);
            }
            if (obj[16] != null) {
				patientInfo.setLatitude(Double.parseDouble(String.valueOf(obj[16])));
            }
            if (obj[17] != null) {
				patientInfo.setLongitude(Double.parseDouble(String.valueOf(obj[17])));
            }
            if (obj[18] != null) {
                String dateTimeString = String.valueOf(obj[18]);
				dateTimeString = dateTimeString.replace(' ', 'T');
				String parsedDateTime = dateTimeString.split("\\.", 2)[0]+".000+0000";
				patientInfo.setQuarantineStartDate(parsedDateTime);
            }
            if (obj[19] != null) {
                String dateTimeString = String.valueOf(obj[19]);
				dateTimeString = dateTimeString.replace(' ', 'T');
				String parsedDateTime = dateTimeString.split("\\.", 2)[0]+".000+0000";
				patientInfo.setQuarantineEndDate(parsedDateTime);
            }
            if (obj[20] != null) {
				patientInfo.setSex(String.valueOf(obj[20]));
            }
            if (obj[21] != null) {
                String dateTimeString = String.valueOf(obj[21]);
				dateTimeString = dateTimeString.replace(' ', 'T');
				String parsedDateTime = dateTimeString.split("\\.", 2)[0]+".000+0000";
				patientInfo.setDateOfBirth(parsedDateTime);
            }
            if (obj[22] != null) {
				patientInfo.setPhoneNumber1(String.valueOf(obj[22]));
            }
            if (obj[23] != null) {
				patientInfo.setPhoneNumber1Type(String.valueOf(obj[23]));
            }
            if (obj[24] != null) {
				patientInfo.setPhoneNumber1HasSMS(Boolean.parseBoolean(String.valueOf(obj[24])));
            }
            if (obj[25] != null) {
				patientInfo.setPhoneNumber1HasInternet(Boolean.parseBoolean(String.valueOf(obj[25])));
            }
            if (obj[26] != null) {
				patientInfo.setPhoneNumber1HasWhatsapp(Boolean.parseBoolean(String.valueOf(obj[26])));
            }
            if (obj[27] != null) {
				patientInfo.setPhoneNumber1IsPrimaryUser(Boolean.parseBoolean(String.valueOf(obj[27])));
            }
            if (obj[28] != null) {
				patientInfo.setQuarantineAddress(String.valueOf(obj[28]));
			}
		}
        
        return patientInfo;
	}    

    public PatientLocationDto searchPatients(Long locationId, Long healthProId, String phoneNumber, int size, int from,
            String firstName, String lastName, String covid19Status, String quarantineStatus, String isolationStatus,
            String quarantineRequestStatus, String medicalRequestStatus, String suppliesRequestStatus,
            String geofenceCompliant, String geofenceStatus, String heartbeatStatus, String healthStatusAlert) {

        return patientDao.searchPatients(locationId, healthProId, phoneNumber, size, from, firstName, lastName,
                covid19Status, quarantineStatus, isolationStatus, quarantineRequestStatus, medicalRequestStatus,
                suppliesRequestStatus, geofenceCompliant, geofenceStatus, heartbeatStatus, healthStatusAlert);
    }
}
