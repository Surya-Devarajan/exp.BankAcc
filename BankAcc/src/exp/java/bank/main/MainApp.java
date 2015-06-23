package exp.java.bank.main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import exp.java.bank.dao.AccountDAO;
import exp.java.bank.dao.PersonDAO;
import exp.java.bank.model.Account;
import exp.java.bank.model.Person;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"spring-config.xml");
		AccountDAO accountDAO = context.getBean(AccountDAO.class);
		PersonDAO personDAO = (PersonDAO) context.getBean("personDAO");
		Account account = new Account();
		Person person = new Person();

		person.setFirstName("Vishnu");
		person.setLastName("G");
		person.setDoB("29-03-1989");
		person.setAddress("some address,some address");
		person.setGender("M");
		person.setPin(695008);
		
		account.setBalance(500);

		accountDAO.save(account, person);

		System.out.println("Accounts::" + person);

		List<Person> list = personDAO.list();

		for (Person p : list) {
			System.out.println("Account List::" + p);
		}
		// close resources
		((AbstractApplicationContext) context).close();
	}

}
