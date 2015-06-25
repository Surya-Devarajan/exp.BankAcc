/**
 * 
 */
package exp.java.bank.dao;

import java.util.List;

import exp.java.bank.model.Person;

/**
 * @author Vishnu
 *
 */
public interface PersonDAO {
	public List<Person> accountList();

	public Person myAccountDetails(int i);

	

	
}
