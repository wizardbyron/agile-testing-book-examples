package com.example.account;

import com.example.account.domain.Account;
import com.example.account.domain.AccountRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AccountTest {

    @Mock
    AccountRepository accountRepository = mock(AccountRepository.class);

    @Test
    public void test_create_account_the_balance_is_zero(){
        Account account = new Account(accountRepository);
        assertEquals(0.0,account.getBalance());
    }

    @Test
    public void test_deposit() throws NegtiveValueException {
        Account account = new Account(accountRepository);
        account.deposit(500.00);
        assertEquals(500.0,account.getBalance());
        verify(accountRepository, times(2)).save(account);
    }

    @Test
    public void test_deposit_negative_value_should_throw_exception(){
        Account account = new Account(accountRepository);
        assertThrows(NegtiveValueException.class, ()->account.deposit(-500));
        assertEquals(0.0,account.getBalance());
        verify(accountRepository, times(1)).save(account);
    }

    @Test
    public void test_withdraw_negative_balance_should_throw_exception () {
        Account account = new Account(accountRepository);
        assertThrows(NegativeBalanceException.class, ()->account.withdraw(500));
        assertEquals(0.0,account.getBalance());
        verify(accountRepository, times(1)).save(account);
    }


    @Test
    public void test_deposit_then_withdraw() throws NegtiveValueException, NegativeBalanceException {
        Account account = new Account(accountRepository);
        account.deposit(500);
        account.withdraw(300);
        assertEquals(200.0,account.getBalance());
        verify(accountRepository, times(3)).save(account);

    }

    @Test
    public void test_withdraw_negative_value_should_throw_exception () {
        Account account = new Account(accountRepository);
        assertThrows(NegtiveValueException.class, ()->account.withdraw(-500));
        assertEquals(0.0,account.getBalance());
        verify(accountRepository, times(1)).save(account);
    }


    @Test
    public void verify_create_account_will_save_to_repository () {
        Account account = new Account(accountRepository);
        verify(accountRepository).save(account);
        assertNotNull(account.getId());
    }

    @Test
    public void verify_create_two_accounts_id_must_not_same () {
        Account account_one = new Account(accountRepository);
        Account account_two = new Account(accountRepository);
        assertNotEquals(account_one.getId(), account_two.getId());
    }

    @Test
    public void verify_load_account_by_id () throws NegtiveValueException {
        Account account = new Account(accountRepository);
        account.deposit(anyDouble());
        when(accountRepository.loadAccountById(account.getId())).thenReturn(account);

        Account account_loaded = accountRepository.loadAccountById(account.getId());

        assertEquals(account.getId(), account_loaded.getId());
        assertEquals(account.getBalance(), account_loaded.getBalance());
    }

}

