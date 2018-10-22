package com.fsp.challenge.daos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fsp.challenge.entities.pizza.Base;
import com.fsp.challenge.entities.pizza.Cheese;
import com.fsp.challenge.entities.pizza.Pizza;
import com.fsp.challenge.entities.pizza.Sauce;
import com.fsp.challenge.entities.pizza.Size;
import com.fsp.challenge.entities.pizza.Topping;
import com.fsp.challenge.repositories.BaseRepository;
import com.fsp.challenge.repositories.CheeseRepository;
import com.fsp.challenge.repositories.PizzaRepository;
import com.fsp.challenge.repositories.SauceRepository;
import com.fsp.challenge.repositories.SizeRepository;
import com.fsp.challenge.repositories.ToppingRepository;


@RestController
public class PizzaDao {
	@Autowired
	PizzaRepository pizzaRepository;
	@Autowired
	BaseRepository baseRepository;
	@Autowired
	SizeRepository sizeRepository;
	@Autowired
	CheeseRepository cheeseRepository;
	@Autowired
	SauceRepository sauceRepository;
	@Autowired
	ToppingRepository toppingRepository;

	@PostMapping("/api/pizza")
	public Pizza createPizza(@RequestBody Pizza pizza) {
		return pizzaRepository.save(pizza);
	}

	@GetMapping("/api/pizza")
	public Iterable<Pizza> findAllPizzas() {
		return pizzaRepository.findAll();
	}

	@GetMapping("/api/pizza/{pizzaId}")
	public Pizza findPizzaById(
			@PathVariable("pizzaId") int id) {
		return pizzaRepository.findOne(id);
	}

	@PutMapping("/api/pizza/{pizzaId}")
	public Pizza updatePizza(
			@PathVariable("pizzaId") int id,
			@RequestBody Pizza newPizza) {
		Pizza pizza = pizzaRepository.findOne(id);
		pizza.set(newPizza);
		return pizzaRepository.save(pizza);
	}

	// size
	@PutMapping("/api/pizza/{pizzaId}/size/{sizeId}")
	public Pizza addPizzaSize(
			@PathVariable("pizzaId") int id,
			@PathVariable("sizeId") int sId) {
		Pizza pizza = pizzaRepository.findOne(id);
		Size size = sizeRepository.findOne(sId);
		int quantity = size.getQuantity();
		if(quantity > 0) {
			pizza.setSize(size);
			size.setQuantity(quantity-1);
			sizeRepository.save(size);
		}
		return pizzaRepository.save(pizza);
	}

	// cheese
	@PutMapping("/api/pizza/{pizzaId}/cheese/{cheeseId}")
	public Pizza addPizzaCheese(
			@PathVariable("pizzaId") int id,
			@PathVariable("cheeseId") int cId) {
		Pizza pizza = pizzaRepository.findOne(id);
		Cheese cheese = cheeseRepository.findOne(cId);
		int quantity = cheese.getQuantity();
		if(quantity > 0) {
			pizza.setCheese(cheese);
			cheese.setQuantity(quantity-1);
			cheeseRepository.save(cheese);
		}
		return pizzaRepository.save(pizza);
	}

	// base
	@PutMapping("/api/pizza/{pizzaId}/base/{baseId}")
	public Pizza addPizzaBase(
			@PathVariable("pizzaId") int id,
			@PathVariable("baseId") int bId) {
		Pizza pizza = pizzaRepository.findOne(id);
		Base base = baseRepository.findOne(bId);
		int quantity = base.getQuantity();
		if(quantity > 0) {
			pizza.setBase(base);
			base.setQuantity(quantity-1);
			baseRepository.save(base);
		}
		return pizzaRepository.save(pizza);
	}
	
	//sauce
	@PutMapping("/api/pizza/{pizzaId}/sauce/{sauceId}")
	public Pizza addPizzaSauce(
			@PathVariable("pizzaId") int id,
			@PathVariable("sauceId") int sId) {
		Pizza pizza = pizzaRepository.findOne(id);
		Sauce sauce = sauceRepository.findOne(sId);
		int quantity = sauce.getQuantity();
		if(quantity > 0) {
			pizza.setSauce(sauce);
			sauce.setQuantity(quantity-1);
			sauceRepository.save(sauce);
		}
		return pizzaRepository.save(pizza);
	}
	
	//topping
	@PutMapping("/api/pizza/{pizzaId}/topping/{toppingId}")
	public Pizza addPizzaTopping(
			@PathVariable("pizzaId") int id,
			@PathVariable("toppingId") int tId) {
		Pizza pizza = pizzaRepository.findOne(id);
		Topping topping = toppingRepository.findOne(tId);
		int quantity = topping.getQuantity();
		if(quantity > 0) {
			pizza.addTopping(topping);
			topping.setQuantity(quantity-1);
			toppingRepository.save(topping);
		}
		return pizzaRepository.save(pizza);
	}

	@DeleteMapping("/api/pizza/{pizzaId}")
	public void deletePizza
	(@PathVariable("pizzaId") int id) {
		pizzaRepository.delete(id);
	}

	/*public void test() {
		// Delete all pizzas
		List<Pizza> pizzas = (List<Pizza>) findAllPizzas();
		for(Pizza pizza : pizzas) {
			deletePizza(pizza.getId());
		}
	}*/
}
