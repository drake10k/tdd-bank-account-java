package org.xpdojo.bank;

public class Account {

    private double balance = 0;

    public double balance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        balance -= amount;
    }

    public void transfer(Account creditor, double amount) {
        withdraw(amount);
        creditor.deposit(amount);
    }
}
