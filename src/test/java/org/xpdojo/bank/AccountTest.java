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
        Account debitor = new Account();
        debitor.deposit(20);

        Account creditor = new Account();

        debitor.transfer(creditor, 10);

        assertThat(debitor.balance()).isEqualTo(10);
        assertThat(creditor.balance()).isEqualTo(10);
    }

    @Test
    public void withdrawMoneyWithBalanceLowerThanZero() {
        Account account = new Account();
        account.withdraw(10);
        assertThat(account.balance()).isNotNegative();
    }
}
