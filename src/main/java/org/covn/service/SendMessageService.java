package org.covn.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@RequestScope
@Component
public class SendMessageService {


    @Value("${textLocalApiUrl}")
    private String textApiUrl;

    @Value("${textlocalApiKey}")
    private String textApiKey;

    public void sendSMS(String mobileNo, String msg) {

        try {
            String apiKey = "apikey=" + textApiKey;
            String message = String.format("&message=Your covenant app location: %s", msg);
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
    }

}
