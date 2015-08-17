package main;


import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

public class Account
{
	//Each customer has transactions and accounts of both checkings and savings.
		private static ArrayList<Transaction> transactions = new ArrayList<Transaction>();

		private Account_type account_type = new Account_type();
		
		private String account_number;
		private double starting_balance;
		
		
		
		
		public ArrayList<Transaction> getTransaction() {
			return transactions;
		}
		public static void setTransaction(Transaction transaction) {
			transactions.add(transaction);
		}
		
		
		public String getAccount_number() {
			return account_number;
		}
		public void setAccount_number(String account_number) {
			this.account_number = account_number;
		}
		
		
		public double getStarting_balance() {
			return starting_balance;
		}
		public void setStarting_balance(double starting_balance) {
			this.starting_balance = starting_balance;
		}	

}
