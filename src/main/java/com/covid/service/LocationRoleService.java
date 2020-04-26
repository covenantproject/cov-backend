package com.covid.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.covid.dto.LocationAndRoleDto;
import com.covid.model.HealthProfessional;
import com.covid.model.Location;
import com.covid.model.Role;
import com.covid.model.UserLocation;
import com.covid.repository.HealthProfessionalRepo;
import com.covid.repository.LocationRepo;
import com.covid.repository.PatientRepo;
import com.covid.repository.RoleRepo;
import com.covid.repository.UserLocationRepo;

@Service
public class LocationRoleService {
	
	@Autowired
	UserLocationRepo userLocationRepo;
	
	@Autowired
	RoleRepo roleRepo;
	
	@Autowired
	LocationRepo locationRepo;

	@Autowired
	HealthProfessionalRepo healthProRepo;
	
	@Autowired
	PatientRepo patientRepo;
	
	 @Autowired
	  private EntityManager entityManager;
	
	
	public List<LocationAndRoleDto> getLocationAndRoles(long userId) {	

		List<LocationAndRoleDto> locationRolesList=new ArrayList<LocationAndRoleDto>();
		
		List<UserLocation> userLoc=userLocationRepo.findAllByUserId(userId);
		for (int i = 0; i < userLoc.size(); i++) {
			LocationAndRoleDto locationRoles=new LocationAndRoleDto();
			Role roles=roleRepo.findByRoleId(userLoc.get(i).getRoleId());
			locationRoles.setUserRole(roles.getRoleName());
			Location location= locationRepo.findByLocationId(userLoc.get(i).getLocationId());
			locationRoles.setLocationId(location.getLocationId());
			locationRoles.setLocationName(location.getLocationName());
			locationRoles.setParentLocationId(location.getParentLocationId());
			
			healthProRepo.findByUserId(userId);
			//long patientCount=patientRepo.findByHealthProfessionalIdCount(healthProfid.getHealthProfessionalId());
			//locationRoles.setAssignPatients(patientCount);
			locationRolesList.add(locationRoles);
		}
		
		return locationRolesList;
	}


	public List<LocationAndRoleDto> getLocationAndRole(int userId) {
		
		List<LocationAndRoleDto> locRoles = new ArrayList<LocationAndRoleDto>();
		StoredProcedureQuery query = entityManager.createStoredProcedureQuery("getLocationsAndRolesForUser")
				.registerStoredProcedureParameter("userId", Integer.class, ParameterMode.IN)
				.setParameter("userId", userId);
		query.execute();
		List list= query.getResultList();	
		Iterator itr = list.iterator();
		LocationAndRoleDto lc=new LocationAndRoleDto();
		while (itr.hasNext()) {
			Object[] obj = (Object[]) itr.next();
			if (obj[0] != null) {
				lc.setLocationId(Integer.parseInt(String.valueOf(obj[0])));
			}
			if (obj[1] != null) {
				lc.setLocationName(String.valueOf(obj[1]));
			}
			if (obj[2] != null) {
				lc.setAssignPatients(Boolean.parseBoolean(String.valueOf(obj[2])));
			}
			if (obj[3] != null) {
				lc.setUserRole(String.valueOf(obj[3]));
			}
			if (obj[4] != null) {
				lc.setParentLocationId(Integer.parseInt(String.valueOf(obj[4])));
			}
			locRoles.add(lc);
		}
		
		return locRoles;		

	}

}
