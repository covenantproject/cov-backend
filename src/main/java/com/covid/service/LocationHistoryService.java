package com.covid.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import com.covid.model.LocationHistory;
import com.covid.repository.LocationHistoryRepo;

@Service
public class LocationHistoryService {

	@Autowired
	LocationHistoryRepo locationHistoryRepo;

	@Autowired
	private EntityManager entityManager;

	public String saveLocationHistory(LocationHistory locationHistory) {
		StoredProcedureQuery query = entityManager.createStoredProcedureQuery("saveLocationHistory")
				.registerStoredProcedureParameter("userId", Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter("Latitude", Double.class, ParameterMode.IN)
				.registerStoredProcedureParameter("Longitude", Double.class, ParameterMode.IN)
				.registerStoredProcedureParameter("Code", String.class, ParameterMode.IN)

				.setParameter("userId", locationHistory.getUserId())
				.setParameter("Latitude", locationHistory.getLatitude())
				.setParameter("Longitude", locationHistory.getLongitude())
				.setParameter("Code", locationHistory.getCode());

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

	public LocationHistory postLocationHistory(LocationHistory locationHistory) {
		return locationHistoryRepo.save(locationHistory);
	}

}
