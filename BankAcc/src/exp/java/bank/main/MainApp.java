package exp.java.bank.main;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import exp.java.bank.dao.AccountDAO;
import exp.java.bank.dao.EditDetailsDAO;
import exp.java.bank.dao.PersonDAO;
import exp.java.bank.dao.TransferDAO;
import exp.java.bank.menu.DepositAccount;
import exp.java.bank.menu.OpenNewAccount;
import exp.java.bank.menu.ShowAllAccount;
import exp.java.bank.menu.TransferAmount;
import exp.java.bank.menu.UpdateDetails;
import exp.java.bank.menu.ViewAccount;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"spring-config.xml");
		AccountDAO accountDAO = context.getBean(AccountDAO.class);
		PersonDAO personDAO = (PersonDAO) context.getBean("personDAO");
		EditDetailsDAO editDetailsDAO = (EditDetailsDAO) context.getBean("editDAO");
		TransferDAO transferDAO = (TransferDAO) context.getBean("transferDAO");
		/*Integer choice;
		System.out.println("Enter your choice.");
		Scanner scan = new Scanner(System.in);
		//boolean quit = false;
		// do {
		choice = scan.nextInt();
		System.out.println("1.	Open new account \n2.	Edit an account details\n"
				+ "3.	View account details\n4.	Show all account details \n5.	Add money to an account\n"
				+ "6.	Transfer money from one to another account");
		switch(choice){
		//case 0 :quit=true;
		//	break;
		case 1 :System.out.println("open");
			break;
		case 2 :System.out.println("edit");
			break;
		case 3 :System.out.println("view");
			break;
		case 4 :System.out.println("show all");
			break;
		case 5 :System.out.println("add money");
			break;
		case 6 :System.out.println("Transfer");
			break;
		case 7 :System.out.println("Exit");
			break;
		default:System.out.println("Wrong choice.");
            break;
		}
		//}while(!quit);
		*/
	/*	OpenNewAccount openAccount = new OpenNewAccount();
		openAccount.newAccount(accountDAO);*/
		ShowAllAccount allAccount = new ShowAllAccount();
		allAccount.showAll(personDAO);
	/*	ViewAccount myAccount = new ViewAccount();
		myAccount.viewAccount(personDAO);*/
		/*DepositAccount deposit = new DepositAccount();
		deposit.deposit(accountDAO);*/
	/*	UpdateDetails updateDetails = new UpdateDetails();
		updateDetails.updatePersonDetails(editDetailsDAO);*/
		TransferAmount transfer = new TransferAmount();
		transfer.moneyTransfer(transferDAO);
		// close resources
		((AbstractApplicationContext) context).close();
	}

}
