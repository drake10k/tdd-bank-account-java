package org.xpdojo.bank;

public class Account {

    private int balance = 0;

    public int balance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        balance -= amount;
    }
}
