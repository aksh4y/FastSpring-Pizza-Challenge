package com.fsp.challenge.entities.pizza;

import java.util.ArrayList;
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
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fsp.challenge.entities.PizzaOrder;

@Entity
public class Pizza {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="BASE_ID")
	private Base base;
	@OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="SAUCE_ID")
	private Sauce sauce;
	@OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="CHEESE_ID")
	private Cheese cheese;
	@OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="SIZE_ID")
	private Size size;
	private double price;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="pizza_order_id")
	@JsonIgnore
	private PizzaOrder order;

	@ManyToMany(cascade = {CascadeType.ALL})
	@JoinTable(name="pizza_toppings",
	joinColumns=@JoinColumn(name="PIZZA_ID", referencedColumnName="id"),
	inverseJoinColumns=@JoinColumn(name="TOPPING_ID", referencedColumnName="id"))
	@JsonIgnore
	List<Topping> toppings;

	public Pizza() {
		super();
	}
	public Pizza(Size size, Base base, Cheese cheese, Sauce sauce) {
		super();
		this.size = size;
		this.base = base;
		this.cheese = cheese;
		this.sauce = sauce;
		calculatePrice();
	}
	public Pizza(int id, Size size, Base base, Cheese cheese, Sauce sauce) {
		super();
		this.id = id;
		this.size = size;
		this.base = base;
		this.cheese = cheese;
		this.sauce = sauce;
		calculatePrice();
	}
	public Pizza(Size size, Base base, Cheese cheese, Sauce sauce, List<Topping> toppings) {
		super();
		this.size = size;
		this.base = base;
		this.cheese = cheese;
		this.sauce = sauce;
		this.toppings = toppings;
		calculatePrice();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Base getBase() {
		return base;
	}
	public void setBase(Base base) {
		this.base = base;
		calculatePrice();
	}
	public Sauce getSauce() {
		return sauce;
	}
	public void setSauce(Sauce sauce) {
		this.sauce = sauce;
		calculatePrice();
	}
	public Cheese getCheese() {
		return cheese;
	}
	public void setCheese(Cheese cheese) {
		this.cheese = cheese;
		calculatePrice();
	}
	public Size getSize() {
		return size;
	}
	public void setSize(Size size) {
		this.size = size;
		calculatePrice();
	}
	public PizzaOrder getOrder() {
		return order;
	}

	public void setOrder(PizzaOrder order) {
		this.order = order;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	public List<Topping> getToppings() {
		return toppings;
	}

	public void setToppings(List<Topping> toppings) {
		this.toppings = toppings;
		calculatePrice();
	}
	public void calculatePrice() {
		price = size.getPrice() + base.getPrice() + cheese.getPrice() + sauce.getPrice();
		if(toppings != null)
			for(Topping t : toppings)
				price += t.getPrice();
	}
	
	public void set(Pizza newPizza) {
		this.order = newPizza.order != null? newPizza.order : this.order;
		this.size = newPizza.size != null ? newPizza.size : this.size;
		this.base = newPizza.base != null ? newPizza.base : this.base;
		this.cheese = newPizza.cheese != null ? newPizza.cheese : this.cheese;
		this.sauce = newPizza.sauce != null ? newPizza.sauce : this.sauce;
		this.toppings = newPizza.toppings != null ? newPizza.toppings : this.toppings;
		calculatePrice();
	}
	public void addTopping(Topping topping) {
		if(toppings == null)
			toppings = new ArrayList<Topping>();
		toppings.add(topping);	
		calculatePrice();
	}
}
