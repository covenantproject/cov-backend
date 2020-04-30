package com.covid.service;

import com.covid.dto.RegisterDto;
import com.covid.dto.UserDto;
import com.covid.vo.AddressEntity;
import com.covid.vo.ExternalIdentifierEntity;
import com.covid.vo.PatientEntity;
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
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.*;

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
        try {
            UserEntity user = convertToEntity(register);
            entityManager.persist(user);
            return user.getUserId();
        } catch (Exception ex) {
            String msg = String.format("Register couldn't complete");
            throw new RuntimeException(msg, ex);
        }
    }

    public RegisterDto getUserProfile(Long userId) {
        UserEntity user = entityManager.find(UserEntity.class, userId);
        RegisterDto userDetails = new RegisterDto();

        if (user == null) {
            throw new RuntimeException("User with id " + userId + " does not exist");
        } else {
            if (user.getPhotoId() != null) {
                PhotoEntity photo = entityManager.find(PhotoEntity.class, user.getPhotoId());
                userDetails = convertToVo(user);
                userDetails.setPhotoPath(photo.getPhotoPath());
            } else {
                userDetails = convertToVo(user);
            }
        }

        return userDetails;
    }

    public UserDto getUserId(String username) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("getuserid")
        .registerStoredProcedureParameter("uname", String.class, ParameterMode.IN)
        .setParameter("uname", username);
        query.execute();
        List list= query.getResultList();	
        Iterator itr = list.iterator();
        UserDto usr = new UserDto();
        while (itr.hasNext()) {
            
            Object[] obj = (Object[]) itr.next();
            if (obj[0] != null) {
                usr.setuserid(Integer.parseInt(String.valueOf(obj[0])));
            }
            if (obj[1] != null) {
                usr.setusername(String.valueOf(obj[1]));
            }
        }

        return usr;	
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
        register.setProofType(user.getExternalIdentifier().getIDType());
        register.setProofAuthority(user.getExternalIdentifier().getIDAuthority());
        register.setProofNumber(user.getExternalIdentifier().getIDNumber());
        if (user.getAddress() != null) {
            register.setAddressType(user.getAddress().getAddressType());
            register.setAddressLine1(user.getAddress().getAddressLine1());
            register.setAddressLine2(user.getAddress().getAddressLine2());
            register.setAddressLine3(user.getAddress().getAddressLine3());
            register.setCity(user.getAddress().getCity());
            register.setDistrict(user.getAddress().getDistrict());
            register.setState(user.getAddress().getState());
            register.setPinCode(user.getAddress().getPinCode());
        }
        if (user.getPhoneNumber() != null) {
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
        address.setAddressType(register.getAddressType());
        address.setAddressLine1(register.getAddressLine1());
        address.setAddressLine2(register.getAddressLine2());
        address.setAddressLine3(register.getAddressLine3());
        address.setCity(register.getCity());
        address.setDistrict(register.getDistrict());
        address.setState(register.getState());
        address.setPinCode(register.getPinCode());
        user.setAddress(address);
        address.setUser(user);

        PhoneNumberEntity phoneNumber = new PhoneNumberEntity();
        phoneNumber.setPhoneNumber(register.getMobileNo());
        user.setPhoneNumber(phoneNumber);
        phoneNumber.setUser(user);

        ExternalIdentifierEntity externalIdentifier = new ExternalIdentifierEntity();
        externalIdentifier.setIDType(register.getProofType());
        externalIdentifier.setIDAuthority(register.getProofAuthority());
        externalIdentifier.setIDNumber(register.getProofNumber());
        user.setExternalIdentifier(externalIdentifier);
        externalIdentifier.setUser(user);

        PatientEntity patient = new PatientEntity();
        user.setPatient(patient);
        patient.setUser(user);

        return user;
    }
}
