package test;

import static org.junit.Assert.*;
import main.Account;
import main.AccountDBHelper;
import main.Transaction;

import org.junit.Test;

public class AccountDBHelperTest
{

	@Test
	public void testGetAllAccounts()
	{
		AccountDBHelper accountDBHelper = new AccountDBHelper();
		accountDBHelper.deleteAccount("111");
	}
//
//	@Test
	public void testGetAccountFromNumber()
	{
		String accountNumber = "11121";
		AccountDBHelper accountDBHelper = new AccountDBHelper();
		Account account = accountDBHelper.getAccountFromNumber(accountNumber);
		System.out.println(account.getName());
	}
	
	//@Test
	public void testUpdateBalance()
	{
		Account account = new Account();
		account.setAccount_number("11121");
		account.setStarting_balance(200);
		
		AccountDBHelper accountDBHelper = new AccountDBHelper();
		accountDBHelper.updateBalance(account);
	}

//	@Test
	public void testInsertAccount()
	{
		Account account = new Account();

		account.setAccount_number("11121");
		account.setName("Ken");
		account.setStarting_balance(1000);
		AccountDBHelper accountDBHelper = new AccountDBHelper();
		accountDBHelper.insertAccount(account);
	}

//	@Test
	public void testAddTransaction()
	{
		Transaction transaction = new Transaction();
		transaction.setAccount_number("11121");
		transaction.setAmount(2000.0);
		transaction.setTransaction_type_id(1);
		
		AccountDBHelper accountDBHelper = new AccountDBHelper();
		accountDBHelper.addTransaction(transaction);
	}


}
