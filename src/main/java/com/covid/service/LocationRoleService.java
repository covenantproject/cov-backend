package com.covid.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.covid.dto.HomeDetailsDto;
import com.covid.dto.LocationAndRoleDto;
import com.covid.model.Patient;
import com.covid.model.PatientCurrentStatus;
import com.covid.vo.UserEntity;



@Service
public class LocationRoleService {
	public List<LocationAndRoleDto> getLocationAndRoles(long userId) {	
		LocationAndRoleDto locationRoles=new LocationAndRoleDto();
		return null;
	}

}
