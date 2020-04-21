package com.covid.service;

import java.util.ArrayList;
import java.util.List;

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
			
			HealthProfessional healthProfid=healthProRepo.findByUserId(userId);
			//long patientCount=patientRepo.findByHealthProfessionalIdCount(healthProfid.getHealthProfessionalId());
			//locationRoles.setAssignPatients(patientCount);
			locationRolesList.add(locationRoles);
		}
		
		return locationRolesList;
	}

}
