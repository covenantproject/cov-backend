package org.covn.service;

import static org.covn.util.CovidUtils.cast;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import org.covn.dto.PatientGeofencedLocationDto;
import org.covn.model.db.PatientGeofencedLocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@RequestScope
@Component
public class GeofenceService {

	@Autowired
	private EntityManager entityManager;

	public String updateGeofence(PatientGeofencedLocationDto geofenceDto) {
		StoredProcedureQuery query = entityManager.createStoredProcedureQuery("updategeofencelocation")
				.registerStoredProcedureParameter("patientId", Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter("geofenceLattitude", Double.class, ParameterMode.IN)
				.registerStoredProcedureParameter("geofenceLongitude", Double.class, ParameterMode.IN)
				.registerStoredProcedureParameter("geofenceRadiusMetres", Double.class, ParameterMode.IN)
				.setParameter("patientId", geofenceDto.getPatGeofenceLoc().getPatientId())
				.setParameter("geofenceLattitude", geofenceDto.getPatGeofenceLoc().getLatitude())
				.setParameter("geofenceLongitude", geofenceDto.getPatGeofenceLoc().getLongitude())
				.setParameter("geofenceRadiusMetres", geofenceDto.getPatGeofenceLoc().getRadiusMetres());


		query.execute();
		List<Object> result = cast(query.getResultList());
		if (result.size() != 0) {
			Iterator<Object> itr = result.iterator();
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

	public List<PatientGeofencedLocation> getGeofence(int patientId) throws ParseException {
	
		List<PatientGeofencedLocation> geoFenceList = new ArrayList<PatientGeofencedLocation>();

		StoredProcedureQuery query = entityManager.createStoredProcedureQuery("getGeofenceLocation")
				.registerStoredProcedureParameter("patientId", Integer.class, ParameterMode.IN)
				.setParameter("patientId", patientId);
		query.execute();
		List<Object[]> list= cast(query.getResultList());	
		
		for(Object[] obj: list) {
			PatientGeofencedLocation gf=new PatientGeofencedLocation();
			if (obj[0] != null) {
				gf.setPatientId(Integer.parseInt(String.valueOf(obj[1])));
			}
			if (obj[1] != null) {
				gf.setGeofencedLocationId(Integer.parseInt(String.valueOf(obj[0])));
			}
			if (obj[2] != null) {
				gf.setLatitude(new BigDecimal(String.valueOf(obj[2])));
			}
			if (obj[3] != null) {
				gf.setLongitude(new BigDecimal(String.valueOf(obj[3])));
			}
			if (obj[4] != null) {
				gf.setRadiusMetres(Double.parseDouble(String.valueOf(obj[4])));
			}
			geoFenceList.add(gf);
		}
		
		return geoFenceList;
	}

}
