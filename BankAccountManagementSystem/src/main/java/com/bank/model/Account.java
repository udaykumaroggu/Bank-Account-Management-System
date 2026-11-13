package com.bank.model;

import com.bank.interfaces.Transaction;
import com.bank.exception.InsufficientBalanceException;

public abstract class Account implements Transaction {
	private int accountNumber;
	private String holderName;
	protected double balance;

	public Account(int accountNumber, String holderName, double balance) {
		this.accountNumber = accountNumber;
		this.holderName = holderName;
		this.balance = balance;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public String getHolderName() {
		return holderName;
	}

	public double getBalance() {
		return balance;
	}

	@Override
	public void deposit(double amount) {
		if (amount <= 0) {
			System.out.println("Invalid deposit amount!");
			return;
		}
		balance += amount;
		System.out.println("Amount deposited successfully!");
	}

	public abstract void displayDetails();

	@Override
	public abstract void withdraw(double amount) throws InsufficientBalanceException;
}
