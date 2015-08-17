package main;

import java.util.ArrayList;

public class Customer
{
	public static final String CUSTOMER_TABLE = "EVIL_CUSTOMER";
	public static final String ID = "ID";
	public static final String FIRST_NAME = "FIRST_NAME";
	public static final String LAST_NAME = "LAST_NAME";
	
	private static ArrayList<Account> customer_accounts = new ArrayList<Account>();
	
	
	//Each customer has first name, last name, and phone number.
	private String first_name;
	private String last_name;
	private String phone_number;
	
	
	public  ArrayList<Account> getCustomer_account() {
		return customer_accounts;
	}
	public static void setCustomer_account(Account customer_account) {
		customer_accounts.add(customer_account);
	}
	
	
	
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	
	
	public String getFirst_name()
	{
		return first_name;
	}
	public void setFirst_name(String first_name)
	{
		this.first_name = first_name;
	}
	
	public String getLast_name()
	{
		return last_name;
	}
	public void setLast_name(String last_name)
	{
		this.last_name = last_name;
	}
	
	
}
