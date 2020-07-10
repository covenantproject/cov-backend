package org.covn.service;

import org.covn.model.db.EmailAddress;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@RequestScope
@Component
public class EmailAddressService extends BaseService<EmailAddress> {

	protected EmailAddressService() {
		super(EmailAddress.class);
		// TODO Auto-generated constructor stub
	}

}
