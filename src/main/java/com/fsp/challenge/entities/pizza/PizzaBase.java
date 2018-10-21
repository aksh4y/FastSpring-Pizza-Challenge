package com.fsp.challenge.entities.pizza;

public class PizzaBase {

	private int id;
	private int pizzaId;
	private Base base;
	
	public PizzaBase(int pizzaId, Base base) {
		super();
		this.pizzaId = pizzaId;
		this.base = base;
	}

	public PizzaBase(int id, int pizzaId, Base base) {
		super();
		this.id = id;
		this.pizzaId = pizzaId;
		this.base = base;
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

	public Base getBase() {
		return base;
	}

	public void setBase(Base base) {
		this.base = base;
	}
}
