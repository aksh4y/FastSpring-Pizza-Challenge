package com.fsp.challenge.daos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fsp.challenge.entities.pizza.Sauce;
import com.fsp.challenge.repositories.SauceRepository;

@RestController
public class SauceDao {
	@Autowired
	SauceRepository sauceRepository;

	@PostMapping("/api/sauce")
	public Sauce createSauce(@RequestBody Sauce sauce) {
		return sauceRepository.save(sauce);
	}
	
	@GetMapping("/api/sauce")
	public Iterable<Sauce> findAllSauces() {
		return sauceRepository.findAll();
	}
	
	@GetMapping("/api/sauce/{sauceId}")
	public Sauce findSauceById(
			@PathVariable("sauceId") int id) {
		return sauceRepository.findOne(id);
	}

	@PutMapping("/api/sauce/{sauceId}")
	public Sauce updateSauce(
			@PathVariable("sauceId") int id,
			@RequestBody Sauce newSauce) {
		Sauce sauce = sauceRepository.findOne(id);
		sauce.set(newSauce);
		return sauceRepository.save(sauce);
	}
	
	@DeleteMapping("/api/sauce/{sauceId}")
	public void deleteSauce
	(@PathVariable("sauceId") int id) {
		sauceRepository.delete(id);
	}
	
	/*public void test() {
		// Delete all sauces
		List<Sauce> sauces = (List<Sauce>) findAllSauces();
		for(Sauce sauce : sauces) {
			deleteSauce(sauce.getId());
		}
	}*/
}
