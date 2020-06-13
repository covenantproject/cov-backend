package org.covn.service;

import org.covn.dto.PatientDto;
import org.covn.model.db.Users;
import org.springframework.stereotype.Service;

@Service
public class DtoConvertService {

	public Users toUsers(PatientDto dto) {
		Users user = new Users();
		user.setAdminGender(dto.getAdminGender())
			.setAgeYrs(dto.getAgeInYrs())
			.setBiologicalSex(dto.getBiologicalSex())
			.setComments(dto.getComments())
			.setDateOfBirth(dto.getDob())
			.setLsAliasName1(dto.getLsAliasName1())
			.setLsAliasName2(dto.getLsAliasName2())
			.setLsDegree(dto.getLsDegrees())
			.setLsDisplayName(dto.getLsDisplayName())
			.setLsFirstName(dto.getLsFirstName())
			.setLsLastName(dto.getLsLastName())
			.setLsMaidenName(dto.getLsMaidenName())
			.setLsMiddleName(dto.getLsMiddleName())
			.setLsSuffix(dto.getLsSuffix())
			.setLsTitle(dto.getLsTitle());
		return null;
	}
	
	
}
