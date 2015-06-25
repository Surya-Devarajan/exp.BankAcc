package exp.java.bank.menu;

import java.util.Scanner;

import exp.java.bank.dao.AccountDAO;
import exp.java.bank.model.Account;
import exp.java.bank.model.Person;

public class OpenNewAccount {
	public void newAccount(AccountDAO accountDAO) {
		Account account = new Account();
		Person person = new Person();
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the First Name :");
		person.setFirstName(scan.nextLine());
		System.out.println("Enter the last Name :");
		person.setLastName(scan.nextLine());
		System.out.println("Enter the date of birth :");
		person.setDoB(scan.nextLine());
		System.out.println("Enter your address :");
		person.setAddress(scan.nextLine());
		System.out.println("Enter the you gender (M/F) :");
		person.setGender(scan.nextLine());
		System.out.println("Enter the pin code :");
		person.setPin(scan.nextInt());
		System.out.println("Enter the amount to be deposited: ");
		account.setBalance(scan.nextDouble());

		accountDAO.save(account, person);

		System.out.println("Accounts::" + person);

	}
}
