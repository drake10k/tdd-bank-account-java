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
}
