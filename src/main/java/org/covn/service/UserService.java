package org.covn.service;

import javax.persistence.EntityManager;

import org.covn.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author SunilAnand
 * @since 2020-04-14
 * 
 * Modified by Senthil N
 **/
@Component
public class UserService {

	/*
	 * UserService should both register users and retrieve their information
	 * Formerly called CovidService
	 * 
	 * Feel free to delete all the old methods and properties
	 * 
	 */
	
	
	
	private void registerNewUser(UserDto userDto) {
		
	}
	
	private UserDto getUserProfile (int userId) {
		return null;
	}

	private void saveUserProfile (UserDto userDto) {
	}
	

	private void uploadPhoto () {
		
	}
	
	
	private void getPhoto () {
		
	}
	
	
	
	// everything below is old stuff, feel free to change/remove
	
	
	
    @Value("${upload.path}")
    private String path;

    @Autowired
    private EntityManager entityManager;

    @Transactional
    public Long registerUser() {
    	return null;
    }

    public UserDto getUserProfile(Long userId) {
        
       
        return null;
    }

    @Transactional
    public Long uploadFile(MultipartFile file) {
        if (file.isEmpty()) {
            throw new RuntimeException("Failed to store empty file");
        }

        return null;
    }

    private UserDto convertToVo(Object user) {
        return null;
    }

    private Object convertToEntity(Object register) {

        return null;
    }
}

