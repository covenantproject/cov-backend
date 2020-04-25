package com.covid.service;

import com.covid.model.PhoneNumber;
import com.covid.repository.PhoneNumberRepo;
import com.covid.repository.UserRepo;
import com.covid.vo.UserEntity;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author SunilAnand
 * @since 2020-04-18
 **/
@Service
public class AuthenticationService {

    @Autowired
    PhoneNumberRepo phoneNoRepo;

    @Autowired
    private UserRepo userRepo;

    @Value("${textLocalApiUrl}")
    private String textApiUrl;

    @Value("${textlocalApiKey}")
    private String textApiKey;

    public void sendOtp(String mobileNo) {
        PhoneNumber phoneNumber = phoneNoRepo.findByPhoneNumber(mobileNo);
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
        PhoneNumber phoneNumber = phoneNoRepo.findByPhoneNumber(mobileNo);
        if (phoneNumber == null) {
            throw new RuntimeException("REC_NOT_FOUND");
        }

        UserEntity user = userRepo.findByUserId(phoneNumber.getUserId());
        if (!StringUtils.equals(otp, user.getOtpCode())) {
            throw new RuntimeException("INVALID_OTP");
        }else {
        	return user.getUserId();
        }
    }

    private void updateUserOtp(Long userId, int otp) {
        UserEntity user = userRepo.findByUserId(userId);
        user.setOtpCode(String.valueOf(otp));
        userRepo.save(user);
    }
}
