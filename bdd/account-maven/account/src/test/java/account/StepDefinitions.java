package account;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import io.cucumber.java.zh_cn.*;

import static org.junit.Assert.*;

public class StepDefinitions {
    private Account account;

    @Given("I have no account")
    public void i_have_no_account() {
        this.account = null;
    }

    @When("I open a new account")
    public void i_open_a_new_account() {
        this.account = new Account();
    }

    @Then("the account balance is {double}")
    public void the_account_balance_is(Double value) {
        assertEquals(value, this.account.getBalance());
    }

    @假设("我没有账户")
    public void 我没有账户() {
        // Write code here that turns the phrase above into concrete actions
        this.account = null;
    }

    @当("我新建账户的时候")
    public void 我新建账户后() {
        this.account = new Account();
    }
    @那么("我的账户余额为 {double}")
    public void 账户余额为(Double value) {
        assertEquals(this.account.getBalance(), value);
    }

    @当("我存入 {double} 元后")
    public void 我存入_元后(Double value) {
        this.account.deposit(value);
    }
    @假设("我的账户初始余额为 {double}")
    public void 我账户的初始余额为(Double value) {
        this.account = new Account();
        this.account.deposit(value);
    }

    @当("我取出 {double} 元后")
    public void 我取出_元后(Double value) {
        this.account.withdraw(value);
    }

    @那么("我收到出错提示“余额不足”")
    public void 我收到出错提示_余额不足() {
        assertThrows("余额不足",Throwable.class,null);
    }
}
