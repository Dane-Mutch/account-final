package com.qa.business.repository;

import static javax.transaction.Transactional.TxType.*;

import java.util.Collection;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;

import com.qa.persistence.Account;
import com.qa.util.JSONUtil;

@Default
@Transactional(SUPPORTS)
public class AccountDBRepository implements IAccountRepository {
	
private static final Logger LOGGER = Logger.getLogger(AccountDBRepository.class);
	
	@PersistenceContext(unitName="primary")
	private EntityManager em;
	
	@Inject
	private JSONUtil util;

	public String getAllAccounts() {
		Query query = em.createQuery("SELECT a FROM Account a");
		Collection <Account> accounts = (Collection<Account>) query.getResultList();
		return util.getJSONForObject(accounts); 
	}
	
	public String getanAccount(Long id) {
		Account accountToDisplay = em.find(Account.class, id);
		if (accountToDisplay != null) {
			return util.getJSONForObject(accountToDisplay);
			} else {
				return "{\"response\":\"account not found\"}";
	}
	}

	@Transactional(REQUIRED)
	public String updateAccount(String jsonString, Long id) {
		Account accountToUpdate = em.find(Account.class, id);
		Account updatedAccount = util.getObjectForJSON(jsonString, Account.class);
		updatedAccount.setId(id);
		if (accountToUpdate != null) {
			updatedAccount.setId(id);
			em.merge(updatedAccount);
		return "{\"response\":\"account successfully updated\"}";
		} else {
			return "{\"response\":\"account not found\"}";
		}
	}

	@Transactional(REQUIRED)
	public String deleteAccount(Long id) {
		Account accountToDelete = em.find(Account.class, id);
		if (accountToDelete != null) {
			em.remove(accountToDelete);
			return "{\"response\":\"account successfully deleted\"}";
		} else {
		return "{\"response\":\"account not found\"}";
	}
	}
	
	@Transactional(REQUIRED)
	public String createAccount(String jsonString) {
		em.persist(util.getObjectForJSON(jsonString, Account.class));
		return "{\"response\":\"account successfully added\"}";
	}

}
