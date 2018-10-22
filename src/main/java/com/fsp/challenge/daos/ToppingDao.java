package com.fsp.challenge.daos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fsp.challenge.entities.pizza.Topping;
import com.fsp.challenge.repositories.ToppingRepository;

@RestController
public class ToppingDao {
	@Autowired
	ToppingRepository toppingRepository;

	@PostMapping("/api/topping")
	public Topping createTopping(@RequestBody Topping topping) {
		return toppingRepository.save(topping);
	}
	
	@GetMapping("/api/topping")
	public Iterable<Topping> findAllToppings() {
		return toppingRepository.findAll();
	}
	
	@GetMapping("/api/topping/{toppingId}")
	public Topping findToppingById(
			@PathVariable("toppingId") int id) {
		return toppingRepository.findOne(id);
	}

	@PutMapping("/api/topping/{toppingId}")
	public Topping updateTopping(
			@PathVariable("toppingId") int id,
			@RequestBody Topping newTopping) {
		Topping topping = toppingRepository.findOne(id);
		topping.set(newTopping);
		return toppingRepository.save(topping);
	}
	
	@DeleteMapping("/api/topping/{toppingId}")
	public void deleteTopping
	(@PathVariable("toppingId") int id) {
		toppingRepository.delete(id);
	}
	
	/*public void test() {
		// Delete all toppings
		List<Topping> toppings = (List<Topping>) findAllToppings();
		for(Topping topping : toppings) {
			deleteTopping(topping.getId());
		}
	}*/
}
