package com.example.card.interfaces;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CardController {

    @GetMapping("/verify_pin/{id}/{pin}")
    public ResponseEntity verifyPIN(@PathVariable("id") Long id,
                                    @PathVariable("pin") Integer pin) {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Content-Type", "application/json;charset=utf-8");
        ResponseEntity response;
        if (id == 1111222233334444l && pin == 123456)
            response = new ResponseEntity("{\"result\":\"OK\"}", responseHeaders, HttpStatus.ACCEPTED);
        else
            response = new ResponseEntity("{\"result\":\"Your PIN is invalid\"}", responseHeaders, HttpStatus.BAD_REQUEST);
        return response;
    }

}
