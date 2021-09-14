package com.example.atm.domain.model;

public class Account {
    private final Double balance;

    public Account(Double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }
}
