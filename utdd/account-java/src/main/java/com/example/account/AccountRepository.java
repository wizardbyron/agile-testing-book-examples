package com.example.account;

public interface AccountRepository  {

    Boolean save(Account account);

    Account loadAccountById(String id);
}
