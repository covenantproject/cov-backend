package org.covn.service;

import static org.covn.util.CovidUtils.cast;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import org.covn.dto.HomeDetailsDto;
import org.covn.model.db.Patient;
import org.covn.model.meta.Patient_;
import org.covn.repository.EntityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HomeDetailsService {

	
    @Autowired
    private EntityRepo repo;
    
    @Autowired
    private EntityManager entityManager;

    public HomeDetailsDto getHomeDetailsById(int userId) {
        HomeDetailsDto homeDetails = new HomeDetailsDto();
        Patient patient = repo.findOne(repo.get(Patient.class).add(Patient_.patientId, userId));
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
