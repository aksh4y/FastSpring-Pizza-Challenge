package com.fsp.challenge.entities;

import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import com.fsp.challenge.entities.Store;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class StoreManager extends Person {

	private String managerKey;
	
	@ManyToOne()
	@JoinColumn(name="store_id")
	@JsonIgnore
	private Store store;

	public StoreManager() {
		super();
	}
		
	public StoreManager(String firstName, String lastName, String username, String password, String email,
			Date dob, String managerKey) {
		super(firstName, lastName, username, password, email, dob);
		this.managerKey = managerKey;
	}

	public int geId() {
		return super.getId();
	}
	public void setId(int id) {
		super.setId(id);
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
		this.store = newManager.store !=null ? 
				newManager.store : this.store;
	}
}
