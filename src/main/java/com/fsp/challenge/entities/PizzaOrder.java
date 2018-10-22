package com.fsp.challenge.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fsp.challenge.entities.pizza.Pizza;

@Entity
public class PizzaOrder {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@OneToOne
    @JoinColumn(name="STORE_ID")
	private Store store;
	@OneToOne
    @JoinColumn(name="CUSTOMER_ID")
	private Customer customer;
	private double totalPrice;
	
	@OneToMany(mappedBy = "order", orphanRemoval=true)
	private List<Pizza> pizzas;

	public PizzaOrder() {
		super();
	}
	
	public PizzaOrder(Store store, Customer customer) {
		super();
		this.store = store;
		this.customer = customer;
	}
	
	public PizzaOrder(Store store, Customer customer, double totalPrice) {
		super();
		this.store = store;
		this.customer = customer;
		this.totalPrice = totalPrice;
	}
	
	public PizzaOrder(Store store, Customer customer, double totalPrice, List<Pizza> pizzas) {
		super();
		this.store = store;
		this.customer = customer;
		this.totalPrice = totalPrice;
		this.pizzas = pizzas;
	}
	
	public PizzaOrder(int id, Store store, Customer customer, double totalPrice, List<Pizza> pizzas) {
		super();
		this.id = id;
		this.store = store;
		this.customer = customer;
		this.totalPrice = totalPrice;
		this.pizzas = pizzas;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public List<Pizza> getPizzas() {
		return pizzas;
	}

	public void setPizzas(List<Pizza> pizzas) {
		this.pizzas = pizzas;
		calculatePrice();
	}
	
	public void addPizza(Pizza pizza) {
		if(pizzas == null)
			pizzas = new ArrayList<Pizza>();
		pizza.setOrder(this);
		pizzas.add(pizza);
		calculatePrice();
	}
	
	public void calculatePrice() {
		if(pizzas != null) {
			totalPrice = 0;
			for(Pizza p : pizzas)
				totalPrice += p.getPrice();
		}
		else 
			totalPrice = 0;
	}
	
	public void set(PizzaOrder newOrder) {
		this.store = newOrder.store != null ? newOrder.store : this.store;
		this.customer = newOrder.customer != null ? newOrder.customer : this.customer;
		this.totalPrice = (Double) newOrder.totalPrice != null ? newOrder.totalPrice : this.totalPrice;
		this.pizzas = newOrder.pizzas != null ? newOrder.pizzas : this.pizzas;
		calculatePrice();
	}
}
