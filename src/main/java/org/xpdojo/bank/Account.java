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
        if (balance - amount > 0) {
            balance -= amount;
        }
    }

    public void transfer(Account creditor, double amount) {
        if (balance() >= amount) {
            withdraw(amount);
            creditor.deposit(amount);
        }
    }
}
