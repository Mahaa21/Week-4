package test;

public class BankAccount {
    private double balance;

    public void deposit(double amount) {
        if (amount > 0) balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= balance) balance -= amount;
        else throw new IllegalArgumentException("Insufficient funds");
    }

    public double getBalance() {
        return balance;
    }
}
