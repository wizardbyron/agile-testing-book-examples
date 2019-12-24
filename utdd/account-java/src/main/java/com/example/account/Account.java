package com.example.account;

import java.util.UUID;

public class Account {

    private final AccountRepository accountRepository;
    private final String id;
    private double balance = 0.0;

    public Account(AccountRepository accountRepository) {
        this.id = UUID.randomUUID().toString();
        this.accountRepository = accountRepository;
        this.accountRepository.save(this);
    }

    public double getBalance() {
        return this.balance;
    }

    private void changeBalance(double value) {
        this.balance += value;
        this.accountRepository.save(this);
    }

    public void deposit(double value) throws NegtiveValueException {
        checkInputValue(value);
        changeBalance(value);
    }

    public void withdraw(double value) throws NegtiveValueException, NegativeBalanceException {
        checkInputValue(value);
        if (this.balance - value < 0) throw new NegativeBalanceException();
        else changeBalance(-value);
    }

    private static void checkInputValue(double value) throws NegtiveValueException {
        if (value < 0.0) throw new NegtiveValueException();
    }

    public String getId() {
        return this.id;
    }
}


