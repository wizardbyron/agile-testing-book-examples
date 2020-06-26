package account;

public class Account {

    private Double balance = 0.00;

    public Double getBalance() {
        return this.balance;
    }

    public void deposit(Double value) {
        this.balance += value;
    }

    public void withdraw(Double value) {
        if (value > this.balance)
            new Throwable("余额不足");
        else this.balance -= value;
    }
}
