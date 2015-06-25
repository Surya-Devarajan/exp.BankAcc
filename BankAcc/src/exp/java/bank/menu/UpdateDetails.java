package exp.java.bank.menu;

import java.util.Scanner;

import exp.java.bank.dao.EditDetailsDAO;
import exp.java.bank.model.Person;


public class UpdateDetails {
	public void updatePersonDetails(EditDetailsDAO editDetailsDAO){
		int accNumber;
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the account number for updating account.");
		accNumber = scan.nextInt();
		System.out.println(".....");
		editDetailsDAO.updateDetails(accNumber);
		
		//disply details probvided accno
		//get details
		//update it
	}
}
