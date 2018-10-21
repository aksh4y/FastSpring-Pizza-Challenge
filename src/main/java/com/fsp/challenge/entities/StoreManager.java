package com.fsp.challenge.entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class StoreManager extends Person {

	private int personId;
	private String managerKey;
	
	@ManyToOne()
	@JsonIgnore
	private Store store;

	public StoreManager() {
		super();
	}

	
	public StoreManager(int personId, String firstName, String lastName, String username, String password, String email,
			Date dob, String managerKey) {
		super(personId, firstName, lastName, username, password, email, dob);
		this.personId = personId;
		this.managerKey = managerKey;
	}
	
	public StoreManager(String firstName, String lastName, String username, String password, String email,
			Date dob, String managerKey) {
		super(firstName, lastName, username, password, email, dob);
		this.managerKey = managerKey;
	}

	public int getPersonId() {
		return personId;
	}
	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public String getManagerKey() {
		return managerKey;
	}

	public void setManagerKey(String managerKey) {
		this.managerKey = managerKey;
	}
	
	public Store getStore() {
		return store;
	}
	
	public void setStore(Store store) {
		this.store = store;
	}	
	
	public void set(StoreManager newManager) {
		super.set(newManager);
		this.managerKey = newManager.managerKey !=null ? 
				newManager.managerKey : this.managerKey;
	}
}
