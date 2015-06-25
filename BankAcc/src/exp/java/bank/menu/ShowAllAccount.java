package exp.java.bank.menu;

import java.util.List;

import exp.java.bank.dao.PersonDAO;
import exp.java.bank.model.Person;

public class ShowAllAccount {
	public void showAll(PersonDAO personDAO) {
		List<Person> list = personDAO.accountList();
		System.out.println("List of all account details are...");
		for (Person p : list) {
			System.out.println(p);
		}
	}
}
