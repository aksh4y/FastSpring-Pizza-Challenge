package com.fsp.challenge.daos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fsp.challenge.entities.pizza.Cheese;
import com.fsp.challenge.repositories.CheeseRepository;

@RestController
public class CheeseDao {
	@Autowired
	CheeseRepository cheeseRepository;

	@PostMapping("/api/cheese")
	public Cheese createCheese(@RequestBody Cheese cheese) {
		return cheeseRepository.save(cheese);
	}
	
	@GetMapping("/api/cheese")
	public Iterable<Cheese> findAllCheeses() {
		return cheeseRepository.findAll();
	}
	
	@GetMapping("/api/cheese/{cheeseId}")
	public Cheese findCheeseById(
			@PathVariable("cheeseId") int id) {
		return cheeseRepository.findOne(id);
	}

	@PutMapping("/api/cheese/{cheeseId}")
	public Cheese updateCheese(
			@PathVariable("cheeseId") int id,
			@RequestBody Cheese newCheese) {
		Cheese cheese = cheeseRepository.findOne(id);
		cheese.set(newCheese);
		return cheeseRepository.save(cheese);
	}
	
	@DeleteMapping("/api/cheese/{cheeseId}")
	public void deleteCheese
	(@PathVariable("cheeseId") int id) {
		cheeseRepository.delete(id);
	}
	
	/*public void test() {
		// Delete all cheeses
		List<Cheese> cheeses = (List<Cheese>) findAllCheeses();
		for(Cheese cheese : cheeses) {
			deleteCheese(cheese.getId());
		}
	}*/
}
