package com.example.account.domain;

public interface AccountRepository  {

    Boolean save(Account account);

    Account loadAccountById(String id);
}
