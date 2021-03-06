package org.xpdojo.bank;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountTest {

    @Test
    public void newAccountShouldHaveZeroBalance() {
        Account account = new Account();
        assertThat(account.balance()).isEqualTo(0);
    }

    @Test
    public void depositMultipleAmountsToIncreaseAccountBalance() {
        Account account = new Account();
        account.deposit(10);
        account.deposit(20);
        assertThat(account.balance()).isEqualTo(30);
    }

    @Test
    public void depositAnAmountWithDecimalToIncreaseAccountBalance() {
        Account account = new Account();
        account.deposit(10.3);
        assertThat(account.balance()).isEqualTo(10.3);
    }

    @Test
    public void withdrawAnAmountToDecreaseAccountBalance() {
        Account account = new Account();
        account.deposit(20);
        account.withdraw(10);
        assertThat(account.balance()).isEqualTo(10);
    }

    @Test
    public void transferMoneyToAnotherAccount() {
        Account sender = new Account();
        sender.deposit(20);

        Account receiver = new Account();

        sender.transfer(receiver, 10);

        assertThat(sender.balance()).isEqualTo(10);
        assertThat(receiver.balance()).isEqualTo(10);
    }

    @Test
    public void withdrawMoneyWithBalanceLowerThanZero() {
        Account account = new Account();
        account.withdraw(10);
        assertThat(account.balance()).isNotNegative();
    }

    @Test
    public void transferMoneyWhenSenderBalanceIsLowerThanTransferredAmount() {
        Account sender = new Account();
        Account receiver = new Account();
        sender.transfer(receiver, 10);

        assertThat(sender.balance()).isNotNegative();
        assertThat(receiver.balance()).isEqualTo(0);
    }
}
