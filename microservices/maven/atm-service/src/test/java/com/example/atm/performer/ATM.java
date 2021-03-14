package com.example.atm.performer;

import com.example.atm.domain.model.DebitCard;
import com.example.atm.domain.service.DebitCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ATM {
    @Autowired
    private DebitCardService debitCardService;
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
        this.verifiedPIN = this.debitCardService.verifyPIN(this.card.getCardID(), pin);
        if (!this.verifiedPIN) {
            this.screenMessage = "Your PIN is invalid.";
        } else {
            this.queryBalance();
        }
    }

    public void init() {
        this.verifiedPIN = false;
        this.card = null;
        this.screenMessage = null;
    }
}
