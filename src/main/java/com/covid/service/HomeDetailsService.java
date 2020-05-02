package com.covid.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.covid.dto.HomeDetailsDto;
import com.covid.model.Patient;
import com.covid.repository.LocationHistoryRepo;
import com.covid.repository.PatientRepo;
import com.covid.repository.UserRepo;

@Service
public class HomeDetailsService {

	
    @Autowired
    LocationHistoryRepo locationHistoryRepo;

    @Autowired
    PatientRepo patientRepo;

    @Autowired
    UserRepo userRepo;
    
    @Autowired
    private EntityManager entityManager;

    public HomeDetailsDto getHomeDetailsById(long userId) {
        HomeDetailsDto homeDetails = new HomeDetailsDto();
//		UserEntity user=userRepo.findByUserId(userId);
        Patient patient = patientRepo.findByUserId(userId);
        if (patient == null) {
            throw new RuntimeException("NO_DETAILS_FOUND");
        }
        LocationHistory status = locationHistoryRepo.findByUserId(patient.getPatientId());
        if (status != null) {
            homeDetails.setCurrentlatitude(status.getLatitude());
            homeDetails.setCurrentlongitutude(status.getLongitude());
        }
        return homeDetails;

    }
    public List<Object> getHomeDetailById(int userId) {
		StoredProcedureQuery query = entityManager.createStoredProcedureQuery("homedetails")
				.registerStoredProcedureParameter("userid", Integer.class, ParameterMode.IN)
				.setParameter("userid", userId);
		query.execute();
		List<Object> result = (List<Object>) query.getResultList();
		if (result.size() != 0) {
			return result;
		} else {
			return null;
		}

	}
    

}
