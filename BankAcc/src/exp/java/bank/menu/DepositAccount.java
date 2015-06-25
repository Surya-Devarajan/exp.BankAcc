package exp.java.bank.menu;

import java.util.Scanner;

import exp.java.bank.dao.AccountDAO;

//Add money to an account
public class DepositAccount {
	public void deposit(AccountDAO accountDAO){
		Integer accountNumber;
		double balance;
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter your account number :");
		accountNumber = scan.nextInt();
		System.out.println("Enter the amount to be deposited :");
		balance = scan.nextDouble();
		accountDAO.deposit(accountNumber,balance);
		
		
		
		
	}
}
