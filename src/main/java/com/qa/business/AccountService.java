package com.qa.business;

import javax.inject.Inject;

import com.qa.business.repository.IAccountRepository;

public class AccountService implements IAccountService {

	@Inject
	private IAccountRepository repo;
	
	public String getAllAccounts() {
		return repo.getAllAccounts();
	}

	public String getAnAccount(Long id) {
		return repo.getanAccount(id);
	}

	public String createAccount(String jsonString) {
		return repo.createAccount(jsonString);
	}

	public String deleteAccount(Long id) {
		return repo.deleteAccount(id);
	}

	public String updateAccount(String jsonString, Long id) {
		return repo.updateAccount(jsonString, id);
	}

}
