package org.covn.service;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import org.covn.dto.HealthProfessionalDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HealthProfessionalService {
	
	@Autowired
	private EntityManager entityManager;

	public String saveHealthPro(HealthProfessionalDto healthProf) {
		StoredProcedureQuery query = entityManager.createStoredProcedureQuery("registerNewHealthPro")
				.registerStoredProcedureParameter("title", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("firstName", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("lastName", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("suffix", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("gender", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("dateOfBirth", Date.class, ParameterMode.IN)
				.registerStoredProcedureParameter("emailAddress", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("phoneNumber", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("healthProType", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("healthProJobTitle", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("healthProOfficeAddress", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("healthProLocationId", Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter("supervisorId", Integer.class, ParameterMode.IN)
				
				.setParameter("title", healthProf.getTitle()).setParameter("firstName", healthProf.getFirstName())
				.setParameter("lastName", healthProf.getLastName()).setParameter("suffix", healthProf.getSuffix())
				.setParameter("gender", healthProf.getGender()).setParameter("dateOfBirth", healthProf.getDateOfBirth())
				.setParameter("emailAddress", healthProf.getEmailAddress()).setParameter("phoneNumber", healthProf.getPhoneNumber())
				.setParameter("healthProType", healthProf.getHealthProType()).setParameter("healthProJobTitle", healthProf.getHealthProJobTitle())
				.setParameter("healthProOfficeAddress", healthProf.getHealthProOfficeAddress()).setParameter("healthProLocationId", healthProf.getHealthProLocationId())
				.setParameter("supervisorId", healthProf.getSupervisorId());
		query.execute();
		List<Object> result = (List<Object>) query.getResultList();
		if (result.size() != 0) {
			Iterator itr = result.iterator();
			String msg="";
			while (itr.hasNext()) {
				String obj = (String) itr.next();
				msg=obj;
			}
			return msg;
			
		} else {
			return "failed";
		}
	}

}
