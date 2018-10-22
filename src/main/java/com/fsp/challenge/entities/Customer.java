package com.fsp.challenge.entities;

import java.sql.Date;

import javax.persistence.Entity;

@Entity
public class Customer extends Person {
	
	public Customer() {
		super();
	}
	
	public Customer(String firstName, String lastName, String username, String password, String email,
			Date dob) {
		super(firstName, lastName, username, password, email, dob);
	}

	public void set(Customer newCustomer) {
		super.set(newCustomer);
	}
}
