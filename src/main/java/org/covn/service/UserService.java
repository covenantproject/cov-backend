package org.covn.service;

import org.covn.dto.UserDto;
import org.covn.vo.AddressEntity;
import org.covn.vo.PhoneNumberEntity;
import org.covn.vo.PhotoEntity;
import org.covn.vo.Register;
import org.covn.vo.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityManager;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

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
    public Long registerUser(Register register) {
        UserEntity user = convertToEntity(register);
        entityManager.persist(user);
        return user.getUserId();
    }

    public UserDto getUserProfile(Long userId) {
        UserEntity user = entityManager.find(UserEntity.class, userId); 
        UserDto userDetails=new UserDto();
      
        if (user == null) {
            throw new RuntimeException("User with id " + userId + " does not exist");
        }else {
        	 if(user.getPhotoId()!=null) {
            	 PhotoEntity photo=entityManager.find(PhotoEntity.class, user.getPhotoId()); 
            	 userDetails=convertToVo(user);
            	 userDetails.setPhotoPath(photo.getPhotoPath()); 
            }else {
            	userDetails=convertToVo(user);
            }
        }
       
        return userDetails;
    }

    @Transactional
    public Long uploadFile(MultipartFile file) {
        if (file.isEmpty()) {
            throw new RuntimeException("Failed to store empty file");
        }

        PhotoEntity photo = new PhotoEntity();
        entityManager.persist(photo);
        try {

            String fileName = file.getOriginalFilename();
            fileName = fileName.replaceAll(" ", "-");
            String name = fileName.substring(0, fileName.lastIndexOf("."));
            String extn = fileName.substring(fileName.lastIndexOf(".") + 1);
            fileName = name + "_" + photo.getPhotoId() + "." + extn;
            fileName = path + fileName;

            InputStream is = file.getInputStream();
            Files.copy(is, Paths.get(fileName), StandardCopyOption.REPLACE_EXISTING);
            photo.setPhotoPath(fileName);
        } catch (Exception e) {
            entityManager.remove(photo);
            String msg = String.format("Failed to store file %s", file.getName());
            throw new RuntimeException(msg, e);
        }
        return photo.getPhotoId();
    }

    private UserDto convertToVo(UserEntity user) {
    	UserDto register = new UserDto();
        register.setTitle(user.getTitle());
        register.setFirstName(user.getFirstName());
        register.setMiddleName(user.getMiddleName());
        register.setLastName(user.getLastName());
        register.setPreferredName(user.getPreferredName());
        register.setShortName(user.getShortName());
        register.setSuffix(user.getSuffix());
        register.setDob(user.getDateOfBirth());
        register.setGender(user.getGender());
        if(user.getAddress()!=null) {
        	register.setAddress(user.getAddress().getAddressLine1());
        }
        if(user.getPhoneNumber()!=null) {
        	register.setMobileNo(user.getPhoneNumber().getPhoneNumber());
        }
        return register;
    }

    private UserEntity convertToEntity(Register register) {
        UserEntity user = new UserEntity();
        user.setTitle(register.getTitle());
        user.setFirstName(register.getFirstName());
        user.setMiddleName(register.getMiddleName());
        user.setLastName(register.getLastName());
        user.setPreferredName(register.getPreferredName());
        user.setShortName(register.getShortName());
        user.setSuffix(register.getSuffix());
        user.setDateOfBirth(register.getDob());
        user.setGender(register.getGender());
        user.setPhotoId(register.getPhotoId());

        AddressEntity address = new AddressEntity();
        address.setAddressLine1(register.getAddress());
        user.setAddress(address);
        address.setUser(user);

        PhoneNumberEntity phoneNumber = new PhoneNumberEntity();
        phoneNumber.setPhoneNumber(register.getMobileNo());
        user.setPhoneNumber(phoneNumber);
        phoneNumber.setUser(user);

        return user;
    }
}
