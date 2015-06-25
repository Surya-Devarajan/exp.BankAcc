
package exp.java.bank.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;
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

	@Override
	public void deposit(int acc, double balance) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		try {
			Transaction tx = session.beginTransaction();
			Query q1=session.createQuery("select balance from Account where id=:id");
			q1.setParameter("id", acc);
			balance+=(double)q1.list().get(0);
			System.out.println("new balance"+balance);
			Query q=session.createQuery("update Account set balance=:balance where id=:accNo");    
			q.setParameter("balance",balance);
			q.setParameter("accNo",acc);
			  
			int status=q.executeUpdate();
			if(status==1){
			System.out.println("Money is deposited to the account with account Number"+acc);}  
			tx.commit();  
		} catch (HibernateException e) {
			// TODO: handle exception
		} finally {
			
			session.close();
		}
	}
	
	

}