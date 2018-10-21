package com.fsp.challenge.entities.pizza;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Sauce {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String name;
	private int price;
	
	public Sauce() {
		super();
	}

	public Sauce(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}

	public Sauce(int id, String name, int price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	public void set(Sauce newSauce) {
		this.name = newSauce.name != null ? newSauce.name : this.name;
		this.price = (Integer) newSauce.price != null ? newSauce.price : this.price;
	}
}
