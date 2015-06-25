/**
 * 
 */
package exp.java.bank.dao;

import exp.java.bank.model.Account;
import exp.java.bank.model.Person;

public interface AccountDAO {
	public void save(Account ac, Person p);
	public void deposit(int acc,double balance);
}
