package com.bank.repository;

import java.util.ArrayList;
import com.bank.model.Account;

public class BankRepository {
	private ArrayList<Account> accounts = new ArrayList<>();

	public boolean addAccount(Account account) {
		if (findAccount(account.getAccountNumber()) != null) {
			return false;
		}
		accounts.add(account);
		return true;
	}

	public Account findAccount(int accountNumber) {
		for (Account account : accounts) {
			if (account.getAccountNumber() == accountNumber) {
				return account;
			}
		}
		return null;
	}

	public void displayAllAccounts() {
		if (accounts.isEmpty()) {
			System.out.println("No accounts available.");
			return;
		}
		for (Account account : accounts) {
			account.displayDetails();
		}
	}
}
