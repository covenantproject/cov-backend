package com.covid.service;

import static com.covid.util.CovidUtils.cast;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.covid.model.db.PhoneNumber;
import com.covid.model.db.Users;
import com.covid.model.meta.PhoneNumber_;
import com.covid.model.meta.Users_;
import com.covid.model.type.PhoneNumberType;
import com.covid.repository.EntityRepo;
import com.covid.repository.EntityRepo.Cond.Oper;

/**
 * @author SunilAnand
 * @since 2020-04-18
 **/
@Service
public class AuthenticationService {

    @Autowired
    private EntityRepo repo;


    @Value("${textLocalApiUrl}")
    private String textApiUrl;

    @Value("${textlocalApiKey}")
    private String textApiKey;

    private PhoneNumber findModilePhoneNumber(String mobileNo) {
        PhoneNumber phoneNumber =  repo.findOne(repo.get(PhoneNumber.class)
        		.add(PhoneNumber_.phoneNumber, mobileNo)
        		.add(PhoneNumber_.phoneType, PhoneNumberType.mobile.name()) 
        );
        return phoneNumber;
    }
    
    public void sendOtp(String mobileNo) {
        PhoneNumber phoneNumber =  this.findModilePhoneNumber(mobileNo);
        if (phoneNumber == null) {
            throw new RuntimeException("REC_NOT_FOUND");
        }

        int otp = ThreadLocalRandom.current().nextInt(1000, 9999);
        //Send OTP to the number
        try {
            String apiKey = "apikey=" + textApiKey;
            String message =String.format("&message=Covenant OTP: %d", otp);
            String sender = "&sender=" + "QANTLR";
            String numbers = "&numbers=" + mobileNo;

            // Send SMS
            HttpURLConnection conn = (HttpURLConnection) new URL(textApiUrl).openConnection();
            String data = apiKey + numbers + message + sender;
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
            conn.getOutputStream().write(data.getBytes(StandardCharsets.UTF_8));
            final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            final StringBuilder builder = new StringBuilder();
            String line;
            while ((line = rd.readLine()) != null) {
                builder.append(line);
            }
            System.out.println("Response: " + builder.toString());
            rd.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("SMS_FAILED");
        }

        updateUserOtp(phoneNumber.getUserId(), otp);
    }

    public long verifyOtp(String mobileNo, String otp) {
        PhoneNumber phoneNumber =  this.findModilePhoneNumber(mobileNo);
        if (phoneNumber == null) {
            throw new RuntimeException("REC_NOT_FOUND");
        }

        Users user = repo.findOne(repo.get(Users.class).add(Users_.userId, phoneNumber.getUserId()));
        if (!StringUtils.equals(otp, user.getOtpCode())) {
            throw new RuntimeException("INVALID_OTP");
        }else {
        	return user.getUserId();
        }
    }

    private void updateUserOtp(int userId, int otp) {
        Users user = repo.findOne(repo.get(Users.class).add(Users_.userId, userId));
        user.setOtpCode(String.valueOf(otp));
        repo.save(user);
    }
}
