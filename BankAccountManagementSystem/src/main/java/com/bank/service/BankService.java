package com.bank.service;

import com.bank.model.Account;
import com.bank.repository.BankRepository;
import com.bank.exception.InsufficientBalanceException;

public class BankService {
	private BankRepository repository = new BankRepository();

	public void createAccount(Account account) {

		if (repository.addAccount(account)) {
			System.out.println("Account created successfully!");
		} else {
			System.out.println("Account number already exists!");
		}
	}

	public void deposit(int accountNumber, double amount) {
		Account account = repository.findAccount(accountNumber);
		if (account == null) {
			System.out.println("Account not found!");
			return;
		}
		account.deposit(amount);
	}

	public void withdraw(int accountNumber, double amount) {
		Account account = repository.findAccount(accountNumber);
		if (account == null) {
			System.out.println("Account not found!");
			return;
		}
		try {
			account.withdraw(amount);
		} catch (InsufficientBalanceException e) {
			System.out.println("Error: " + e.getMessage());
		} catch (IllegalArgumentException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

	public void displayAccount(int accountNumber) {
		Account account = repository.findAccount(accountNumber);
		if (account != null) {
			account.displayDetails();
		} else {
			System.out.println("Account not found!");
		}
	}

	public void displayAllAccounts() {
		repository.displayAllAccounts();
	}

	public void transfer(int from, int to, double amount) {
		Account sender = repository.findAccount(from);
		Account receiver = repository.findAccount(to);
		if (sender == null || receiver == null) {
			System.out.println("Invalid account number!");
			return;
		}
		if (from == to) {
			System.out.println("Cannot transfer to the same account!");
			return;
		}
		try {
			sender.withdraw(amount);
			receiver.deposit(amount);
			System.out.println("Transfer successful!");

		} catch (InsufficientBalanceException e) {
			System.out.println("Transfer failed: " + e.getMessage());
		} catch (IllegalArgumentException e) {
			System.out.println("Transfer failed: " + e.getMessage());
		}
	}
}
