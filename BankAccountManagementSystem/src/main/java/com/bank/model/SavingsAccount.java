
package com.bank.model;

import com.bank.exception.InsufficientBalanceException;

public class SavingsAccount extends Account {
	private double minimumBalance = 500;

	public SavingsAccount(int accountNumber, String holderName, double balance) {
		super(accountNumber, holderName, balance);
	}

	@Override
	public void withdraw(double amount) throws InsufficientBalanceException {
		if (amount <= 0) {
			throw new IllegalArgumentException("Withdrawal amount must be positive.");
		}
		if (balance - amount < minimumBalance) {
			throw new InsufficientBalanceException("Minimum balance of 500 must be maintained.");
		}
		balance -= amount;
		System.out.println("Savings withdrawal successful!");
	}

	@Override
	public void displayDetails() {
		System.out.println("\n--- Savings Account ---");
		System.out.println("Account Number: " + getAccountNumber());
		System.out.println("Holder Name: " + getHolderName());
		System.out.println("Balance: " + getBalance());
		System.out.println("Minimum Balance: " + minimumBalance);
	}
}
