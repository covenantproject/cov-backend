package org.covn.service;

import org.covn.dto.UserDto;
import org.covn.vo.AddressEntity;
import org.covn.vo.PhoneNumberEntity;
import org.covn.vo.PhotoEntity;
import org.covn.vo.Register;
import org.covn.vo.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityManager;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * @author Senthil N
 **/
@Component
public class PatientService {

	/*
	 * PatinetService should both register Patients and retrieve their information
	 * 
	 */

	private void registerNewPatient (PatientDto patientDto) {
		// use UserService to register the new User
		// and then save patient-specific information in the Patient table
		// change return value to a status code or the patient_id rather than void
	}
	
	private PatientDto getPatientInfo (int patient_id) {
		return null;
	}
	
	private void savePatientInfo (PatientDto patientDto) {
		// change return value to a status code or the patient_id rather than void
	}
	
	
}
