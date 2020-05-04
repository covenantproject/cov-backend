package com.covid.service;

import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.covid.dto.*;

@Service
public class HistoryService {

	@Autowired
	private EntityManager entityManager;

	public List<HistoryDto> getAllHistory(int userId) {
		List<HistoryDto> historyList = new ArrayList<HistoryDto>();

		StoredProcedureQuery query = entityManager.createStoredProcedureQuery("getallhistory")
				.registerStoredProcedureParameter("userid", Integer.class, ParameterMode.IN)
				.setParameter("userid", userId);
		query.execute();
		List list = query.getResultList();
		Iterator itr = list.iterator();

		while (itr.hasNext()) {
			HistoryDto lc = new HistoryDto();
			Object[] obj = (Object[]) itr.next();
			if (obj[0] != null) {
				lc.setIshealthupdated(Boolean.parseBoolean(String.valueOf(obj[0])));
			}
			if (obj[1] != null) {
				lc.setIshelpupdated(Boolean.parseBoolean(String.valueOf(obj[1])));
			}
			if (obj[2] != null) {
				lc.setHascough(Boolean.parseBoolean(String.valueOf(obj[2])));
			}
			if (obj[3] != null) {
				lc.setHasfever(Boolean.parseBoolean(String.valueOf(obj[3])));
			}
			if (obj[4] != null) {
				lc.setHaschills(Boolean.parseBoolean(String.valueOf(obj[4])));
			}
			if (obj[5] != null) {
				lc.setHasbreathingissue(Boolean.parseBoolean(String.valueOf(obj[5])));
			}
			if (obj[6] != null) {
				lc.setCurrenthealthstatus(String.valueOf(obj[6]));
			}
			if (obj[7] != null) {
				lc.setTemperature(String.valueOf(obj[7]));
			}
			if (obj[8] != null) {
				lc.setHeartrate(String.valueOf(obj[8]));
			}
			if (obj[9] != null) {
				lc.setRespiratoryrate(String.valueOf(obj[9]));
			}
			if (obj[10] != null) {
				lc.setSpo2(String.valueOf(obj[10]));
			}
			if (obj[11] != null) {
				lc.setRequesttype(String.valueOf(obj[11]));
			}
			if (obj[12] != null) {
				lc.setComments(String.valueOf(obj[12]));
			}
			if (obj[13] != null) {
				lc.setTimestamp(String.valueOf(obj[13]));
			}
			historyList.add(lc);
		}

		return historyList;
	}
}
