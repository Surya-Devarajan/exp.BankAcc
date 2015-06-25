package exp.java.bank.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import exp.java.bank.model.*;

public class PersonDAOImpl implements PersonDAO{

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Person> accountList() {
		Session session = this.sessionFactory.openSession();
		List<Person> personList = session.createQuery("from Person").list();
		session.close();
		return personList;
	}
	@Override
	public Person myAccountDetails(int accNumber){
		Session session = this.sessionFactory.openSession();
		Query query =session.createQuery("from Person where accNumber=:accNO");
		query.setParameter("accNO", accNumber);
		Person personAccount = (Person) query.uniqueResult();
		return personAccount;		//change to list<person> for more than one row
		
	}
}
