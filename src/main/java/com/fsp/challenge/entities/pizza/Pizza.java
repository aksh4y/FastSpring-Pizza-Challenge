package com.fsp.challenge.entities.pizza;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fsp.challenge.entities.Order;

@Entity
public class Pizza {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private int baseId;
	private int sauceId;
	private int cheeseId;
	private int sizeId;
	private int price;

	@ManyToOne()
	@JsonIgnore
	private Order order;

	@ManyToMany(cascade = {CascadeType.ALL})
	@JoinTable(name="pizza_toppings",
	joinColumns=@JoinColumn(name="PIZZA_ID", referencedColumnName="id"),
	inverseJoinColumns=@JoinColumn(name="TOPPING_ID", referencedColumnName="id"))
	@JsonIgnore
	List<Topping> toppings;

	public Pizza() {
		super();
	}
	public Pizza(int size, int base, int cheese, int sauce) {
		super();
		this.sizeId = size;
		this.baseId = base;
		this.cheeseId = cheese;
		this.sauceId = sauce;
	}
	public Pizza(int id, int size, int base, int cheese, int sauce) {
		super();
		this.id = id;
		this.sizeId = size;
		this.baseId = base;
		this.cheeseId = cheese;
		this.sauceId = sauce;
	}
	public Pizza(int size, int base, int cheese, int sauce, List<Topping> toppings) {
		super();
		this.sizeId = size;
		this.baseId = base;
		this.cheeseId = cheese;
		this.sauceId = sauce;
		this.toppings = toppings;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBaseId() {
		return baseId;
	}
	public void setBaseId(int baseId) {
		this.baseId = baseId;
	}
	public int getSauceId() {
		return sauceId;
	}

	public void setSauceId(int sauceId) {
		this.sauceId = sauceId;
	}

	public int getCheeseId() {
		return cheeseId;
	}

	public void setCheeseId(int cheeseId) {
		this.cheeseId = cheeseId;
	}

	public int getSizeId() {
		return sizeId;
	}

	public void setSizeId(int sizeId) {
		this.sizeId = sizeId;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	public List<Topping> getToppings() {
		return toppings;
	}

	public void setToppings(List<Topping> toppings) {
		this.toppings = toppings;
	}
	public void set(Pizza newPizza) {
		this.sizeId = (Integer) newPizza.sizeId != null ? newPizza.sizeId : this.sizeId;
		this.baseId = (Integer) newPizza.baseId != null ? newPizza.baseId : this.baseId;
		this.cheeseId = (Integer) newPizza.cheeseId != null ? newPizza.cheeseId : this.cheeseId;
		this.sauceId = (Integer) newPizza.sauceId != null ? newPizza.sauceId : this.sauceId;
		this.toppings = newPizza.toppings != null ? newPizza.toppings : this.toppings;
	}

}
