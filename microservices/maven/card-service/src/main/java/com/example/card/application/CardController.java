package com.example.card.application;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class CardController {

    @GetMapping("/verify")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public String verify(@RequestParam Long id,
                         @RequestParam Integer pin) {
        ResponseEntity response;
        if (id == 1111222233334444l && pin == 123456)
            return "OK";
        else
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Your PIN is invalid");
    }

}
