package com.covid.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
