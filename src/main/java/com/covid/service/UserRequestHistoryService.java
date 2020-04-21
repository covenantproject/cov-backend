package com.covid.service;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.covid.model.HealthHistory;
import com.covid.model.UserRequestHistory;
import com.covid.repository.UserRequestHistoryRepo;



@Service
public class UserRequestHistoryService {
	
	@Autowired
	UserRequestHistoryRepo userRequestRepo;
	
	@Autowired
	private EntityManager entityManager;
	
	public String updateUserRequest(UserRequestHistory userRequest) {
		StoredProcedureQuery query = entityManager.createStoredProcedureQuery("raiseyourhand")
				.registerStoredProcedureParameter("userid", Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter("reqtype", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("reqstatus", String.class, ParameterMode.IN)
				.registerStoredProcedureParameter("comments", String.class, ParameterMode.IN)
				.setParameter("userid", userRequest.getUserId()).setParameter("reqtype", userRequest.getRequestType())
				.setParameter("reqstatus", userRequest.getRequestStatus()).setParameter("comments", userRequest.getRequestComments());
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
