package com.example.atm.performer;

import com.example.atm.domain.model.DebitCard;
import com.example.atm.domain.service.DebitCardService;

public class ATM {
    private final DebitCardService debitCardService = new DebitCardService();
    private DebitCard card;
    private String screenMessage;
    private boolean verifiedPIN = false;

    public void insertCard(DebitCard debitCard) {
        this.card = debitCard;
    }

    public void queryBalance() {
        if (this.verifiedPIN) {
            this.screenMessage = String.format("Your balance is: %f", this.card.getBalance());
        } else {
            this.screenMessage = String.format("Please input PIN:");
        }
    }

    public String getScreenMessage() {
        return this.screenMessage;
    }

    public void enterPIN(Integer pin) {
        this.verifiedPIN = this.card.verifyPIN(pin);
        this.queryBalance();
    }
}
