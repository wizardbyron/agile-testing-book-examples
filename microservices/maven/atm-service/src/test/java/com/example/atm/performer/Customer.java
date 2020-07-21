package com.example.atm.performer;

import com.example.atm.domain.model.Account;
import com.example.atm.domain.model.DebitCard;

public class Customer {
    private DebitCard debitCard;

    public void haveCard(DebitCard debitCard) {
        this.debitCard = debitCard;
    }

    public void setDebitCardPIN(Integer pin) {
        this.debitCard.setPIN(pin);
    }

    public void setCardAccount(Account account) {
        this.debitCard.setAccount(account);
    }

    public void insertCardToATM(ATM atm) {
        atm.insertCard(this.debitCard);
    }

    public void queryBalanceOn(ATM atm) {
        atm.queryBalance();
    }

    public void enterPIN(ATM atm, Integer pin) {
        atm.enterPIN(pin);
    }
}
