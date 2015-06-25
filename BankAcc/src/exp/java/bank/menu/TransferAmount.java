package exp.java.bank.menu;

import java.util.Scanner;

import exp.java.bank.dao.TransferDAO;

public class TransferAmount {
	public void moneyTransfer(TransferDAO transferDAO){
		Integer myAccountNumber;
		Integer yourAccountNumber;
		Double amount;
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter your account number :");
		myAccountNumber = scan.nextInt();
		System.out.println("Enter destination account number :");
		yourAccountNumber = scan.nextInt();
		System.out.println("Enter the amount to be transferd :");
		amount = scan.nextDouble();
		transferDAO.amountTransfer(myAccountNumber,yourAccountNumber,amount);
		
		
	}
}
