package com.fsp.challenge.entities;

import java.sql.Date;

import javax.persistence.Entity;

@Entity
public class Customer extends Person {

	private int personId;

	public Customer() {
		super();
	}
	
	public Customer(int personId, String firstName, String lastName, String username, String password, String email,
			Date dob) {
		super(personId, firstName, lastName, username, password, email, dob);
		this.personId = personId;
	}
	
	public Customer(String firstName, String lastName, String username, String password, String email,
			Date dob) {
		super(firstName, lastName, username, password, email, dob);
		
	}

	public int getPersonId() {
		return personId;
	}
	public void setPersonId(int personId) {
		this.personId = personId;
	}
	
	public void set(Customer newCustomer) {
		super.set(newCustomer);
	}
}
