package com.bank.interfaces;

import com.bank.exception.InsufficientBalanceException;

public interface Transaction {
	void deposit(double amount);

	void withdraw(double amount) throws InsufficientBalanceException;
}
