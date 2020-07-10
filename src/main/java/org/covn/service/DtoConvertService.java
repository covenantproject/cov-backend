package org.covn.service;

import org.covn.dto.PatientDto;
import org.covn.model.db.Users;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@RequestScope
@Component
public class DtoConvertService {

	public Users toUsers(PatientDto dto) {
		Users user = new Users();

		return null;
	}
	
	
}
