package com.covid.service;

import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.covid.dto.*;

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
				.registerStoredProcedureParameter("userName", String.class, ParameterMode.IN)

				.setParameter("title", healthProf.getTitle()).setParameter("firstName", healthProf.getFirstName())				
				.setParameter("lastName", healthProf.getLastName()).setParameter("suffix", healthProf.getSuffix())
				.setParameter("gender", healthProf.getGender()).setParameter("dateOfBirth", healthProf.getDateOfBirth())
				.setParameter("emailAddress", healthProf.getEmailAddress())
				.setParameter("phoneNumber", healthProf.getPhoneNumber())
				.setParameter("healthProType", healthProf.getHealthProType())
				.setParameter("healthProJobTitle", healthProf.getHealthProJobTitle())
				.setParameter("healthProOfficeAddress", healthProf.getHealthProOfficeAddress())
				.setParameter("healthProLocationId", healthProf.getHealthProLocationId())
				.setParameter("supervisorId", healthProf.getSupervisorId())
				.setParameter("userName", healthProf.getUserName());
		query.execute();
		List<Object> result = (List<Object>) query.getResultList();
		if (result.size() != 0) {
			Iterator itr = result.iterator();
			String msg = "";
			while (itr.hasNext()) {
				String obj = (String) itr.next();
				msg = obj;
			}
			return msg;

		} else {
			return "failed";
		}
	}


	public List<HealthProHierarchyDto> getUsrHierarchy(int supervisorID) {		
		List<HealthProHierarchyDto> usrHierarchy = new ArrayList<HealthProHierarchyDto>();

		StoredProcedureQuery query = entityManager.createStoredProcedureQuery("getuserhierarchy")
				.registerStoredProcedureParameter("superid", Integer.class, ParameterMode.IN)
				.setParameter("superid", supervisorID);
		query.execute();
		List list= query.getResultList();	
		Iterator itr = list.iterator();
		
		while (itr.hasNext()) {
			HealthProHierarchyDto lc = new HealthProHierarchyDto();
			Object[] obj = (Object[]) itr.next();
			if (obj[0] != null) {
				lc.sethealthProId(Integer.parseInt(String.valueOf(obj[0])));
			}
			if (obj[1] != null) {
				lc.setTitle(String.valueOf(obj[1]));
			}
			if (obj[2] != null) {
				lc.setFirstName(String.valueOf(obj[2]));
			}
			if (obj[3] != null) {
				lc.setLastName(String.valueOf(obj[3]));
			}
			if (obj[4] != null) {
				lc.setSuffix(String.valueOf(obj[4]));
			}
			if (obj[5] != null) {
				lc.setHealthProType(String.valueOf(obj[5]));
			}
			if (obj[6] != null) {
				lc.setHealthProJobTitle(String.valueOf(obj[6]));
			}
			if (obj[7] != null) {
				lc.setHealthProOfficeAddress(String.valueOf(obj[7]));
			}
			if (obj[8] != null) {
				lc.setHealthProLocationId(Integer.parseInt(String.valueOf(obj[8])));
			}
			if (obj[9] != null) {
				lc.setSupervisorId(Integer.parseInt(String.valueOf(obj[9])));
			}
			usrHierarchy.add(lc);
		}
		
		return usrHierarchy;		
	}
}
