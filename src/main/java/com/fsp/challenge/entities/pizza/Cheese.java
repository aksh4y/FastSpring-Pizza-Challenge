package com.fsp.challenge.entities.pizza;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cheese {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String name;
	private int price;
	
	public Cheese() {
		super();
	}

	public Cheese(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}

	public Cheese(int id, String name, int price) {
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
	
	public void set(Cheese newCheese) {
		this.name = newCheese.name != null ? newCheese.name : this.name;
		this.price = (Integer) newCheese.price != null ? newCheese.price : this.price;
	}
}
