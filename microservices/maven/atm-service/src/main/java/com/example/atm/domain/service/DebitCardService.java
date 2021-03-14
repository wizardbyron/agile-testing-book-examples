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
            String requestURL = String.format("http://%s/verify_pin/%d/%d",this.cardServiceHost,cardID, pin);
            ResponseEntity<Map> entity = template.getForEntity(requestURL, Map.class);
            Map body = entity.getBody();
            return "OK".equals(body.get("result")) && (entity.getStatusCode() == HttpStatus.ACCEPTED);
        }catch (Exception e){
            return false;
        }
    }

}
