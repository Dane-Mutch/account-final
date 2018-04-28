package com.qa.persistence;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Account {
	
	@Id @GeneratedValue
	private Long id;
	
	private String firstName;
	
	private String secondName;
	
	private String addressLine1;
	
	private String addressLine2;
	
	private int accountBalance;
	
	public Account() {
		
	}
	
	public Account(String firstName, String secondName, String addressLine1, String addressLine2, int accountBalance) {
	
		this.firstName = firstName;
		this.secondName = secondName;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.accountBalance = accountBalance;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getSecondName() {
		return secondName;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}
	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	public String getAddressLine2() {
		return addressLine2;
	}
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	public int getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(int accountBalance) {
		this.accountBalance = accountBalance;
	}
	public Long getId() {
		return id;
	}
	
	

}
