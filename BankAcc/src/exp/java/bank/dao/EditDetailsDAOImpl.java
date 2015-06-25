package exp.java.bank.dao;

import java.util.Scanner;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import exp.java.bank.model.Person;

public class EditDetailsDAOImpl implements EditDetailsDAO {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("resource")
	@Override
	public void updateDetails(int accountNumber) {
		// TODO Auto-generated method stub
		String fname, lname, address;
		String dob;
		Integer pin = null;

		Session session = this.sessionFactory.openSession();

		try {
			Transaction tx = session.beginTransaction();
			System.out.println("acc no is" + accountNumber);
			Query query = session
					.createQuery("from Person where account=:accNO");
			query.setInteger("accNO", accountNumber);
			Person person = (Person) query.uniqueResult();
			/*
			 *  //Person person = (Person) session.get(Person.class,
			 * accountNumber); The above line will execute only if accountNumber
			 * is a primary key
			 */

			Scanner scan = new Scanner(System.in);
			System.out.println("am here" + person);
			System.out.println("Your First Name is :" + person.getFirstName());

			System.out.println("Update the field or press enter to continue..");
			fname = scan.nextLine();
			if (!fname.equals(""))
				person.setFirstName(fname);
			System.out.println("Your Last Name is :" + person.getLastName());
			System.out.println("Update the field or press enter to continue..");
			lname = scan.nextLine();
			if (!lname.equals(""))
				person.setLastName(lname);
			System.out.println("Your Date of Birth is :" + person.getDoB());
			System.out.println("Update the field or press enter to continue..");
			dob = scan.nextLine();
			if (!dob.equals(""))
				person.setDoB(dob);
			System.out.println("Your Address is :" + person.getAddress());
			System.out.println("Update the field or press enter to continue..");
			address = scan.nextLine();
			if (!address.equals(""))
				person.setLastName(lname);
			System.out.println("Your pin number is :" + person.getPin());
			System.out.println("Update the field or press enter to continue..");
			pin = scan.nextInt();
			if (!pin.equals(""))
				person.setPin(pin);
			session.update(person);
			System.out.println("Updated sucessfully");
			tx.commit();

		} catch (HibernateException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

}
