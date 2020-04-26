package com.covid.service;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.covid.dto.HealthInfoDto;

@Service
public class HealthInfoService {

	@Autowired
	private EntityManager entityManager;
	
	public String updateHealthInfo(HealthInfoDto userRequest) {
		StoredProcedureQuery query = entityManager.createStoredProcedureQuery("updatehealth")
				.registerStoredProcedureParameter("userid", Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter("coughpresent", Boolean.class, ParameterMode.IN)
				.registerStoredProcedureParameter("feverpresent", Boolean.class, ParameterMode.IN)
				.registerStoredProcedureParameter("breathingdifficultypresent", Boolean.class, ParameterMode.IN)
				.registerStoredProcedureParameter("progressstatus", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("temperature", Double.class, ParameterMode.IN)
				.registerStoredProcedureParameter("heartrate", Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter("respiratoryrate", Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter("spo2", Integer.class, ParameterMode.IN)
				.setParameter("userid", userRequest.getUserid()).setParameter("coughpresent", userRequest.isCoughpresent())
				.setParameter("feverpresent", userRequest.isFeverpresent()).setParameter("breathingdifficultypresent", userRequest.isBreathingdifficultypresent())
				.setParameter("progressstatus", userRequest.getProgressstatus()).setParameter("temperature", userRequest.getTemperature())
				.setParameter("heartrate", userRequest.getHeartrate()).setParameter("respiratoryrate", userRequest.getRespiratoryrate()).setParameter("spo2", userRequest.getSpo2());
		query.execute();
		List<Object> result = query.getResultList();
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
