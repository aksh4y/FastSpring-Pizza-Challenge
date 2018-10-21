package com.fsp.challenge.daos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.fsp.challenge.entities.pizza.Pizza;
import com.fsp.challenge.repositories.PizzaRepository;


@RestController
public class PizzaDao {
	@Autowired
	PizzaRepository pizzaRepository;

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
