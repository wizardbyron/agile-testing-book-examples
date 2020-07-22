package com.example.atm.domain.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

public class DebitCardService {

    public boolean verifyPIN(Long cardID, Integer pin) {
        RestTemplate template = new RestTemplate();
        try {
            String requestURL = String.format("http://localhost:8080/verify_pin/%d/%d", cardID, pin);
            ResponseEntity<Map> entity = template.getForEntity(requestURL, Map.class);
            Map body = entity.getBody();
            return "OK".equals(body.get("result")) && (entity.getStatusCode() == HttpStatus.ACCEPTED);
        }catch (Exception e){
            return false;
        }
    }

}
