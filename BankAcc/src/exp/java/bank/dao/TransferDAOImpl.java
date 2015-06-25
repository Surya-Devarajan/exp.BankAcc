package exp.java.bank.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class TransferDAOImpl implements TransferDAO {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void amountTransfer(Integer myAccountNumber,
			Integer yourAccountNumber, Double amount) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		Double mybalance, yourbalance;
		try {
			Transaction txn = session.beginTransaction();
			Query query = session
					.createQuery("select account.balance from Person where account=:myAccNo");
			query.setInteger("myAccNo", myAccountNumber);
			mybalance = (Double) query.uniqueResult();
			System.out.println(mybalance);
			Query queryYourAcc = session
					.createQuery("select account.balance from Person where account=:yourAccNo");
			queryYourAcc.setInteger("yourAccNo", yourAccountNumber);
			yourbalance = (Double) queryYourAcc.uniqueResult();
			if ((!yourbalance.equals(null)) && (mybalance > amount)) {
				Query queryMyUpdate = session
						.createQuery("update Account set balance=:newBalance where id=:myAccNo");
				queryMyUpdate.setInteger("myAccNo", myAccountNumber);
				queryMyUpdate.setDouble("newBalance", mybalance - amount);
				int statusMyAcc = queryMyUpdate.executeUpdate();
				Query queryYourUpdate = session
						.createQuery("update Account set balance=:newBalance where id=:yourAccNo");
				queryYourUpdate.setInteger("yourAccNo", yourAccountNumber);
				queryYourUpdate.setDouble("newBalance", yourbalance + amount);
				int statusYourAcc =queryYourUpdate.executeUpdate();
				
				if(statusMyAcc==1&&statusYourAcc==1){
					System.out.println("Money has been transferd from "+myAccountNumber+" to "+yourAccountNumber);
				}
			}
			
			/*
			 * // above query can be done like this also.
			 * if(session.get(Account.class, yourAccountNumber) != null){
			 * System.out.println("will enter if Account table has the value");
			 * }
			 */

			txn.commit();
		} catch (HibernateException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			session.close();
		}
		
	}

}
