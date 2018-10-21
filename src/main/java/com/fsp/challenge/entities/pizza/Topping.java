package com.fsp.challenge.entities.pizza;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Topping {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String name;
	private int price;
	
	public Topping() {
		super();
	}

	public Topping(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}

	public Topping(int id, String name, int price) {
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
	
	public void set(Topping newTopping) {
		this.name = newTopping.name != null ? newTopping.name : this.name;
		this.price = (Integer) newTopping.price != null ? newTopping.price : this.price;
	}
}
