package com.bank.main;

import java.util.Scanner;
import com.bank.model.Account;
import com.bank.model.SavingsAccount;
import com.bank.model.CurrentAccount;
import com.bank.service.BankService;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BankService service = new BankService();

		int choice = 0;
		do {
			System.out.println("\n===== BANK MANAGEMENT SYSTEM =====");
			System.out.println("1. Create Savings Account");
			System.out.println("2. Create Current Account");
			System.out.println("3. Deposit Money");
			System.out.println("4. Withdraw Money");
			System.out.println("5. Check Account Details");
			System.out.println("6. Display All Accounts");
			System.out.println("7. Transfer Money");
			System.out.println("8. Exit");
			System.out.print("Enter your choice: ");
			try {
				choice = Integer.parseInt(sc.nextLine().trim());
			} catch (NumberFormatException e) {
				System.out.println("Please enter a valid choice!");
				continue;
			}
			try {
				switch (choice) {
				case 1:
				case 2:
					System.out.print("Enter Account Number: ");
					int id = Integer.parseInt(sc.nextLine().trim());
					System.out.print("Enter Holder Name: ");
					String name = sc.nextLine().trim();
					if (name.isEmpty() || id <= 0) {
						System.out.println("Invalid account details!");
						break;
					}
					System.out.print("Enter Initial Balance: ");
					double balance = Double.parseDouble(sc.nextLine().trim());
					if (!Double.isFinite(balance) || balance < 0) {
						System.out.println("Invalid balance!");
						break;
					}
					Account account;
					if (choice == 1) {
						account = new SavingsAccount(id, name, balance);
					} else {
						account = new CurrentAccount(id, name, balance);
					}
					service.createAccount(account);
					break;
				case 3:
					System.out.print("Enter Account Number: ");
					int depositId = Integer.parseInt(sc.nextLine());
					System.out.print("Enter Amount: ");
					double depositAmount = Double.parseDouble(sc.nextLine());
					service.deposit(depositId, depositAmount);
					break;
				case 4:
					System.out.print("Enter Account Number: ");
					int withdrawId = Integer.parseInt(sc.nextLine());
					System.out.print("Enter Amount: ");
					double withdrawAmount = Double.parseDouble(sc.nextLine());
					service.withdraw(withdrawId, withdrawAmount);
					break;
				case 5:
					System.out.print("Enter Account Number: ");
					int searchId = Integer.parseInt(sc.nextLine());
					service.displayAccount(searchId);
					break;
				case 6:
					service.displayAllAccounts();
					break;
				case 7:
					System.out.print("Enter Sender Account: ");
					int from = Integer.parseInt(sc.nextLine());
					System.out.print("Enter Receiver Account: ");
					int to = Integer.parseInt(sc.nextLine());
					System.out.print("Enter Amount: ");
					double amount = Double.parseDouble(sc.nextLine());
					service.transfer(from, to, amount);
					break;
				case 8:
					System.out.println("Thank you for using our bank!");
					break;
				default:
					System.out.println("Invalid menu option!");
				}

			} catch (NumberFormatException e) {
				System.out.println("Please enter valid numeric details!");
			}
		} while (choice != 8);
		sc.close();
	}
}
