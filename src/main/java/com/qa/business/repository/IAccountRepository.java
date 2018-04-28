package com.qa.business.repository;

public interface IAccountRepository {
		
		String getAllAccounts();
		
		String getanAccount(Long id);
		
		String updateAccount(String jsonString, Long id);
		
		String deleteAccount(Long id);
		
		String createAccount(String jsonString);
	
}



