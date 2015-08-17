package test;

import static org.junit.Assert.*;
import main.Account;
import main.AccountDBHelper;
import main.Customer;
import main.Transaction;

import org.junit.Test;

public class AccountDBHelperTest
{
	@Test
	public void testHasSaving()
	{
		AccountDBHelper db = new AccountDBHelper();
		assertTrue(db.hasSaving(2));
	}
//	@Test
	public void testAvailablePhone()
	{
		AccountDBHelper db = new AccountDBHelper();
		assertTrue(db.availablePhone("1234567890"));
		assertFalse(db.availablePhone("8325266007"));
	}
//	@Test
	public void testInsertCustomer()
	{
		Customer customer = new Customer();
		customer.setFirst_name("Ken");
		customer.setLast_name("Ngo");
		customer.setPhone_number("8325266007");
		
		AccountDBHelper db = new AccountDBHelper();
		db.insertCustomer(customer);
	}
	
//	@Test
	public void testFindCustomer()
	{
		AccountDBHelper db = new AccountDBHelper();
		Customer customer = db.findCustomerByPhone("8325266007");
		System.out.println(customer.getFirst_name());
	}
	
//	@Test
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
//		System.out.println(account.getName());
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
//		account.setName("Ken");
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
