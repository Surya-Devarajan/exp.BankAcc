package exp.java.bank.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import exp.java.bank.model.Person;

public class PersonDAOImp implements PersonDAO{

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Person> list() {
		Session session = this.sessionFactory.openSession();
		List<Person> personList = session.createQuery("from Person").list();
		session.close();
		return personList;
	}
}
