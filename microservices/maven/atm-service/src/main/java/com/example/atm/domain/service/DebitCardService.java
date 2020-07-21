package com.example.atm.domain.service;

public class DebitCardService {
    public boolean verifyPIN(Long cardID, Integer pin) {
        return pin == 123456;
    }
}
