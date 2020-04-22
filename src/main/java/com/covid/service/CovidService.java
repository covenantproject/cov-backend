package com.covid.service;

import com.covid.dto.RegisterDto;
import com.covid.vo.AddressEntity;
import com.covid.vo.PhoneNumberEntity;
import com.covid.vo.PhotoEntity;
import com.covid.vo.Register;
import com.covid.vo.UserEntity;
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
 **/
@Component
public class CovidService {

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

    public RegisterDto getUserProfile(Long userId) {
        UserEntity user = entityManager.find(UserEntity.class, userId); 
        RegisterDto userDetails=new RegisterDto();
      
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

    private RegisterDto convertToVo(UserEntity user) {
    	RegisterDto register = new RegisterDto();
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
