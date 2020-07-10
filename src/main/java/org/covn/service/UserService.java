package org.covn.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.covn.dto.UserDto;
import org.covn.model.db.EmailAddress;
import org.covn.model.db.Users;
import org.covn.model.meta.Users_;
import org.covn.model.type.AdminGender;
import org.covn.repository.Cond;
import org.covn.repository.Cond.Oper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

/**
 * @author SunilAnand
 * @since 2020-04-14
 * 
 * Modified by Senthil N
 **/
@RequestScope
@Component
public class UserService extends BaseService<Users> {

	
	@Autowired
	private EmailAddressService emailService;
	
	public UserService() {
		super(Users.class);
	}

	@Transactional
	public int save(UserDto dto) {
		Users user = dto.getUser();
		this.save(user);
		
		List<EmailAddress> emails = dto.getEmailAddressList();
		emailService.saveAll(emails);
		
		return user.getKey();
		 
	}
	
	
	public UserDto findByUserName(String userName) {
		Users user = this.findOneByExample(Users.of().setUsername(userName));
		UserDto dto = new UserDto();
		dto.setUser(user.copy());
		return dto;
	}

	public List<UserDto> findAgeAndSex(int age, AdminGender gender){
		//find by example only support AND condition on multiples right now, but easily could add support for OR and only with equals
		//for more advance query please user JPA Criteria api and use example on findByAgeOverAndNotSex
		List<Users> users = this.findByExample(Users.of().setAgeYrs(age).setAdminGender(gender.getKey()));
		List<UserDto> result = this.apply(users, (user) -> {
			UserDto dto = new UserDto();
			dto.setUser(user);
			return dto;
		});
		return result;
		
	}
	
	public List<UserDto> findByAgeOverAndNotSex(int age, AdminGender gender){
		Cond<Users> cond = Cond.of(Users.class).add(Users_.ageYrs, Oper.gt, age)
								.add(Users_.adminGender, Oper.ne, gender.getKey())
								;
		List<Users> list = this.find(cond);
		List<UserDto> result = this.apply(list, (user) -> {
			final UserDto dto = new UserDto();
			dto.setUser(user.copy());
			List<EmailAddress> emails = new ArrayList<>(user.getEmailAddressByUserIdSet());
			emails = emailService.apply(emails, (email) -> email.copy());
			dto.setEmailAddressList(emails);
			//and other fields
			return dto;
		});
		return result;
	}
	
}

