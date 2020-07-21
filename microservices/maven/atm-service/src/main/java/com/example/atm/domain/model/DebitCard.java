package com.example.atm.domain.model;

public class DebitCard {
    private Integer PIN = -1;
    private final Long cardId;
    private Account account;

    public DebitCard(Long cardId) {
        this.cardId = cardId;
    }

    public void setPIN(Integer pin) {
        this.PIN = pin.intValue();
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public double getBalance() {
        return this.account.getBalance();
    }

    public boolean verifyPIN(Integer pin){
        return this.PIN.intValue() == pin;
    }

    public Long getCardID() {
        return this.cardId;
    }
}
