package main;


import java.util.Date;
import java.util.GregorianCalendar;

public class Account
{

	private String account_number;
	private String name;
	private double starting_balance;
	private String birth_date;
	private Date b_date = new Date();
	private set_date set ;

	

	public String getAccount_number() {
		return account_number;
	}
	public void setAccount_number(String account_number) {
		this.account_number = account_number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getStarting_balance() {
		return starting_balance;
	}

	public void setStarting_balance(double starting_balance) {
		this.starting_balance = starting_balance;

	}
	public Date getBirth_date() {
		return b_date;
	}
//	public void setBirth_date(String birth_date) {
//		set = new set_date();
//		set.setDate(birth_date);
//		b_date = new GregorianCalendar(set.getYear(),set.getMonth(),set.getDay()) ;
//	}
	
	public void setBirth_date(Date birth_date)
	{
		b_date = birth_date;
	}
	
	
}
