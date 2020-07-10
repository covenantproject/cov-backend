package org.covn.service;

import static org.covn.util.CovidUtils.cast;

import java.util.Iterator;
import java.util.List;

import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import org.covn.model.db.PatientRequestHistory;
import org.covn.repository.EntityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;



@RequestScope
@Component
public class UserRequestHistoryService {
	
	@Autowired
	private EntityRepo repo;
	
	public String updateUserRequest(PatientRequestHistory patientRequest) {
		

		List<Object> result = repo.execStoredProcedureQuery((entityManager) -> {
			StoredProcedureQuery query = entityManager.createStoredProcedureQuery("raiseyourhand")
					.registerStoredProcedureParameter("userid", Integer.class, ParameterMode.IN)
					.registerStoredProcedureParameter("reqtype", String.class, ParameterMode.IN)
					.registerStoredProcedureParameter("reqstatus", String.class, ParameterMode.IN)
					.registerStoredProcedureParameter("comments", String.class, ParameterMode.IN)
					.setParameter("userid", patientRequest.getPatientId()).setParameter("reqtype", patientRequest.getRequestType())
					.setParameter("reqstatus", patientRequest.getRequestStatus()).setParameter("comments", patientRequest.getRequestComments());
			query.execute();
			return cast(query.getResultList());
		});
		if (result.size() != 0) {
			Iterator<Object> itr = result.iterator();
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
