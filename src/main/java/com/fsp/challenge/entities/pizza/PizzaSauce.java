package com.fsp.challenge.entities.pizza;

public class PizzaSauce {

	private int id;
	private int pizzaId;
	private Sauce sauce;
	
	public PizzaSauce(int pizzaId, Sauce sauce) {
		super();
		this.pizzaId = pizzaId;
		this.sauce = sauce;
	}

	public PizzaSauce(int id, int pizzaId, Sauce sauce) {
		super();
		this.id = id;
		this.pizzaId = pizzaId;
		this.sauce = sauce;
	}
	
	public int getId() {
		return id;
	}
	
	public int getPizzaId() {
		return pizzaId;
	}

	public void setPizzaId(int pizzaId) {
		this.pizzaId = pizzaId;
	}

	public Sauce getSauce() {
		return sauce;
	}

	public void setSauce(Sauce sauce) {
		this.sauce = sauce;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}