package org.covn.service;

import org.covn.model.db.EmailAddress;
import org.springframework.stereotype.Service;

@Service
public class EmailAddressService extends BaseService<EmailAddress> {

	protected EmailAddressService() {
		super(EmailAddress.class);
		// TODO Auto-generated constructor stub
	}

}
