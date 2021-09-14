package com.example.atm.domain.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class DebitCardService {

    @Value("${card-service.host}")
    private String cardServiceHost;

    public boolean verifyPIN(Long cardID, Integer pin) {
        RestTemplate template = new RestTemplate();
        try {
            String requestURL = String.format("http://%s/verify?id=%d&pin%d", this.cardServiceHost, cardID, pin);
            String result = template.getForObject(requestURL, String.class);
            return "OK".equals(result);
        } catch (Exception e) {
            return false;
        }
    }

}
