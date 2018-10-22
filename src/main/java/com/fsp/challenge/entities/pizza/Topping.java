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
	private int quantity;
	private double price;
	
	public Topping() {
		super();
	}

	public Topping(String name, double price, int quantity) {
		super();
		this.name = name;
		this.price = price;
	}

	public Topping(int id, String name, double price, int quantity) {
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
	
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public void set(Topping newTopping) {
		this.name = newTopping.name != null ? newTopping.name : this.name;
		this.price = (Double) newTopping.price != null ? newTopping.price : this.price;
		this.quantity = (Integer) newTopping.quantity != null ? newTopping.quantity : this.quantity;
	}
}
