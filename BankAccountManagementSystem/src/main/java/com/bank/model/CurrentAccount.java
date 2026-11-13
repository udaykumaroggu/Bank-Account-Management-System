package com.bank.model;

import com.bank.exception.InsufficientBalanceException;

public class CurrentAccount extends Account {
	private double overdraftLimit = 5000;

	public CurrentAccount(int accountNumber, String holderName, double balance) {
		super(accountNumber, holderName, balance);
	}

	@Override
	public void withdraw(double amount) throws InsufficientBalanceException {
		if (amount <= 0) {
			throw new IllegalArgumentException("Withdrawal amount must be positive.");
		}
		if (balance - amount < -overdraftLimit) {
			throw new InsufficientBalanceException("Overdraft limit exceeded!");
		}
		balance -= amount;
		System.out.println("Current account withdrawal successful!");
	}

	@Override
	public void displayDetails() {
		System.out.println("\n--- Current Account ---");
		System.out.println("Account Number: " + getAccountNumber());
		System.out.println("Holder Name: " + getHolderName());
		System.out.println("Balance: " + getBalance());
		System.out.println("Overdraft Limit: " + overdraftLimit);
	}
}
