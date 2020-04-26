package com.covid.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.covid.dto.GeofenceDto;
import com.covid.model.GeofenceLocation;

@Service
public class GeofenceService {

	@Autowired
	private EntityManager entityManager;

	public String updateGeofence(GeofenceDto geofenceDto) {
		StoredProcedureQuery query = entityManager.createStoredProcedureQuery("updategeofencelocation")
				.registerStoredProcedureParameter("patientId", Integer.class, ParameterMode.IN)
				.registerStoredProcedureParameter("geofenceLattitude", Double.class, ParameterMode.IN)
				.registerStoredProcedureParameter("geofenceLongitude", Double.class, ParameterMode.IN)
				.registerStoredProcedureParameter("geofenceRadiusMetres", Double.class, ParameterMode.IN)
				.registerStoredProcedureParameter("geofenceStartDate", Date.class, ParameterMode.IN)
				.registerStoredProcedureParameter("geofenceEndDate", Date.class, ParameterMode.IN)
				.setParameter("patientId", geofenceDto.getPatientId())
				.setParameter("geofenceLattitude", geofenceDto.getLatitude())
				.setParameter("geofenceLongitude", geofenceDto.getLongitude())
				.setParameter("geofenceRadiusMetres", geofenceDto.getRadius())
				.setParameter("geofenceStartDate", geofenceDto.getStartDate())
				.setParameter("geofenceEndDate", geofenceDto.getEndDate());

		query.execute();
		List<Object> result = query.getResultList();
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

	public List<GeofenceLocation> getGeofence(int patientId) throws ParseException {
	
		List<GeofenceLocation> geoFenceList = new ArrayList<GeofenceLocation>();

		StoredProcedureQuery query = entityManager.createStoredProcedureQuery("getGeofenceLocation")
				.registerStoredProcedureParameter("patientId", Integer.class, ParameterMode.IN)
				.setParameter("patientId", patientId);
		query.execute();
		List<Object> list= query.getResultList();	
		Iterator<Object> itr = list.iterator();
		GeofenceLocation gf=new GeofenceLocation();
		while (itr.hasNext()) {
			Object[] obj = (Object[]) itr.next();
			if (obj[0] != null) {
				gf.setPatientId(Integer.parseInt(String.valueOf(obj[1])));
			}
			if (obj[1] != null) {
				gf.setGeofenceLocationId(Integer.parseInt(String.valueOf(obj[0])));
			}
			if (obj[2] != null) {
				gf.setGeoFenceLatitude(Double.parseDouble(String.valueOf(obj[2])));
			}
			if (obj[3] != null) {
				gf.setGeoFenceLongitude(Double.parseDouble(String.valueOf(obj[3])));
			}
			if (obj[4] != null) {
				gf.setGeoFenceRadiusMetres(Double.parseDouble(String.valueOf(obj[4])));
			}
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			if (obj[5] != null) {
				 Date dt=dateFormat.parse(String.valueOf(obj[5]));
				 gf.setGeoFenceStartDate(dt);
			}
			if (obj[6] != null) {
				Date dt=dateFormat.parse(String.valueOf(obj[6]));
				gf.setGeoFenceEndDate(dt);
			}
			geoFenceList.add(gf);
		}
		
		return geoFenceList;
	}

}
