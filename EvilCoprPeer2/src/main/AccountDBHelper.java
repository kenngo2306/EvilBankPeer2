package main;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AccountDBHelper
{
	private static final String ACCOUNT_TABLE = "Evil_Account";
	private static final String ID = "ID";
	private static final String ACCOUNT_NUMBER = "ACCOUNT_NUMBER";
	private static final String NAME = "NAME";
	private static final String STARTING_BALANCE = "STARTING_BALANCE";
	private static final String BIRTH_DATE = "BIRTH_DATE";
	
	private static final String TRANSACTION_TABLE = "Evil_Transactions";

	private static final String TRANSACTION_TYPE_ID = "TRANSACTION_TYPE_ID";
	private static final String TRANSACTION_DATE = "TRANSACTION_DATE";
	private static final String AMOUNT = "AMOUNT";
	
	public void updateBalance(Account account)
	{
		String sql = "UPDATE " + ACCOUNT_TABLE + " SET " + STARTING_BALANCE + " = " + account.getStarting_balance()
				+ " WHERE " + ACCOUNT_NUMBER + "= '"+ account.getAccount_number() + "'" ;
		System.out.println(sql);
		try
		{
			Statement stmt = getConnection().createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void deleteAccount(String account_number)
	{
		String sql = "DELETE FROM " + ACCOUNT_TABLE + " WHERE account_number = '" + account_number +"'";
		try
		{
			Statement stmt = getConnection().createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public  ArrayList<Account> getAllAccounts()
	{
		ArrayList<Account> accounts = new ArrayList<Account>();

        String sql = "select * from " + ACCOUNT_TABLE;

        //creating PreparedStatement object to execute query
        ResultSet result = selectSQL(sql);
        try
        {
        	 while(result.next())
             {
             	Account account = new Account();
             	account.setAccount_number(result.getString("account_number"));
     
             	account.setBirth_date(result.getDate("birth_date"));
             	account.setName(result.getString("name"));
             	account.setStarting_balance(result.getDouble("starting_balance"));
       	
             	//TODO add fields for accounts
             	accounts.add(account);
             }
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        }
       
		
		return accounts;
	}
	
	public void addTransaction(Transaction transaction)
	{
		//insert transaction
		String insertTransaction = "INSERT INTO " + TRANSACTION_TABLE + 
				"( " +
				" " + ACCOUNT_NUMBER + ", " +
				" " + TRANSACTION_TYPE_ID + ", " +
				" " + TRANSACTION_DATE + ", " +
				" " + AMOUNT +
				" ) VALUES  " +
				"(?,?,?,?)";
		System.out.println(insertTransaction);
		
		try
		{
			java.util.Date utilDate = transaction.getTransaction_date();
		    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		    
			PreparedStatement prepareStatement = getConnection().prepareStatement(insertTransaction);
			
			prepareStatement.setString(1, transaction.getAccount_number());
			prepareStatement.setInt(2, transaction.getTransaction_type_id());
			prepareStatement.setDate(3, sqlDate);
			prepareStatement.setDouble(4,transaction.getAmount());
			
			prepareStatement.executeUpdate();
		} 
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//update balance
		Account account = getAccountFromNumber(transaction.getAccount_number());
		
		//TODO update balance
		
			
	}
	
	
	public Account getAccountFromNumber(String accountNumber)
	{
		Account account = new Account();
		String sql = "SELECT * FROM " + ACCOUNT_TABLE + " WHERE account_number = '" + accountNumber + "'";
//		String sql = "SELECT * FROM " + ACCOUNT_TABLE;
		System.out.println(sql);
		ResultSet result = selectSQL(sql);
		try
		{
			while(result.next())
			{
             	account.setAccount_number(result.getString("account_number"));
             	account.setBirth_date(result.getDate("birth_date"));
             	account.setName(result.getString("name"));
             	account.setStarting_balance(result.getDouble("starting_balance"));
			}
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return account;
	}
	
	public void insertAccount(Account account)
	{
		String insertAccount = "INSERT INTO " + ACCOUNT_TABLE + 
				"( "+
				" " + ACCOUNT_NUMBER + ", " +
				" " + NAME + ", " +
				" " + STARTING_BALANCE + ", " +
				" " + BIRTH_DATE +
				" ) VALUES  " +
				"(?,?,?,?)";
		System.out.println(insertAccount);
		try
		{
			java.util.Date utilDate = account.getBirth_date();
		    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
			PreparedStatement prepareStatement = getConnection().prepareStatement(insertAccount);
			prepareStatement.setString(1, account.getAccount_number());
			prepareStatement.setString(2, account.getName());
			prepareStatement.setDouble(3, account.getStarting_balance());
			prepareStatement.setDate(4,sqlDate);
			
			prepareStatement.executeUpdate();
		} 
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Connection getConnection()
	{
		Connection conn = null;
		try
		{
			conn =  DBConnection.getConnection();
		} 
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	public ResultSet selectSQL(String sql)
	{
		Connection conn = null;
		ResultSet result = null;
		try
		{
			conn =  DBConnection.getConnection();
			PreparedStatement preStatement = conn.prepareStatement(sql);
			result = preStatement.executeQuery();
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}
