package main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
public class Evil_corp_app {
	public static void main(String [] args){
		
		Scanner key = new Scanner(System.in);
		Validator val = new Validator();
		
		//Initializing parameters for account class

		String account_number;
		String name;
		String starting_balance;
		String birth_date;
		
		//Initializing parameters for transaction class.
		

		//private String account_number;
		String transaction_type_id="";
		String amount="";
		String transaction_date = "";
		
		//Operator + for deposit, - for other transaction.
		String operator;
		
		
		//Add account information into the database.
		AccountDBHelper all_in_sql = new AccountDBHelper();
		
		
		
		System.out.println("Welcome to Evil Corp bank Accounts");
		
		while(true)
		{

			Account account = new Account();
			//Entering account number or -1 to exit.
			System.out.println("Enter account number or -1 to exit entering account: ");
			account_number = key.next();
			key.nextLine();
		
			if(account_number.equalsIgnoreCase("-1")){break;}
			
			//Increment ID by one for each account added.
			

			account.setAccount_number(account_number);
	
			//Enter the account name.
			
			System.out.println("Enter the account name : ");
			name = key.next();
			key.nextLine();
			
			account.setName(name);
			
			//Enter Starting balance.
			System.out.println("Enter the starting balance : ");
			starting_balance = key.next();
			key.nextLine();
			balance_loop:
				while(true)
				{
					if(val.validateIntWithRange(starting_balance, 1, 1000000))
					{
						break balance_loop;
					}
					else
					{
						System.out.println("Invalid account number, try again.");
						System.out.println("Enter the starting balance : ");
						starting_balance = key.next();
						key.nextLine();
					}
				}
	
			account.setStarting_balance(Double.parseDouble(starting_balance));
			
			//Enter birth date as the format "mm/dd/yyyy", no other formats accepted.
			System.out.println("Enter the date of birth : ");
			birth_date = key.next();
			key.nextLine();
			
			date_loop:
				while(true){
					if(val.validateDateWithFormat(birth_date))
					{
						break date_loop;
					}
					else
					{
						System.out.println("Invalid date, try again.");
						System.out.println("Enter the date of birth : format(mm/dd/yyyy)");
						birth_date = key.next();
						key.nextLine();
					}
				
				}
			
			//mm/dd/yyyy
			SimpleDateFormat sdf = new SimpleDateFormat("mm/dd/yyyy");
			try
			{
				account.setBirth_date(sdf.parse(birth_date));
			} catch (ParseException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//System.out.println(account.getAccount_number());
			all_in_sql.insertAccount(account);
		}
		
		
		System.out.println("Welcome to Evil Corp bank Transactions");

		transaction_loop:
		while(true)
		{
			System.out.println("Enter account number or -1 to exit transactions: ");
			account_number = key.next();
			key.nextLine();
			
			if(account_number.equalsIgnoreCase("-1"))
			{
				break transaction_loop;
			}
			
			
			//Look for the account number and see if that in the database.
			
			boolean hasAccount = false;
			while(!hasAccount)
			{
				if(account_number.equalsIgnoreCase("-1"))
				{
					break transaction_loop;
				}
				
				Account account = all_in_sql.getAccountFromNumber(account_number);
				
				if(account.getAccount_number() != null)
				{
					hasAccount = true;
				}
				else
				{
					System.out.println("Account not found! Please try again");
					System.out.println("Enter account number or -1 to exit transactions: ");
					account_number = key.next();
					key.nextLine();
				}
			}

			
			boolean validType = false;
			while(!validType)
			{
				System.out.println("Enter the transaction type: \n"
						+ "1 - Deposite.\n"
						+ "2 - Check.\n"
						+ "3 - Withdrawal.\n"
						+ "4 - Debit Card.");
				transaction_type_id = key.next();
				key.nextLine();
				validType = val.validateIntWithRange(transaction_type_id, 1, 4);
				
				if(!validType)
				{
					System.out.println("Invalid type, please try again!");
				}
			}
			
			Transaction transaction = new Transaction();
			
			//
			transaction.setAccount_number(account_number);
			//set tran type id
			transaction.setTransaction_type_id(Integer.parseInt(transaction_type_id));
			
			validType = false;
			while(!validType)
			{
				System.out.println("Enter Transaction amount: ");
				
				amount = key.next();
				key.nextLine();
				validType = val.validateDoubleWithRange(amount, 0, 10000000);
				
				if(!validType)
				{
					System.out.println("Invalid amount, please try again! (from 0 to 10000000)");
				}
			}
			
			//set tran amount
			transaction.setAmount(Double.parseDouble(amount));
			
			
			validType = false;
			while(!validType)
			{
				System.out.println("Enter Transaction date: (MM/DD/YYYY)");
				transaction_date =  key.next();
				key.nextLine();
				validType = val.validateDateWithFormat(transaction_date);
				if (!validType){
					System.out.println("Invalid date, try insert date (MM/DD/YYYY): ");
				}

			}
		
			SimpleDateFormat sdf = new SimpleDateFormat("mm/dd/yyyy");
			
			try
			{
				transaction.setTransaction_date(sdf.parse(transaction_date));
			} catch (ParseException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//transaction.process_transaction(account);
			
			all_in_sql.addTransaction(transaction);
		
		
		
					
			//Process transaction.
			


		}
	
	}
}

