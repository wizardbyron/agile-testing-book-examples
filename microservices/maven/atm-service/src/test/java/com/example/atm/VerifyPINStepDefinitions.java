package com.example.atm;

import com.example.atm.domain.model.Account;
import com.example.atm.domain.model.DebitCard;
import com.example.atm.performer.ATM;
import com.example.atm.performer.Customer;
import io.cucumber.java.zh_cn.假如;
import io.cucumber.java.zh_cn.假设;
import io.cucumber.java.zh_cn.当;
import io.cucumber.java.zh_cn.那么;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VerifyPINStepDefinitions {
    private final Customer customer = new Customer();
    @Autowired
    private ATM atm;

    @假如("储户拥有一张卡号为\"{}\"的借记卡")
    public void 储户拥有一张卡号为_的借记卡(Long cardId) {
        this.customer.haveCard(new DebitCard(cardId));
    }

    @假设("密码为\"{int}\"")
    public void 密码为(Integer PIN) {
        this.customer.setDebitCardPIN(PIN);
    }

    @假设("储户借记卡账户余额为\"{double}\"元")
    public void 储户借记卡账户余额为_元(Double balance) {
        this.customer.setCardAccount(new Account(balance));
    }

    @当("储户将卡插入ATM")
    public void 储户将卡插入atm() {
        this.customer.insertCardToATM(atm);
    }

    @当("储户选择查询余额")
    public void 储户选择查询余额() {
        this.customer.queryBalanceOn(atm);
    }

    @那么("提示储户输入密码")
    public void 提示储户输入密码() {
        assertEquals("Please input PIN:", this.atm.getScreenMessage());
    }

    @那么("输入密码\"{int}\"")
    public void 输入密码(Integer pin) {
        this.customer.enterPIN(this.atm, pin);
    }

    @那么("储户可以看到自己的余额\"{double}\"元")
    public void 储户可以看到自己的余额_元(Double balance) {
        assertEquals(String.format("Your balance is: %f", balance), this.atm.getScreenMessage());
    }

    @那么("储户可以看到密码错误的提示")
    public void 储户可以看到密码错误的提示() {
        assertEquals("Your PIN is invalid.", this.atm.getScreenMessage());
    }

    @假设("ATM空闲")
    public void ATM空闲() {
        this.atm.reset();
    }
}
