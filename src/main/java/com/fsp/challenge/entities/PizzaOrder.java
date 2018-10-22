package com.fsp.challenge.entities;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fsp.challenge.entities.pizza.Pizza;

@Entity
public class PizzaOrder {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private int storeId;
	private int customerId;
	private int totalPrice;
	
	@OneToMany(mappedBy = "order", orphanRemoval=true)
	@JsonIgnore
	private List<Pizza> pizzas;

	public PizzaOrder() {
		super();
	}
	
	public PizzaOrder(int storeId, int customerId) {
		super();
		this.storeId = storeId;
		this.customerId = customerId;
	}
	
	public PizzaOrder(int storeId, int customerId, int totalPrice) {
		super();
		this.storeId = storeId;
		this.customerId = customerId;
		this.totalPrice = totalPrice;
	}
	
	public PizzaOrder(int storeId, int customerId, int totalPrice, List<Pizza> pizzas) {
		super();
		this.storeId = storeId;
		this.customerId = customerId;
		this.totalPrice = totalPrice;
		this.pizzas = pizzas;
	}
	
	public PizzaOrder(int id, int storeId, int customerId, int totalPrice, List<Pizza> pizzas) {
		super();
		this.id = id;
		this.storeId = storeId;
		this.customerId = customerId;
		this.totalPrice = totalPrice;
		this.pizzas = pizzas;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStoreId() {
		return storeId;
	}

	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public List<Pizza> getPizzas() {
		return pizzas;
	}

	public void setPizzas(List<Pizza> pizzas) {
		this.pizzas = pizzas;
	}
	
	public void set(PizzaOrder newOrder) {
		this.storeId = (Integer) newOrder.storeId != null ? newOrder.storeId : this.storeId;
		this.customerId = (Integer) newOrder.customerId != null ? newOrder.customerId : this.customerId;
		this.totalPrice = (Integer) newOrder.totalPrice != null ? newOrder.totalPrice : this.totalPrice;
		this.pizzas = newOrder.pizzas != null ? newOrder.pizzas : this.pizzas;
	}
}
