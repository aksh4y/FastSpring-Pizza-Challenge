package com.fsp.challenge.entities.pizza;

public class PizzaCheese {

	private int id;
	private int pizzaId;
	private Cheese cheese;
	
	public PizzaCheese(int pizzaId, Cheese cheese) {
		super();
		this.pizzaId = pizzaId;
		this.cheese = cheese;
	}

	public PizzaCheese(int id, int pizzaId, Cheese cheese) {
		super();
		this.id = id;
		this.pizzaId = pizzaId;
		this.cheese = cheese;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPizzaId() {
		return pizzaId;
	}

	public void setPizzaId(int pizzaId) {
		this.pizzaId = pizzaId;
	}

	public Cheese getCheese() {
		return cheese;
	}

	public void setCheese(Cheese cheese) {
		this.cheese = cheese;
	}
}
