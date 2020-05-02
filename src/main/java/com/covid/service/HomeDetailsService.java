package com.covid.service;

import static com.covid.util.CovidUtils.cast;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import org.apache.commons.lang3.tuple.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.covid.dto.HomeDetailsDto;
import com.covid.model.Patient;
import com.covid.model.Patient_;
import com.covid.repository.EntityRepo;

@Service
public class HomeDetailsService {

	
    @Autowired
    private EntityRepo repo;
    
    @Autowired
    private EntityManager entityManager;

    public HomeDetailsDto getHomeDetailsById(int userId) {
        HomeDetailsDto homeDetails = new HomeDetailsDto();
        Patient patient = repo.findOne(Patient.class, Pair.of(Patient_.patientId, userId));
        if (patient == null) {
            throw new RuntimeException("NO_DETAILS_FOUND");
        }

        //TODO find current user location and populated in homeDetails
        return homeDetails;

    }
    public List<Object> getHomeDetailById(int userId) {
		StoredProcedureQuery query = entityManager.createStoredProcedureQuery("homedetails")
				.registerStoredProcedureParameter("userid", Integer.class, ParameterMode.IN)
				.setParameter("userid", userId);
		query.execute();
		List<Object> result = cast(query.getResultList());
		if (result.size() != 0) {
			return result;
		} else {
			return null;
		}

	}
    

}
