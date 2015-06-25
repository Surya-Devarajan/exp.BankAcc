package exp.java.bank.menu;

import java.util.List;

import exp.java.bank.dao.PersonDAO;
import exp.java.bank.model.Person;

public class ViewAccount {
	public void viewAccount(PersonDAO personDAO){
		Person person =personDAO.myAccountDetails(1004);
		System.out.println("Acount details of account number");
		
			System.out.println(person);

	}
}
