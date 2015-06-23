
package exp.java.bank.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import exp.java.bank.model.Account;
import exp.java.bank.model.Person;

public class AccountDAOImpl implements AccountDAO {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void save(Account account,Person person) {
		Session session = sessionFactory.openSession();
		try {		
			Transaction tx = session.beginTransaction();
			session.save(account);
			
			person.setAccount(account);
			session.save(person);	
			
			tx.commit();
		} catch(HibernateException e) {
			e.printStackTrace();
		} finally {
			
			session.close();
		}
		
	}

	

}