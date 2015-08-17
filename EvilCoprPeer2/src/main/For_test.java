package main;

import static org.junit.Assert.*;

import org.junit.Test;

public class For_test {
	@Test
	public void test_customer(){
		
		Customer  customer = new Customer();
		customer.setFirst_name("Ahmed");
		customer.setLast_name("Hameed");
		
		customer.setPhone_number("7206201389");
		
		
		Account account = new Account();
		Transaction transaction = new Transaction();
		
		account.setAccount_number("10115");
		account.setStarting_balance(1000);
		
		transaction.setTransaction_type_id(1);
		transaction.setAmount(100);
		
		
		account.setTransaction(transaction);
		customer.setCustomer_account(account);
		
		transaction.process_transaction(account);
		assertTrue(! account.getTransaction().get(1). < 1000);
		//assertTrue(customer.getCustomer_account().isEmpty());
//		customer.setFirst_name("King");
//		customer.setLast_name("Kung");
//		
//		customer.setPhone_number("0123456789");
//		
//	
//		account.setAccount_number("10116");
//		account.setStarting_balance(1200);
//		
//		transaction.setTransaction_type_id(2);
//		transaction.setAmount(100);
	
	}
	
	
}
