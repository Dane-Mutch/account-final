package com.qa.business;

public interface IAccountService {
	
	String getAllAccounts();
	
	String getAnAccount(Long id);
	
	String createAccount(String jsonString);
	
	String deleteAccount(Long id);
	
	String updateAccount(String jsonString, Long id);

}
