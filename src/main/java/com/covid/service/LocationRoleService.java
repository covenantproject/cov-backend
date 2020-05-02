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
import com.covid.model.LocationHierarchy;
import com.covid.repository.EntityRepo;


@Service
public class LocationRoleService {
	

	@Autowired
	private EntityRepo repo;
	
	
	 @Autowired
	  private EntityManager entityManager;
	
	
	public List<LocationAndRoleDto> getLocationAndRoles(long userId) {	

		List<LocationAndRoleDto> locationRolesList=new ArrayList<LocationAndRoleDto>();
		
		List<LocationHierarchy> userLoc= null;
		for (int i = 0; i < userLoc.size(); i++) {
			//TODO populate DTO
			locationRolesList.add(null);
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
