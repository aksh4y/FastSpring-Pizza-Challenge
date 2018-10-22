package com.fsp.challenge.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Store {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	
	@OneToMany(mappedBy="store", orphanRemoval=true)
	@JsonIgnore
	private List<StoreManager> storeManagers;
	
	public Store() {
		super();
	}
	
	public Store(String name) {
		super();
		this.name = name;
	}
	
	public Store(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
		
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<StoreManager> getStoreManagers() {
		return storeManagers;
	}
	public void setStoreManagers(List<StoreManager> managers) {
		this.storeManagers = managers;
	}
	public void set(Store newStore) {
		this.name = newStore.name != null ?
				newStore.name : this.name; 
		this.storeManagers = newStore.storeManagers != null ?
				newStore.storeManagers : this.storeManagers;
	}
	public void addManager(StoreManager manager) {
		if(storeManagers == null)
			storeManagers = new ArrayList<StoreManager>();
		storeManagers.add(manager);
		manager.setStore(this);
	}
	public void removeManager(StoreManager manager) {
		if(storeManagers == null)
			return;
		storeManagers.remove(manager);
		manager.setStore(null);
	}
}
